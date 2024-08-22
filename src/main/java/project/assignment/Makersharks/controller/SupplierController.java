package project.assignment.Makersharks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import project.assignment.Makersharks.model.Supplier;
import project.assignment.Makersharks.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam @NotBlank String location,
            @RequestParam @NotBlank String natureOfBusiness,
            @RequestParam @NotBlank String manufacturingProcesses,
            @RequestParam @Min(0) int page,
            @RequestParam @Min(1) int size) {

        Page<Supplier> suppliers = supplierService.searchSuppliers(location, natureOfBusiness, manufacturingProcesses,
                page, size);
        return ResponseEntity.ok(suppliers);
    }

}
