package tarea2;

public class PagoEfectivo implements Pagable {

    private String nombreCliente;

    public PagoEfectivo(String nombreCliente) {
        if (nombreCliente == null || nombreCliente.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() { return nombreCliente; }

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto debe ser mayor a $0.00 (efectivo).");
            return;
        }
        System.out.println("----------------------------------------");
        System.out.println("        PAGO EN EFECTIVO                ");
        System.out.println("----------------------------------------");
        System.out.println("Cliente   : " + nombreCliente);
        System.out.printf ("Monto     : $%.2f%n", monto);
        System.out.println("Comisión  : $0.00 (sin comisión)");
        System.out.printf ("Total     : $%.2f%n", monto);
        System.out.println("Estado    : PROCESADO ");
        System.out.println("----------------------------------------\n");
    }
}
