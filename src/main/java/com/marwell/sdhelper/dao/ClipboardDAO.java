package com.marwell.sdhelper.dao;

import com.marwell.sdhelper.ConnectionFactory.HibernateUtil;
import com.marwell.sdhelper.model.Agente;
import com.marwell.sdhelper.model.Clipboard;
import com.marwell.sdhelper.model.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 *
 * @author Eduardo Marwell
 */
public class ClipboardDAO {
    private final SessionFactory factory = new HibernateUtil().getConnection();
    private final Session session;
    private final Transaction transaction;

    public ClipboardDAO(){
        session = factory.openSession();
        transaction = session.beginTransaction();
    }
 
    public boolean add (Clipboard clipboard) {
        try {
            session.save(clipboard);
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
    
    public boolean update (Clipboard clipboard) {
         try {
            session.update(clipboard);
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
        
    public boolean delete (Clipboard clipboard) {
        try {
            session.delete(clipboard);
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
    
    public List<Agente> buscaLink (Link link) {
        String query = "from Agente clipboard where agente.backlog = true";
        List<Agente> retorno = session.createQuery(query).list();
        transaction.commit();
        return retorno;
    }
}
