package me.gabreuw.smartmoney.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TransactionType {

    INCOME(1),
    EXPENSE(2);

    @Getter
    private final int code;

}
