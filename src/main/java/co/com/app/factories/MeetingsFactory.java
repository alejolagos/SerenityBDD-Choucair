package co.com.app.factories;

import co.com.app.models.MeetingsModel;
import org.openqa.selenium.NotFoundException;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class MeetingsFactory {
    private static final String PARAMETERS_JSON = "json/parameters.json";

    public static MeetingsModel getParameters() throws FileNotFoundException {
        return getInformation().stream()
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundException(String.format("meeting not found into parameters.json")));
    }

    public static List<MeetingsModel> getInformation() throws FileNotFoundException {
        return Arrays.asList(from(getFile()).getObject("meetings", MeetingsModel[].class));
    }

    private static URL getFile() throws FileNotFoundException {
        String path = PARAMETERS_JSON;
        URL filePath = MeetingsFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found: " + path);
        }
        return filePath;
    }

}
