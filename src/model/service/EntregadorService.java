package model.service;
import model.entity.Entregador;
import model.repository.EntregadorRepository;

public class EntregadorService {

    public boolean cadastrarEntregador(int id, String nome, String veiculo, EntregadorRepository entregadorRepository){

        for(Entregador e : entregadorRepository.listar().values()){
            if(e.getId() == id){
                return false;
            }
        }

        if(nome.isBlank()){
            return false;
        }

        if(veiculo.isBlank()){
            return false;
        }
        entregadorRepository.salvar(new Entregador(id, nome, veiculo));
        return true;
    }
}
