package com.example.cupick.controller.api;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Random;

@RestController
public class MassageApiController {

    private DefaultMessageService messageService;

    @Value("${sms.apikey}")
    private String apiKey;

    @Value("${sms.secretkey}")
    private String SecretKey;

    @PostConstruct
    private void MassageContra() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, SecretKey, "https://api.coolsms.co.kr");

    }
    /**
     * 단일 메시지 발송 예제
     */
    @PostMapping("/check/sendSms")
    public String sendOne(@RequestParam(value = "to") String to) {
        System.out.println(11111);
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01099858941");
        message.setTo(to);
        String numStr="";
        for(int i=0; i<6; i++) {
            Random random = new Random();
            String ran = Integer.toString(random.nextInt(10));
            numStr+=ran;
        }
        System.out.println(numStr);
        message.setText("인증번호는 ["+numStr+"] 입니다.");

        /*SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);*/
        return numStr;
    }
}
