package br.com.fiap.transaction.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.PriorityBlockingQueue;

import lombok.Getter;
import br.com.fiap.transaction.comparator.TransactionTimestampComparator;
import br.com.fiap.transaction.dto.Statistics;
import br.com.fiap.transaction.bean.Transaction;

@Service
public class StatisticsService {

    private static final int QUEUE_INITIAL_CAPACITY = 1000;
    private static final int POLLING_INTERVAL_RATE_MILLIS = 1;

    private final PriorityBlockingQueue<Transaction> transactionsLast60Seconds =
            new PriorityBlockingQueue<>(QUEUE_INITIAL_CAPACITY, new TransactionTimestampComparator());

   
    @Scheduled(fixedRate = POLLING_INTERVAL_RATE_MILLIS)
    private void evictOldEntries() {
        while (!transactionsLast60Seconds.isEmpty() && !transactionsLast60Seconds.peek().isNewerThanTimeLimit()) {
            transactionsLast60Seconds.poll();
        }
        updateStatistics();
    }
    
    private void updateStatistics() {
        statistics = new Statistics(transactionsLast60Seconds);
    }
    
    @Getter
    private Statistics statistics = new Statistics(transactionsLast60Seconds);

    public void addTransaction(Transaction transaction) {
        transactionsLast60Seconds.add(transaction);
        updateStatistics();
    }


}
