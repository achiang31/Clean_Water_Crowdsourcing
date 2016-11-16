import org.junit.Test;
import sample.profileController;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11/16/16.
 */
public class profileControllerTest {

    /**
     *
     * @throws Exception
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
     *
     * @throws Exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void validateLatTestException() throws Exception {
        profileController.validateEmail("");
        profileController.validateEmail(null);
    }

    /**
     *
     * @throws Exception
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void validateLatTestFalse() throws Exception {
        assertFalse(profileController.validateEmail("alex"));
        assertFalse(profileController.validateEmail("gatech.edu"));
        assertFalse(profileController.validateEmail("zihan@gmail"));
        assertFalse(profileController.validateEmail("xu@sample.nett"));
    }
}
