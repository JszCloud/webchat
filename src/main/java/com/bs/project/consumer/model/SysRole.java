package com.bs.project.consumer.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;



    public SysRole(Long id,String name) {
        this.name = name;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysRole(String name) {
        this.name = name;
    }
    public SysRole(Long id) {
        this.id = id;
    }

    public SysRole() {
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
