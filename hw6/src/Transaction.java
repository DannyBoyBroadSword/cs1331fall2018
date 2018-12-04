import java.util.Optional;

/**
 * Transaction for hw6
 * @author ahennessy6
 * @version 1.1.2
 */
public class Transaction {
    private TransactionType type;
    private double amount;
    private Optional<String> comment = Optional.empty();

    /**
     * @return the type.
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * @return the amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return the comment.
     */
    public Optional<String> getComment() {
        if (this.hasComment()) {
            return comment;
        } else {
            return Optional.empty();
        }
    }

    /**
     * @return if there is a comment.
     */
    public boolean hasComment() {
        return this.comment.isPresent();
    }

    /**
     * @param type is the type of Transaction.
     * @param amount is the amount of the Transaction.
     * @param comment is a comment associated with the transaction.
     */
    Transaction(TransactionType type, double amount, String comment) {
        this.type = type;
        this.amount = amount;
        // this.comment = Optional.empty();
        try {
            this.comment = Optional.of(comment);
        } catch (Exception e) {
            this.comment = Optional.empty();
        }

    }
    /**
     * @param type is the type of Transaction.
     * @param amount is the amount of the Transaction.
     */
    Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.comment = Optional.empty();
    }

}
