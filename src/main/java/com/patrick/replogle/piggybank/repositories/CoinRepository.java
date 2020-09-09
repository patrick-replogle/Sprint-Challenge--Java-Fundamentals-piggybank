package com.patrick.replogle.piggybank.repositories;

import com.patrick.replogle.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long>
{

}
