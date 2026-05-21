package model.service;

import model.entity.Cliente;
import model.repository.ClienteRepository;

public class ClienteService {
    
    public boolean cadastrarCliente(int id, String nome, String endereco, ClienteRepository clienteRepository){
        
        boolean idDuplicado = false;
        
        for(Cliente c : clienteRepository.listar().values()){
            if(c.getId() == id){
                idDuplicado = true;
            }
        }
        if(idDuplicado){
            return true;
        }
        
        if(nome.isBlank()){
            return false;
        }
        
        if(endereco.isBlank()){
            return false;
        }
        clienteRepository.salvar(new Cliente(id, nome, endereco));
        return true;
    }
}
