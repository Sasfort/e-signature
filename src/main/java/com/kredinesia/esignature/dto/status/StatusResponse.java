package com.kredinesia.esignature.dto.status;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StatusResponse {
    String code;
    List<Object> data;
    String message;
}
