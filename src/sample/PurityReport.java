package sample;

/**
 * Created by bigjohnlin on 10/24/2016.
 */
public class PurityReport extends Report {
    private int virusPPM;
    private int contaminatePPM;
    private OverallCondition overallCondition;

    /**
     * Create a new Report object for user
     * @param location location where u examine the water
     */
    public PurityReport(Location location) {
        super(location);
    }

    /**
     * Get the Virus PPM of the report
     * @return Virus PPM in the report
     */
    public int getVirusPPM() {
        return virusPPM;
    }

    /**
     * Set the virus ppm for the report
     * @param ppm virus ppm for the report
     */
    public void setVirusPPM(int ppm) {
        virusPPM = ppm;
    }

    /**
     * Get the condition ppm of the report
     * @return condition ppm in the report
     */
    public int getContaminatePPM() {
        return contaminatePPM;
    }

    /**
     * Set the condition ppm for the report
     * @param ppm condition ppm for the report
     */
    public void setConditionPPM(int ppm) {
        contaminatePPM = ppm;
    }

    /**
     * Get the overall condition of the report
     * @return Overall Condition in the report
     */
    public OverallCondition getOverallCondition() {
        return overallCondition;
    }

    /**
     * Set the Overall Condition for the report
     * @param condition Overall Condition for the report
     */
    public void setOverallCondition(String condition) {
        overallCondition = overallCondition.valueOf(condition);
    }


}
