package sample.TestCases;

import org.junit.Before;
import org.junit.Test;
import sample.reportController;

import static org.junit.Assert.*;

/**
 * Created by bigjohnlin on 11/9/2016.
 */
public class reportControllerTest {

    @Test
    public void validateLatTestTrue() throws Exception {
        assertTrue(reportController.validateLat("0"));
        assertTrue(reportController.validateLat("90"));
        assertTrue(reportController.validateLat("-90"));
        assertTrue(reportController.validateLat("-45"));
        assertTrue(reportController.validateLat("45"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void validateLatTestException() throws Exception {
        reportController.validateLat("");
        reportController.validateLat(null);
    }
    @Test
    public void validateLatTestFalse() throws Exception {
        assertFalse(reportController.validateLat("-91"));
        assertFalse(reportController.validateLat("91"));
        assertFalse(reportController.validateLat("123456"));
        assertFalse(reportController.validateLat("-123456"));
    }
    @Test
    public void validateLongTest() throws Exception {
        assertTrue(reportController.validateLong("0"));
        assertTrue(reportController.validateLong("180"));
        assertTrue(reportController.validateLong("-180"));
        assertTrue(reportController.validateLong("90"));
        assertTrue(reportController.validateLong("-90"));
        assertFalse(reportController.validateLong("-181"));
        assertFalse(reportController.validateLong("181"));
        assertFalse(reportController.validateLong("123456"));
        assertFalse(reportController.validateLong("-123456"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void validateLongTestException() throws Exception {
        reportController.validateLong("");
        reportController.validateLong(null);
    }
}