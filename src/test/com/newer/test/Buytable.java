package com.newer.test;

import com.newer.mapper.BuytableMapper;
import com.newer.service.BuytableService;
import org.junit.Test;
import java.sql.Date;

import java.util.List;

public class Buytable {
    @Test
    public void findAllbuytable(){

        BuytableService buytableService=new BuytableService();
        buytableService.findAllBuytable().forEach(buytable -> {
            System.out.println(buytable.getNumber()+buytable.getFname());
        });


    }
}
