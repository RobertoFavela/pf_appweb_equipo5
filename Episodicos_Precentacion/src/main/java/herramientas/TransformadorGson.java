/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import com.google.gson.Gson;

/**
 *
 * @author tacot
 */
public class TransformadorGson {
    
    private final Gson gson;
    public TransformadorGson(){
        gson = new Gson();
    }
    
    public String convertirAGson(Object objeto){
        return gson.toJson(objeto);
    }
    
    public <T> T convertirDesdeGson (String gsonParametro, Class<T> clase){
        return gson.fromJson(gsonParametro, clase);
    }
}
