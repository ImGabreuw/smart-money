package me.gabreuw.smartmoney.config;

import lombok.SneakyThrows;
import me.gabreuw.smartmoney.domain.Transaction;
import me.gabreuw.smartmoney.domain.enums.TransactionType;
import me.gabreuw.smartmoney.repositories.TransactionRepository;
import me.gabreuw.smartmoney.utils.helpers.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TransactionConfig implements CommandLineRunner {

    @Autowired
    private TransactionRepository repository;

    @SneakyThrows
    @Override
    public void run(String... args) {
        Transaction luz = new Transaction(null, "Luz", 100.0, DateHelper.parse("2021-02-28"), TransactionType.EXPENSE);
        Transaction site = new Transaction(null, "Site", 1000.0, DateHelper.parse("2021-02-20"), TransactionType.INCOME);

        repository.saveAll(List.of(
           luz,
           site
        ));
    }
}
