package com.comabem;

import junit.framework.TestCase;

public class ProdutoTest extends TestCase {

    public void testSetNome() {
        Produto p = new Produto();
        boolean resultado = p.setNome("João");
        assertEquals(true, resultado);
    }

    public void testSetPreco() {
        Produto p = new Produto();
        boolean resultado = p.setPreco(15);
        assertEquals(true, resultado);
    }

}
