package com.company;

import java.util.Scanner;

public class Maestros
{
    // ATRIBUTOS O VARIABLES
    private String id = "";
    private String nombre = "";
    private String apellido = "";
    private double salario = 0.0;


    // GET y SET
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public double getSalario()
    {
        return salario;
    }

    public void setSalario(double salario)
    {
        this.salario = salario;
    }


    // METODOS

    public void mostrarDatos()
    {
        for(int i = 0; i<Main.maestros.size(); i++)
        {
            System.out.println("Id: " + id);
            System.out.println("Nombre: " + nombre + " " + apellido);
            System.out.println("Salario: " + salario);
            System.out.println(" ");
        }
    }
}
