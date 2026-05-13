package tarea1;

/**
 * Clase Certificado
 * Representa un certificado académico emitido por la institución.
 * Implementa el contrato Imprimible.
 */
public class Certificado implements Imprimible {

    // Atributos propios del certificado (encapsulados)
    private String nombreEstudiante;
    private String carrera;
    private int numeroDocumento;

    // Constructor
    public Certificado(String nombreEstudiante, String carrera, int numeroDocumento) {
        if (nombreEstudiante == null || nombreEstudiante.isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacío.");
        }
        if (numeroDocumento <= 0) {
            throw new IllegalArgumentException("El número de documento debe ser mayor a cero.");
        }
        this.nombreEstudiante = nombreEstudiante;
        this.carrera = carrera;
        this.numeroDocumento = numeroDocumento;
    }

    // Getters
    public String getNombreEstudiante() { return nombreEstudiante; }
    public String getCarrera()          { return carrera; }
    public int getNumeroDocumento()     { return numeroDocumento; }

    /**
     * Implementación del contrato Imprimible.
     * Muestra la información del certificado académico.
     */
    @Override
    public void imprimir() {
        System.out.println("========================================");
        System.out.println("         CERTIFICADO ACADÉMICO          ");
        System.out.println("========================================");
        System.out.println("Documento N°: " + numeroDocumento);
        System.out.println("Estudiante  : " + nombreEstudiante);
        System.out.println("Carrera     : " + carrera);
        System.out.println("Se certifica que el estudiante ha cumplido");
        System.out.println("satisfactoriamente todos los requisitos.");
        System.out.println("========================================\n");
    }
}
