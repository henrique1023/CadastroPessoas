package com.cadastro.pessoas.cadastropessoas.utils;

public class Cast {

    public static int toInteger(Object var){
        int aux = 0;
        try{
            if(var != null) {
                aux = Integer.parseInt(var.toString());
            }
        }catch (Exception e){
            return 0;
        }

        return aux;
    }

    public static double toDouble(Object var){
        double aux = 0;
        if(var != null) {
            aux = Double.parseDouble(var.toString());
        }
        return aux;
    }

    public static long toLong(Object var){
        long aux = 0;
        if(var != null) {
            aux = Long.parseLong(var.toString());
        }
        return aux;
    }

    public static String toString(Object var) {
        String aux = "";
        try{
            if(var != null) {
                aux = var.toString();
            }
        }catch (Exception e){
            return "";
        }
        return aux;
    }
}
