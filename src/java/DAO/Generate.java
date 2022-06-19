/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author nhine
 * @param <Object>
 * @param <T>
 */
public interface Generate<Object,T> {
    public List<Object> getAll();
    public Object getById(T id);
    public List<Object> searchByName(String name);
    public boolean create(Object obj);
    public boolean update(Object obj);
    public boolean delete(T id);
}
