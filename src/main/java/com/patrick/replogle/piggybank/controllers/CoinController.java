package com.patrick.replogle.piggybank.controllers;

import com.patrick.replogle.piggybank.models.Coin;
import com.patrick.replogle.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{

    @Autowired
    private CoinRepository emprepos;

    // http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listAllCoins()
    {
        List<Coin> myList = new ArrayList<>();

        emprepos.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1, c2) -> (int)(c1.getValue() - c2.getValue()));

        double total = 0;
        for (Coin c : myList)
        {
            total += c.getQuantity() * c.getValue();
            int quantity = c.getQuantity();

            if (quantity == 1)
            {
                System.out.println(quantity + " " + c.getName());
            }

            else if(quantity > 1)
            {
                System.out.println(quantity + " " + c.getNameplural());
            }
        }

        System.out.printf("The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
