package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.Place;
import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.entity.Ward;
import com.kbl.kundgolservice.repository.PersonRepository;
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
    @Autowired
    private PersonRepository personRepository;
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

    public byte[] downloadImage(Long id){
        Optional<PublicService> imageData = repository.findByServiceId(id);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }

    public List<PublicService> fetchAllService(){
        return repository.findAll();
    }


}