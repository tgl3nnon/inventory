package com.glennon.inventory.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "BREWERY")
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BREWERY_ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "BREWERY_NAME")
    @NotNull
    private String breweryName;

}