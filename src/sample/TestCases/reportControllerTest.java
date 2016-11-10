package sample.TestCases;

import org.junit.Before;
import org.junit.Test;
import sample.reportController;

import static org.junit.Assert.*;

/**
 * Created by bigjohnlin on 11/9/2016.
 */
public class reportControllerTest {
    @Before
    public void setUp() throws Exception {

    }

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
    public void validateLong() throws Exception {

    }

}