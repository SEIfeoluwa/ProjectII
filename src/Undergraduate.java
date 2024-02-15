public class Undergraduate extends Students {
    private String year; // Freshman, Sophomore, Junior, Senior

    public Undergraduate(String name, int creditHours, double qualityPoints, String year) {
        super(name, creditHours, qualityPoints);
        this.year = year;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        return (year.equals("Junior") || year.equals("Senior")) && super.eligibleForHonorSociety();
    }

    @Override
    public String toString() {
        return super.toString() + ", Year: " + year;
    }
}
