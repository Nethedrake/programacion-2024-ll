package models;

public class Candidato {
    private String nombre;
    private int votos;
    private double porcentaje;

    public Candidato(String nombre, int votos) {
        this.nombre = nombre;
        this.votos = votos;

    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getVotos() {return votos;}

    public void setVotos(int votos) {this.votos = votos;}

    public double getPorcentaje() {return porcentaje;}

    public void setPorcentaje(double porcentaje) {this.porcentaje = porcentaje;}

    @Override
    public String toString() {
        return "Candidato{" +
                "nombre='" + nombre + '\'' +
                ", votos=" + votos +
                ", porcentaje=" + porcentaje +
                '}';
    }
}
