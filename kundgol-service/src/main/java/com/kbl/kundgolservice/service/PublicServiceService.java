package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.dto.PublicServiceDto;
import com.kbl.kundgolservice.entity.Place;
import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.entity.Ward;
import com.kbl.kundgolservice.repository.PlaceRepository;
import com.kbl.kundgolservice.repository.PublicServiceRepository;
import com.kbl.kundgolservice.repository.WardRepository;
import com.kbl.kundgolservice.util.ImageUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PublicServiceService {
    @Autowired
    private PublicServiceRepository repository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private WardRepository wardRepository;
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
        Place p = placeRepository.findByPlaceCode(publicService1.getPlaceCode());
        Ward w = wardRepository.findByPlaceCodeAndWardCode(publicService1.getPlaceCode(),publicService1.getWardCode());
        //Fetch for specific ward of a person
        List<PublicService> publicServiceList1 = repository.findByPlaceCodeAndWardCodeAndServiceType(publicService1.getPlaceCode(),publicService1.getWardCode(),"G");
        //Fetch for all wards based on place of a person
        List<PublicService> publicServiceList2 = repository.findByPlaceCodeAndWardCodeAndServiceType(publicService1.getPlaceCode(),"WD-ALL","G");
        Ward w1 = wardRepository.findByPlaceCodeAndWardCode(publicService1.getPlaceCode(),"WD-ALL");

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
        return publicServiceList;
    }

    public List<PublicService> getPersonWiseData1(String name){
        List<PublicService> publicServiceList = new ArrayList<>();
        List<PublicServiceDto> publicServiceDtoList = new ArrayList<>();

        PublicService publicService1 = repository.findByPersonName(name);

        Place p = placeRepository.findByPlaceCode(publicService1.getPlaceCode());
        Ward w = wardRepository.findByPlaceCodeAndWardCode(publicService1.getPlaceCode(),publicService1.getWardCode());
        List<PublicService> publicServiceList1 = repository.findByPlaceCodeAndWardCodeAndServiceType(publicService1.getPlaceCode(),publicService1.getWardCode(),"G");

        List<PublicService> publicServiceList2 = repository.findByPlaceCodeAndWardCodeAndServiceType(publicService1.getPlaceCode(),"WD-ALL","G");
        Ward w1 = wardRepository.findByPlaceCodeAndWardCode(publicService1.getPlaceCode(),"WD-ALL");

        publicServiceList.add(publicService1);
        PublicServiceDto dto = entityToDto(publicService1,p,w);
        publicServiceDtoList.add(dto);

        publicServiceList.addAll(publicServiceList1);
        Iterator itr = publicServiceList1.listIterator();
        while(itr.hasNext()){

            dto = entityToDto((PublicService) itr.next(),p,w);
            publicServiceDtoList.add(dto);
        }

        publicServiceList.addAll(publicServiceList2);
        itr = publicServiceList2.listIterator();
        while(itr.hasNext()){
            dto = entityToDto((PublicService) itr.next(),p,w1);
            publicServiceDtoList.add(dto);
        }
        System.out.println(publicServiceDtoList);

        return publicServiceList;
    }

    private PublicServiceDto entityToDto(PublicService ps, Place p, Ward w){
        PublicServiceDto dto = new PublicServiceDto();
        dto.setServiceId(ps.getServiceId());
        dto.setCategoryCode(ps.getCategoryCode());
        /*if(null != ps.getCategoryCode())
        {
            dto.setCategoryCode(ps.getCategoryCode());
            dto.setCategoryName(c.getCategoryName());
            dto.setCategoryNameK(c.getCategoryNameK());
        }
        else{
            dto.setCategoryCode(null);
            dto.setCategoryName(null);
            dto.setCategoryNameK(null);
        }*/

        dto.setPlaceCode(ps.getPlaceCode());
        dto.setPlaceName(p.getPlaceName());
        dto.setPlaceNameK(p.getPlaceNameK());

        dto.setWardCode(ps.getWardCode());
        dto.setWardName(w.getWardName());
        dto.setWardNameK(w.getWardNameK());

        dto.setPersonName(ps.getPersonName());
        dto.setPersonNameK(ps.getPersonNameK());
        dto.setMessageTitle(ps.getMessageTitle());
        dto.setMessage(ps.getMessage());
        dto.setFileName(ps.getFileName());
        dto.setFileType(ps.getFileType());
        dto.setImageData(ps.getImageData());
        dto.setYear(ps.getYear());
        dto.setServiceType(ps.getServiceType());
        dto.setCreatedBy(ps.getCreatedBy());
        dto.setCreatedDate(ps.getCreatedDate());
        dto.setUpdatedBy(ps.getUpdatedBy());
        dto.setUpdatedDate(ps.getUpdatedDate());
        return dto;
    }
}