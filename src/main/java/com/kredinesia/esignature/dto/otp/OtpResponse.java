package com.kredinesia.esignature.dto.otp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtpResponse {
    String code;
    String data;
    String message;
}
