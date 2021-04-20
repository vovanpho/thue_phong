package com.example.demo.convert;

public interface BaseConverter<E,D> {
	E toEntity(D dto);
	D toDto(E entity);
}
