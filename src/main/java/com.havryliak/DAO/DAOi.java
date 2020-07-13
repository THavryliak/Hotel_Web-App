package com.havryliak.DAO;

import java.util.List;

public interface DAOi<T> {

    List<T> getAll();
    //Returns a list of all objects stored in DB

    void add(T t);
    //Adds new object  to DB

    void deleteBy(int param);
    //Room - delete by room number
    //Roomer - delete by id

    T findBy(int param);
    //Room - find by number
    //Roomer - find by id
}
