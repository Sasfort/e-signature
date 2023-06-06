package com.kredinesia.esignature.services;

import com.kredinesia.esignature.dto.callback.CallbackRequest;
import com.kredinesia.esignature.dto.callback.CallbackResponse;
import com.kredinesia.esignature.dto.status.StatusRequest;
import com.kredinesia.esignature.dto.status.StatusResponse;
import com.kredinesia.esignature.dto.update.UpdateRequest;
import com.kredinesia.esignature.dto.update.UpdateResponse;
import com.kredinesia.esignature.dto.upload.UploadRequest;
import com.kredinesia.esignature.dto.upload.UploadResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignatureService {
    public UpdateResponse updateData(UpdateRequest updateRequest) {
        return new UpdateResponse(
                "200",
                updateRequest.toString(),
                "Data has been updated successfully."
        );
    }

    public UploadResponse uploadContract(UploadRequest uploadRequest) {
        List<Object> objectList = new ArrayList<>();
        return new UploadResponse("200", objectList, "Document has been uploaded.");
    }

    public StatusResponse checkStatus(StatusRequest statusRequest) {
        List<Object> objectList = new ArrayList<>();
        return new StatusResponse("200", objectList, "Status has been successfully retrieved.");
    }

    public CallbackResponse returnCallback(CallbackRequest callbackRequest) {
        return new CallbackResponse("200", callbackRequest.toString(), "Callback has been returned.");
    }
}
