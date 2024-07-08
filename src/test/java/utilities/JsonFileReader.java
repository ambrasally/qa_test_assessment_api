package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonFileReader {
    /**
     * Reads a JSON file and returns a JsonNode.
     *
     * @param filePath the path to the JSON file.
     * @return JsonNode containing the JSON data.
     * @throws IOException if there is an error reading the file.
     */
    public static JsonNode getJsonData(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(new File(filePath));
    }

    public static void main(String[] args) throws IOException {
        JsonNode jsonData = getJsonData("path/to/expectedData.json");
        System.out.println(jsonData);
    }
}
