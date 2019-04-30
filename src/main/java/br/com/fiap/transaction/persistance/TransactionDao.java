package br.com.fiap.transaction.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.fiap.transaction.bean.Transaction;
import br.com.fiap.transaction.service.StatisticsService;
import br.com.fiap.transaction.service.TransactionService;

@Repository
@org.springframework.transaction.annotation.Transactional
public class TransactionDao {

    private ArrayList<> transactionList;
    
    TransactionDao(){
        transactionList = new new HashMap<>();
    }

    public void save(Transaction transaction) {
        transactionList.put(transaction.timestamp, transaction.amout);
    }
    
    public void getAll() {
        return transactionList;
    }
}
