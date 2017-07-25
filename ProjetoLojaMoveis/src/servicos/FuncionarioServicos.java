/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Funcionario;

/**
 *
 * @author Vinicius
 */
public class FuncionarioServicos {

    /**
     * @param fVO Objeto que vem  da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarFuncionario(Funcionario fVO) throws SQLException {
        FuncionarioDAO fDAO = DAOFactory.getFuncionariosDAO();
        fDAO.cadastrarFuncionario(fVO);
    }//fecha método

    //Método deletarProduto
    /**
    * @author Vinicius
    * @since  06/07/2017
    * @version 1.0 beta mark 2
    * @param idFuncionario 
    * @throws SQLException  
    */
    public void deletarFuncionario(long idFuncionario) throws SQLException{
        FuncionarioDAO fDAO = DAOFactory.getFuncionariosDAO();
        fDAO.deletarFuncionarios(idFuncionario);
    }//fecha método deletarMoveis
    public ArrayList<Funcionario> filtrar(String query) throws SQLException {
        FuncionarioDAO fDAO = DAOFactory.getFuncionariosDAO();
        return fDAO.filtrar(query);
    }
    public ArrayList<Funcionario> buscarFuncionario() throws SQLException {
        FuncionarioDAO fDAO = DAOFactory.getFuncionariosDAO();
        return fDAO.buscarFuncionarios();
    }//fecha método
    
    public void alterarFuncionario(Funcionario f) throws SQLException{
        FuncionarioDAO fDAO = DAOFactory.getFuncionariosDAO();
        fDAO.alterarFuncionario(f);
    }//fecha método alterar
}//fecha classe
