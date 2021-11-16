package uz.pdp.datarestpcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.datarestpcmarket.entity.Property;
import uz.pdp.datarestpcmarket.payload.ApiResponse;
import uz.pdp.datarestpcmarket.payload.ReferenceDto;
import uz.pdp.datarestpcmarket.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyController {
    @Autowired
    PropertyService referenceService;
    @GetMapping("/property")
    public ResponseEntity<List<Property>> getReference(){
        List<Property> propertyList = referenceService.getProperty();
        return ResponseEntity.ok(propertyList);
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<Property> getReferenceById(@PathVariable Integer id){
        Property propertyById = referenceService.getPropertyById(id);
        return ResponseEntity.ok(propertyById);
    }

    @PostMapping("/property")
    public ResponseEntity<ApiResponse> addProperty(@RequestBody ReferenceDto referenceDto){
        ApiResponse apiResponse = referenceService.addProperty(referenceDto);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/property/{id}")
    public ResponseEntity<ApiResponse> editProperty(@PathVariable Integer id,@RequestBody ReferenceDto referenceDto){
        ApiResponse apiResponse = referenceService.editProperty(referenceDto, id);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<ApiResponse> deleteProperty(@PathVariable Integer id){
        ApiResponse apiResponse = referenceService.deleteProperty(id);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(apiResponse);
    }
}
