package tarea3;

public class Cajero implements Autenticable, Gestionable {

    private String nombre;
    private String usuarioRegistrado;
    private String claveRegistrada;
    private int sucursal;

    public Cajero(String nombre, String usuario, String clave, int sucursal) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cajero no puede estar vacío.");
        }
        if (usuario == null || clave == null || usuario.isEmpty() || clave.isEmpty()) {
            throw new IllegalArgumentException("Usuario y clave no pueden estar vacíos.");
        }
        if (sucursal <= 0) {
            throw new IllegalArgumentException("El número de sucursal debe ser mayor a cero.");
        }
        this.nombre             = nombre;
        this.usuarioRegistrado  = usuario;
        this.claveRegistrada    = clave;
        this.sucursal           = sucursal;
    }

    public String getNombre()   { return nombre; }
    public int getSucursal()    { return sucursal; }

    @Override
    public boolean iniciarSesion(String usuario, String clave) {
        if (usuarioRegistrado.equals(usuario) && claveRegistrada.equals(clave)) {
            System.out.println("Cajero '" + nombre + "' autenticado correctamente.");
            return true;
        }
        System.out.println("Credenciales incorrectas para cajero '" + nombre + "'.");
        return false;
    }

    @Override
    public void gestionarDatos() {
        System.out.println("[CAJERO - " + nombre + "] Gestionando transacciones de caja en sucursal " + sucursal + ".");
        System.out.println("Registrando depósito, retiro o consulta de saldo.");
    }
}
