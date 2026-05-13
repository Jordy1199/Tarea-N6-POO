package tarea2;

public class Main {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("       SISTEMA BANCARIO DE PAGOS");
        System.out.println("============================================\n");

        PagoEfectivo efectivo     = new PagoEfectivo("Luis Armando Vega");
        PagoTarjeta  tarjeta      = new PagoTarjeta("Ana Sofía Ramos", "4821");
        Transferencia transferencia = new Transferencia("Jorge Esteban Mora", "2200-0045-8831");

        Pagable[] pagos = { efectivo, tarjeta, transferencia };

        System.out.println(">>> Procesando pagos con monto válido ($500.00):\n");
        for (Pagable pago : pagos) {
            pago.procesarPago(500.0);
        }

        System.out.println(">>> Prueba de validaciones con monto inválido:\n");
        for (Pagable pago : pagos) {
            pago.procesarPago(-100.0);
        }
        for (Pagable pago : pagos) {
            pago.procesarPago(0);
        }

        System.out.println("\n>>> Prueba de excepción en creación de objeto:");
        try {
            PagoTarjeta tarjetaMal = new PagoTarjeta("Ana", "12");  // solo 2 dígitos
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        System.out.println("\n Sistema bancario ejecutado correctamente.");
    }
}
