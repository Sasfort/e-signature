package com.kredinesia.esignature.dto.upload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UploadResponse {
    String code;
    List<Object> data;
    String message;
}
