/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicos;

/**
 * @author vinicius
 * @since 07/04/2014 - 11:46
 * @version 1.0 beta
 */
public class ServicosFactory {
    
   private static MovelServicos movelServicos= new MovelServicos();

   public static MovelServicos getMovelServicos(){
       
       return movelServicos;                                
   }//fecha metodo
   private static FuncionarioServicos funcionarioServicos= new FuncionarioServicos();

   public static FuncionarioServicos getFuncionarioServicos(){
       
       return funcionarioServicos;                                
   }//fecha metodo
   private static ClienteServicos clienteServicos= new ClienteServicos();

   public static ClienteServicos getClienteServicos(){
       
       return clienteServicos;                                
   }//fecha metodo
    
}//fecha classe
