package com.comabem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipalActivity extends AppCompatActivity {

    private Button botaoCadastrar, botaoListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        // Referenciar os botões:
        botaoCadastrar = findViewById(R.id.botaoCadastrarProdutos);
        botaoListar = findViewById(R.id.botaoListarProdutos);

        // Ação do botão para a próxima atividade
        // Trocar de Activity (tela) do botão "Cadastrar Produto"
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalActivity.this, CadastrarActivity.class);
                startActivity(intent);
            }
        });

        // Trocar de (Activity) tela do botão "Listtar Produtos"
        botaoListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalActivity.this, ListarActivity.class);
                startActivity(intent);
            }
        });


    }
}