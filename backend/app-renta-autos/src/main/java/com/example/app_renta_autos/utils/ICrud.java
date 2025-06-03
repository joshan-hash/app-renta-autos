package com.example.app_renta_autos.utils;

import java.util.List;

public interface ICrud <T> {
    T add(T t);
    T update(T t);
    T delete(T t);
    List<T> getAll();
    T findById(Integer id);
}
