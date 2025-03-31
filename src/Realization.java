import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Realization {
    private List<Patient> patients = new ArrayList<>();
    private final String FILE_PATH = "patients.json";
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public Realization()
    {
        loadFromFile();
    }
    public void addPatient(String name,String species,String diagnos,int age,LocalDateTime recordDate )
    {
        patients.add(new Patient(name,species,diagnos,age,recordDate));
        saveToFile();
        System.out.println("New patient was added succsessfully!");
    }
    public void showRecords()
    {
        if (patients.isEmpty()) System.out.println("No patient found");
        else for(Patient el : patients){System.out.println(el);}
    }
    public void changeRecord(String nameChange,String speciesChange,String diagnosChange,int ageChange)
    {
        boolean found = false;
        for (Patient el : patients)
        {
            if(el.getName().equalsIgnoreCase(nameChange))
            {
                el.setSpecies(speciesChange);
                el.setDiagnos(diagnosChange);
                el.setAge(ageChange);
                el.setRecordDate(LocalDateTime.now());
                found = true;
                break;
            }
        }
        if (found) {
            saveToFile();
            System.out.println("Patient record updated.");
        } else {
            System.out.println("Patient was not found");
        }
    }
    public void deleteRecord(String nameDelete)
    {
        for(Patient el : patients)
        {
            if(el.getName().equalsIgnoreCase(nameDelete))
            {
                patients.remove(el);
                saveToFile();
                System.out.println("Patient was removed from the list");
                break;
            }
            else
            {
                System.out.println("Patient was not found");
                break;
            }
        }
    }
    public void findPatient(String nameFind,String speciesFind)
    {
        for(Patient el : patients)
        {
            if (el.getName().equalsIgnoreCase(nameFind) || el.getSpecies().equalsIgnoreCase(speciesFind))
            {
                System.out.println("Patient found: " + el.toString());
                break;
            }
            else
            {
                System.out.println("Patient was not found");
                break;
            }
        }
    }
    public void sortRecords(int sortingType)
    {
        if (patients.isEmpty())
        {
            System.out.println("No patient found");
            return;
        }
        switch (sortingType)
        {
            case 1:
                patients.sort(Comparator.comparing(Patient::getName));
                System.out.println("Patients sorted by alphabet successfully!");
                break;
            case 2:
                patients.sort(Comparator.comparing(Patient::getAge));
                System.out.println("Patients sorted by age successfully!");
                break;
            case 3:
                patients.sort(Comparator.comparing(Patient::getRecordDate));
                System.out.println("Patients sorted by record date successfully!");
                break;
            default:
                System.out.println("Invalid sort type");
        }
        showRecords();
    }
    private void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH, StandardCharsets.UTF_8)) {
            gson.toJson(patients, writer);
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    private void loadFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                String json = new String(Files.readAllBytes(Paths.get(FILE_PATH)), StandardCharsets.UTF_8);
                patients = gson.fromJson(json, new TypeToken<List<Patient>>() {}.getType());
                if (patients == null) patients = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }


}
