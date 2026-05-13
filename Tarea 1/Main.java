package tarea1;

public class Main {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println(" SISTEMA ACADÉMICO DE DOCUMENTOS");
        System.out.println("===========================================\n");


        Certificado cert = new Certificado(
                "María Gabriela Torres",
                "Ingeniería en Sistemas",
                1001
        );

        ActaNotas acta = new ActaNotas(
                "Carlos Andrés Mejía",
                "2024-2025 Primer Semestre",
                8.75,
                1002
        );

        HorarioAcademico horario = new HorarioAcademico(
                "Administración de Empresas",
                "2024-2025 Segundo Semestre",
                new String[]{"Cálculo I", "Programación Básica", "Comunicación Oral", "Economía"},
                1003
        );

        // --- Polimorfismo: arreglo de tipo interfaz ---
        // Cada elemento es un tipo diferente, pero todos cumplen el contrato Imprimible
        Imprimible[] documentos = { cert, acta, horario };

        System.out.println(">>> Imprimiendo todos los documentos académicos:\n");

        for (Imprimible doc : documentos) {
            doc.imprimir();  // Polimorfismo en acción
        }

        // --- Prueba de validaciones ---
        System.out.println(">>> Prueba de validaciones:");
        try {
            ActaNotas actaInvalida = new ActaNotas("Pedro", "2024", 15.0, 9999);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        try {
            Certificado certInvalido = new Certificado("", "Derecho", 5000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        System.out.println("\n✓ Sistema académico ejecutado correctamente.");
    }
}
