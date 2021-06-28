package com.rj.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@ToString
public class Employee implements Serializable {
    private Integer eId;
    private String eName;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
}
