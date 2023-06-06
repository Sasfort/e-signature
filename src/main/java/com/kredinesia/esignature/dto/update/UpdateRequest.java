package com.kredinesia.esignature.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;

@Data
@AllArgsConstructor
public class UpdateRequest {
    File ktp;
    File selfie;
    File[] attachments;
    String[] attachmentsCategory;
}
