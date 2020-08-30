/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.banco;

import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import br.banco.Banco;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Mateus
 */
public class BancoTest {

    private Conta c1;
    private Conta c2;
    private Usuario joao;
    private Usuario manoel;

    @Before
    public void criarAmbiente() {
        c1 = new Conta(100.0, "Basica");
        c2 = new Conta(200.0, "Prime");
        joao = new Usuario("Joao da Silva", "111111111", "joaosilva@mailinator.com");
        manoel = new Usuario("Manoel da Silva", "22222222", "manoelsilva@mailinator.com");
    }

    @Test
    public void deveSomarTodasAsContasTrazendoOSaldoDoBanco() {
        List<Conta> contas = new ContaBuilder().addConta(c1, joao).addConta(c2, manoel).constroi();
        ContaDao dao = mock(ContaDao.class);
        when(dao.getContas()).thenReturn(contas);

        dao.salvaConta(contas.get(0));
        dao.salvaConta(contas.get(1));
        Banco banco = new Banco(dao);
        assertEquals(2, banco.getContas().size(), 0.00001);
        assertEquals(300, banco.totalSaldo(), 0.00001);
    }

    @Test
    public void deveAtualizarAsContasComJurosAplicados() {
        List<Conta> contas = new ContaBuilder()
                .addConta(c1, joao)
                .addConta(c2, manoel).constroi();

        ContaDao dao = mock(ContaDao.class);
        when(dao.getContas()).thenReturn(contas);

        Banco banco = new Banco(dao);
        banco.atualizaJuros(5);

        // verificando se o metodo atualizaConta foi realmente invocado!
        //verify(dao).atualizaConta(contas.get(0));
        //deve ser executado uma única vez
        verify(dao, times(1)).atualizaConta(contas.get(0));
        assertEquals(615.0, banco.totalSaldo(), 0.00001);
    }

}
