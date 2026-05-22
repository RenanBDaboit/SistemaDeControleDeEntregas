package model.service;

import model.entity.Cliente;
import model.entity.Entrega;
import model.entity.Entregador;
import model.repository.ClienteRepository;
import model.repository.EntregaRepository;
import model.repository.EntregadorRepository;

public class EntregaService {
    
    public boolean cadastrarEntrega(int id, int idCliente, int idEntregador, String descricao, 
                                    ClienteRepository clienteRepository, EntregadorRepository entregadorRepository, 
                                    EntregaRepository entregaRepository){
        boolean entregadorNaoExistente = true;
        boolean clienteNaoExistente = true;
        
        Cliente clienteSalvar = null;
        Entregador entregadorSalvar = null;
        
        if(descricao.isBlank()){
            return false;
        }
        
        for(Cliente cliente : clienteRepository.listar().values()){
            if(cliente.getId() == idCliente){
                clienteNaoExistente = false;
                clienteSalvar = cliente;
            }
        }
        
        for(Entregador entregador : entregadorRepository.listar().values()){
            if(entregador.getId() == idEntregador){
                entregadorNaoExistente = false;
                entregadorSalvar = entregador;
            }
        }
        
        for(Entrega entrega : entregaRepository.listar().values()){
            if(entrega.getId() == id){
                return false;
            }
        }
        
        if(clienteNaoExistente){
            return false;
        }
        
        if(entregadorNaoExistente){
            return false;
        }
        
        entregaRepository.salvar(new Entrega(id, clienteSalvar, entregadorSalvar, descricao, Entrega.Status.PENDENTE));
        entregadorSalvar.setDispnivel(false);
        return true;
        
    }
    
    public boolean atualizar(int id, int idCliente, int idEntregador, String descricao,
                             ClienteRepository clienteRepository, EntregadorRepository entregadorRepository,
                             EntregaRepository entregaRepository){

        boolean idNaoExistente = true;
        boolean entregadorNaoExistente = true;
        boolean clienteNaoExistente = true;

        Cliente clienteAtualizar = null;
        Entregador entregadorAtualizar = null;

        if(descricao.isBlank()){
            return false;
        }

        for(Cliente cliente : clienteRepository.listar().values()){
            if(cliente.getId() == idCliente){
                clienteNaoExistente = false;
                clienteAtualizar = cliente;
            }
        }

        for(Entregador entregador : entregadorRepository.listar().values()){
            if(entregador.getId() == idEntregador){
                entregadorNaoExistente = false;
                entregadorAtualizar = entregador;
            }
        }

        for(Entrega entrega : entregaRepository.listar().values()){
            if(entrega.getId() == id){
                idNaoExistente = false;
            }
        }

        if(idNaoExistente){
            return false;
        }

        if(clienteNaoExistente){
            return false;
        }

        if(entregadorNaoExistente){
            return false;
        }

        entregaRepository.salvar(new Entrega(id, clienteAtualizar, entregadorAtualizar, descricao, Entrega.Status.EM_ANDAMENTO));
        entregadorAtualizar.setDispnivel(false);
        return true;
    }
    
    public boolean finalizar(int id, EntregaRepository entregaRepository){

        boolean idNaoExistente = true;
        
        for(Entrega entrega : entregaRepository.listar().values()){
            if(entrega.getId() == id){
                idNaoExistente = false;
            }
        }

        if(idNaoExistente){
            return false;
        }

        
        entregaRepository.listar().get(id).setStatus(Entrega.Status.FINALIZADA);
        return true;
    }
    
    public boolean remover(int id, EntregaRepository entregaRepository){

        boolean idNaoExistente = true;

        for(Entrega entrega : entregaRepository.listar().values()){
            if(entrega.getId() == id){
                idNaoExistente = false;
            }
        }

        if(idNaoExistente){
            return false;
        }
        
        if(!entregaRepository.listar().get(id).getStatus().equals(Entrega.Status.FINALIZADA)){
            return false;
        }
        
        entregaRepository.remover(id);
        return true;
    }
}
