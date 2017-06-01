import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GSON2 {
	public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("D:\\Info.json")) {

			// Convert JSON to Java Object
            Info info = gson.fromJson(reader, Info.class);
            System.out.println(info);

			// Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
