package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Client;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    List<Client> getAllClients();
    Optional<Client> getOnById(Long id);
    Client addClient(Client client);
    Client updateClient(Long id,Client client);

    Client findByEmail(String email);
}
