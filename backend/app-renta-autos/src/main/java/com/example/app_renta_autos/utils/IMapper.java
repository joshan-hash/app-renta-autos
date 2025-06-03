package com.example.app_renta_autos.utils;

public interface IMapper <T> {
    T getDto();
    void setData(T t);
}
