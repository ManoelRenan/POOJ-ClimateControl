package com.example.pooj_climatecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormLogin extends AppCompatActivity {

    EditText usuario;
    EditText senha;
    Button entrar;

    private TextView text_tela_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_login);

        //Evento de login --> para tela inicial
        usuario = (EditText) findViewById(R.id.edit_email);
        senha = (EditText) findViewById(R.id.edit_senha);
        entrar = (Button) findViewById(R.id.btn_entrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("admim".equals(usuario.getText().toString()) && "1234".equals(senha.getText().toString()))
                {
                    startActivity(new Intent(FormLogin.this,TelaPrimeiroLogin.class));

                } else {
                    Toast falhaAutencacao = Toast.makeText(FormLogin.this,getResources().getString(R.string.activity_main_falha_autenticacao), Toast.LENGTH_SHORT);
                    falhaAutencacao.show();
                }
            }
        });

        //Evento de clique na opcao Registra-se
        IniciarComponentes();

        text_tela_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this, FormCadastro.class);
                startActivity(intent);
            }
        });
    }

    protected void onSart(){
        super.onStart();
        usuario.setText("");
        senha.setText("");
    }
    private void IniciarComponentes(){
        text_tela_registrar = findViewById(R.id.text_tela_registrar);
    }
}