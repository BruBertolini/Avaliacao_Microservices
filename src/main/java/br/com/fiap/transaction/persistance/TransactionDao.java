package br.com.fiap.transaction.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import br.com.fiap.transaction.bean.Transaction;
import br.com.fiap.transaction.service.StatisticsService;
import br.com.fiap.transaction.service.TransactionService;

@Repository
@org.springframework.transaction.annotation.Transactional
public class TransactionDao {

    @Autowired
    private EntityManager entityManager;

    public void save(Transaction transaction) {
        getEntityManager().persist(transaction);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
