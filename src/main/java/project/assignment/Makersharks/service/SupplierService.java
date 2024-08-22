package project.assignment.Makersharks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import project.assignment.Makersharks.model.Supplier;
import project.assignment.Makersharks.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> searchSuppliers(String location, String natureOfBusiness,
            String manufacturingProcesses, int page, int size) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContains(
                location, natureOfBusiness, manufacturingProcesses, PageRequest.of(page, size));
    }
}
