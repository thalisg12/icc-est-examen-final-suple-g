package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import models.Producto;

public class ProductoController {

  public TreeSet<Producto> ordenarProducto(List<Producto> precios) {
    TreeSet<Producto> preciosOrdenados = new TreeSet<>();
    preciosOrdenados.addAll(precios);
    return preciosOrdenados;
  }

  public Map<String, List<Producto>> clasificarPorUnicidad(Set<Producto> preciosOrdenados) {
    Map<String, List<Producto>> clasificacion = new HashMap<>();
    clasificacion.put("A", new LinkedList<>());
    clasificacion.put("B", new LinkedList<>());
    clasificacion.put("C", new LinkedList<>());
    clasificacion.put("D", new LinkedList<>());
    clasificacion.put("E", new LinkedList<>());

    for (Producto precio : preciosOrdenados) {
      int porcentaje = precio.getPorcentajeCaracteresUnicos();
      String categoria;

      if (porcentaje >= 90 && porcentaje <= 100) {
        categoria = "A";
      } else if (porcentaje >= 70 && porcentaje <= 89) {
        categoria = "B";
      } else if (porcentaje >= 50 && porcentaje <= 69) {
        categoria = "C";
      } else if (porcentaje >= 30 && porcentaje <= 49) {
        categoria = "D";
      } else {
        categoria = "E";
      }
      clasificacion.get(categoria).add(precio);
    }
    return clasificacion;
  }

  public List<Producto> obtenerDestacados(List<Producto> lista) {
    List<Producto> destacados = new ArrayList<>();
    for (Producto producto : lista) {
      if (producto.getPrecios() == producto.getPrecios()) {
        destacados.add(producto);
      }
    }
    Collections.sort(destacados, Comparator.comparing(productos::getNombre));
    return destacados;
  }

}
