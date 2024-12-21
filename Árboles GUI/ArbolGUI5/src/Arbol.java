import java.util.*;

public class Arbol {
    private Nodo raiz;
    private ArrayList<Nodo> nodos;
    private int numNodos;

    public Arbol() {
        raiz = null;
        nodos = new ArrayList<>();
        numNodos = 0;
    }

    public void anadirNodo(Nodo nodo, Nodo padre, String posicion) {
        if (padre == null) {
            if (raiz == null) {
                raiz = nodo;
            } else {
                throw new IllegalArgumentException("La raíz ya existe");
            }
        } else {
            switch (posicion) {
                case "izquierda1":
                    if (padre.izquierda1 == null) {
                        padre.izquierda1 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo izquierda1 ya existe");
                    }
                    break;
                case "izquierda2":
                    if (padre.izquierda2 == null) {
                        padre.izquierda2 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo izquierda2 ya existe");
                    }
                    break;
                case "centro":
                    if (padre.centro == null) {
                        padre.centro = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo centro ya existe");
                    }
                    break;
                case "derecha1":
                    if (padre.derecha1 == null) {
                        padre.derecha1 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo derecha1 ya existe");
                    }
                    break;
                case "derecha2":
                    if (padre.derecha2 == null) {
                        padre.derecha2 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo derecha2 ya existe");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Posición no válida");
            }
        }
        nodos.add(nodo);
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public String getEtiquetaNodoSiguiente() {
        return String.valueOf((char) ('A' + numNodos++));
    }

    // Método bfs (Recorrido en Anchura)
    public String bfs() {
        if (raiz == null) return "";

        StringBuilder resultado = new StringBuilder();
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            Nodo nodo = queue.poll();
            resultado.append(nodo.etiqueta).append(" ");
            if (nodo.izquierda1 != null) queue.add(nodo.izquierda1);
            if (nodo.izquierda2 != null) queue.add(nodo.izquierda2);
            if (nodo.centro != null) queue.add(nodo.centro);
            if (nodo.derecha1 != null) queue.add(nodo.derecha1);
            if (nodo.derecha2 != null) queue.add(nodo.derecha2);
        }

        return resultado.toString().trim();
    }

    // Método dfs (Recorrido en Profundidad)
    public String dfs() {
        if (raiz == null) return "";

        StringBuilder resultado = new StringBuilder();
        Stack<Nodo> stack = new Stack<>();
        stack.push(raiz);

        while (!stack.isEmpty()) {
            Nodo nodo = stack.pop();
            resultado.append(nodo.etiqueta).append(" ");
            // Añadir hijos al stack en orden inverso para asegurar recorrido correcto
            if (nodo.derecha2 != null) stack.push(nodo.derecha2);
            if (nodo.derecha1 != null) stack.push(nodo.derecha1);
            if (nodo.centro != null) stack.push(nodo.centro);
            if (nodo.izquierda2 != null) stack.push(nodo.izquierda2);
            if (nodo.izquierda1 != null) stack.push(nodo.izquierda1);
        }

        return resultado.toString().trim();
    }

    // Método para obtener la matriz de adyacencia
    public Object[][] getMatrizAdyacencia() {
        int tam = nodos.size();
        Object[][] matriz = new Object[tam][tam];
        Map<String, Integer> etiquetaAIndice = new HashMap<>();

        for (int i = 0; i < tam; i++) {
            etiquetaAIndice.put(nodos.get(i).etiqueta, i);
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = 0;
            }
        }

        for (Nodo nodo : nodos) {
            int desdeIndice = etiquetaAIndice.get(nodo.etiqueta);
            if (nodo.izquierda1 != null) {
                int hastaIndice = etiquetaAIndice.get(nodo.izquierda1.etiqueta);
                matriz[desdeIndice][hastaIndice] = 1;
            }
            if (nodo.izquierda2 != null) {
                int hastaIndice = etiquetaAIndice.get(nodo.izquierda2.etiqueta);
                matriz[desdeIndice][hastaIndice] = 1;
            }
            if (nodo.centro != null) {
                int hastaIndice = etiquetaAIndice.get(nodo.centro.etiqueta);
                matriz[desdeIndice][hastaIndice] = 1;
            }
            if (nodo.derecha1 != null) {
                int hastaIndice = etiquetaAIndice.get(nodo.derecha1.etiqueta);
                matriz[desdeIndice][hastaIndice] = 1;
            }
            if (nodo.derecha2 != null) {
                int hastaIndice = etiquetaAIndice.get(nodo.derecha2.etiqueta);
                matriz[desdeIndice][hastaIndice] = 1;
            }
        }

        return matriz;
    }

    // Métodos de recorrido: preorden, inorden y postorden ya implementados
}
