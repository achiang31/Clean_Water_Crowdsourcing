import org.junit.Test;
import Controller.profileController;

import static org.junit.Assert.*;

public class profileControllerTest {

    /**
     * Method to validate the email address for true
     * @throws Exception for throw
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateEmailTestTrue() throws Exception {
        assertTrue(profileController.validateEmail("alex@gmail.com"));
        assertTrue(profileController.validateEmail("zihan@gatech.edu"));
        assertTrue(profileController.validateEmail("xu@sample1.gov"));
        assertTrue(profileController.validateEmail("0311@sample2.net"));
    }

    /**
     * Method to validate the email address for exception
     * @throws Exception for throw
     */
    @Test (expected = IllegalArgumentException.class)
    public void validateLatTestException() throws Exception {
        profileController.validateEmail("");
        profileController.validateEmail(null);
    }

    /**
     * Method to validate the email address for false
     * @throws Exception for throw
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLatTestFalse() throws Exception {
        assertFalse(profileController.validateEmail("alex"));
        assertFalse(profileController.validateEmail("gatech.edu"));
        assertFalse(profileController.validateEmail("zihan@gmail"));
        assertFalse(profileController.validateEmail("xu@sample.nett"));
        assertFalse(profileController.validateEmail("@yahoo.com"));
    }
}
