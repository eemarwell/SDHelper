package com.marwell.sdhelper.dao;

import com.marwell.sdhelper.ConnectionFactory.HibernateUtil;
import com.marwell.sdhelper.model.Agente;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Eduardo Marwell
 */
public class AgenteDAO {
    private final SessionFactory factory = new HibernateUtil().getConnection();
    private final Session session;
    private final Transaction transaction;
    
    public AgenteDAO(){
        session = factory.openSession();
        transaction = session.beginTransaction();
    }
 
    public boolean add (Agente agente) {
        try {
            session.save(agente);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("==================ERRO====================");
            System.out.println(e);
            return false;
        } finally {
            session.close();
            factory.close();
        }
       
    }
    
    public boolean update (Agente agente) {
         try {
            session.update(agente);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("==================ERRO====================");
            System.out.println(e);
            return false;
        } finally {
            session.close();
            factory.close();
        }
    }
        
    public boolean delete (Agente agente) {
        try {
            session.delete(agente);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("==================ERRO====================");
            System.out.println(e);
            return false;
        } finally {
            session.close();
            factory.close();
        }
    }
    
    public List<Agente> buscaBacklog (Agente agente) {
        String query = "from Agente agente where agente.backlog = true";
        List<Agente> retorno = session.createQuery(query).list();
        transaction.commit();
        return retorno;
    }
}
