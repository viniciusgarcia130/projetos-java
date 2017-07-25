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
import modelo.Movel;
import persistencia.ConexaoBanco;

/**
 *
 * @author vinicius
 * @version 1.0 power ranger beta
 * @since 06/07/2017 19:12
 */
public class MovelDAO {

    public void cadastrarMoveis(Movel mVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "insert into movel(idMovel,nome,preco,tipo,quantidade,altura, largura, comprimento)"
                    + "values(null, '" + mVO.getNome() + "', " + mVO.getPreco() + ","
                    + " '" + mVO.getTipo() + "'," + mVO.getQuantidade() + "," + mVO.getAltura() + "," + mVO.getLargura() + "," + mVO.getComprimento() + ")";

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir dados! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public ArrayList<Movel> buscarMoveis() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from movel";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<Movel> mov = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                Movel m = new Movel();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                m.setIdMovel(rs.getLong("idMovel"));
                m.setNome(rs.getString("nome"));
                m.setTipo(rs.getString("tipo"));
                m.setPreco(rs.getDouble("preco"));
                m.setQuantidade(rs.getInt("quantidade"));
                m.setAltura(rs.getDouble("altura"));
                m.setLargura(rs.getDouble("largura"));
                m.setComprimento(rs.getDouble("comprimento"));

                /* Inserindo o objeto pVO no ArrayList */
                mov.add(m);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return mov;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar moveis! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método buscarProduto

    public ArrayList<Movel> filtrar(String query) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "select * from movel " + query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Movel> mov = new ArrayList<>();
            while (rs.next()) {
                Movel v = new Movel();

                v.setIdMovel(rs.getLong("idMovel"));
                v.setNome(rs.getString("nome"));
                v.setTipo(rs.getString("tipo"));
                v.setPreco(rs.getDouble("preco"));
                v.setQuantidade(rs.getInt("quantidade"));
                v.setAltura(rs.getDouble("altura"));
                v.setLargura(rs.getDouble("largura"));
                v.setComprimento(rs.getDouble("comprimento"));

                mov.add(v);
            }
            return mov;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar produtos! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public void deletarMoveis(long idMovel) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "delete from movel where idMovel=" + idMovel;

            stat.execute(sql);
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar produto! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }//fecha deletar
    
   public void alterarMovel(Movel m) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try {
            String sql;
            
            sql = "update movel set "
                    + "nome='" + m.getNome()+"', "
                    + "preco=" + m.getPreco()+", "
                    + "tipo='" + m.getTipo()+ "', "
                    + "quantidade=" + m.getQuantidade()+", "
                    + "altura=" + m.getAltura()+", "
                    + "largura=" + m.getLargura()+ " "
                    + "where idMovel=" + m.getIdMovel();
            
            stat.executeUpdate(sql);
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar o móvel! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha alterarCliente    
}
