package com.kredinesia.esignature.dto.otp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Otp {
    String email;
    String code;
    Date expire;
}
