package com.mapper;

import com.entity.Admin;
import com.entity.Student;


import java.util.List;

public interface AdminMapper {
     public void add(Admin Admin);
     public void delete(Integer id);
     public void update(Admin Admin);
     public List<Admin> list();
     public Admin findById(Integer id);
     public Admin findByName(String name);
}
