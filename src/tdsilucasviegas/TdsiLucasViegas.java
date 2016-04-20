/*
    ANTES DE TUDO, QUERIA DEIXAR AQUI O RELATO DO QUE ACONTECEU NA AULA DE PROGRAMAÇÃO DO DIA 20/04/2016
    
    FOI DESCOBERTO UM BUG NA *Classe*DAO, ONDE SE NO ARQUIVO MAIN VOCÊ INSERE DOIS 'DADOS' NO BANCO
    COMO POR EXEMPLO:
        turmadao.incluir(t1);
        turmadao.incluir(t2);

    AO FINAL DA OPERAÇÃO incluir(t1) ELE FECHA A CONEXÃO, MAS AO REALIZAR O incluir(t2) ELE NÃO REALIZA
    POIS A CONEXÃO ESTÁ FECHADA.

    PARA RESOLVER ESSE BUG, CRIAMOS EM CASA ClasseDao UM MÉTODO CHAMADO VerificaConexao()
    MAS ELE É MEIO ESTRANHO, POIS CRIA E FECHA UMA CONEXÃO A CADA INSERT

    ENTÃO PARA NÃO REALIZAR ESSA OPERAÇÃO BIZARRA, A OPERAÇÃO FINAL DO ARQUIVO MAIN É FECHAR A CONEXÃO.
    MAS AÍ ESTÁ O PROBLEMA.
    
    NÃO É AUTOMÁTIZADO ESSA OPERAÇÃO.

    CABE AO PROGRAMADOR FECHAR A CONEXÃO.

    E ISSO PODE CAUSAR VÁRIOS PROBLEMAS NO FUTURO. ESSA OPERAÇÃO AINDA ESTÁ EM ABERTO.
    E PODE SER ATUALIZADA A QUALQUER MOMENTO.

        Ass.
            LucasSilvaViegas

*/

package tdsilucasviegas;

import Modelo.Aluno;
import Modelo.Turma;
import dao.AlunoDAO;
import dao.Conexao;
import dao.TurmaDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TdsiLucasViegas {

    public static void main(String[] args) throws ParseException, Exception {

        AlunoDAO alunodao = new AlunoDAO();
        TurmaDAO turmadao = new TurmaDAO();

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        Aluno a4 = new Aluno();

        Turma t1 = new Turma();
        Turma t2 = new Turma();

        a1.setNome("FULANO SILVA MACHADO");
        a1.setCpf("56040561051");
        a1.setFaltas(8);
        a1.setIdade(12);
        a1.setRenda(BigDecimal.valueOf(2500));
        a1.setRendimento(75.00);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = sdf.parse("15/1/1998");
        a1.setNascimento(data);

        a2.setNome("ZACUL AVLIS SAGEIV");
        a2.setCpf("04174704042");
        a2.setFaltas(0);
        a2.setIdade(16);
        a2.setRenda(BigDecimal.valueOf(2000));
        a2.setRendimento(99.99);
        data = sdf.parse("05/3/2000");
        a2.setNascimento(data);

        a3.setNome("BELTRANO SILVA MACHADO");
        a3.setCpf("75650471051");
        a3.setFaltas(10);
        a3.setIdade(16);
        a3.setRenda(BigDecimal.valueOf(1900));
        a3.setRendimento(87.50);
        data = sdf.parse("03/04/1996");
        a3.setNascimento(data);

        a4.setNome("CICLANO SILVA MACHADO");
        a4.setCpf("12345678910");
        a4.setFaltas(2);
        a4.setIdade(12);
        a4.setRenda(BigDecimal.valueOf(2225));
        a4.setRendimento(95.00);
        data = sdf.parse("29/2/2016");
        a4.setNascimento(data);
        
        t1.setNumProfessores(9);
        t1.setNivel("Médio");
        t1.setSala(14);
        t1.setSerie(3);
        t1.setTelevisao(true);
        t1.setVentiladores(true);
        t1.setTurma("3M");

        t2.setNumProfessores(12);
        t2.setNivel("Fundamental");
        t2.setSala(07);
        t2.setSerie(7);
        t2.setTelevisao(false);
        t2.setVentiladores(true);
        t2.setTurma("7F");
        
        turmadao.incluir(t1);
        turmadao.incluir(t2);
        
        a1.setTurma(t2);
        a2.setTurma(t1);
        a3.setTurma(t1);
        a4.setTurma(t2);

        alunodao.incluir(a1);
        alunodao.incluir(a2);
        alunodao.incluir(a3);
        alunodao.incluir(a4);

        Conexao.closeConexao();
    }

}
