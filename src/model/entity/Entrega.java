package model.entity;

public class Entrega {

    private int id;
    private Cliente cliente;
    private Entregador entregador;
    private String descricao;
    private String status;

    public Entrega(int id, Cliente cliente, Entregador entregador, String descricao, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
