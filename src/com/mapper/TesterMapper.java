package com.mapper;

import com.entity.Tester;

import java.util.List;

public interface TesterMapper {
    public void add(Tester Tester);
    public void delete(Integer id);
    public void update(Tester Tester);
    public List<Tester> list();
    public Tester findById(Integer id);
    public Tester findByName(String name);
}
