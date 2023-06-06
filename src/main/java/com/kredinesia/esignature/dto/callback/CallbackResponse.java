package com.kredinesia.esignature.dto.callback;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CallbackResponse {
    String code;
    String data;
    String message;
}
