package duckdns.niceft.nicefilmticket.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class BuyerController {

    @GetMapping("/hello")
    public String helloWorld() {

        return "hello world";
    }
}
