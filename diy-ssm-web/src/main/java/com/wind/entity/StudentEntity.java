package com.wind.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@Component
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 3353687334552477688L;

    private int id;             //学号
    private String name;        //姓名
    private int classId;        //班级
    private int status;         //是否有效(1:有效，-1:无效)
    private Date addTime;       //添加时间
    private Date updateTime;    //更新时间
}
