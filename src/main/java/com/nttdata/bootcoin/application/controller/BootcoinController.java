package com.nttdata.bootcoin.application.controller;

import com.nttdata.bootcoin.infrastructure.entity.ExchangeRate;
import com.nttdata.bootcoin.infrastructure.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BootcoinController {

  @Autowired
  private ExchangeRateService exchangeRateService;

  @PostMapping("/exchange")
  private Mono<ExchangeRate> updateExchangeRate(@RequestBody ExchangeRate exchangeRate) {
    return exchangeRateService.save(exchangeRate);
  }
}
