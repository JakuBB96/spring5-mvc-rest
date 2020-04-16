package com.barancewicz.services;

import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.api.v1.model.VendorDTO;
import com.barancewicz.api.v1.model.VendorsListDTO;

import java.util.List;

public interface VendorService {

    VendorsListDTO getAllVendors();
    VendorDTO getVendorById(Long id);
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);
    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);
    void deleteVendorById(Long id);

}
