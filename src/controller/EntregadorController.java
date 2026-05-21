package controller;

import model.repository.EntregadorRepository;
import model.service.EntregadorService;

public class EntregadorController {

    private final EntregadorRepository repository;
    private final EntregadorService service = new EntregadorService();

    public EntregadorController(EntregadorRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrar(int id, String nome, String veiculo){
        return service.cadastrarEntregador(id, nome, veiculo, repository);
    }
}
