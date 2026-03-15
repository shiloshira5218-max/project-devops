
package com.example.project_devops.service;


import com.example.project_devops.model.ShopGun;
import com.example.project_devops.repo.ShopGunRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopGunService {

    private final ShopGunRepository repository;

    // Constructor Injection (מומלץ)
    public ShopGunService(ShopGunRepository repository) {
        this.repository = repository;
    }

    public Iterable<ShopGun> all() {
        return repository.findAll();
    }

    public Optional<ShopGun> getGunById(Long id) {
        return repository.findById(id);
    }

    public ShopGun saveGun(ShopGun shopGun) {
        return repository.save(shopGun);
    }

    public void deleteGun(Long id) {
        repository.deleteById(id);
    }
}
