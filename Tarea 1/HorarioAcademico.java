package tarea1;

/**
 * Clase HorarioAcademico
 * Representa el horario de clases de una carrera en un período dado.
 * Implementa el contrato Imprimible.
 */
public class HorarioAcademico implements Imprimible {

    // Atributos propios (encapsulados)
    private String carrera;
    private String periodoAcademico;
    private String[] materias;
    private int numeroDocumento;

    // Constructor
    public HorarioAcademico(String carrera, String periodoAcademico, String[] materias, int numeroDocumento) {
        if (materias == null || materias.length == 0) {
            throw new IllegalArgumentException("El horario debe tener al menos una materia.");
        }
        if (numeroDocumento <= 0) {
            throw new IllegalArgumentException("El número de documento debe ser mayor a cero.");
        }
        this.carrera = carrera;
        this.periodoAcademico = periodoAcademico;
        this.materias = materias;
        this.numeroDocumento = numeroDocumento;
    }

    // Getters
    public String getCarrera()          { return carrera; }
    public String getPeriodoAcademico() { return periodoAcademico; }
    public String[] getMaterias()       { return materias; }
    public int getNumeroDocumento()     { return numeroDocumento; }

    /**
     * Implementación del contrato Imprimible.
     * Muestra el horario académico con las materias registradas.
     */
    @Override
    public void imprimir() {
        System.out.println("========================================");
        System.out.println("         HORARIO ACADÉMICO              ");
        System.out.println("========================================");
        System.out.println("Documento N°: " + numeroDocumento);
        System.out.println("Carrera     : " + carrera);
        System.out.println("Período     : " + periodoAcademico);
        System.out.println("Materias registradas:");
        for (int i = 0; i < materias.length; i++) {
            System.out.println("  " + (i + 1) + ". " + materias[i]);
        }
        System.out.println("Total de materias: " + materias.length);
        System.out.println("========================================\n");
    }
}
