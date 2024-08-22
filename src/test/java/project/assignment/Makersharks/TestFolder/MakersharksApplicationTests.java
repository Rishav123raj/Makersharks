package project.assignment.Makersharks.TestFolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import project.assignment.Makersharks.model.Supplier;
import project.assignment.Makersharks.repository.SupplierRepository;
import project.assignment.Makersharks.service.SupplierService;

@SpringBootTest
class MakersharksApplicationTests {

	@Autowired
	SupplierService service;

	@Test
	void searchSuppliers_ShouldReturnCorrectResult() {
		SupplierRepository repository = Mockito.mock(SupplierRepository.class);
		SupplierService service = new SupplierService();

		Supplier supplier = new Supplier(1L, "Company Name", "https://website.com", "India", "small_scale",
				"3d_printing");
		Page<Supplier> mockPage = new PageImpl<>(Collections.singletonList(supplier));
		Mockito.when(repository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContains(any(), any(), any(),
				any()))
				.thenReturn(mockPage);

		Page<Supplier> result = service.searchSuppliers("India", "small_scale", "3d_printing", 0, 10);
		assertEquals(1, result.getTotalElements());
		assertEquals("Company Name", result.getContent().get(0).getCompanyName());
	}

}
