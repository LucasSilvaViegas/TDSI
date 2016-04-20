package dao;

import Modelo.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TurmaDAO {
    EntityManager em;
    
    public TurmaDAO() throws Exception {
        EntityManagerFactory emf;
        emf = Conexao.getConexao();
        em = emf.createEntityManager();
    }
    
    public void incluir(Turma obj) throws Exception {
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

    public List<Turma> listar() throws Exception {
        return em.createNamedQuery("Turma.findAll").getResultList();
    }
    
    public void alterar(Turma obj) throws Exception {
        
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
    
    public void excluir(Turma obj) throws Exception {
        
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
