package com.example.jhonnypereztapia.modelo;

import java.math.BigDecimal;

public class Food {
    private String nombre;
    private String descripcion;
    private double precio;

    public Food(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("la descripcion no puede estar vacia");
        }
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrice(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("el precio no puede ser negativo");
        }
        this.precio = precio;
    }
}