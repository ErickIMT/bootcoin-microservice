package com.nttdata.bootcoin.infrastructure.service;

import com.nttdata.bootcoin.domain.service.ExchangeEventService;
import com.nttdata.bootcoin.infrastructure.entity.ExchangeRate;
import com.nttdata.bootcoin.infrastructure.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class ExchangeRateService implements ExchangeRateRepository {

  @Autowired
  private ExchangeEventService exchangeEventService;

  @Override
  public Mono<ExchangeRate> save(ExchangeRate exchangeRate) {

    /*Se establece fecha del registro*/
    exchangeRate.setRegisteredDate(new Date());

    /*Registro de Evento con KAFKA*/
    exchangeEventService.publish(exchangeRate);
    return Mono.just(exchangeRate);
  }
}
