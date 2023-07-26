package com.mentorama.Alunos.Model;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/CadastroDeAlunos")
public class AlunosController<nome> {
    private final List<Alunos> alunos;

    public AlunosController(){
        this.alunos = new ArrayList<>();
        Alunos aluno1 = new Alunos(1, "Herculano", 42);
        Alunos aluno2 = new Alunos(2, "Lima", 32);
        Alunos aluno3 = new Alunos(3, "Pedro", 21);
        Alunos aluno4 = new Alunos(4, "Mateus", 60);
        this.alunos.add(aluno1);
        this.alunos.add(aluno2);
        this.alunos.add(aluno3);
        this.alunos.add(aluno4);
    }


    @GetMapping
    public List<Alunos> findAll(@RequestParam(required = false) String aluno) {
        return alunos.stream()
                .filter(aln -> aln.getNomeDoAluno().contains(aluno))
                .collect(Collectors.toList());
    }


    @GetMapping("/id/{id}")
    public Alunos buscarporid(@PathVariable("id") Integer id ){
        return this.alunos.stream().filter(aln -> aln.getId().equals(id)).findFirst()
                .orElse(null);

    }


    @PostMapping
    public Integer add(@RequestBody final @NonNull Alunos aluno){
        if(aluno.getId() == 1){
            aluno.setId(aluno.size() + 1);
        }
        alunos.add(aluno);
        return aluno.getId();
    }
    @PutMapping
    public void update(@RequestBody final Alunos aluno){
        alunos.stream().filter(aln -> aln.getId().equals(aluno.getId()))
                .forEach(aln -> aln.setNomeDoAluno(aluno.getNomeDoAluno()));
    }
    @DeleteMapping("/(id)")
    public void delete(@PathVariable ("id") Integer id){
        alunos.removeIf(aln -> aln.getId().equals(id));

    }
}
