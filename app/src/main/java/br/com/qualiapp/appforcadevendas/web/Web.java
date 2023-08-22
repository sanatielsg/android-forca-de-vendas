package br.com.qualiapp.appforcadevendas.web;

import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.com.qualiapp.appforcadevendas.json.CustomJsonObjectRequest;

public class Web {
    private Map<String, String> params;

    public Web(Map<String, String> params){
        this.params = params;
    }

    public void registrarUsuarioWeb(String usuario, String senha) {
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

}
