package http;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.FacilityRecord;
import model.TreatmentFields;
import model.TreatmentRecord;
import model.Treatments;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoHttpRESTfulClient
{
	//Create a new instance of http client which will connect to REST api over network
	private static DefaultHttpClient httpClient = new DefaultHttpClient();
	
	public static void main(String[] args) throws Exception 
	{
		//Demo Get request
		getTreatment();
		// getCaseInfo();
		//Demo Post request
		// demoPostRESTAPI();
	}

	public static void getCaseInfo() throws Exception {
		try {
			// omitted due to NDA
			String apiOutput = connectToHttp("https://api.airtable.com/");

			System.out.println(allCaseStyles);
		}
		finally
		{
			//Important: Close the connect
			httpClient.getConnectionManager().shutdown();
		}
	}

	public static List<String> getCaseInfoPerTreatment() throws Exception {

		// omitted due to NDA
		String apiOutput = connectToHttp("https://api.airtable.com/");
		ObjectMapper objectMapper = new ObjectMapper();
		List<String> caseInfoList = new ArrayList<>();
		Treatments treatments = objectMapper.readValue(apiOutput, Treatments.class);
		for (TreatmentRecord record: treatments.getRecords()) {
			if (record.getFields().getCaseInfo() != null) {
				if (!caseInfoList.contains(record.getFields().getCaseInfo().get(0))) {
					caseInfoList.add(record.getFields().getCaseInfo().get(0));
				}
			}
		}

		return caseInfoList;
	}
	
	public static Map<String, List<List<String>>> getTreatment() throws Exception
	{
		try
		{
			// connect to entire Treatments
			// omitted due to NDA
			String apiOutput = connectToHttp("https://api.airtable.com/");

			//Lets see what we got from API
			System.out.println(apiOutput);

			ObjectMapper objectMapper = new ObjectMapper();

			Treatments treatments = objectMapper.readValue(apiOutput, Treatments.class);

//			CodesPerTreatment cptCodePerTreatment = objectMapper.readValue(apiOutput1, CodesPerTreatment.class);
//			cptCodePerTreatment.buildMap();
			HashMap<String, List<TreatmentRecord>> caseCPTCodesMap = new HashMap<>();

			List<String> caseInfoList = getCaseInfoPerTreatment(); // list of cases
			System.out.println(caseInfoList);
			for (String key: caseInfoList) {
				caseCPTCodesMap.put(key, new ArrayList<>());
				treatments.getRecords().stream().filter(
						x -> x.getFields().getCaseInfo() != null &&
								x.getFields().getCaseInfo().get(0).equals(key)).forEach(
						y -> {
							List<TreatmentRecord> newList = caseCPTCodesMap.get(key);
							// y.getFields().getCptCode();
							newList.add(y);
							caseCPTCodesMap.put(key, newList);
						}
				);
			}

			for (String key: caseCPTCodesMap.keySet()) {
				System.out.println(key + " " + caseCPTCodesMap.get(key));
			}

			Function<TreatmentRecord, String> getFacility = treatmentRecord ->
					treatmentRecord.getFields().getFacility() != null ?
					treatmentRecord.getFields().getFacility().get(0) : "";

			String recordKey = caseInfoList.get(0);

			return convertToTable(caseCPTCodesMap.get(recordKey).stream()
					.collect(Collectors.groupingBy(getFacility)));

			// under a single caseInfo, identified by the key "recRZDKo37WiJdlGr"
//			for (String recordKey: caseInfoList) {
//				// System.out.println(recordKey);
//				Map<String, List<TreatmentRecord>> recordPerFacility = caseCPTCodesMap.get(recordKey)
//						.stream().collect(Collectors.groupingBy(getFacility));
//
//				System.out.println(recordPerFacility);
//				System.out.println(convertToTable(recordPerFacility));
//				System.out.println(convertToTable(recordPerFacility).keySet());
//				System.out.println(convertToTable(recordPerFacility).entrySet());
//			}
		}
		finally
		{
			//Important: Close the connect
			httpClient.getConnectionManager().shutdown();
		}
	}

	// Key is the id of facility
	// value is a list string of fields that we are interested in
	private static Map<String, List<List<String>>> convertToTable(Map<String, List<TreatmentRecord>> recordPerFacility)
			throws IOException {
		// List of string can be replaced by a new class
		Map<String, List<List<String>>> result = new HashMap<>();
		for(String key:recordPerFacility.keySet()) {
			if (!key.equals("")) {
				String output = connectToHttp("https://api.airtable.com/v0/appthHHuRXgjyxiWO/Facilities/" + key);
				ObjectMapper objectMapper = new ObjectMapper();
				// System.out.println(output);
				FacilityRecord facilities = objectMapper.readValue(output, FacilityRecord.class);

				String cptCodeKey = facilities.getFields().getTitle();
				List<List<String>> record = new ArrayList<>();
				for (TreatmentRecord treatmentRecord: recordPerFacility.get(key)) {
					TreatmentFields fields = treatmentRecord.getFields();
					String cptCode = fields.getName() != null ? fields.getName() : "Not Available";
					String units = fields.getUnits() != null ? fields.getUnits() : "Not Available";
					String dateOfService = fields.getDateOfService() != null ?
							 String.format("%tB %<te %<tY", fields.getDateOfService()) : "Not Available";
					String charge = fields.getPlaintiffCharge() != null ? fields.getPlaintiffCharge() : "Not Available";
					String ucrLow = fields.getUcrRange() != null ?
							fields.getUcrRange().get(0).split(" - ")[0] : "";
					String ucrHigh = fields.getUcrRange() != null ?
							fields.getUcrRange().get(0).split(" - ")[1] : "";
					String ucrAvg = fields.getUcrAvg() != null ? fields.getUcrAvg().get(0): "";
					List<String> fieldsPerRecord = Arrays.asList(
							cptCode, units, dateOfService, charge, ucrLow, ucrHigh, ucrAvg);
					record.add(fieldsPerRecord);
				}
				result.put(cptCodeKey, record);
			}
		}
		return result;
	}


	public static String connectToHttp(String httpAddress) {
		String apiOutput = "";
		try {
			HttpGet getRequest = new HttpGet(httpAddress);
			getRequest.addHeader("Authorization", "Bearer keyqJCmapqZR9RYen");

			//Send the request; It will immediately return the response in HttpResponse object
			HttpResponse response = httpClient.execute(getRequest);

			//verify the valid error code first
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Read Treatments Failed with HTTP error code : " + statusCode);
			}

			//Now pull back the response object
			HttpEntity httpEntity = response.getEntity();
			apiOutput = EntityUtils.toString(httpEntity);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return apiOutput;
	}
}
