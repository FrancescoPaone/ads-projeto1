package br.puc.ads.projetoIntegrador1.model;

public class Paciente {
    String nome;
    Integer idade;

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public Paciente(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Paciente(String nome) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }


}
