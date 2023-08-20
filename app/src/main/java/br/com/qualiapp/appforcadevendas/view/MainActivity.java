package br.com.qualiapp.appforcadevendas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.com.qualiapp.appforcadevendas.R;
import br.com.qualiapp.appforcadevendas.json.CustomJsonObjectRequest;
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
            String usuarioDigitado = edtUsuario.getText().toString().trim();
            String senhaDigitada = edtSenha.getText().toString().trim();

            if (validarCampos()){
                Parametro parametro = new Parametro();
                ParametroDAO dao = new ParametroDAO(getApplicationContext());
                parametro = dao.get();
                if (parametro != null){
                    if(usuarioDigitado.equals(parametro.getpUsuario())
                            && senhaDigitada.equals(parametro.getpSenha())
                    ){
                        //entrar no sistema
                    }else{
                        //login inválido
                    }
                }else{
                    if (Util.checarConexao(getBaseContext())){
                        registrarUsuarioWeb(usuarioDigitado, senhaDigitada);
                    }else{
                        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        startActivity(intent);
                    }
                }
            }else{
                Toast.makeText(getApplicationContext(),"Campo(s) Inválido(s)!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validarCampos() {
        if (edtUsuario.getText().toString().trim().length() <=2){
            edtUsuario.setError("Seu nome de usuário está incompleto!");
            edtUsuario.requestFocus();
            return false;
        }else if(edtSenha.getText().toString().trim().length() <=2 ){
            edtSenha.setError("Sua senha precisa ter pelo menos duas letras ou números!");
            edtSenha.requestFocus();
            return false;
        }
        return true;
    }

    private void registrarUsuarioWeb(String usuario, String senha) {
        int method = Request.Method.POST;
        String url = "http://192.168.3.100/AppVendas";
        JSONObject jsonRequest = null;
        Response.Listener<JSONObject> listener = null;
        Response.ErrorListener errorListener = null;

        params = new HashMap<String, String>();
        params.put("usuario",usuario);
        params.put("senha", senha);
        CustomJsonObjectRequest request = new CustomJsonObjectRequest(method, url, jsonRequest, listener, errorListener);
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