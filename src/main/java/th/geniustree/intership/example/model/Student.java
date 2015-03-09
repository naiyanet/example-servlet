/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.geniustree.intership.example.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author M6500
 */
public class Student implements Serializable{
    private Integer id;
    private String name;
    private String sex;
    private Date bod;

    public Student(Integer id,String name,String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    public Student(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }
    
    
}
