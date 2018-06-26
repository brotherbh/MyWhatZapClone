package zap.techmais.com.whatsappclone.helper;

import android.util.Base64;

public class Base64Custom {


    public static String CodificarBase64(String texto){

        return Base64.encodeToString(texto.getBytes(),Base64.DEFAULT).replaceAll("\\n | \\r","");

    }//






/*
    public static String descodificar(String textoCodificado){


       Base64.decode()


    }//

*/




}//Fp
