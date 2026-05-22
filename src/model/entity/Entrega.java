package model.entity;

public class Entrega {

    private int id;
    private Cliente cliente;
    private Entregador entregador;
    private String descricao;
    public enum Status{
        PENDENTE,
        EM_ANDAMENTO,
        FINALIZADA
    }
    
    public Status status;

    public Entrega(int id, Cliente cliente, Entregador entregador, String descricao, Status status) {
        this.id = id;
        this.cliente = cliente;
        this.entregador = entregador;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", entregador=" + entregador +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                '}';
    }
}
