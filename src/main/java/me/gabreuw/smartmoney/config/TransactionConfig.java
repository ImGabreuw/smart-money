package me.gabreuw.smartmoney.config;

import lombok.SneakyThrows;
import me.gabreuw.smartmoney.domain.Transaction;
import me.gabreuw.smartmoney.domain.enums.TransactionType;
import me.gabreuw.smartmoney.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

@Configuration
public class TransactionConfig implements CommandLineRunner {

    @Autowired
    private TransactionRepository repository;

    @SneakyThrows
    @Override
    public void run(String... args) {
        Transaction luz = new Transaction(null, "Luz", 100.0, Instant.now(), TransactionType.EXPENSE);
        Transaction site = new Transaction(null, "Site", 1000.0, Instant.now(), TransactionType.INCOME);

        repository.saveAll(List.of(
           luz,
           site
        ));
    }
}
