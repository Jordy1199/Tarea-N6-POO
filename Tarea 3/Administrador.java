package tarea3;

public class Administrador implements Autenticable, Reportable, Gestionable {

    private String nombre;
    private String usuarioRegistrado;
    private String claveRegistrada;
    private String departamento;

    public Administrador(String nombre, String usuario, String clave, String departamento) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del administrador no puede estar vacío.");
        }
        if (usuario == null || clave == null || usuario.isEmpty() || clave.isEmpty()) {
            throw new IllegalArgumentException("Usuario y clave no pueden estar vacíos.");
        }
        if (departamento == null || departamento.isEmpty()) {
            throw new IllegalArgumentException("El departamento no puede estar vacío.");
        }
        this.nombre             = nombre;
        this.usuarioRegistrado  = usuario;
        this.claveRegistrada    = clave;
        this.departamento       = departamento;
    }

    public String getNombre()       { return nombre; }
    public String getDepartamento() { return departamento; }

    @Override
    public boolean iniciarSesion(String usuario, String clave) {
        if (usuarioRegistrado.equals(usuario) && claveRegistrada.equals(clave)) {
            System.out.println("Administrador '" + nombre + "' autenticado correctamente.");
            return true;
        }
        System.out.println("Credenciales incorrectas para administrador '" + nombre + "'.");
        return false;
    }

    @Override
    public void generarReporte() {
        System.out.println("[ADMINISTRADOR - " + nombre + "] Generando reporte completo del departamento " + departamento + ".");
        System.out.println("Reporte incluye: ventas, empleados, auditoría y finanzas.");
    }

    @Override
    public void gestionarDatos() {
        System.out.println("[ADMINISTRADOR - " + nombre + "] Gestionando datos del sistema — departamento: " + departamento + ".");
        System.out.println(" Puede crear, editar y eliminar usuarios, productos y configuraciones.");
    }
}
