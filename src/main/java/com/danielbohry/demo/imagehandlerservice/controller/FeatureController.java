package com.danielbohry.demo.imagehandlerservice.controller;

import com.danielbohry.demo.imagehandlerservice.exception.NotFoundException;
import com.danielbohry.demo.imagehandlerservice.model.Feature;
import com.danielbohry.demo.imagehandlerservice.service.FeatureService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "features")
public class FeatureController {

    private FeatureService service;

    public FeatureController(FeatureService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Feature>> getAll() {
        List<Feature> result = service.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Feature> getById(@PathVariable UUID id) {
        try {
            Feature result = service.find(id);
            return ResponseEntity.ok(result);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "{id}/quicklook", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getQuickLook(@PathVariable UUID id) {
        try {
            String result = service.findQuicklook(id);
            return ResponseEntity.ok(Base64.decodeBase64(result));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
