package org.homeapart.controller;

import lombok.RequiredArgsConstructor;
import org.homeapart.domain.Additionally;
import org.homeapart.domain.Apart;
import org.homeapart.domain.enums.AdditionallyList;
import org.homeapart.service.AdditionallyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/additionnally")
@RequiredArgsConstructor
public class AdditionallyController {
    private final AdditionallyService additionallyService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(additionallyService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Additionally savingAdditionally(@RequestParam AdditionallyList additionallyList){
        Additionally addition=new Additionally();
        addition.setAdditionally(additionallyList);
        return additionallyService.save(addition);
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long deleteAdditionally(@PathVariable Long id) {
        if (additionallyService.findById(id) == null) throw new IllegalArgumentException("additionally do not exist");
        Additionally additionally = additionallyService.findById(id);
        return additionallyService.delete(additionally);

    }
}
