package me.gabreuw.smartmoney.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardException {

    private Long timestamp;
    private Integer status;
    private String errorType;
    private String errorMessage;
    private String path;

}
