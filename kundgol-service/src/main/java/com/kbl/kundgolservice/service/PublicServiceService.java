package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.repository.PublicServiceRepository;
import com.kbl.kundgolservice.util.ImageUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PublicServiceService {

    @Autowired
    private PublicServiceRepository repository;
    public PublicService savePublicService(PublicService publicService){
        return repository.save(publicService);
    }
    public PublicService uploadImage(MultipartFile file,Long id) throws IOException {
        Optional<PublicService> ps = repository.findByServiceId(id);
        if(ps.isPresent()) {
            ps.get().setFileName(file.getOriginalFilename());
            ps.get().setFileType(file.getContentType());
            ps.get().setImageData(ImageUtil.compressImage(file.getBytes()));
        }
        return repository.save(ps.get());

    }

    public Optional<PublicService> fetchPublicServiceByName(String name){
        Optional<PublicService> p = Optional.ofNullable(repository.findByPersonName(name));
        if(p.isPresent())
            return p;
        else{
            p =  Optional.ofNullable(repository.findByPersonNameK(name));
            return p;
        }
    }
    public byte[] downloadImage(Long id){
        Optional<PublicService> imageData = repository.findByServiceId(id);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
    public List<PublicService> getPersonWiseData(String name){
        List<PublicService> publicServiceList = new ArrayList<>();
        PublicService publicService1 = repository.findByPersonName(name);
        List<PublicService> publicServiceList1 = repository.findByWardCodeAndServiceType(publicService1.getWardCode(),"G");
        List<PublicService> publicServiceList2 = repository.findByPlaceCodeAndWardCodeAndServiceType(publicService1.getPlaceCode(),"WD-ALL","G");
        publicServiceList.add(publicService1);
        publicServiceList.addAll(publicServiceList1);
        publicServiceList.addAll(publicServiceList2);
        return publicServiceList;
    }

    public PublicService fetchByPersonName(String name) {
        PublicService publicService = repository.findByPersonName(name);
        return publicService;
    }

        public List<PublicService> fetchByWardCodeAndServiceType(String wardCode, String serviceType) {
            List<PublicService> publicServiceList = repository.findByWardCodeAndServiceType(wardCode,serviceType);
            return publicServiceList;
        }
    public List<PublicService> fetchByPlaceCodeAndWardCodeAndServiceType(String placeCode,String wardCode, String serviceType) {
        List<PublicService> publicServiceList1 = new ArrayList<>();
        List<PublicService> publicServiceList = new ArrayList<>();
        if(!wardCode.isEmpty() || !wardCode.isBlank()){
            publicServiceList1 = repository.findByPlaceCodeAndWardCodeAndServiceType(placeCode,wardCode,serviceType);
            publicServiceList.addAll(publicServiceList1);
        }
            publicServiceList1 = repository.findByPlaceCodeAndWardCodeAndServiceType(placeCode,"WD-ALL",serviceType);
        publicServiceList.addAll(publicServiceList1);

            //List<PublicService> publicServiceList = repository.findByPlaceCodeAndWardCodeAndServiceType(placeCode,wardCode,serviceType);


        return publicServiceList;
    }

}