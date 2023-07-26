package com.mentorama.Alunos.Model;

public class Alunos {
    private Integer id;
    private String NomeDoAluno;
    private Integer idade;


    public Alunos(Integer id, String nomeDoAluno, Integer idade){
        this.id = id;
        NomeDoAluno = nomeDoAluno;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDoAluno() {
        return NomeDoAluno;
    }

    public void setNomeDoAluno(String nomeDoAluno) {
        NomeDoAluno = nomeDoAluno;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer size(){
        return 0;
    }
}
