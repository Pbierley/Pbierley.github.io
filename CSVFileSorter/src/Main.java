import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File csvFile = new File("employee-sample.csv");
        String userInputName = getPerson();
        String department = findPersonDepartment(userInputName, csvFile);
        returnList(userInputName,department,csvFile);
        String divisionKeyWord = getDivisionKeyWord();
        System.out.println(returnDivisionNames(divisionKeyWord, csvFile));
    }

    public static String getPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired Username: ");
        String userInputName = scanner.nextLine();
        return userInputName;
    }

    public static String findPersonDepartment(String userInputName, File csvFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                // Outputs the entire value of each line
                //System.out.println(Arrays.toString(values));
                String beforeFirstComma = values[0];
                if (beforeFirstComma.equals(userInputName)) {
                    System.out.println("found " + beforeFirstComma);
                    String department = values[4];
                    System.out.println("department- " + department);
                    return department;
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String returnList(String excludedPerson, String department, File csvFile){
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                String nameColumn = values[0];
                String departmentColumn = values[4];
                if (departmentColumn.equals(department) && !nameColumn.equals(excludedPerson)){
                        count++;
                        System.out.println(count + " " + nameColumn + " " + departmentColumn);
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String, Integer> returnDivisionNames(String divisionKeyWord, File csvFile){
        int count = 0;
        int keyLength = divisionKeyWord.length();
        Map<String, Integer> divisions = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                // Outputs the entire value of each line
                //System.out.println(Arrays.toString(values));
                String division = values[5];
                if(division.length() >= keyLength && division.substring(0,keyLength).equals(divisionKeyWord)){
                    if (divisions.containsKey(division)) {
                        divisions.put(division, divisions.get(division) + 1);
                    } else {
                        divisions.put(division, 1);
                    }
                }
            }
            return divisions;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getDivisionKeyWord(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired keyword: (Transportation)");
        String key = scanner.nextLine();
        return key;
    }
}



