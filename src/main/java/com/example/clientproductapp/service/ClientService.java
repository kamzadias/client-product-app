package com.example.clientproductapp.service;

import com.example.clientproductapp.dto.ClientDto;
import com.example.clientproductapp.entity.Client;
import com.example.clientproductapp.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<ClientDto> getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(value -> modelMapper.map(value, ClientDto.class));
    }

    public Optional<ClientDto> getClientByIin(String iin) {
        Optional<Client> client = clientRepository.findByIin(iin);
        return client.map(value -> modelMapper.map(value, ClientDto.class));
    }
}
