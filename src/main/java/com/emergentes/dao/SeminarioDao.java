/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;
import com.emergentes.modelo.Seminario;
import java.util.List;

public interface SeminarioDao {
    public void insert(Seminario seminario) throws Exception;
    public void update(Seminario seminario) throws Exception;
    public void delete(int id) throws Exception;
    public Seminario getById(int id) throws Exception;
    public List<Seminario> getAll() throws Exception;
  
}
