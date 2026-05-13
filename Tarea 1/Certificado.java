package tarea1;

public class Certificado implements Imprimible {

    private String nombreEstudiante;
    private String carrera;
    private int numeroDocumento;

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

    public String getNombreEstudiante() { return nombreEstudiante; }
    public String getCarrera()          { return carrera; }
    public int getNumeroDocumento()     { return numeroDocumento; }

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
