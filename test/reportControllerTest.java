import org.junit.Test;
import sample.reportController;

import static org.junit.Assert.*;

/**
 * Test Case for Report Controller
 */
public class reportControllerTest {

    /**
     * method to validate the latitude for True
     * @throws Exception for throw
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLatTestTrue() throws Exception {
        assertTrue(reportController.validateLat("0"));
        assertTrue(reportController.validateLat("90"));
        assertTrue(reportController.validateLat("-90"));
        assertTrue(reportController.validateLat("-45"));
        assertTrue(reportController.validateLat("45"));
    }
    /**
     * method to validate the latitude for Exception
     * @throws Exception for throw
     */
    @Test (expected = IllegalArgumentException.class)
    public void validateLatTestException() throws Exception {
        reportController.validateLat("");
        reportController.validateLat(null);
    }
    /**
     * method to validate the latitude for False
     * @throws Exception for throw
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLatTestFalse() throws Exception {
        assertFalse(reportController.validateLat("-91"));
        assertFalse(reportController.validateLat("91"));
        assertFalse(reportController.validateLat("123456"));
        assertFalse(reportController.validateLat("-123456"));
    }

}