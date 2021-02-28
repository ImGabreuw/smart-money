package me.gabreuw.smartmoney.controller;

import me.gabreuw.smartmoney.domain.dto.TransactionDTO;
import me.gabreuw.smartmoney.services.TransactionService;
import me.gabreuw.smartmoney.utils.helpers.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/momentseach")
    public ResponseEntity<List<TransactionDTO>> findByMoment(
            @RequestParam(value = "moment", defaultValue = "") String moment
    ) {
        List<TransactionDTO> transactionDTO = service.findByMoment(DateHelper.parse(moment));

        return ResponseEntity
                .ok()
                .body(transactionDTO);
    }

    @GetMapping(path = "/rangeseach")
    public ResponseEntity<List<TransactionDTO>> findByMomentRage(
            @RequestParam(value = "minMoment", defaultValue = "") String min,
            @RequestParam(value = "maxMoment", defaultValue = "") String max
    ) {
        List<TransactionDTO> transactionDTO = service.findByMomentRange(
                DateHelper.parse(min),
                DateHelper.parse(max)
        );

        return ResponseEntity
                .ok()
                .body(transactionDTO);
    }

}
