import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sample.reportController;

import static org.junit.Assert.*;

//Alan

public class reportControllerTest2 {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

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
    @Test (expected = IllegalArgumentException.class)
    public void validateLongTestIllegal() throws Exception {
        reportController.validateLong(null);
        reportController.validateLong("");
    }
    @Test (expected = NumberFormatException.class)
    public void validateLongTestFormal() throws Exception {
        reportController.validateLong("lololol");
        reportController.validateLong("Hiryuugekizokushintenraihou");
    }

    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLongTestFalse() throws Exception {
        assertFalse(reportController.validateLong("181"));
        assertFalse(reportController.validateLong("-181"));
        assertFalse(reportController.validateLong("1000000"));
        assertFalse(reportController.validateLong("-1000000"));
    }
}