import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Utils {
    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONObject userObject = Utils.loadJSONFile("./src/test/resources/Creds.json");

        String username = (String) userObject.get("username");
        String password = (String) userObject.get("password");
    }

    public static JSONObject loadJSONFile(String fileLocation) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocation));
        return (JSONObject) obj;
    }
}
