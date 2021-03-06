package com.barancewicz.api.v1.mapper;


import com.barancewicz.api.v1.model.VendorDTO;
import com.barancewicz.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor customer);

    Vendor vendorDTOToVendor(VendorDTO customer);

}
