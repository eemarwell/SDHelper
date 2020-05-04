package com.marwell.sdhelper.dao;

import com.marwell.sdhelper.ConnectionFactory.HibernateUtil;
import com.marwell.sdhelper.model.Agente;
import com.marwell.sdhelper.model.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 *
 * @author Eduardo Marwell
 */
public class LinkDAO {
    private final SessionFactory factory = new HibernateUtil().getConnection();
    private final Session session;
    private final Transaction transaction;

    public LinkDAO(){
        session = factory.openSession();
        transaction = session.beginTransaction();
    }
 
    public boolean add (Link link) {
        try {
            session.save(link);
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
    
    public boolean update (Link link) {
         try {
            session.update(link);
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
        
    public boolean delete (Link link) {
        try {
            session.delete(link);
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
    
    public List<Agente> buscaBacklog (Link link) {
        String query = "from Link link where link";
        List<Agente> retorno = session.createQuery(query).list();
        transaction.commit();
        return retorno;
    }
}
