public class Graduate extends Students {
    private String degree; // Master's or Doctorate

    public Graduate(String name, int creditHours, double qualityPoints, String degree) {
        super(name, creditHours, qualityPoints);
        this.degree = degree;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        return degree.equals("Masters") && super.eligibleForHonorSociety();
    }

    @Override
    public String toString() {
        return super.toString() + ", Degree: " + degree;
    }
}
