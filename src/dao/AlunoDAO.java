package dao;

import Modelo.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AlunoDAO {
    EntityManager em;
    
    public AlunoDAO() throws Exception {
        EntityManagerFactory emf;
        emf = Conexao.getConexao();
        em = emf.createEntityManager();
    }
    
    public void incluir(Aluno obj) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
//            em.close();
            
        }
        
    }

    public List<Aluno> listar() throws Exception {
        return em.createNamedQuery("Aluno.findAll").getResultList();
    }
    
    public void alterar(Aluno obj) throws Exception {
        
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
//            em.close();
        }
    }
    
    public void excluir(Aluno obj) throws Exception {
        
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
        } finally {
//            em.close();
        }
    }

//    public void fechaEmf() {
//        Conexao.closeConexao();
//    }
//    
//    
//    private void verificaConexao() throws Exception
//    {
//        if(!em.isOpen())
//        {
//             EntityManagerFactory emf;
//            emf = Conexao.getConexao();
//            em = emf.createEntityManager();
//        }
//    }
    

}
