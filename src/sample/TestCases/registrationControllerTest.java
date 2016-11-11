package sample.TestCases;
import org.junit.Before;
import org.junit.Test;
import sample.AccountType;
import sample.registrationController;
import static org.junit.Assert.*;

/**
 * Created by xingxing on 11/9/16.
 */
public class registrationControllerTest {
    @Before
    public void setUp() {
    }
    @Test
    public void testAccountType() {
        assertEquals(registrationController.determineAccountType("User"), AccountType.US);
        assertEquals(registrationController.determineAccountType("Worker"), AccountType.WK);
        assertEquals(registrationController.determineAccountType("Manager"), AccountType.MN);
        assertEquals(registrationController.determineAccountType("mm"), AccountType.AD);
    }
}
