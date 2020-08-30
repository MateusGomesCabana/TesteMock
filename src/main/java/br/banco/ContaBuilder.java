/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.banco;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class ContaBuilder {
    private List<Conta> contas;

   public ContaBuilder() {
       contas = new ArrayList<Conta>();
   }

   public ContaBuilder addConta(Conta conta, Usuario usuario) {
       conta.setUsuario(usuario);
       this.contas.add(conta);
       return this;
   }

   public List<Conta> constroi() {
       return this.contas;
   }

}
