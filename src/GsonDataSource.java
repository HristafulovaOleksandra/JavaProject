import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GsonDataSource {
    private final String filePath;

    private final Gson gson;

    public GsonDataSource(String filePath, Gson gson) {
        this.filePath=filePath;
        this.gson=gson;
    }
    public void saveToFile(List<Patient> patients) {
        try (FileWriter writer = new FileWriter(filePath, StandardCharsets.UTF_8)) {
            gson.toJson(patients, writer);
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    public List<Patient> loadFromFile() {
        List<Patient> patients = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (file.exists()) {
                String json = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
                patients.addAll(gson.fromJson(json, new TypeToken<List<Patient>>() {}.getType()));
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return patients;
    }
}
