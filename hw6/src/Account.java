import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Account for hw6
 * @author ahennessy6
 * @version 1.1.2
 */
public class Account {
    private List<Transaction> pastTransactions;

    /**
     * @return past Transactions.
     * @param n in database corresponding to the
     * transaction that should be returned.
     */
    public Transaction getTransaction(int n) {
        return pastTransactions.get(n);
    }

    /**
     * @return predicate test implementation.
     * @param predicate input that is used in our test blueprint.
     */
    public List<Transaction> findTransactionsByPredicate(
            Predicate<Transaction> predicate) {
        List<Transaction> output = new ArrayList<>();
        for (Transaction transaction : this.pastTransactions) {
            if (predicate.test(transaction)) {
                output.add(transaction);
            } else {
                assert true;
            }
        }
        return output;
    }

    /**
     * @return get Transactions by amount.
     * @param amount of transactions that should be returned.
     */
    public List<Transaction> getTransactionsByAmount(double amount) {
        class TransactionsByAmount implements Predicate<Transaction> {
            @Override
            public boolean test(Transaction t) {
                return amount == t.getAmount();
            }
        }
        return findTransactionsByPredicate(new TransactionsByAmount());
    }

    /**
     * @return get Transactions by withdrawals.
     */
    public List<Transaction> getWithdrawals() {
        return findTransactionsByPredicate(new Predicate<Transaction>() {
            @Override
            public boolean test(Transaction t) {
                return TransactionType.WITHDRAWAL == t.getType();
            }
        });
    }

    /**
     * @return get Transactions by deposits.
     */
    public List<Transaction> getDeposits() {
        return findTransactionsByPredicate((Transaction t) -> {
                return TransactionType.DEPOSIT == t.getType();
            });
    }

    /**
     * @return get transactions with comment longer than.
     * @param length is the length for which
     * transactions should be returned for being too long.
     */
    public List<Transaction> getTransactionsWithCommentLongerThan(int length) {
        class GetTransactionsWithCommentLongerThan
                implements Predicate<Transaction> {
            @Override
            public boolean test(Transaction t) {
                if (t.hasComment()) {
                    //System.out.println(t.getComment());
                    return t.getComment().toString().length() - 10 > length;
                } else {
                    return false;
                }
            }
        }

        return findTransactionsByPredicate(
                new GetTransactionsWithCommentLongerThan());
    }

    /**
     * @return all transactions with comments.
     */
    public List<Transaction> getTransactionsWithComment() {
        return findTransactionsByPredicate((Transaction t) -> {
                return t.hasComment();
            });

    }
    /**
     * @return all past transactions within an account.
     */
    public List<Transaction> getPastTransactions() {
        return pastTransactions;
    }

    /**
     * @param transactions is the list passed in to create an Account Object.
     */
    Account(List<Transaction> transactions) {
        this.pastTransactions = transactions;
    }

}
