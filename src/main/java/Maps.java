import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Maps {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(System.getProperty("user.dir") + "/src/main/dataSet.json");
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileObject = fileElement.getAsJsonObject();

        JsonArray MapLocation = fileObject.get("markers").getAsJsonArray();
        List<MapsPOJO> mapLocations = new ArrayList();
        for (JsonElement mapElement : MapLocation.getAsJsonArray()) {
            JsonObject mapJsonObject = mapElement.getAsJsonObject();
            String locations = mapJsonObject.get("name").getAsString();
            String coordinates = mapJsonObject.get("position").getAsString();

            MapsPOJO map = new MapsPOJO(locations, coordinates);
            mapLocations.add(map);
        }
        System.out.println("All locations:- " + mapLocations);
        }
    }