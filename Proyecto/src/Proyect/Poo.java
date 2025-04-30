package Proyect;

import java.util.ArrayList;

class Superheroe {
    private String nombre;
    private String descripcion;
    private boolean capa;


    public Superheroe(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
        this.capa = false;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public boolean isCapa() {
        return capa;
    }


    public void setCapa(boolean capa) {
        this.capa = capa;
    }


    public String toString() {
        return "Nombre: " + nombre + ", Descripción: " + descripcion + ", Capa: " + capa;
    }
}


class Dimension {
    private double alto;
    private double ancho;
    private double profundidad;


    public Dimension() {
        this.alto = 0;
        this.ancho = 0;
        this.profundidad = 0;
    }


    public Dimension(double alto, double ancho, double profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }


    public double getAlto() {
        return alto;
    }


    public void setAlto(double alto) {
        this.alto = alto;
    }


    public double getAncho() {
        return ancho;
    }


    public void setAncho(double ancho) {
        this.ancho = ancho;
    }


    public double getProfundidad() {
        return profundidad;
    }


    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }


    public double getVolumen() {
        return alto * ancho * profundidad;
    }


    public String toString() {
        return "Alto: " + alto + ", Ancho: " + ancho + ", Profundidad: " + profundidad + ", Volumen: " + getVolumen();
    }
}


class Figura {
    private String codigo;
    private double precio;
    private Superheroe superheroe;
    private Dimension dimensiones;


    public Figura(String codigo, double precio, Dimension dimensiones, Superheroe superheroe) {
        this.codigo = codigo;
        this.precio = precio;
        this.dimensiones = dimensiones;
        this.superheroe = superheroe;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Superheroe getSuperheroe() {
        return superheroe;
    }


    public void setSuperheroe(Superheroe superheroe) {
        this.superheroe = superheroe;
    }


    public Dimension getDimensiones() {
        return dimensiones;
    }


    public void setDimensiones(Dimension dimensiones) {
        this.dimensiones = dimensiones;
    }


    public void subirPrecio(double cantidad) {
        this.precio += cantidad;
    }


    public String toString() {
        return "Código: " + codigo + ", Precio: " + precio + ", Superhéroe: [" + superheroe + "], Dimensiones: [" + dimensiones + "]";
    }
}


class Coleccion {
    private String nombreColeccion;
    private ArrayList<Figura> listaFiguras;


    public Coleccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
        this.listaFiguras = new ArrayList<>();
    }


    public String getNombreColeccion() {
        return nombreColeccion;
    }


    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }


    public void añadirFigura(Figura fig) {
        listaFiguras.add(fig);
    }


    public void subirPrecio(double cantidad, String id) {
        for (Figura f : listaFiguras) {
            if (f.getCodigo().equals(id)) {
                f.subirPrecio(cantidad);
                break;
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Colección: ").append(nombreColeccion).append("\n");
        for (Figura f : listaFiguras) {
            sb.append(f.toString()).append("\n");
        }
        return sb.toString();
    }


    public String conCapa() {
        StringBuilder sb = new StringBuilder();
        for (Figura f : listaFiguras) {
            if (f.getSuperheroe().isCapa()) {
                sb.append(f.toString()).append("\n");
            }
        }
        return sb.toString();
    }


    public Figura masValioso() {
        if (listaFiguras.isEmpty()) return null;
        Figura max = listaFiguras.get(0);
        for (Figura f : listaFiguras) {
            if (f.getPrecio() > max.getPrecio()) {
                max = f;
            }
        }
        return max;
    }


    public double getValorColeccion() {
        double suma = 0;
        for (Figura f : listaFiguras) {
            suma += f.getPrecio();
        }
        return suma;
    }


    public double getVolumenColeccion() {
        double suma = 0;
        for (Figura f : listaFiguras) {
            suma += f.getDimensiones().getVolumen();
        }
        return suma + 200;
    }
}


class Main {
    public static void main(String[] args) {
        Superheroe batman = new Superheroe("Batman");
        batman.setDescripcion("Traje negro, orejas puntiagudas");
        batman.setCapa(true);


        Dimension dim1 = new Dimension(10, 5, 3);
        Figura figura1 = new Figura("BAT001", 29.99, dim1, batman);


        Superheroe spiderman = new Superheroe("Spiderman");
        spiderman.setDescripcion("Traje rojo y azul");
        spiderman.setCapa(false);


        Dimension dim2 = new Dimension(12, 6, 4);
        Figura figura2 = new Figura("SPID001", 34.50, dim2, spiderman);


        Coleccion marvel = new Coleccion("Colección Marvel");
        marvel.añadirFigura(figura1);
        marvel.añadirFigura(figura2);


        System.out.println(marvel);


        System.out.println("Figuras con capa:");
        System.out.println(marvel.conCapa());


        System.out.println("Figura más valiosa:");
        System.out.println(marvel.masValioso());


        System.out.println("Valor total de la colección: " + marvel.getValorColeccion());
        System.out.println("Volumen total de la colección: " + marvel.getVolumenColeccion());


        marvel.subirPrecio(5.0, "BAT001");
        System.out.println("Después de subir el precio de BAT001:");
        System.out.println(marvel);
    }
}





