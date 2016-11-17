package Model;

/**
 * Worker Class
 */
public class Worker extends User {

    /**
     * constructor for worker
     * @param account account type for worker
     * @param username username for worker
     * @param password password for worker
     */
    public Worker(AccountType account, String username, String password) {
        super(account, username, password);
    }

}
