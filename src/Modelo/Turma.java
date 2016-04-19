package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma implements Serializable{

    @Id
    private String turma;
    
    @Column (length=50, nullable = false)
    private String nivel;
    
    @Column (nullable = false)
    private int serie;
    
    @Column (nullable = false)
    private int sala;
    
    @Column (nullable = false)
    private boolean ventiladores;
    
    @Column (nullable = false)
    private boolean televisao;
    
    @Column (nullable = false)
    private int NumProfessores;
    
    @OneToMany (mappedBy="turma")
    private List<Aluno> alunos;

    
    
    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getSerie() {
        return serie;
    }
    public void setSerie(int serie) {
        this.serie = serie;
    }
    
    public int getSala() {
        return sala;
    }
    public void setSala(int sala) {
        this.sala = sala;
    }
    
    public boolean getVentiladores() {
        return ventiladores;
    }
    public void setVentiladores(boolean ventiladores) {
        this.ventiladores = ventiladores;
    }
    
    public boolean getTelevisao() {
        return televisao;
    }
    public void setTelevisao(boolean televisao) {
        this.televisao = televisao;
    }
    
    public int getNumProfessores() {
        return NumProfessores;
    }
    public void setNumProfessores(int NumProfessores) {
        this.NumProfessores = NumProfessores;
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

 
}
