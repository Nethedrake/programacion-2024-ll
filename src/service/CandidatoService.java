package service;

import models.Candidato;

import java.util.ArrayList;
import java.util.Scanner;

public class CandidatoService {
    private Scanner sc;
    private ArrayList<Candidato> candidatos;
    public CandidatoService(){
        sc = new Scanner(System.in);
        candidatos = new ArrayList<>();
    }

    public void gestionDeEleccion(){
        for (int i = 0; i < 5; i++) {
            System.out.println(" Ingrese el nombre del candidato " + (i+1) + ": ");
            String nombre = sc.next();
            System.out.println(" Ingrese los votos de " + nombre + ": ");
            int votos = sc.nextInt();
            candidatos.add(new Candidato(nombre,votos));
        }
        calcularVotos();
    }
    private void calcularVotos() {
        if (candidatos.isEmpty()) {
            System.out.println("No hay candidatos para calcular.");
            return;
        }
        int totalVotos = 0;
        for (Candidato candidato : candidatos) {
            totalVotos += candidato.getVotos();
        }
        for (Candidato candidato : candidatos) {
            double porcentaje = (double) candidato.getVotos() / totalVotos * 100;
            candidato.setPorcentaje(porcentaje);
        }
        System.out.println("\n---- Resultados de la elección ----");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
        Candidato ganador = determinarGanador();
        System.out.println("\nEl ganador de la elección es: " + ganador.getNombre());
    }
    private Candidato determinarGanador() {
        Candidato ganador = candidatos.get(0);
        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() > ganador.getVotos()) {
                ganador = candidato;
            }
        }
        return ganador;
    }
}
