
package Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int matricula;
    
    @Column(length=100,nullable=false)
    private String nome;
    
    @Column(precision=10,scale=2,nullable=false)
    private BigDecimal renda;

    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date nascimento;

    @Column(nullable=false)
    private int idade;
    
    @Column(length=11, nullable=false)
    private String cpf;

    @Column(precision=5, scale=2, nullable=false)
    private Double rendimento;
    
    @Column(nullable = false)
    private int faltas;

    @ManyToOne 
    @JoinColumn(name = "turma")
    private Turma turma;
    
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Double getRendimento() {
        return rendimento;
    }
    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }

    public int getFaltas() {
        return faltas;
    }
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public BigDecimal getRenda() {
        return renda;
    }
    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
}
