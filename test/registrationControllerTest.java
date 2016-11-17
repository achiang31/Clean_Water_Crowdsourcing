import org.junit.Test;
import Model.AccountType;
import Controller.registrationController;
import static org.junit.Assert.*;

/**
 * test case for registraction controller
 */
public class registrationControllerTest {
    /**
     * testing the account type
     */
    @SuppressWarnings("FeatureEnvy")
    @Test
    public void testAccountType() {
        assertEquals(registrationController.determineAccountType("User"), AccountType.US);
        assertEquals(registrationController.determineAccountType("Worker"), AccountType.WK);
        assertEquals(registrationController.determineAccountType("Manager"), AccountType.MN);
        assertEquals(registrationController.determineAccountType("mm"), AccountType.AD);
    }
}
