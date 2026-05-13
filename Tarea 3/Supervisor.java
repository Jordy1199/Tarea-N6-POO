package tarea3;

public class Supervisor implements Autenticable, Reportable {

    private String nombre;
    private String usuarioRegistrado;
    private String claveRegistrada;
    private String zona;

    public Supervisor(String nombre, String usuario, String clave, String zona) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del supervisor no puede estar vacío.");
        }
        if (usuario == null || clave == null || usuario.isEmpty() || clave.isEmpty()) {
            throw new IllegalArgumentException("Usuario y clave no pueden estar vacíos.");
        }
        if (zona == null || zona.isEmpty()) {
            throw new IllegalArgumentException("La zona de supervisión no puede estar vacía.");
        }
        this.nombre             = nombre;
        this.usuarioRegistrado  = usuario;
        this.claveRegistrada    = clave;
        this.zona               = zona;
    }

    public String getNombre() { return nombre; }
    public String getZona()   { return zona; }

    @Override
    public boolean iniciarSesion(String usuario, String clave) {
        if (usuarioRegistrado.equals(usuario) && claveRegistrada.equals(clave)) {
            System.out.println("✓ Supervisor '" + nombre + "' autenticado correctamente.");
            return true;
        }
        System.out.println("Credenciales incorrectas para supervisor '" + nombre + "'.");
        return false;
    }

    @Override
    public void generarReporte() {
        System.out.println("[SUPERVISOR - " + nombre + "] Generando reporte de supervisión para zona: " + zona + ".");
        System.out.println("Reporte incluye: desempeño de cajeros, incidencias y cumplimiento de metas.");
    }
}
