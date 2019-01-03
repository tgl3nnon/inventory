package com.glennon.inventory.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "BEER")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BEER_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "BEER_NAME", unique = true, nullable = false)
    @NotNull
    private String name;

    @Column(name = "STYLE", unique = true, nullable = false)
    @NotNull
    private String style;

    @Column(name = "VOLUME", unique = true, nullable = false)
    @NotNull
    private Integer volume;

    @Column(name = "QUANTITY", unique = true, nullable = false)
    @NotNull
    private Integer quantity;

    @Column(name = "BOTTLE_DATE", unique = true, nullable = false)
    @NotNull
    private Date bottleDate;

    @ManyToOne
    @JoinColumn(name = "BREWERY_ID", referencedColumnName = "BREWERY_ID", nullable = false)
    @NotNull
    private Brewery brewery;

    @Column(name = "LOCATION", unique = true, nullable = false)
    private String location;

}
