import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.docs.v1.Docs;
import com.google.api.services.docs.v1.DocsScopes;
import com.google.api.services.docs.v1.model.*;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.*;

import static http.DemoHttpRESTfulClient.connectToHttp;
import static http.DemoHttpRESTfulClient.getTreatment;
import static org.apache.http.client.utils.DateUtils.parseDate;


public class DocsQuickstart {
    private static final String APPLICATION_NAME = "Treatment";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    // ID omitted due to NDA
    private static final String DOCUMENT_ID = "xxx";
    private static CaseInfoFields caseInfoFields;
    private static EnumMap<AFFIDAVIT_ENUM, String> caseInfoMap = new EnumMap<>(AFFIDAVIT_ENUM.class);
//    private static ExpertInfoFields expertInfo;
//    private static TreatmentFields treatment;

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DocsScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = DocsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static void main(String... args) throws Exception, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Docs service = new Docs.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        Drive driveService = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        // Prints the title of the requested doc:
        // https://docs.google.com/document/d/195j9eDD3ccgjQRttHhJPymLJUCOUjs-jmwTrekvdjFE/edit
        getAirtableData(0);
        ExpertInfoFields expert = new ExpertInfoFields();
        expert.setExpertReports("the price is beyond the reasonable range.");
        TreatmentFields treatments = new TreatmentFields();
        treatments.setDateOfInjury(parseDate("2017-06-28"));
        expert.setExpertReports("the price is beyond the reasonable range.");
        Map<String, List<List<String>>> treatmentsMap = getTreatment();
        String copyId = generate(DOCUMENT_ID, driveService, "Counter AFF Copy", caseInfoFields,
                expert, treatments, treatmentsMap);

        Document response = service.documents().get(copyId).execute();
        String title = response.getTitle();
        System.out.printf("The title of the doc is: %s\n", title);

        write(service, copyId);
    }

    private static String mapToString(Map<String, List<List<String>>> recordsPerFacility) {
        StringBuilder result = new StringBuilder();
        for (String key: recordsPerFacility.keySet()) {
            result.append(key).append("\n");
            result.append("--------------------------\n");
            for (List<String> stringList: recordsPerFacility.get(key)) {
                result.append("CPT Code: ").append(stringList.get(0)).append(", ");
                result.append("Unit: ").append(stringList.get(1)).append(", ");
                result.append("Date of Service: ").append(stringList.get(2)).append(", ");
                result.append("Plaintiff Charge: ").append(stringList.get(3)).append(", ");
                result.append("UCR low: ").append(stringList.get(4)).append(", ");
                result.append("UCR high: ").append(stringList.get(5)).append(", ");
                result.append("UCR average: ").append(stringList.get(5)).append("\n");
            }
        }

        return result.toString();
    }

    private static void createDoc(Docs service, String title) throws IOException {
        Document doc = new Document()
                .setTitle(title);
        doc = service.documents().create(doc)
                .execute();
        System.out.println("Created document with title: " + doc.getTitle());
    }

    /*
    1. copy template into new file
    2. read from air table and fetch the data
    3. search fields and replace with data using EnumMap
    Problem: Can I write a single request to replace all of the fields????
    store fields locally using getFields methods and pass in as parameter
    */
    public static String generate(String templateId, Drive driveService, String titlename,
                                CaseInfoFields caseInfo, ExpertInfoFields expertInfo, TreatmentFields treatment,
                                  Map<String, List<List<String>>> treatmentsMap) throws IOException {

        String copyId = copyDoc(templateId, driveService, titlename);

        caseInfo.applyToMap(caseInfoMap);
        treatment.applyToMap(caseInfoMap);
        expertInfo.applyToMap(caseInfoMap);
        caseInfoMap.put(AFFIDAVIT_ENUM.TREATMENTS, mapToString(treatmentsMap));
        StringBuilder facilities = new StringBuilder();
        for (String facility: treatmentsMap.keySet()) {
            facilities.append(facility).append("\n");
        }
        caseInfoMap.put(AFFIDAVIT_ENUM.FACILITIES, facilities.toString());
        LocalDate generateDate = LocalDate.now();
        StringBuilder dateString = new StringBuilder();
        dateString.append(generateDate.getDayOfMonth()).append(" day of ")
                .append(generateDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US))
                .append(", ").append(generateDate.getYear());
        caseInfoMap.put(AFFIDAVIT_ENUM.GENERATE_DATE, dateString.toString());
        return copyId;
}

    private static String copyDoc(String documentId, Drive service, String copyTitle) throws IOException {
        File copyMetadata = new File().setName(copyTitle);
        File documentCopyFile =
                service.files().copy(documentId, copyMetadata).execute();
        return documentCopyFile.getId();
    }

    private static void getAirtableData(int index) throws Exception {
        // string omitted due to NDA
        String apioutput = connectToHttp("https://api.airtable.com/");
        ObjectMapper objectMapper = new ObjectMapper();
        CaseInfos newCaseInfo = objectMapper.readValue(apioutput, CaseInfos.class);
        caseInfoFields = newCaseInfo.getRecords().get(index).getFields();
    }

    private static void write(Docs service, String documentId) throws IOException {
        List<Request> requests = new ArrayList<>();
        System.out.println(caseInfoMap);
        for (Map.Entry<AFFIDAVIT_ENUM, String> entry : caseInfoMap.entrySet()) {
            AFFIDAVIT_ENUM key = entry.getKey();
            String value = entry.getValue();
            System.out.println(value);
            System.out.println(key);
            if(value == null)
                continue;
            requests.add(new Request()
                    .setReplaceAllText(new ReplaceAllTextRequest()
                            .setContainsText(new SubstringMatchCriteria()
                                    .setText("{{" + key.toString() + "}}")
                                    .setMatchCase(true))
                            .setReplaceText(value)));
        }

        BatchUpdateDocumentRequest body = new BatchUpdateDocumentRequest().setRequests(requests);
        service.documents().batchUpdate(documentId, body).execute();
    }

    private static void WriteDemo(Docs service, String documentId) throws IOException {

        List<Request> requests = new ArrayList<>();

        String customerName = "Alice";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = formatter.format(LocalDate.now());

        // I can use a for loop to replace all the fields specified in ENUM
        requests.add(new Request()
                .setReplaceAllText(new ReplaceAllTextRequest()
                        .setContainsText(new SubstringMatchCriteria()
                                .setText("{{Plaintiff}}")
                                .setMatchCase(true))
                        .setReplaceText(customerName)));

        requests.add(new Request()
                .setReplaceAllText(new ReplaceAllTextRequest()
                        .setContainsText(new SubstringMatchCriteria()
                                .setText("{{Defendant}}")
                                .setMatchCase(true))
                        .setReplaceText(date)));

        requests.add(new Request()
                .setReplaceAllText(new ReplaceAllTextRequest()
                        .setContainsText(new SubstringMatchCriteria()
                                .setText("{{NAME}}")
                                .setMatchCase(true))
                        .setReplaceText("hello world")));

        BatchUpdateDocumentRequest body = new BatchUpdateDocumentRequest().setRequests(requests);
        service.documents().batchUpdate(documentId, body).execute();
    }

    private static void insertTable(Docs docsService, String documentId) throws IOException {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request().setInsertText(new InsertTextRequest()
                .setText("Hello")
                .setLocation(new Location().setIndex(5))));
        requests.add(new Request().setInsertTableRow(new InsertTableRowRequest()
                .setTableCellLocation(new TableCellLocation()
                        .setTableStartLocation(new Location()
                                .setIndex(2))
                        .setRowIndex(1)
                        .setColumnIndex(1))
                .setInsertBelow(true)));

        BatchUpdateDocumentRequest body = new BatchUpdateDocumentRequest().setRequests(requests);
        BatchUpdateDocumentResponse response = docsService.documents()
                .batchUpdate(DOCUMENT_ID, body).execute();
    }
}