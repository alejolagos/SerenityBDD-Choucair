package co.com.app.factories;

import co.com.app.models.UserModel;
import org.openqa.selenium.NotFoundException;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class UsersFactory {

    private static final String USERS_JSON = "json/parameters.json";

    public static UserModel withName(String name) throws FileNotFoundException {
        return getInformation().stream()
                .filter(user -> user.getName()
                        .equals(name))
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundException(String.format("User with code %s not found", name)));
    }

    public static List<UserModel> getInformation() throws FileNotFoundException {
        return Arrays.asList(from(getFile()).getObject("users", UserModel[].class));
    }

    private static URL getFile() throws FileNotFoundException {
        String path = USERS_JSON;
        URL filePath = UsersFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found: " + path);
        }
        return filePath;
    }

}
