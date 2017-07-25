/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


/**
 * @author vinicius
 * @since 07/04/2014 - 11:46
 * @version 1.0 beta
 */
public class DAOFactory {
    
    private static MovelDAO moveisDAO = new MovelDAO();
    
    public static MovelDAO getMoveisDAO(){
        return moveisDAO;
      }//fecha método
    private static FuncionarioDAO funcionariosDAO = new FuncionarioDAO();
    
    public static FuncionarioDAO getFuncionariosDAO(){
        return funcionariosDAO;
      }//fecha método

    private static ClienteDAO ClienteDAO = new ClienteDAO();
    
    public static ClienteDAO getClienteDAO(){
        return ClienteDAO;
      }//fecha método
}
