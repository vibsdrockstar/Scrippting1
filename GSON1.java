import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GSON1 {
	public static void main(String[] args) {

        Data d = createDummyObject();

        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(data);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("C:\\Users\\vibhor\\Desktop\\Info.json")) {

            gson.toJson(data, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Data createDummyObject() {

        Data d = new Data();
        d.setName("Swapnil");
        d.setAge(21);
        d.setPosition("Founder");
        d.setSalary(new BigDecimal("100000"));

        List<String> info = new ArrayList<>();
        info.add("java");
        info.add("python");
        info.add("swift");

        info.setInfo(info);

        return d;

    }

}
}
