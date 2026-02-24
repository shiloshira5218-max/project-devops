package com.example.project_devops.model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "shopgun")
@Getter
@Setter
public class ShopGun implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Length(min = 3, max = 50)
    private String name;

    @NotNull
    @Min(1)
    @Max(100000)
    private Double price;

    @Length(max = 500)
    private String description;

    @Min(0)
    @Max(10000)
    private Integer stock;

    @Length(max = 500)
    private String imageUrl;

    public ShopGun() {}

    public ShopGun(String name, Double price, String description, Integer stock, String imageUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }
}
