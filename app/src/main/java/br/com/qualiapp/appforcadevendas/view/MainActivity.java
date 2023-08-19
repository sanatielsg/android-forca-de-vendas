package br.com.qualiapp.appforcadevendas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import br.com.qualiapp.appforcadevendas.R;
import br.com.qualiapp.appforcadevendas.model.bean.Parametro;
import br.com.qualiapp.appforcadevendas.model.dao.ParametroDAO;
import br.com.qualiapp.appforcadevendas.util.Util;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuario;
    private EditText edtSenha;
    private Button btnRegistrar;
    private RequestQueue requestQueue;
    private static final String TAG_SUCESSO = "sucesso";
    private static final String TAG_MENSAGEM = "mensagem";
    private Map<String, String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.edt_usuario_registrar);
        edtSenha = findViewById(R.id.edt_senha_registrar);
        btnRegistrar = findViewById(R.id.btn_registrar);

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        btnRegistrar.setOnClickListener(v -> {
            if (Util.checarConexao(getBaseContext())){

            }else{
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
            }
        });

    }

    public void testar(){
        Parametro p = new Parametro();
        ParametroDAO dao = new ParametroDAO(getApplicationContext());
        p.setpUsuCodigo(99);
        p.setpImportarCliente("todos");
        p.setpDescontoDoVendedor(10);
        p.setpTrabalharComEstoqueNegativo("S");
        p.setpEndIPLocal("http://192.168.3.100/AppVendas");
        p.setpEndIPRemoto("http://appvendas.qualiapp.com.br");
        p.setpUsuario("vendedor1");
        p.setpSenha("123");
        dao.insert(p);
    }
}