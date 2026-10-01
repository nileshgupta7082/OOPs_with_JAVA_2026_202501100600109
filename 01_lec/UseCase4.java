public class UseCase4 {
    public static void main(String[] args) {
        double balance = 5000.0;
        double withdrawAmount = 7500;

        //todo: call withdraw() inside a try block;
        //catch the InsufficientFundsException and print the exception message
        // and use finally to print "transaction attempt completed"

        try {
            withdraw(balance, withdrawAmount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }

    static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }else{
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
            }
        }
    }


class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}