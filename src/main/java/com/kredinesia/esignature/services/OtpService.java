package com.kredinesia.esignature.services;

import com.kredinesia.esignature.dto.email.EmailRequest;
import com.kredinesia.esignature.dto.email.EmailResponse;
import com.kredinesia.esignature.dto.otp.Otp;
import com.kredinesia.esignature.dto.otp.OtpRequest;
import com.kredinesia.esignature.dto.otp.OtpResponse;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class OtpService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public EmailResponse sendOtp(EmailRequest emailRequest) {
        try {
            String password = getOtp();
            Otp otp = new Otp(
                    emailRequest.getRecipient(),
                    password,
                    new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5))
            );
            //Save OTP

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setFrom(new InternetAddress(sender));
            message.setRecipients(MimeMessage.RecipientType.TO, emailRequest.getRecipient());
            message.setSubject("OTP untuk Peminjaman di Kredinesia");

            String htmlContent = String.format(
                    "<p>Terima kasih sudah menggunakan Kredinesia. OTP anda adalah <strong>%s</strong>. " +
                            "Silakan masukkan password tersebut di aplikasi Kredinesia anda untuk melanjutkan " +
                            "proses peminjaman.</p> " +
                            "<img src=\"https://www.kredinesia.id/static/img/footerlogo.bc27069.png\" width=\"300\">",
                    password
            );
            message.setContent(htmlContent, "text/html; charset=utf-8");

            javaMailSender.send(message);

            return new EmailResponse(
                    "200",
                    emailRequest.toString(),
                    String.format("Email sent to %s successfully.", emailRequest.getRecipient())
            );
        } catch (Exception e) {
            return new EmailResponse("500", emailRequest.toString(), e.getMessage());
        }
    }

    public OtpResponse submitOtp(OtpRequest otpRequest) {
        return new OtpResponse("200", otpRequest.toString(), "Otp is correct.");
    }

    public static String getOtp() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
