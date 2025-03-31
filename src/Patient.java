import java.time.LocalDateTime;

public class Patient {
    private String name;
    private String species;
    private String diagnos;
    private int age;
    private LocalDateTime recordDate;
    public Patient(String name, String species, String diagnosis, int age)
    {
        this.name = name;
        this.species = species;
        this.diagnos = diagnosis;
        this.age = age;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSpecies() {return species;}
    public void setSpecies(String species) {this.species = species;}
    public String getDiagnos() {return diagnos;}
    public void setDiagnos(String diagnos) {this.diagnos = diagnos;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public LocalDateTime getRecordDate() {return recordDate;}
    public void setRecordDate(LocalDateTime recordDate) {this.recordDate = recordDate;}
    @Override
    public String toString()
    {
        return "Name: "+name+"Species: "+species+"Diagnos: "+diagnos+"Age: "+age+"\n"+"RecordDate: "+recordDate;
    }


}
