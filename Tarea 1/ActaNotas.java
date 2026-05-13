package tarea1;

/**
 * Clase ActaNotas
 * Representa el acta de notas de un estudiante en un período académico.
 * Implementa el contrato Imprimible.
 */
public class ActaNotas implements Imprimible {

    // Atributos propios (encapsulados)
    private String nombreEstudiante;
    private String periodoAcademico;
    private double promedio;
    private int numeroDocumento;

    // Constructor
    public ActaNotas(String nombreEstudiante, String periodoAcademico, double promedio, int numeroDocumento) {
        if (promedio < 0 || promedio > 10) {
            throw new IllegalArgumentException("El promedio debe estar entre 0 y 10.");
        }
        if (numeroDocumento <= 0) {
            throw new IllegalArgumentException("El número de documento debe ser mayor a cero.");
        }
        this.nombreEstudiante = nombreEstudiante;
        this.periodoAcademico = periodoAcademico;
        this.promedio = promedio;
        this.numeroDocumento = numeroDocumento;
    }

    // Getters
    public String getNombreEstudiante() { return nombreEstudiante; }
    public String getPeriodoAcademico() { return periodoAcademico; }
    public double getPromedio()         { return promedio; }
    public int getNumeroDocumento()     { return numeroDocumento; }

    /**
     * Implementación del contrato Imprimible.
     * Muestra el acta de notas con el promedio del estudiante.
     */
    @Override
    public void imprimir() {
        System.out.println("========================================");
        System.out.println("            ACTA DE NOTAS              ");
        System.out.println("========================================");
        System.out.println("Documento N°: " + numeroDocumento);
        System.out.println("Estudiante  : " + nombreEstudiante);
        System.out.println("Período     : " + periodoAcademico);
        System.out.printf ("Promedio    : %.2f / 10.00%n", promedio);
        System.out.println("Estado      : " + (promedio >= 7.0 ? "APROBADO ✓" : "REPROBADO ✗"));
        System.out.println("========================================\n");
    }
}
