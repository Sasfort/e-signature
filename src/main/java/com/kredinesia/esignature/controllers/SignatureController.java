package com.kredinesia.esignature.controllers;

import com.kredinesia.esignature.dto.callback.CallbackRequest;
import com.kredinesia.esignature.dto.callback.CallbackResponse;
import com.kredinesia.esignature.dto.email.EmailRequest;
import com.kredinesia.esignature.dto.email.EmailResponse;
import com.kredinesia.esignature.dto.otp.OtpRequest;
import com.kredinesia.esignature.dto.otp.OtpResponse;
import com.kredinesia.esignature.dto.status.StatusRequest;
import com.kredinesia.esignature.dto.status.StatusResponse;
import com.kredinesia.esignature.dto.update.UpdateRequest;
import com.kredinesia.esignature.dto.update.UpdateResponse;
import com.kredinesia.esignature.dto.upload.UploadRequest;
import com.kredinesia.esignature.dto.upload.UploadResponse;
import com.kredinesia.esignature.services.OtpService;
import com.kredinesia.esignature.services.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class SignatureController {

    @Autowired
    private SignatureService signatureService;

    @Autowired
    private OtpService otpService;

    @PutMapping("/update-data")
    @ResponseStatus(HttpStatus.OK)
    public UpdateResponse updateData(@RequestBody UpdateRequest updateRequest) {
        return signatureService.updateData(updateRequest);
    }

    @PostMapping("/upload-contract")
    @ResponseStatus(HttpStatus.CREATED)
    public UploadResponse uploadContract(@RequestBody UploadRequest uploadRequest) {
        return signatureService.uploadContract(uploadRequest);
    }

    @GetMapping("/check-status")
    @ResponseStatus(HttpStatus.OK)
    public StatusResponse checkStatus(@RequestBody StatusRequest statusRequest) {
        return signatureService.checkStatus(statusRequest);
    }

    @GetMapping("/return-callback")
    @ResponseStatus(HttpStatus.OK)
    public CallbackResponse returnCallback(@RequestBody CallbackRequest callbackRequest) {
        return signatureService.returnCallback(callbackRequest);
    }

    @PostMapping("/send-email")
    @ResponseStatus(HttpStatus.OK)
    public EmailResponse sendEmail(@RequestBody EmailRequest emailRequest) {
        return otpService.sendOtp(emailRequest);
    }

    @PostMapping("/submit-otp")
    @ResponseStatus(HttpStatus.OK)
    public OtpResponse submitOtp(@RequestBody OtpRequest otpRequest) {
        return otpService.submitOtp(otpRequest);
    }
}
