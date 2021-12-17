package co.com.app.factories;

import co.com.app.models.ContactsModel;
import co.com.app.models.MeetingsModel;
import org.openqa.selenium.NotFoundException;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class ContactsFactory {
    private static final String PARAMETERS_JSON = "json/parameters.json";

    public static List<ContactsModel> getParameters() throws FileNotFoundException {
        return getInformation();
    }

    public static List<ContactsModel> getInformation() throws FileNotFoundException {
        return Arrays.asList(from(getFile()).getObject("contacts", ContactsModel[].class));
    }

    private static URL getFile() throws FileNotFoundException {
        String path = PARAMETERS_JSON;
        URL filePath = ContactsFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found: " + path);
        }
        return filePath;
    }

}
