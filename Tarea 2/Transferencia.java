package tarea2;

public class Transferencia implements Pagable {

    private static final double COMISION_TRANSFERENCIA = 0.015; // 1.5%

    private String nombreCliente;
    private String cuentaDestino;

    public Transferencia(String nombreCliente, String cuentaDestino) {
        if (nombreCliente == null || nombreCliente.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (cuentaDestino == null || cuentaDestino.isEmpty()) {
            throw new IllegalArgumentException("La cuenta destino no puede estar vacía.");
        }
        this.nombreCliente  = nombreCliente;
        this.cuentaDestino  = cuentaDestino;
    }

    public String getNombreCliente() { return nombreCliente; }
    public String getCuentaDestino() { return cuentaDestino; }

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("✗ Error: el monto debe ser mayor a $0.00 (transferencia).");
            return;
        }
        double comision = monto * COMISION_TRANSFERENCIA;
        double total    = monto + comision;

        System.out.println("----------------------------------------");
        System.out.println("     TRANSFERENCIA BANCARIA             ");
        System.out.println("----------------------------------------");
        System.out.println("Cliente   : " + nombreCliente);
        System.out.println("Cuenta    : " + cuentaDestino);
        System.out.printf ("Monto     : $%.2f%n", monto);
        System.out.printf ("Comisión  : $%.2f (1.5%%)%n", comision);
        System.out.printf ("Total     : $%.2f%n", total);
        System.out.println("Estado    : PROCESADO ✓");
        System.out.println("----------------------------------------\n");
    }
}
