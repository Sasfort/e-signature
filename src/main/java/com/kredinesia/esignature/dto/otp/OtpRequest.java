package com.kredinesia.esignature.dto.otp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtpRequest {
    String otp;
    String email;
}
