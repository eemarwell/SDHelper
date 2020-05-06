package com.marwell.sdhelper.dao;

import com.marwell.sdhelper.ConnectionFactory.HibernateUtil;
import com.marwell.sdhelper.model.Clipboard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
    
    public List<Clipboard> buscaClipboard (Clipboard clipboard) {
        String query = "from Clipboard clipboard";
        List<Clipboard> retorno = session.createQuery(query).list();
        transaction.commit();
        return retorno;
    }

    public <T> List<T> buscaClipboards(Class<T> type) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }
}
