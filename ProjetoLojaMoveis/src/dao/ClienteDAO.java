/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;
import persistencia.ConexaoBanco;

/**
 *
 * @author vinicius
 * @version 1.0 power ranger beta
 * @since 06/07/2017 19:12
 */
public class ClienteDAO {
    public void cadastrarCliente(Cliente cVO) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "insert into cliente(idCliente,nome,rg,cpf,email,telefone,endereco)"
                    + "values(null, '" + cVO.getNome() + "', '" + cVO.getCpf() + "','"
                    + cVO.getRg() + "','" + cVO.getEmail() + "'," + cVO.getTelefone() + ",'" + cVO.getEndereco() + "')" ;

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir dados! "+e.getMessage());
        }finally{
            con.close();
            stat.close();
        }
    }
     public ArrayList<Cliente> buscarClientes() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from cliente ";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<Cliente> cli = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                Cliente c = new Cliente();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                c.setIdCliente(rs.getLong("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getInt("telefone"));
                c.setEndereco(rs.getString("endereco"));

                /* Inserindo o objeto pVO no ArrayList */
                cli.add(c);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return cli;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar cliente! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método buscarProduto
    public ArrayList<Cliente> filtrar(String query) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;       
            sql = "select * from cliente "+query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Cliente> cli = new ArrayList<>();
            while (rs.next()) {
                
                Cliente c = new Cliente();
                
                c.setIdCliente(rs.getLong("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getInt("telefone"));
                c.setEndereco(rs.getString("endereco"));

                /* Inserindo o objeto pVO no ArrayList */
                cli.add(c);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return cli;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar cliente! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
        public void deletarCliente(long idCliente) throws SQLException{

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();   
        
        try {
            String sql;
            sql = "delete from cliente where idCliente="+idCliente;
            
            stat.execute(sql);
        } catch (SQLException se) {
            throw  new SQLException("Erro ao deletar Cliente! "+se.getMessage());
       } finally {
            stat.close();
            con.close();
        }
    }
        
    public void alterarCliente(Cliente c) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try {
            String sql;
            
            sql = "update cliente set "
                    + "nome='" + c.getNome()+"', "
                    + "rg='" + c.getRg() +"', "
                    + "cpf='" + c.getCpf() + "', "
                    + "endereco='" + c.getEndereco() +"', "
                    + "email='" + c.getEmail() +"', "
                    + "telefone=" + c.getTelefone() + " "
                    + "where idCliente=" + c.getIdCliente();
            
            stat.executeUpdate(sql);
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar o cliente! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha alterarCliente    
}
