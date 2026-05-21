package model.repository;

import model.entity.Entregador;

import java.util.HashMap;

public class EntregadorRepository {

    private final HashMap<Integer, Entregador> entregadores = new HashMap<>();

    public void salvar(Entregador entregador){
        entregadores.put(entregador.getId(), entregador);
    }

    public void cadastrar(Entregador entregador){
        entregadores.put(entregador.getId(), entregador);
    }

    public Entregador buscarPorId(int id){
        return entregadores.get(id);
    }

    public HashMap<Integer, Entregador> listar(){
        return entregadores;
    }

    public void remover(int id){
        entregadores.remove(id);
    }
}
