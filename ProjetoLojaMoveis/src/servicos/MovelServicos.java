/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.MovelDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Movel;

/**
 *
 * @author Vinicius
 */
public class MovelServicos {

    /**
     * @param mVO Objeto que vem  da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarMovel(Movel mVO) throws SQLException {
        MovelDAO mDAO = DAOFactory.getMoveisDAO();
        mDAO.cadastrarMoveis(mVO);
    }//fecha método

    //Método deletarProduto
    /**
    * @author Vinicius
    * @since  06/07/2017
    * @version 1.0 beta mark 2
    * @param idMovel 
    * @throws SQLException  
    */
    public void deletarMovel(long idMovel) throws SQLException{
        MovelDAO mDAO = DAOFactory.getMoveisDAO();
        mDAO.deletarMoveis(idMovel);
    }//fecha método deletarMoveis
    public ArrayList<Movel> filtrar(String query) throws SQLException {
        MovelDAO mDAO = DAOFactory.getMoveisDAO();
        return mDAO.filtrar(query);
    }
    public ArrayList<Movel> buscarMovel() throws SQLException {
        MovelDAO mDAO = DAOFactory.getMoveisDAO();
        return mDAO.buscarMoveis();
    }//fecha método
    
    public void alterarMovel(Movel m) throws SQLException{
        MovelDAO mDAO = DAOFactory.getMoveisDAO();
        mDAO.alterarMovel(m);
    }//fecha método alterarMoveis
}//fecha classe
