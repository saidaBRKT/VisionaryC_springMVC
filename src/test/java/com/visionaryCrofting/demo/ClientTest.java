package com.visionaryCrofting.demo;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ClientTest {
    @Autowired
    ClientService clientService;
    @Test
    public void addClient(){
        Client client = new Client("salim@gmail..com","Azerty@123","0677889900", List.of());
        Client client1 = new Client();
        Client result = clientService.addClient(client1);
        Assertions.assertSame(client1,result);
    }
    @Test
    public void updatClient(){
        Long id = Long.valueOf(1);
        Client client = new Client("said@gmail.com","Azerty@23","123456789",new ArrayList<>());
        Client result = clientService.updateClient(id,client);
        System.out.println(result);
        Assertions.assertEquals(id,result.getId());
    }

}
