package model.entity;

public class Entregador {

    private int id;
    private String nome;
    private String veiculo;
    private boolean disponivel;

    public Entregador(int id, String nome, String veiculo) {
        this.id = id;
        this.nome = nome;
        this.veiculo = veiculo;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public boolean isDispnivel() {
        return disponivel;
    }

    public void setDispnivel(boolean disponivel) {
        this.disponivel = disponivel;

        
    }
}
