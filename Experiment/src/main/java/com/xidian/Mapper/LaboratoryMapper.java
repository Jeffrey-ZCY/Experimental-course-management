package com.xidian.Mapper;


import com.xidian.pojo.Laboratory;

import java.util.List;

public interface LaboratoryMapper {
    //增加实验室
    public void addLaboratory(Laboratory laboratory);

    //删除实验室
    public void deleteLaboratory(int room);

    //查看全部实验室
    public List<Laboratory> getLaboratoryList();

    //查看指定房间号实验室
    public Laboratory getLaboratoryByRoom(int room);
}
