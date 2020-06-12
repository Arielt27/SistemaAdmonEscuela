package com.company;
import java.util.ArrayList;
import java.util.Scanner;

//Sistema de administración de escuela
//El sistema debe manejar 3 tipos de objetos: la escuela, el estudiante y los maestros.
//El sistema debe llevar el control de las finanzas de la escuela,
//controlando las deudas de los estudiantes y lo que se les debe pagar a los maestros.
//Una vez finalizado el sistema debe tener:
//Un objeto de escuela con estudiantes, maestros, ingresos y egresos
//Un objeto maestro con  un nombre, un id y un salario
//Un objeto estudiante con un nombre, un id, un grado, pagos realizados y el total de pagos.

public class Main
{
    // OBJETOS
    static Menus mP = new Menus();
    static Maestros maestro = new Maestros();
    public static Scanner lector = new Scanner(System.in);
    static Estudiantes estudiante = new Estudiantes();
    static Escuela escuela = new Escuela();


    // LISTAS
    public static ArrayList<Maestros> maestros = new ArrayList<Maestros>();
    private static ArrayList<Estudiantes> estudiantes = new ArrayList<Estudiantes>();

    // GET y SET
    public static ArrayList<Estudiantes> getEstudiantes()
    {
        return estudiantes;
    }

    public static void setEstudiantes(ArrayList<Estudiantes> estudiantes)
    {
        Main.estudiantes = estudiantes;
    }


    public static void main(String[] args)
    {
        // VARIABLES
        int opc = 0;
        int opcEsc = 0;
        int opcEst = 0;
        String pregunta = "";
        String No = "n";


        // PROGRAMA PRINCIPAL

        mP.menuPrincipal();
        opc = lector.nextInt();

        while(opc!=3)
        {

            switch(opc)
            {
                case 1: // ESCUELA

                    System.out.println(" ");
                    mP.menuEscuela();
                    opcEsc = lector.nextInt();

                    switch(opcEsc)
                    {
                        case 1: // AGREGAR MAESTROS
                            int pos = 0;
                            boolean ciclo = false;

                            while(!ciclo)
                            {
                                System.out.println(" ");

                                System.out.print("Ingrese el nombre: ");
                                String nombre = lector.next();

                                System.out.print("Ingrese el apellido: ");
                                String apellido = lector.next();

                                System.out.print("Ingrese el salario: ");
                                double salario = lector.nextDouble();

                                String id = escuela.generarIDMaestro();

                                maestro.setNombre(nombre);
                                maestro.setApellido(apellido);
                                maestro.setId(id);
                                maestro.setSalario(salario);
                                maestros.add(pos, maestro);

                                pos = pos + 1;

                                System.out.println("Datos guardados.");
                                System.out.println(" ");

                                System.out.println("¿Ingresar otro maestro?");
                                pregunta = lector.next();

                                if(pregunta.equals(No))
                                {
                                    ciclo = true;
                                }
                            }

                            System.out.println(" ");

                            break;

                        case 2: // AGREGAR ESTUDIANTES
                            int posEst = 0;
                            boolean cicloEst = false;

                            while(!cicloEst)
                            {
                                System.out.println(" ");

                                System.out.print("Ingrese el nombre del estudiante: ");
                                String nombre = lector.next();

                                System.out.print("Ingrese el apellido del estudiante: ");
                                String apellido = lector.next();

                                System.out.print("Ingrese el grado del estudiante: ");
                                int grado = lector.nextInt();

                                if(grado < 1)
                                {
                                    System.out.println("El grado del estudiante debe ser mayor que 0");
                                    System.out.println(" ");
                                    System.out.print("Ingrese el grado del estudiante: ");
                                    grado = lector.nextInt();
                                }

                                String id = escuela.generarID(estudiante);

                                estudiante.setId(id);
                                estudiante.setNombre(nombre);
                                estudiante.setApellido(apellido);
                                estudiante.setGrado(grado);
                                getEstudiantes().add(posEst, estudiante);

                                posEst = posEst + 1;

                                System.out.println("Datos guardados.");
                                System.out.println(" ");

                                System.out.println("Su id es: " + estudiante.getId());
                                System.out.println(" ");

                                System.out.println("¿Ingresar otro estudiante?");
                                pregunta = lector.next();

                                if(pregunta.equals(No))
                                {
                                    cicloEst = true;
                                }
                            }

                            System.out.println(" ");

                            break;

                        case 3: // VER INGRESOS

                            System.out.println(" ");
                            escuela.mostrarIngresos();

                            break;

                        case 4: // VER DEUDAS

                            System.out.println(" ");
                            escuela.mostrarDeudas();

                            break;

                        case 5: // MENU PRINCIPAL

                            System.out.println(" ");

                            break;
                    }

                    mP.menuPrincipal();
                    opc = lector.nextInt();

                    break;

                case 2: // ESTUDIANTES

                    System.out.println(" ");
                    mP.menuEstudiantes();
                    opcEst = lector.nextInt();

                    switch(opcEst)
                    {
                        case 1: // REALIZAR PAGO

                            System.out.println(" ");

                            boolean ciclo2 = false;

                            while(!ciclo2)
                            {
                                escuela.realizarPago();

                                System.out.print("¿Desea realizar otro pago? ");
                                pregunta = lector.next();
                                System.out.println(" ");

                                if(pregunta.equals(No))
                                {
                                    ciclo2 = true;
                                }
                            }

                            System.out.println(" ");
                            mP.menuPrincipal();
                            opc = lector.nextInt();

                            break;

                        case 2: // CONSULTAR PAGO

                            System.out.println(" ");

                            boolean ciclo3 = false;

                            while(!ciclo3)
                            {
                                escuela.mostrarPagosRealizados();

                                System.out.print("¿Desea consultar otro pago? ");
                                pregunta = lector.next();

                                if(pregunta.equals(No))
                                {
                                    ciclo3 = true;
                                }
                            }

                            System.out.println(" ");
                            mP.menuPrincipal();
                            opc = lector.nextInt();

                            break;

                        case 3: // MENU PRINCIPAL

                            System.out.println(" ");
                            mP.menuPrincipal();
                            opc = lector.nextInt();

                            break;
                    }

                    break;

            }
        }
    }
}
