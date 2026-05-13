package tarea2;

public class PagoTarjeta implements Pagable {

    private static final double COMISION_TARJETA = 0.03; // 3%

    private String nombreCliente;
    private String ultimosDigitos; // últimos 4 dígitos de la tarjeta

    public PagoTarjeta(String nombreCliente, String ultimosDigitos) {
        if (nombreCliente == null || nombreCliente.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (ultimosDigitos == null || ultimosDigitos.length() != 4) {
            throw new IllegalArgumentException("Debe ingresar los últimos 4 dígitos de la tarjeta.");
        }
        this.nombreCliente = nombreCliente;
        this.ultimosDigitos = ultimosDigitos;
    }

    public String getNombreCliente()   { return nombreCliente; }
    public String getUltimosDigitos()  { return ultimosDigitos; }

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto debe ser mayor a $0.00 (tarjeta).");
            return;
        }
        double comision = monto * COMISION_TARJETA;
        double total    = monto + comision;

        System.out.println("----------------------------------------");
        System.out.println("        PAGO CON TARJETA                ");
        System.out.println("----------------------------------------");
        System.out.println("Cliente   : " + nombreCliente);
        System.out.println("Tarjeta   : **** **** **** " + ultimosDigitos);
        System.out.printf ("Monto     : $%.2f%n", monto);
        System.out.printf ("Comisión  : $%.2f (3%%)%n", comision);
        System.out.printf ("Total     : $%.2f%n", total);
        System.out.println("Estado    : PROCESADO ✓");
        System.out.println("----------------------------------------\n");
    }
}
