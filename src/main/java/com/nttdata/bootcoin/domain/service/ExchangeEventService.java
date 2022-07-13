package com.nttdata.bootcoin.domain.service;

import com.nttdata.bootcoin.domain.events.Event;
import com.nttdata.bootcoin.domain.events.EventType;
import com.nttdata.bootcoin.domain.events.UpdateExchangeCreatedEvent;
import com.nttdata.bootcoin.infrastructure.entity.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ExchangeEventService {

  @Autowired
  private KafkaTemplate<String, Event<?>> producer;

  @Value("${topic.bootcoin.name:exchange}")
  private String topicExchange;

  public void publish(ExchangeRate exchangeRate) {

    UpdateExchangeCreatedEvent updated = new UpdateExchangeCreatedEvent();
    updated.setData(exchangeRate);
    updated.setId(UUID.randomUUID().toString());
    updated.setType(EventType.UPDATED);
    updated.setDate(new Date());

    this.producer.send(topicExchange, updated);
  }
}
