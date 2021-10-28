package com.wind.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author cmm
 */
@Entity
@Table(name = "RUN_Department", schema = "RUNOOB", catalog = "")
public class RunDepartmentEntity implements Serializable {

    private static final long serialVersionUID = -8759356651704106286L;

    private Integer id;
    private String name;
    private Integer status;
    private Date addTime;
    private Date updateTime;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Add_Time")
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "Update_Time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunDepartmentEntity that = (RunDepartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(status, that.status) && Objects.equals(addTime, that.addTime)
                && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, addTime, updateTime);
    }
}
