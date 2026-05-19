package model.repository;

import model.entity.Entrega;

import java.util.HashMap;

public class EntregaRepository {

    private final HashMap<Integer, Entrega> entregas = new HashMap<>();

    public void cadastrar(Entrega entrega){
        entregas.put(entrega.getId(), entrega);
    }

    public Entrega buscarPorId(int id){
        return entregas.get(id);
    }

    public HashMap<Integer, Entrega> listar(){
        return entregas;
    }

    public void remover(int id){
        entregas.remove(id);
    }
}
