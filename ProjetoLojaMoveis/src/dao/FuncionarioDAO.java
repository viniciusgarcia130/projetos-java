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
import modelo.Funcionario;
import persistencia.ConexaoBanco;

/**
 *
 * @author vinicius
 * @version 1.0 power ranger beta
 * @since 06/07/2017 19:12
 */
public class FuncionarioDAO {

    public void cadastrarFuncionario(Funcionario fVO) throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "insert into funcionario(idFuncionario,nome,cpf,rg,setor,telefone,endereco)"
                    + "values(null, '" + fVO.getNome() + "', '" + fVO.getCpf() + "','" + fVO.getRg() + "',"
                    + " '" + fVO.getSetor() + "'," + fVO.getTelefone() + ",'" + fVO.getEndereco() + "')";

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir dados! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public ArrayList<Funcionario> buscarFuncionarios() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from funcionario";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<Funcionario> fun = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                Funcionario f = new Funcionario();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                f.setIdFuncionario(rs.getLong("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setSetor(rs.getString("setor"));
                f.setEndereco(rs.getString("endereco"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setTelefone(rs.getInt("telefone"));

                /* Inserindo o objeto pVO no ArrayList */
                fun.add(f);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return fun;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar funcionario! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método buscarProduto

    public ArrayList<Funcionario> filtrar(String query) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "select * from funcionario " + query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Funcionario> fun = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setIdFuncionario(rs.getLong("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setSetor(rs.getString("setor"));
                f.setEndereco(rs.getString("endereco"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setTelefone(rs.getInt("telefone"));

                fun.add(f);
            }
            return fun;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar funcionarios! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public void deletarFuncionarios(long idFuncionario) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "delete from funcionario where idFuncionario=" + idFuncionario;

            stat.execute(sql);
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar funcionario! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }
    
    public void alterarFuncionario(Funcionario f) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            sql = "update funcionario set "
                    + "nome='"+f.getNome()+"', cpf='"+f.getCpf()+"', rg='"+f.getRg()+"', setor='"+f.getSetor()+"', telefone="+f.getTelefone()+", endereco='"+f.getEndereco()+"' "
                    + "where idFuncionario="+f.getIdFuncionario()+"";

            stat.executeUpdate(sql);

        } catch (SQLException se) {
            throw new SQLException("Erro ao alterar "
                    + "funcionario! " + se.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha alterarProduto
}
