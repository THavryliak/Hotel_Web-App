package com.havryliak.DAO;

import java.util.List;

public interface DAOi<T> {

    List<T> getAll();
    //Returns a list of all objects stored in DB

    void add(T t);
    //Adds new object to DB

    void deleteBy(int param);
    //Room - deletes by room number
    //Roomer - deletes by id
    //Room_Roomer - deletes by id

    T findBy(int param);
    //Room - finds by number
    //Roomer - finds by id
    //Room_Roomer - finds by id
}
