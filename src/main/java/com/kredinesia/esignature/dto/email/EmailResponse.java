package com.kredinesia.esignature.dto.email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailResponse {
    String code;
    String data;
    String message;
}
