
package com.example.escola;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtN1, edtN2;
    TextView txtM, txtSit;
    LinearLayout layResult;
    ImageView imgSit;
    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtN1 = findViewById(R.id.edtN1);
        edtN2 = findViewById(R.id.edtN2);
        txtM = findViewById(R.id.txtM);
        txtSit = findViewById(R.id.txtSit);
        layResult = findViewById(R.id.layResult);
        imgSit = findViewById(R.id.imgSit);
        layResult.setVisibility(View.GONE);
        imgSit.setVisibility(View.GONE);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private float calcularMedia() {
        float n1 = Float.parseFloat(edtN1.getText().toString());
        float n2 = Float.parseFloat(edtN2.getText().toString());
        return (n1 + n2) / 2;
    }

    private String encontrarSituacao(float media) {
        if (media < 4) {
            Toast.makeText(getApplicationContext(), getString(R.string.strMsgRp), Toast.LENGTH_LONG).show();
            txtSit.setTextColor(ContextCompat.getColor(this, R.color.corReprovado));
            imgSit.setImageResource(R.drawable.emojireprovado);
            return getString(R.string.strRip);
        } else if (media < 6) {
            Toast.makeText(getApplicationContext(), getString(R.string.strMsgRc), Toast.LENGTH_LONG).show();
            txtSit.setTextColor(ContextCompat.getColor(this, R.color.corRecuperacao));
            imgSit.setImageResource(R.drawable.emojirecuperacao);
            return getString(R.string.strRec);
        }
        Toast.makeText(getApplicationContext(), getString(R.string.strMsgAp), Toast.LENGTH_LONG).show();
        imgSit.setImageResource(R.drawable.emojiaprovado);
        txtSit.setTextColor(ContextCompat.getColor(this, R.color.corAprovado));
        return getString(R.string.strAproved);
    }

    private void alterarCampos(float media, String situacao) {
        txtM.setText(String.format("%.1f", media));
        txtSit.setText(situacao);
    }

    private boolean tudoOk() {
        if (edtN1.getText().toString().trim().isEmpty()) {
            edtN1.setError(getString(R.string.msgErro));
            return false;
        } else if (edtN2.getText().toString().trim().isEmpty()) {
            edtN2.setError(getString(R.string.msgErro));
            return false;
        }
        return true;
    }

    public void calcular(View view) {
        if (tudoOk()) {
            inputMethodManager.hideSoftInputFromWindow(edtN1.getWindowToken(), 0);
            layResult.setVisibility(View.VISIBLE);
            imgSit.setVisibility(View.VISIBLE);
            float media = calcularMedia();
            String situacao = encontrarSituacao(media);
            alterarCampos(media, situacao);
        }
    }
}