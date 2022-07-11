package com.comabem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {

    private ImageButton botaoVoltarTPListar;
    private ListView listView;
    private ProdutoDAO dao;
    private List<Produto> produtos;
    private List<Produto> produtosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        // Usar ListView
        listView = findViewById(R.id.listaprodutos);
        dao = new ProdutoDAO(this);
        produtos = dao.obterProdutos();
        produtosFiltrados.addAll(produtos);

        // Usar um adaptador de array
        ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this,
                android.R.layout.simple_expandable_list_item_1, produtos);
        listView.setAdapter(adaptador);

        // Voltar Tela Principal
        botaoVoltarTPListar = findViewById(R.id.botaoVoltarTPListar);
        botaoVoltarTPListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarActivity.this, TelaPrincipalActivity.class);
                startActivity(intent);
            }
        });
    }
}