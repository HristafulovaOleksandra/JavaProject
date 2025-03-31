import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Realization {
    private List<Patient> patients = new ArrayList<>();
    public void addPatient(String name,String species,String diagnos,int age,LocalDateTime recordDate )
    {
        patients.add(new Patient(name,species,diagnos,age,recordDate));
        System.out.println("New patient was added succsessfully!");
    }
    public void showRecords()
    {
        if (patients.isEmpty()) System.out.println("No patient found");
        else for(Patient el : patients){System.out.println(el);}
    }
    public void changeRecord(String nameChange,String speciesChange,String diagnosChange,int ageChange)
    {
        for (Patient el : patients)
        {
            if(el.getName().equalsIgnoreCase(nameChange))
            {
                el.setSpecies(speciesChange);
                el.setDiagnos(diagnosChange);
                el.setAge(ageChange);
                el.setRecordDate(LocalDateTime.now());
                System.out.println("Patient was changed to " + el.toString());
            }
            else System.out.println("Patient was not found");
        }
    }
    public void deleteRecord(String nameDelete)
    {
        for(Patient el : patients)
        {
            if(el.getName().equalsIgnoreCase(nameDelete))
            {
                patients.remove(el);
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
    public void findPatient(String nameFind)
    {
        for(Patient el : patients)
        {
            if (el.getName().equalsIgnoreCase(nameFind))
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
    public void sortRecords()
    {

    }
}
