package br.com.fiap.transaction.comparator;

import java.util.Comparator;

import br.com.fiap.transaction.bean.Transaction;

public class TransactionTimestampComparator implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {
        return o1.getTimestamp().compareTo(o2.getTimestamp());
    }
}
