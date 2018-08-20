package SamouczekProgramisty.Test1.Bank;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Java8Collections {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.addTransaction(2, TransactionType.DEPOSIT);
        bankAccount.addTransaction(100, TransactionType.DEPOSIT);
        bankAccount.addTransaction(50, TransactionType.DEPOSIT);
        bankAccount.addTransaction(60, TransactionType.DEPOSIT);
        bankAccount.addTransaction(70, TransactionType.DEPOSIT);
        bankAccount.addTransaction(10, TransactionType.DEPOSIT);
        bankAccount.addTransaction(2, TransactionType.WITHDRAW);

        List<Transaction> transactions = bankAccount.getTransactions();

        List<Transaction> collect = transactions.stream()
                //.sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                //.filter(s -> s.getAmount() > 50)
                .collect(toList());
        collect.forEach(s -> System.out.println(s));
    }

    private static class BankAccount {
        private List<Transaction> transactions = new ArrayList<Transaction>();

        public int addTransaction(int amount, TransactionType transactionType) {
            Transaction transaction = new Transaction(amount, transactionType);
            transactions.add(transaction);
            return 0;
        }

        public List<Transaction> getTransactions() {
            return Collections.unmodifiableList(transactions);
        }

        @Override
        public String toString() {
            return "BankAccount{" +
                    "transactions=" + transactions +
                    '}';
        }
    }

    private static class Transaction {
        private final double amount;
        private final TransactionType transactionType;
        private final Date dateCreated;

        public Transaction(double amount, TransactionType transactionType) {
            this.amount = amount;
            this.transactionType = transactionType;
            this.dateCreated = new Date();
        }

        public double getAmount() {
            return amount;
        }

        public TransactionType getTransactionType() {
            return transactionType;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "amount=" + amount +
                    ", transactionType=" + transactionType +
                    ", dateCreated=" + dateCreated +
                    '}';
        }
    }

    private static enum TransactionType {
        DEPOSIT, WITHDRAW;
    }
}
