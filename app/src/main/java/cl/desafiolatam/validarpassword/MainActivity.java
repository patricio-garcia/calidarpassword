package cl.desafiolatam.validarpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import cl.desafiolatam.validarpassword.validador.Password;

public class MainActivity extends AppCompatActivity {

    private EditText etPassword;
    private TextView tvMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = findViewById(R.id.etPassword);
        tvMensaje = findViewById(R.id.tvResultado);

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calcularPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void calcularPassword(String str) {
        Password password = Password.calcular(str);
        tvMensaje.setText(password.mensaje);
        tvMensaje.setBackgroundColor(password.color);
    }
}