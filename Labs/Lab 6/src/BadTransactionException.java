/**
 * Created by IntelliJ IDEA.
 * User: Lawrence
 * Date: 3/9/2015
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BadTransactionException extends Exception {

    public int amount;  // The invalid account number.

    /**
     *  Creates an exception object for nonexistent account "badAcctNumber".
     **/
    public BadTransactionException(int amount) {
        super("Invalid amount: " + amount);

        this.amount = amount;
    }
}
