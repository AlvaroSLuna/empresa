package BBDDempresa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        System.out.println("Bienvenido al gestor de dietas");
        do {
            System.out.println("\nElija una de las siguientes opciones:");
            System.out.println("1. Añadir Dietas.");
            System.out.println("2. Mostrar Dietas.");
            System.out.println("3. Incrementar Dietas.");
            System.out.println("4. Salir.");
            System.out.println("Opcion:");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    anyadirDietas(scanner);
                    break;
                case 2:
                    mostrarDietas();
                    break;
                case 3:
                    incrementarDietas();
                    break;
                case 4:
                    System.out.println("Hasta pronto");
                    break;
                default:
            }
        }while (opc != 4);
    }

    public void anyadirDietas(Scanner scanner) {

        String ID = "";
        String Empleado = "";
        String Departamento = "";
        String Cantidad = "";
        String Concepto = "";

        do {
            System.out.println("Introduce el ID");
            ID = scanner.nextLine();
            System.out.println("Introduce el Empleado");
            Empleado = scanner.nextLine();
            System.out.println("Introduce el Departamento");
            Departamento = scanner.nextLine();
            System.out.println("Introduce la Cantidad");
            Cantidad = scanner.nextLine();
            System.out.println("Introduce el Concepto");
            Concepto = scanner.nextLine();

        } while (ID.equals("") || Empleado.equals("") || Departamento.equals("") || Cantidad.equals("") || Concepto.equals(""));

        Dieta dieta = new Dieta(ID, Empleado, Departamento, Cantidad, Concepto);
        Conexion con = new Conexion();
        String result = con.anyadirDietas(dieta);
        System.out.println(result);
    }

    public void mostrarDietas() {

        System.out.println("Estas son las dietas en empleados de informatica mayores de 30€:");

        Conexion con = new Conexion();
        String result = con.mostarDietas();
        System.out.println(result);
    }

    public void incrementarDietas() {

        System.out.println("Las Dietas han sido incrementadas en 10% en el departamento de Ventas");

        Conexion con = new Conexion();
        String result = con.incrementarDietas();
        System.out.println(result);
    }

    public static int validaMenu(Scanner t) {
        int resultado = 0;
        boolean valid = false;

        do {
            try {
                resultado = t.nextInt();
                if (resultado >= 1 && resultado <= 4) {
                    valid = true;
                } else {
                    System.out.println("Opción Incorrecta, vuelve a intentarlo");
                    valid = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción erronea, vuelve a intentarlo");
                t.next();
            }
        } while (!valid);
        return resultado;
    }
}