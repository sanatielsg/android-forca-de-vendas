package br.com.qualiapp.appforcadevendas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.qualiapp.appforcadevendas.R;
import br.com.qualiapp.appforcadevendas.model.bean.Parametro;
import br.com.qualiapp.appforcadevendas.model.dao.ParametroDAO;

public class MainActivity extends AppCompatActivity {
    private Button btnTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTeste = findViewById(R.id.btn_teste);

        btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parametro p = new Parametro();
                ParametroDAO dao = new ParametroDAO(getApplicationContext());
                p.setpUsuCodigo(99);
                p.setpImportarCliente("todos");
                p.setpDescontoDoVendedor(10);
                p.setpTrabalharComEstoqueNegativo("S");
                p.setpEndIPLocal("http://192.168.3.100/AppVendas");
                p.setpEndIPRemoto("http://appvendas.qualiapp.com.br");

                dao.insert(p);

            }
        });


    }
}