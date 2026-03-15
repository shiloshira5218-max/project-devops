package com.example.project_devops.Controller;

import com.example.project_devops.dto.ShopGunIn;
import com.example.project_devops.model.ShopGun;
import com.example.project_devops.service.ShopGunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/shopguns")
public class ShopGunController {

    @Autowired
    private ShopGunService shopGunService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllShopGuns() {
        return new ResponseEntity<>(shopGunService.all(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOneGun(@PathVariable Long id) {

        Optional<ShopGun> dbGun = shopGunService.getGunById(id);

        if (dbGun.isPresent()) {
            return new ResponseEntity<>(dbGun.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("ShopGun not found", HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<?> insertGun(@RequestBody ShopGunIn shopGunIn) {

        ShopGun shopGun = shopGunIn.toShopGun();
        shopGun = shopGunService.saveGun(shopGun);

        return new ResponseEntity<>(shopGun, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateGun(@PathVariable Long id,
                                       @RequestBody ShopGunIn shopGunIn) {

        Optional<ShopGun> dbGun = shopGunService.getGunById(id);

        if (dbGun.isPresent()) {

            shopGunIn.updateShopGun(dbGun.get());
            ShopGun updated = shopGunService.saveGun(dbGun.get());

            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

        return new ResponseEntity<>("ShopGun not found", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGun(@PathVariable Long id) {

        Optional<ShopGun> dbGun = shopGunService.getGunById(id);

        if (dbGun.isPresent()) {

            shopGunService.deleteGun(id);
            return new ResponseEntity<>("DELETED", HttpStatus.OK);
        }

        return new ResponseEntity<>("ShopGun not found", HttpStatus.NOT_FOUND);
    }
}