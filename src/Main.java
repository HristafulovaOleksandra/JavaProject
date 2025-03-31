import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Realization realization = new Realization();
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~Choose the action~~~");
        boolean running = true;
        while (running) {
            System.out.println("VetClinic patients Menu: ");
            System.out.println("1. Add Patient");
            System.out.println("2. Show all records");
            System.out.println("3. Change record");
            System.out.println("4. Delete record");
            System.out.println("5. Find patient");
            System.out.println("6. Sort records");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1://Add Patient
                    System.out.println("Input patient's name: ");
                    String name = scanner.nextLine();
                    System.out.println("Input patient's species: ");
                    String species = scanner.nextLine();
                    System.out.println("Input patient's diagnos: ");
                    String diagnos = scanner.nextLine();
                    System.out.println("Input patient's age: ");
                    int age = scanner.nextInt();
                    LocalDateTime recordDate = LocalDateTime.now();
                    realization.addPatient(name,species,diagnos,age,recordDate);
                    break;
                case 2://Show records
                    realization.showRecords();
                    break;
                case 3://Change record
                    System.out.println("~~~Input data about patient to change the record~~~");
                    System.out.println("Find patient by name: ");
                    String nameChange = scanner.nextLine();
                    System.out.println("Input NEW patient's species: ");
                    String speciesChange = scanner.nextLine();
                    System.out.println("Input NEW patient's diagnos: ");
                    String diagnosisChange = scanner.nextLine();
                    System.out.println("Input NEW patient's age: ");
                    int ageChange = scanner.nextInt();
                    realization.changeRecord(nameChange,speciesChange,diagnosisChange,ageChange);
                    break;
                case 4://Delete record
                    System.out.print("Input patient's name to delete record: ");
                    String nameDelete = scanner.nextLine();
                    realization.deleteRecord(nameDelete);
                    break;
                case 5://Find patient
                    System.out.print("Input patient's name to find record: ");
                    String nameFind = scanner.nextLine();
                    realization.findPatient(nameFind);
                    break;
                case 6://Sort records
                    System.out.println("Sorting:\n1. By alphabet\n2. By age\n3. By record date");
                    System.out.print("Choose sorting type: ");
                    int sortingType = scanner.nextInt();
                    scanner.nextLine();
                    realization.sortRecords(sortingType);
                    break;
                case 7:
                    running = false;
                    System.out.println("~~~Exit~~");
                    break;
                default:
                    System.out.println("Unavailable choice");
                    choice = scanner.nextInt();
                    scanner.nextLine();


            }
        }
        scanner.close();
    }
}
