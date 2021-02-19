package edu.escuelaing.arep.app;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;


import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App{

    /**
     *El metodo mean permite iniciar el programa cuando este es ejecutado.
     * @param args
     */
    public static void main(String[] args) {
        staticFileLocation("/static");
        port(getPort());
        get("parcial1arepsebastiannieto.herokuapp.com/trigonometrica",(req, res) -> calcula(req, res));

    }

    /**
     * De acuerdo al tipo de operación trigonometrica retorna la respuesta-
     * @param req
     * @param res
     * @return String que contiene la respuesta.
     */
    static String calcula(Request req, Response res){
        String tipo = req.queryParams("tipo");
        double num = Double.parseDouble(req.queryParams("num"));
        Trigonometricas trigonometricas = new Trigonometricas();
        double resultado = 0.0;
        if(tipo.equals("cos")){
            resultado = trigonometricas.getCos(num);
        }else if(tipo.equals(("tan"))){
            resultado = trigonometricas.getTan(num);
        }else if(tipo.equals("sen"))
            resultado = trigonometricas.getSen(num);

        String mostrar = new Gson().toJson( "{\"Tu respuesta es\": \""+ resultado+"\"}");
        return mostrar;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36500;
    }



}
