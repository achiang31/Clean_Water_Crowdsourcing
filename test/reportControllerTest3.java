import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sample.reportController;

import static org.junit.Assert.*;

//Sean

public class reportControllerTest3 {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @SuppressWarnings("FeatureEnvy")
    @Test (expected = NumberFormatException.class)
    public void validateLongTestFormal() throws Exception {
        reportController.validateLong("jibadajibachang");
        reportController.validateLong("heyjibadayouchang");
        reportController.validateLong("jibaduanjibaxiao");
        reportController.validateLong("heyjibaduanyouxiao");
    }
    @Test
    public void validateLongTestTrue() throws Exception {
        assertTrue(reportController.validateLong("0"));
        assertTrue(reportController.validateLong("90"));
        assertTrue(reportController.validateLong("-90"));
        assertTrue(reportController.validateLong("-180"));
        assertTrue(reportController.validateLong("180"));
        assertTrue(reportController.validateLong("45"));
        assertTrue(reportController.validateLong("-45"));
        assertTrue(reportController.validateLong("10"));
        assertTrue(reportController.validateLong("-10"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void validateLongTestIllegal() throws Exception {
        reportController.validateLong(null);
        reportController.validateLong("");
    }
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLongTestFalse() throws Exception {
        assertFalse(reportController.validateLong("181"));
        assertFalse(reportController.validateLong("-181"));
        assertFalse(reportController.validateLong("24383838438"));
        assertFalse(reportController.validateLong("-24383838438"));
    }
}