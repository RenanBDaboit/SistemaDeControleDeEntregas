package controller;

import model.entity.Cliente;
import model.entity.Entrega;
import model.entity.Entregador;
import model.repository.ClienteRepository;
import model.repository.EntregaRepository;
import model.repository.EntregadorRepository;
import model.service.EntregaService;

import java.util.HashMap;

public class EntregaController {

    private final EntregaRepository repository;
    private final EntregadorRepository entregadorRepository;
    private final ClienteRepository clienteRepository;
    private final EntregaService service = new EntregaService();

    public EntregaController(EntregaRepository repository, EntregadorRepository entregadorRepository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.entregadorRepository = entregadorRepository;
        this.clienteRepository = clienteRepository;
    }

    public boolean cadastrar(int id, int idCliente, int idEntregador, String descricao, Entrega.Status status){
        return service.cadastrarEntrega(id, idCliente, idEntregador, descricao, clienteRepository, entregadorRepository, repository);
    }

    public boolean atualizar(int id, int idCliente, int idEntregador, String descricao){
        return service.atualizar(id, idCliente, idEntregador, descricao, clienteRepository, entregadorRepository, repository);
    }

    public boolean finalizar(int id){
        return service.finalizar(id, repository);
    }

    public boolean remover(int id){
        return service.remover(id, repository);
    }

    public HashMap<Integer, Cliente> listarClientes(){
        return clienteRepository.listar();
    }

    public HashMap<Integer, Entregador> listarEntregadores(){
        return entregadorRepository.listar();
    }

}
