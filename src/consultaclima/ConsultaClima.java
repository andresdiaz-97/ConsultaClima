/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consultaclima;

import GUI.Busqueda;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Usuario
 */
public class ConsultaClima {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Busqueda b1 = new Busqueda();
                b1.setVisible(true);
    } 
//    public static void main(String[] args) throws MalformedURLException, IOException {
//        // TODO code application logic here
//        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=santiago&units=metric&lang=es&appid=7e2f8f6c2a3ad73c471d6750d940b300");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        int responseCode = con.getResponseCode();
//        String responsemsg = con.getResponseMessage();
//        System.out.println("GET Response Code :: " + responsemsg);
//        
//        
//        // Handle the response of the http request
//        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
//        StringBuilder sb = new StringBuilder();
//        String output;
//        while ((output = br.readLine()) != null) {
//        sb.append(output);
//        }
//        String myresult =  sb.toString();
//        System.out.println("GET Response Code :: " + myresult);
//    }
    
}
