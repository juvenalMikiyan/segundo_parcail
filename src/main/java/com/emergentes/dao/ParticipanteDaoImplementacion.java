/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;
import com.emergentes.toolls.ConexionBaseDatos;
import com.emergentes.modelo.Participante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ParticipanteDaoImplementacion extends ConexionBaseDatos implements ParticipanteDao{
    
    
   @Override
    public void insert(Participante participante) throws Exception {
        String sql = "insert into participantes (, apellidos, nombres, id_seminario, confirmado) values (?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, participante.getApellidos());
        ps.setString(2, participante.getNombres());
        ps.setInt(3, participante.getId_seminario());
        ps.setInt(4, participante.getConfirmado());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Participante participante) throws Exception {
        String sql = "update participantes set apellidos=?,nombres=?,id_seminario=?,confirmado=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, participante.getApellidos());
        ps.setString(2, participante.getNombres());
        ps.setInt(3,participante.getId_seminario());
        ps.setInt(4, participante.getConfirmado());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from participantes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Participante getById(int id) throws Exception {
        Participante par = new Participante();
        String sql = "select * from participantes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            par.setId(rs.getInt("id"));
            par.setApellidos(rs.getString("apellidos"));
            par.setNombres(rs.getString("nombres"));
            par.setId_seminario(rs.getInt("id_seminario"));
            par.setConfirmado(rs.getInt("confirmado"));
        }
        this.desconectar();
        return par;
    }

    @Override
    public List<Participante> getAll() throws Exception {
        List<Participante> lista = null;
        String sql = "select * from participantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Participante>();
        while (rs.next()) {            
            Participante par = new Participante();
            par .setId(rs.getInt("id"));
            par .setApellidos(rs.getString("apellidos"));
            par .setNombres(rs.getString("nombres"));
            par .setId_seminario(rs.getInt("id_seminario"));
            par .setConfirmado(rs.getInt("confirmado"));
            lista.add(par );
        }
        this.desconectar();
        return lista;
    }
}
