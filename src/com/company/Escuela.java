package com.company;

import java.util.ArrayList;

import static com.company.Main.lector;

public class Escuela
{
    // ATRIBUTOS O VARIABLES
    public static ArrayList<Double> egresos = new ArrayList<Double>();
    public static ArrayList<Double> ingresos = new ArrayList<Double>();
    private Maestros maestros;
    private Estudiantes estudiantes;
    private int correlativo;
    private int correlativoEstudiante = 1;


    // GET y SET
    public ArrayList<Double> getIngresos()
    {
        return ingresos;
    }

    public void setIngresos(ArrayList<Double> ingresos)
    {
        this.ingresos = ingresos;
    }

    public ArrayList<Double> getEgresos()
    {
        return egresos;
    }

    public void setEgresos(ArrayList<Double> egresos)
    {
        this.egresos = egresos;
    }


    // METODOS
    public String generarIDMaestro()
    {
        String id = "2020-" + correlativo;
        correlativo++;
        return id;
    }

    public String generarID(Estudiantes estudiante)
    {
        String id = "2020-" + estudiante.getGrado() + correlativoEstudiante;
        return id;
    }

    public void realizarPago()
    {
        String ID;

        System.out.print("Ingrese su id: ");
        ID = lector.next();

        for (int i = 0; i< Main.getEstudiantes().size(); i++)
        {
            if (ID.equals(Main.getEstudiantes().get(i).getId()))
            {
                System.out.println("Nombre: " + Main.getEstudiantes().get(i).getNombre() + " " + Main.getEstudiantes().get(i).getApellido());
                System.out.println("Grado: " + Main.getEstudiantes().get(i).getGrado());
                System.out.print("Ingrese el monto a pagar: ");
                double pago = lector.nextInt();

                ingresos.add(pago);
                Main.getEstudiantes().get(i).agregarPago(pago);

                System.out.println("Pago realizado.");
                System.out.println(" ");

            }else{
                System.out.println("ID no valido");
                System.out.println(" ");
            }
        }
    }

    public void mostrarPagosRealizados()
    {
        String ID;
        double total = 0;

        System.out.println("Ingrese su id:");
        ID = lector.nextLine();

        for (int i = 0; i< Main.getEstudiantes().size(); i++)
        {
            if (ID.equals(Main.getEstudiantes().get(i).getId()))
            {
                System.out.println("Nombre: " + Main.getEstudiantes().get(i).getNombre());
                System.out.println("Grado: " + Main.getEstudiantes().get(i).getGrado());
                System.out.println("Pagos Realizados: ");

                for (int j = 0; j< Main.getEstudiantes().get(i).getPagosSize(); j++ )
                {
                    System.out.println("L. " + Main.getEstudiantes().get(i).getPagosRealizados(j));
                    total = total + Main.getEstudiantes().get(i).getPagosRealizados(j);
                }
            }
        }
        System.out.println("Total: ");
        System.out.print("L. ");
        System.out.println(total);
    }

    public void mostrarIngresos()
    {
        double total = 0;

        System.out.println("Total Ingresos:");

        for (int i = 0; i<ingresos.size(); i++)
        {
            total = total + ingresos.get(i);
        }
        System.out.println("L. " + total);
    }

    public void mostrarDeudas()
    {
        double total = 0;

        System.out.println("Total pago maestros:");

        for (int i = 0; i < Main.maestros.size(); i++)
        {
            total = total + Main.maestros.get(i).getSalario();
        }
        System.out.println("L." + total);
        System.out.println(" ");
    }

}
