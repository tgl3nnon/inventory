package com.glennon.inventory.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BEER_ID")
    private Integer id;

    @Column(name = "BEER_NAME")
    @NotNull
    private String name;

    @Column(name = "STYLE")
    @NotNull
    private String style;

    @Column(name = "VOLUME")
    @NotNull
    private Integer volume;

    @Column(name = "QUANTITY")
    @NotNull
    private Integer quantity;

    @Column(name = "BOTTLE_DATE")
    @NotNull
    private Date bottleDate;

    @Column(name = "LOCATION")
    @NotNull
    private String location;

    @ManyToOne
    @JoinColumn(name = "BREWERY_ID")
    private Brewery brewery;

}
