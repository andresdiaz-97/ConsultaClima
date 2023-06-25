/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultaclima;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import static java.util.Map.entry;

/**
 *
 * @author Usuario
 */
public class FullResponseBuilder {
    public static String getFullResponse(HttpURLConnection con) throws IOException {
        StringBuilder fullResponseBuilder =  new StringBuilder();
        
        fullResponseBuilder.append(con.getResponseCode())
        .append(" ")
        .append(con.getResponseMessage())
        .append("\n");
        
        con.getHeaderFields().entrySet().stream()
            .filter(entry -> entry.getKey() != null)
            .forEach(entry -> {
                fullResponseBuilder.append(entry.getKey()).append(": ");
            fullResponseBuilder.append("\n");  
                List headerValues = entry.getValue();
                Iterator it = headerValues.iterator();
                if(it.hasNext()) {
                    fullResponseBuilder.append(it.next());
                    while(it.hasNext()) {
                        fullResponseBuilder.append(", ").append(it.next());
                    }
                }
                
                
    });
        
        
        return fullResponseBuilder.toString();
    }
}
