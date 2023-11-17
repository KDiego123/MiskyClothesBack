package com.upc.miskyclothes.interfaceservice;

import com.upc.miskyclothes.entities.Disenador;

import java.util.List;
public interface DisenadorService {
public Disenador register (Disenador disenador);
public List<Disenador> listDisenador();
List<Disenador>listByName(String prefix);
}
