package com.nttdata.bootcoin.domain.events;

import com.nttdata.bootcoin.infrastructure.entity.ExchangeRate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateExchangeCreatedEvent extends Event<ExchangeRate> {

}
