package com.example.project_devops.dto;

import com.example.project_devops.model.ShopGun;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
public class ShopGunIn implements Serializable {

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

    // יצירת אובייקט חדש
    public ShopGun toShopGun() {
        return new ShopGun(
                name,
                price,
                description,
                stock,
                imageUrl
        );
    }

    // עדכון אובייקט קיים
    public void updateShopGun(ShopGun shopGun) {
        shopGun.setName(name);
        shopGun.setPrice(price);
        shopGun.setDescription(description);
        shopGun.setStock(stock);
        shopGun.setImageUrl(imageUrl);
    }
}