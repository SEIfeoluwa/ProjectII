import java.io.*;
import java.util.ArrayList;
 
public class Projectll {
    public static void main(String[] args) {
        ArrayList<Students> students = new ArrayList<>();
        double totalGpa = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0] + "," + parts[1];
                int creditHours = Integer.parseInt(parts[2]);
                double qualityPoints = Double.parseDouble(parts[3]);
                String lastPart = parts[4];

                Students student;
                if (lastPart.equals("Freshman") || lastPart.equals("Sophomore") || lastPart.equals("Junior") || lastPart.equals("Senior")) {
                    student = new Undergraduate(name, creditHours, qualityPoints, lastPart);
                } else { // Assume Masters or Doctorate
                    student = new Graduate(name, creditHours, qualityPoints, lastPart);
                }
                students.add(student);
                totalGpa += student.gpa();
            }
            reader.close();

            double averageGpa = totalGpa / students.size();
            double gpaThreshold = (averageGpa + 4.0) / 2;
            Students.setGpaThreshold(gpaThreshold);
            System.out.println("GPA Threshold: " + String.format("%.2f", gpaThreshold));

            for (Students student : students) {
                if (student.eligibleForHonorSociety()) {
                    System.out.println(student);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file students.txt does not exist.");
        } catch (IOException e) {
            System.err.println("Error reading the file.");
        }
    }
}
