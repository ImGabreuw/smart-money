package me.gabreuw.smartmoney.repositories;

import me.gabreuw.smartmoney.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByMoment(Date moment);

    List<Transaction> findAllByMomentBetween(Date min, Date max);

}
