package com.kredinesia.esignature.dto.callback;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CallbackRequest {
    String eventName;
    List<Object> data;
    String docTitle;
    String docToken;
    List<Object> recipients;
    String privyId;
    String type;
    String signatoryStatus;
    String signedAt;
    String documentStatus;
    List<Object> download;
    String url;
    String expiredAt;
    String message;
}
