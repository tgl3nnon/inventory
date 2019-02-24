package com.glennon.inventory.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @Column(name = "BEER_ID")
    private Integer id;

    @Column(name = "BEER_NAME")
    private String name;

    @Column(name = "STYLE")
    private String style;

    @Column(name = "VOLUME")
    private Integer volume;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "BOTTLE_DATE")
    private Date bottleDate;

    @ManyToOne
    @JoinColumn(name = "BREWERY_ID")
    private Brewery brewery;

    @Column(name = "LOCATION")
    private String location;

}
