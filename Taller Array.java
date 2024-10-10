import java.util.ArrayList;

// Clase Producto
class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}

// Clase Inventario
class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void modificarCantidad(String nombre, int nuevaCantidad) {
        Producto p = buscarProducto(nombre);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            System.out.println("La cantidad de " + nombre + " ha sido actualizada a " + nuevaCantidad);
        } else {
            System.out.println("Producto no encontrado: " + nombre);
        }
    }
}

// Clase Principal
public class SistemaInventario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregar productos
        inventario.agregarProducto(new Producto("Manzanas", 10, 0.5));
        inventario.agregarProducto(new Producto("Bananas", 20, 0.3));
        inventario.agregarProducto(new Producto("Naranjas", 15, 0.4));

        // Mostrar inventario
        System.out.println("Inventario completo:");
        inventario.mostrarInventario();

        // Buscar producto
        String nombreProducto = "Bananas";
        Producto productoEncontrado = inventario.buscarProducto(nombreProducto);
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado);
        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }

        // Modificar cantidad de un producto
        inventario.modificarCantidad("Bananas", 25);

        // Intentar modificar la cantidad de un producto que no existe
        inventario.modificarCantidad("Peras", 10);

        // Mostrar inventario actualizado
        System.out.println("Inventario actualizado:");
        inventario.mostrarInventario();
    }
}
