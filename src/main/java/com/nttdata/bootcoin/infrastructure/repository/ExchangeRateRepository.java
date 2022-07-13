package com.nttdata.bootcoin.infrastructure.repository;

import com.nttdata.bootcoin.infrastructure.entity.ExchangeRate;
import reactor.core.publisher.Mono;

public interface ExchangeRateRepository {

  Mono<ExchangeRate> save(ExchangeRate exchangeRate);
}
