package com.wind.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


@Component
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 7475710140661551551L;

    private int id;             //学号
    private String name;        //姓名
    private int classId;        //班级
    private int status;         //是否有效(1:有效，-1:无效)
    private Date addTime;       //添加时间
    private Date updateTime;    //更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
