package br.com.up.whatsappmsgproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutPhone; // Variavel que recebe layout de telefone
    private TextInputLayout inputLayoutMessage; // Variavel que recebe layour de mensagem

    private TextInputEditText inputEditTextPhone; // Variavel que recebe o input do telefone
    private TextInputEditText inputEditTextMessage; // Variavel que recebe o input da mensagem

    private Button buttonEnviar; // Variavel do botão

    private String phonetr, msgtr = ""; // Variavel pra transformar para String os inputs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutPhone = findViewById(R.id.phone_input_layout); // Pegando o layout de telefone
        inputLayoutMessage = findViewById(R.id.message_input_layout); // Pegando o layout de mensagem

        inputEditTextPhone = findViewById(R.id.phone_input_text); // Pegando o input de telefone
        inputEditTextMessage = findViewById(R.id.message_input_text); // Pegando o input de mensagem

        buttonEnviar = findViewById(R.id.btn_enviar); // Pegando o botão enviar.

        buttonEnviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        phonetr = inputEditTextPhone.getText().toString(); // Transformando o input para String
                        msgtr = inputEditTextMessage.getText().toString(); // Transformando o input para String

                        if (!phonetr.isEmpty() && !msgtr.isEmpty()) { // Se não estiver vazio "!" continuar...

                            Uri whatsLink = Uri.parse("https://wa.me/" + phonetr + "?text=" + msgtr); //Colocando o link e entre ele os dados necessarios para funcionar
                            Intent whatsIntent = new Intent(Intent.ACTION_VIEW, whatsLink); // Criando a intent que levara ao whatsapp
                            startActivity(whatsIntent); // Iniciando a intent
                            inputEditTextPhone.setText(""); // Setando o texto para deixa-lo em branco igual no inicio.
                            inputEditTextMessage.setText(""); // Setando o texto para deixa-lo em branco igual no inicio.

                        } else {

                            Toast.makeText(MainActivity.this, "Numero ou mensagem não atribuida! Por favor preencha ambos os campos.", Toast.LENGTH_LONG).show(); // Mensagem de erro caso esteja vazio algum dos campos

                        }

                    }
                }
        );
    }
}