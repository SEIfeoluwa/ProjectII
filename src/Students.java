public class Students {
    private String name;
    private int creditHours;
    private double qualityPoints;
    private static double gpaThreshold;

    public Students(String name, int creditHours, double qualityPoints) {
        this.name = name;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints;
    }

    public double gpa() {
        return qualityPoints / creditHours;
    }

    public boolean eligibleForHonorSociety() {
        return gpa() > gpaThreshold;
    }

    public String toString() {
        return name + ", GPA: " + String.format("%.2f", gpa());
    }

    public static void setGpaThreshold(double threshold) {
        gpaThreshold = threshold;
    }
}
