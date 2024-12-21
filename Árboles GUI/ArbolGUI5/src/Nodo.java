public class Nodo {
    int x, y;
    String etiqueta;
    Nodo izquierda1, izquierda2, centro, derecha1, derecha2; // Nuevos nodos hijos

    public Nodo(int x, int y, String etiqueta) {
        this.x = x;
        this.y = y;
        this.etiqueta = etiqueta;
        this.izquierda1 = null;
        this.izquierda2 = null;
        this.centro = null;
        this.derecha1 = null;
        this.derecha2 = null;
    }

    @Override
    public String toString() {
        return etiqueta + " (" + x + ", " + y + ")";
    }
}