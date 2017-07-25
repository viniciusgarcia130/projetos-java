/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author Vinicius
 */
public class ClienteServicos {

    /**
     * @param cVO Objeto que vem  da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarCliente(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarCliente(cVO);
    }//fecha método

    //Método deletarProduto
    /**
    * @author Vinicius
    * @since  06/07/2017
    * @version 1.0 beta mark 2
    * @param id_cliente 
    * @throws SQLException  
    */
    public void deletarCliente(long id_cliente) throws SQLException{
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.deletarCliente(id_cliente);
    }//fecha método deletarMoveis
    public ArrayList<Cliente> filtrar(String query) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.filtrar(query);
    }
    public ArrayList<Cliente> buscarCliente() throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.buscarClientes();
    }//fecha método
    
    public void alterarCliente(Cliente c) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.alterarCliente(c);
    }//fecha método
    
}//fecha classe
