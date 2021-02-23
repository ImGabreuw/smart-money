package me.gabreuw.smartmoney.services;

import me.gabreuw.smartmoney.domain.Transaction;
import me.gabreuw.smartmoney.domain.dto.TransactionDTO;
import me.gabreuw.smartmoney.repositories.TransactionRepository;
import me.gabreuw.smartmoney.services.exceptions.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<TransactionDTO> findAll() {
        return transactionMapper(repository.findAll());
    }

    public TransactionDTO findById(Long id) {
        return repository.findById(id)
                .map(TransactionDTO::new)
                .orElseThrow(() -> new EntityNotFound(id));
    }

    public List<TransactionDTO> findByMoment(Instant moment) {
        return transactionMapper(repository.findAllByMoment(moment));
    }

    public List<TransactionDTO> findByMomentRange(Instant min, Instant max) {
        return transactionMapper(repository.findAllByMomentBetween(min, max));
    }

    private List<TransactionDTO> transactionMapper(List<Transaction> transactions) {
        return transactions.stream()
                .map(TransactionDTO::new)
                .collect(Collectors.toList());
    }
}
