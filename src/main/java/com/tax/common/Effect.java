package com.tax.common;

public interface Effect<T> {
  void apply(T t);
}