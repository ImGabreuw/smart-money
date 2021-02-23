package me.gabreuw.smartmoney.controller;

import me.gabreuw.smartmoney.domain.dto.TransactionDTO;
import me.gabreuw.smartmoney.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll() {
        List<TransactionDTO> transactions = service.findAll();

        return ResponseEntity
                .ok()
                .body(transactions);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable Long id) {
        TransactionDTO transactionDTO = service.findById(id);

        return ResponseEntity
                .ok()
                .body(transactionDTO);
    }

}
