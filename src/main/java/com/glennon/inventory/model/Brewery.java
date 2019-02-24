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
    @Column(name = "BREWERY_ID")
    private Integer breweryId;

    @Column(name = "BREWERY_NAME")
    private String breweryName;

}