package de.javengers.addressbook.entity;

import javax.persistence.*;

@Entity
@Table
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String label = "";

    public Label() {
    }

    public Label(String label) {
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
