package sample;

/**
 * Created by bigjohnlin on 10/24/2016.
 */
public class PurityReport extends Report {
    private int virusPPM;
    private int conditionPPM;
    private OverallCondition overallCondition;

    public PurityReport(Location location) {
        super(location);
    }

    public int getVirusPPM() {
        return virusPPM;
    }

    public void setVirusPPM(int ppm) {
        virusPPM = ppm;
    }

    public int getConditionPPM() {
        return conditionPPM;
    }

    public void setConditionPPM(int ppm) {
        conditionPPM = ppm;
    }

    public OverallCondition getOverallCondition() {
        return overallCondition;
    }

    public void setOverallCondition(String condition) {
        overallCondition = overallCondition.valueOf(condition);
    }


}
