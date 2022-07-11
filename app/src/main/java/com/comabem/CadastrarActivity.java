package com.comabem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    private ImageButton botaoVoltarTP;
    private Button botaoCadastrar;

    ImageView imagemProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        // Pedir Permissão do uso da camera:
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        // Uso da camera:
        imagemProduto = (ImageView) findViewById(R.id.fotoProduto);
        findViewById(R.id.button_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tirarFoto();
            }
        });


        // Referenciar os botoes:
        botaoVoltarTP = findViewById(R.id.botaoVoltarTP);

        // Ação do botão para a próxima atividade
        // Trocar de Activity (tela) para tela principal"
        botaoVoltarTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastrarActivity.this, TelaPrincipalActivity.class);
                startActivity(intent);
            }

        });

        botaoCadastrar = findViewById(R.id.button_register);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserir(view);
            }
        });


    }


    public void tirarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap foto = (Bitmap) extras.get("data");
            imagemProduto.setImageBitmap(foto);
        }
        super.onActivityResult(resultCode, resultCode, data);

    }

    public void inserir(View view) {
        EditText etNome = findViewById(R.id.inputNome);
        String nome = etNome.getText().toString();
        EditText etDescricao = findViewById(R.id.inputDescricao);
        String descricao = etDescricao.getText().toString();
        EditText etPreco = findViewById(R.id.inputPreco);
        double preco = Double.parseDouble(etPreco.getText().toString());

        Produto produto = new Produto(nome, descricao, preco);

        ProdutoDAO dao;
        dao = new ProdutoDAO(this);
        long id = dao.inserir(produto);
        Toast.makeText(this, "Produto inserido com o id: " + id, Toast.LENGTH_SHORT).show();

    }


}