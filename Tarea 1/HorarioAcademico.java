package tarea1;

public class HorarioAcademico implements Imprimible {

    private String carrera;
    private String periodoAcademico;
    private String[] materias;
    private int numeroDocumento;

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

    public String getCarrera()          { return carrera; }
    public String getPeriodoAcademico() { return periodoAcademico; }
    public String[] getMaterias()       { return materias; }
    public int getNumeroDocumento()     { return numeroDocumento; }

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
