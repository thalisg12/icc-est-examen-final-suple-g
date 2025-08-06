package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Producto {

  private String nombre;
  private String codigo;
  private List<Double> precios;

  public Producto(String nombre, String codigo, List<Double> precios) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.precios = precios;
  }

  private int calcularPorcentajeUnicos() {
    if (nombre == null || nombre.isEmpty()) {
      return 0;
    }
    String nombreSinEspacios = nombre.toLowerCase().replace(" ", "");
    if (nombreSinEspacios.isEmpty()) {
      return 0;
    }
    Set<Character> caracteresUnicos = new HashSet<>();
    for (char c : nombreSinEspacios.toCharArray()) {
      caracteresUnicos.add(c);
    }
    return (caracteresUnicos.size() * 100) / nombreSinEspacios.length();
  }

  private int cantidadPreciosRepetidos() {
    if (precios == null || precios.isEmpty()) {
      return 0;
    }
    double sum = 0;
    for (Double precio : precios) {
      sum += precio;
    }
    return (int) Math.round(sum / precios.size());
  }

  public int getCatidadPreciosRepetidos() {
    return cantidadPreciosRepetidos();
  }

  public int getPorcentajeCaracteresUnicos() {
    return calcularPorcentajeUnicos();
  }

  public String getNombre() {
    return nombre;
  }

  public String getCodigo() {
    return codigo;
  }

  public List<Double> getPrecios() {
    return precios;
  }

  @Override
  public int compareTo(Producto otroProducto) {
    int comparacion = Integer.compare(otroProducto.porcentaje, this.porcentaje);
    if (comparacion != 0) {
      return comparacion;
    }
    int comparacionNombre = this.nombre.compareTo(precios.nombre);
    if (comparacionNombre != 0) {
      return comparacionNombre;
    }
    return this.codigo.compareTo(precios.nombre);
  }

  @Override
  public int hashCode() {
    return precios;
  }

  @Override
  public boolean equals(Object obj) {
    //
  }

  @Override
  public String toString() {
    return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precios=" + precios + "]";
  }

}
