package br.com.qualiapp.appforcadevendas.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Util extends Activity {

    public static boolean checarConexao(Context context){
        boolean conectado = false;
        try{
            final ConnectivityManager conmgr =
                    (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
            final android.net.NetworkInfo mobile = conmgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);//0
            final android.net.NetworkInfo wifi = conmgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);//1
            if(conmgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED) {conectado = true;}
            if(conmgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {conectado = true;}
        }catch (Exception e){
            conectado = false;
        }
        return conectado;
    }


}
