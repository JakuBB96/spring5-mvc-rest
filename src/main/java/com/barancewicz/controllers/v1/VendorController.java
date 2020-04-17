package com.barancewicz.controllers.v1;

import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.api.v1.model.CustomersListDTO;
import com.barancewicz.api.v1.model.VendorDTO;
import com.barancewicz.api.v1.model.VendorsListDTO;
import com.barancewicz.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.barancewicz.controllers.v1.VendorController.BASE_URL;
@Api(description = "This is vendor controller")
@RestController
@RequestMapping(BASE_URL)
public class VendorController {
    public static final String BASE_URL = "/api/v1/vendors";

    private final VendorService vendorService;


    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }
    @ApiOperation(value = "This will get a list of vendors", notes = "Here are some API notes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorsListDTO getListOfVendors() {
        return vendorService.getAllVendors();
    }
    @ApiOperation(value = "This will get a single vendor by Id", notes = "Just one instance of vendor")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }
    @ApiOperation(value = "This will create a new vendor", notes = "Here are some implementation notes")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }
    @ApiOperation(value = "This will update an existing vendor", notes = "Here are some implementation notes")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }
    @ApiOperation(value = "This will update given property", notes = "Here are some implementation notes")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.patchVendor(id, vendorDTO);
    }
    @ApiOperation(value = "This will delete vendor with given id", notes = "Here are some implementation notes")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendorById(id);
    }



}
