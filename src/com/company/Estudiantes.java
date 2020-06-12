package com.company;

import java.util.ArrayList;

public class Estudiantes
{
    // ATRIBUTOS O VARIABLES

    private String id;
    private int grado;
    private String nombre;
    private String apellido;
    private ArrayList<Double> pagosRealizados = new ArrayList<Double>();
    private double pagosTotales;


    // GET y SET

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getGrado()
    {
        return grado;
    }

    public void setGrado(int grado)
    {
        this.grado = grado;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public Double getPagosRealizados(int indice)
    {
        return pagosRealizados.get(indice);
    }

    public void setPagosRealizados(ArrayList<Double> pagosRealizados)
    {
        this.pagosRealizados = pagosRealizados;
    }

    public int getPagosSize()
    {
        return pagosRealizados.size();
    }

    public double getPagosTotales()
    {
        return pagosTotales;
    }

    public void setPagosTotales(double pagosTotales)
    {
        this.pagosTotales = pagosTotales;
    }


    // METODOS

    public  void agregarPago(double pago)
    {
        this.pagosRealizados.add(pago);
    }
}
