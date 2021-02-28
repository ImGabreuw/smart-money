package me.gabreuw.smartmoney.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gabreuw.smartmoney.domain.Transaction;
import me.gabreuw.smartmoney.domain.enums.TransactionType;
import me.gabreuw.smartmoney.utils.helpers.DateHelper;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TransactionDTO {

    private String name;
    private Double amount;
    private Date moment;

    private TransactionType type;

    public TransactionDTO(Transaction transaction) {
        this.name = transaction.getName();
        this.amount = transaction.getAmount();
        this.moment = transaction.getMoment();
        this.type = transaction.getType();
    }

    public int getType() {
        return type.getCode();
    }

    public String getMoment() {
        return DateHelper.format(moment);
    }
}
