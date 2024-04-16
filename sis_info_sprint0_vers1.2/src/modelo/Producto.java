
package modelo;

/**
 *
 * @author Isai
 */
public class Producto {

    int posicion;
    String marca;
    int precio;
    int comparador;

    public Producto() {
    }

    public Producto(int posicion, String marca, int precio, int comparador) {
        this.posicion = posicion;
        this.marca = marca;
        this.precio = precio;
        this.comparador = comparador;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getComparador() {
        return comparador;
    }

    public void setComparador(int comparador) {
        this.comparador = comparador;
    }

}
