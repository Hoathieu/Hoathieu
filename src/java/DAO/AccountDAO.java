/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.TblAccount;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nhine
 */
public class AccountDAO implements Generate<TblAccount, Integer>{

    Session session;

    public AccountDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public List<TblAccount> getAll() {
        Query q = session.createQuery("from TblAccount");
        return q.list();
    }

    @Override
    public TblAccount getById(Integer id) {
        return (TblAccount) session.get(TblAccount.class, id);
    }

    @Override
    public List<TblAccount> searchByName(String name) {
        Query q = session.createQuery("from TblAccount where accLogin = :name");
        q.setParameter("name", name);
        return q.list();
    }

    @Override
    public boolean create(TblAccount obj) {
        try {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(TblAccount obj) {
        try {
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            session.beginTransaction();
            session.delete(getById(id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean login(String name, String pass) {
        Query q = session.createQuery("from TblAccount where accLogin = :name and accPassword = :pass");
        q.setParameter("name", name);
        q.setParameter("pass", pass);
        return q.list().size() > 0;
    }
}
