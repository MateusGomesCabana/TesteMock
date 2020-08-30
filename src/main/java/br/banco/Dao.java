/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.banco;

import java.util.List;

/**
 *
 * @author Mateus
 */
public interface Dao {

    public void salvaConta(Conta conta);

    public List<Conta> getContas();

    public void atualizaConta(Conta conta);

}
