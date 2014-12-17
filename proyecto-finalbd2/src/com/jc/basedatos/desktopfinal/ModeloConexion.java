/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.basedatos.desktopfinal;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author campitos
 */
public class ModeloConexion {
    
    public String conectarse(){
        String valor="nada";
        try{
       //   String mapper=m.mapear();
        //String urlParameters=   mapper;
        //  System.out.println(urlParameters);
     URL url = new URL("http://localhost:8091/base-datos/insertar-pelicula");
      // URL url = new URL("http://192.168.0.102:8091/jelastic_campitos/servicios/usuario");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
      String USER_AGENT = "Mozilla/5.0";
 con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                //con.setRequestProperty("content-type","application/json; charset=utf-8"); 
               con.setRequestProperty("content-type","text/html; charset=utf-8"); 
            String sinopsis = null;
            String titulo = null;
 
		String urlParameters = "titulo="+titulo+"&sinopsis="+sinopsis;
            
		
		con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                                    con.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
        valor=inputLine;
    
        }
    
        in.close();
        
     }catch(Exception e){
      valor=e.getMessage();
     }
        
        return valor;
    }
    
}
