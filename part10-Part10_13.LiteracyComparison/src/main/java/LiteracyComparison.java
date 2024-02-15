
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Comparator;

public class LiteracyComparison {

    public static void main(String[] args) {

        String fileName = "literacy.csv";
        ArrayList<LiteracyRecords> records = new ArrayList<>();

        try ( Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String parts[] = line.split(",");
                if (parts.length == 6) {
                    String theme = parts[0].trim();
                    String ageGroup = parts[1].trim();
                    String gender = parts[2].trim();
                    String country = parts[3].trim();
                    int year = Integer.parseInt(parts[4].trim());
                    double literacyPercent = Double.parseDouble(parts[5].trim());
                    records.add(new LiteracyRecords(theme, ageGroup, gender, country, year, literacyPercent));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        records.sort((r1, r2) -> Double.compare(r1.getLiteracyPercent(), r2.getLiteracyPercent()));
        records.forEach(r -> System.out.println(r.toString()));

    }
}
