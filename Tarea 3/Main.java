package tarea3;

import java.util.Scanner;

public class Main {

    private static final Cajero cajero           = new Cajero("Gabriela Cornejo", "Gaby123", "caje123", 5);
    private static final Administrador admin     = new Administrador("Jordy Cajas", "jordy1", "admin1234", "Desarrollo");
    private static final Supervisor supervisor   = new Supervisor("Roberto Casa", "Beto12", "super123", "Zona Norte");

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("    SISTEMA DE ROLES EMPRESARIALES        ");
        System.out.println("===========================================\n");

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerEntero(sc, "Seleccione un rol (1-4): ");

            switch (opcion) {
                case 1 -> menuCajero(sc);
                case 2 -> menuAdministrador(sc);
                case 3 -> menuSupervisor(sc);
                case 4 -> {
                    System.out.println("\n>>> Saliendo del sistema. ¡Hasta luego!");
                    salir = true;
                }
                default -> System.out.println("✗ Opción no válida. Intente de nuevo.\n");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("SELECCIONE ROL");
        System.out.println("1. Cajero  ");
        System.out.println("2. Administrador ");
        System.out.println("3. Supervisor ");
        System.out.println("4. Salir");
    }

    private static void menuCajero(Scanner sc) {
        System.out.println("\n--- ACCESO CAJERO ---");
        System.out.print("Usuario: "); String u = sc.nextLine();
        System.out.print("Clave  : "); String c = sc.nextLine();

        Autenticable auth = cajero;
        if (!auth.iniciarSesion(u, c)) return;

        System.out.println("\nMENÚ CAJERO ");
        System.out.println("1. Gestionar datos de caja");
        System.out.println("2. Volver");

        int op = leerEntero(sc, "Opción: ");
        if (op == 1) {
            Gestionable g = cajero;
            g.gestionarDatos();
        } else {
            System.out.println("Volviendo al menú principal.\n");
        }
    }

    private static void menuAdministrador(Scanner sc) {
        System.out.println("\n--- ACCESO ADMINISTRADOR ---");
        System.out.print("Usuario: "); String u = sc.nextLine();
        System.out.print("Clave  : "); String c = sc.nextLine();

        Autenticable auth = admin;
        if (!auth.iniciarSesion(u, c)) return;

        System.out.println("\n MENÚ ADMINISTRADOR");
        System.out.println("  1. Gestionar datos ");
        System.out.println("  2. Generar reporte");
        System.out.println(" 3. Volver ");

        int op = leerEntero(sc, "Opción: ");
        switch (op) {
            case 1 -> { Gestionable g = admin; g.gestionarDatos(); }
            case 2 -> { Reportable r = admin;  r.generarReporte(); }
            default  -> System.out.println("Volviendo al menú principal.\n");
        }
    }

    private static void menuSupervisor(Scanner sc) {
        System.out.println("\n--- ACCESO SUPERVISOR ---");
        System.out.print("Usuario: "); String u = sc.nextLine();
        System.out.print("Clave  : "); String c = sc.nextLine();

        Autenticable auth = supervisor;
        if (!auth.iniciarSesion(u, c)) return;

        System.out.println("\nMENÚ SUPERVISOR ");
        System.out.println("1. Generar reporte de zona");
        System.out.println("2. Volver");

        int op = leerEntero(sc, "Opción: ");
        if (op == 1) {
            Reportable r = supervisor;
            r.generarReporte();
        } else {
            System.out.println("Volviendo al menú principal.\n");
        }
    }
    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
