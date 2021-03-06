import org.junit.Test;
import Controller.reportController;

import static org.junit.Assert.*;

/**
 * Report Controller Test Class 2
 */
public class reportControllerTest2 {
    /**
     * method to validate the longitude for True
     * @throws Exception for throw
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLongTestTrue() throws Exception {
        assertTrue(reportController.validateLong("0"));
        assertTrue(reportController.validateLong("90"));
        assertTrue(reportController.validateLong("-90"));
        assertTrue(reportController.validateLong("-180"));
        assertTrue(reportController.validateLong("180"));
        assertTrue(reportController.validateLong("60"));
        assertTrue(reportController.validateLong("-60"));
        assertTrue(reportController.validateLong("30"));
        assertTrue(reportController.validateLong("-30"));
        assertTrue(reportController.validateLong("75"));
        assertTrue(reportController.validateLong("-75"));
    }
    /**
     * method to validate the latitude for Exception
     * @throws Exception for throw
     */
    @Test (expected = IllegalArgumentException.class)
    public void validateLongTestIllegal() throws Exception {
        reportController.validateLong(null);
        reportController.validateLong("");
    }
    /**
     * method to validate the latitude for NumberFormat
     * @throws Exception for throw
     */
    @Test (expected = NumberFormatException.class)
    public void validateLongTestFormal() throws Exception {
        reportController.validateLong("lololol");
        reportController.validateLong("Hiryuugekizokushintenraihou");
    }
    /**
     * method to validate the latitude for False
     * @throws Exception for throw
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLongTestFalse() throws Exception {
        assertFalse(reportController.validateLong("181"));
        assertFalse(reportController.validateLong("-181"));
        assertFalse(reportController.validateLong("1000000"));
        assertFalse(reportController.validateLong("-1000000"));
    }
}