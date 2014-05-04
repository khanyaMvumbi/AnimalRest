/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.services;

/**
 *
 * @author Khanya
 */
import java.util.List;

public interface Services<S, ID> {

    public S find(ID id);

    public S persist(S entity);

    public S merge(S entity);

    public void remove(S entity);

    public List<S> findAll();
}
