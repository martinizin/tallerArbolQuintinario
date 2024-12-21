import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ArbolGrafico extends JPanel {
    private Arbol arbol;

    public ArbolGrafico(Arbol arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Obtener el tamaño del panel
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Calcular la posición inicial (centrado en el panel)
        int x = panelWidth / 2;
        int y = 50; // Un valor fijo para la raíz del árbol

        // Dimensiones para los nodos hijos
        int dimensionX = panelWidth / 4;
        int dimensionY = 80;

        // Dibujar el árbol
        dibujarArbol(g2d, arbol.getRaiz(), x, y, dimensionX, dimensionY);
    }

    public void dibujarArbol(Graphics2D g2d, Nodo nodo, int x, int y, int dimensionX, int dimensionY) {
        if (nodo != null) {
            // Dibuja el nodo actual (puedes personalizar cómo se dibuja el nodo aquí)
            g2d.fillOval(x - 15, y - 15, 30, 30); // Nodo circular
            g2d.drawString(nodo.etiqueta, x - 10, y + 5); // Etiqueta del nodo

            // Asigna las coordenadas del nodo actual
            nodo.x = x;
            nodo.y = y;

            // Dibujar líneas y nodos hijos
            int offsetX = dimensionX / 2; // Espaciado entre hijos

            // izquierda1
            if (nodo.izquierda1 != null) {
                g2d.drawLine(x, y, x - dimensionX, y + dimensionY);
                dibujarArbol(g2d, nodo.izquierda1, x - dimensionX, y + dimensionY, offsetX, dimensionY);
            }
            // izquierda2
            if (nodo.izquierda2 != null) {
                g2d.drawLine(x, y, x - offsetX, y + dimensionY);
                dibujarArbol(g2d, nodo.izquierda2, x - offsetX, y + dimensionY, offsetX, dimensionY);
            }
            // centro
            if (nodo.centro != null) {
                g2d.drawLine(x, y, x, y + dimensionY);
                dibujarArbol(g2d, nodo.centro, x, y + dimensionY, offsetX, dimensionY);
            }
            // derecha1
            if (nodo.derecha1 != null) {
                g2d.drawLine(x, y, x + offsetX, y + dimensionY);
                dibujarArbol(g2d, nodo.derecha1, x + offsetX, y + dimensionY, offsetX, dimensionY);
            }
            // derecha2
            if (nodo.derecha2 != null) {
                g2d.drawLine(x, y, x + dimensionX, y + dimensionY);
                dibujarArbol(g2d, nodo.derecha2, x + dimensionX, y + dimensionY, offsetX, dimensionY);
            }
        }
    }
}
