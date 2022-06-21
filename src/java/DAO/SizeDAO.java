/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.TblAccount;
import entities.TblSize;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nhine
 */
public class SizeDAO implements Generate<TblSize, Integer>{

    Session session;

    public SizeDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public List<TblSize> getAll() {
        Query q = session.createQuery("from TblSize");
        return q.list();
    }

    @Override
    public TblSize getById(Integer id) {
        return (TblSize) session.get(TblSize.class, id);
    }

    @Override
    public List<TblSize> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(TblSize obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(TblSize obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
