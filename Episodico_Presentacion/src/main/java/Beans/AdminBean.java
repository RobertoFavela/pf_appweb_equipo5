/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DAOsSQL.AdminDAO;
import EntidadesSQL.Admin;
import interfaces.IAdminDAO;
import java.util.List;

public class AdminBean {
    private IAdminDAO admorDAO;
    private Admin admor;
    private List<Admin> listaAdmor;

    public void init() {
        admorDAO = new AdminDAO();
        admor = new Admin();
        listaAdmor = admorDAO.buscarTodos();
    }

    public void guardar() {
        admorDAO.guardar(admor);
        admor = new Admin();
        listaAdmor = admorDAO.buscarTodos();
    }

    public void eliminar(int id) {
        admorDAO.eliminar(id);
        listaAdmor = admorDAO.buscarTodos();
    }

    public Admin buscarPorId(int id) {
        return admorDAO.buscarPorId(id);
    }

    public List<Admin> getListaAdmor() {
        return listaAdmor;
    }

    public Admin getAdmor() {
        return admor;
    }

    public void setAdmor(Admin admor) {
        this.admor = admor;
    }
}
