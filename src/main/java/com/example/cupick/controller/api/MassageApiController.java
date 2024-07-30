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


    public void sendOne(String to) {
        System.out.println(11111);
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01099858941");
        message.setTo(to);
        message.setText("[Cupick]"+"\n"+"서로가 연결되었습니다"+"\n"+"서로에게 연락을 해보세요");

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);
    }
}
