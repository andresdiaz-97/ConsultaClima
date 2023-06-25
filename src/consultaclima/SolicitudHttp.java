/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultaclima;

import com.google.gson.Gson;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class SolicitudHttp {
        public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        
    }
        public static String buscar(String x) throws MalformedURLException, IOException, ParseException {
            
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+x+"&units=metric&lang=es&appid=7e2f8f6c2a3ad73c471d6750d940b300");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            String responsemsg = con.getResponseMessage();
            //System.out.println("GET Response Code :: " + responsemsg);
            
            
            // convert the json response to map
            
            
            


            // Handle the response of the http request
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            String myresult =  sb.toString();
            //System.out.println("GET Response Code :: " + myresult);
            
            // new shit
            ArrayList<String> array1 = new ArrayList<String>();
            ArrayList<String> array2 = new ArrayList<String>();
            String cadena = null;
            String cadena2 = null;
            
            int counter = 0; // 0 means no cuotes("") open
            int counter2 = 0;
        
            for(int i = 0; i < myresult.length(); i++) {
                if(counter == 0){
                    if(myresult.charAt(i) == '"') {
                         counter = 1;
                    }                
                     
                } else {
                    // todo aca es counter =1 
                    if(myresult.charAt(i) != '"' ) {
                        cadena = cadena + cadena.valueOf(myresult.charAt(i));
                    } else {
                        array1.add(cadena);
                        counter2++;
                        cadena = "";
                        counter = 0;
                    }
                }
                
            }
            
            counter = 0;
            counter2 = 0;
            
            for(int i = 0; i < myresult.length(); i++) {
                if(counter == 0){
                    if(myresult.charAt(i) == ':' && myresult.charAt(i + 1) != '{') {
                         counter = 1;
                    }                
                     
                } else {
                    // todo aca es counter =1 
                    if(myresult.charAt(i) != ',' ) {
                        cadena = cadena + cadena.valueOf(myresult.charAt(i));
                    } else {
                        array2.add(cadena);
                        counter2++;
                        cadena = "";
                        counter = 0;
                    }
                }
            }
            
            
            for(int i = 0; i < array1.size(); i++) {
                System.out.println(array1.get(i));
                System.out.println("\n");
            }
            
            for(int i = 0; i < array2.size(); i++) {
                System.out.println(array2.get(i));
                System.out.println("\n");
            }
            return(myresult);  
        }
}

//public class SolicitudHttp {
//        public static void main(String[] args) throws MalformedURLException, IOException {
//        // TODO code application logic here
//        
//    }
//        public static String buscar(String x) throws MalformedURLException, IOException {
//            
//            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+x+"&units=metric&lang=es&appid=7e2f8f6c2a3ad73c471d6750d940b300");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            int responseCode = con.getResponseCode();
//            String responsemsg = con.getResponseMessage();
//            //System.out.println("GET Response Code :: " + responsemsg);
//            
//            
//            // convert the json response to map
//            Gson gson = new Gson();
//            
//            
//
//
//            // Handle the response of the http request
//            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
//            StringBuilder sb = new StringBuilder();
//            String output;
//            while ((output = br.readLine()) != null) {
//            sb.append(output);
//            }
//            String myresult =  sb.toString();
//            //System.out.println("GET Response Code :: " + myresult);
//            return(myresult);
//        }
//}
