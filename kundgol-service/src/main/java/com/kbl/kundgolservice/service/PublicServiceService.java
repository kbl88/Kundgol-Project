package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.ProductImage;
import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.repository.PublicServiceRepository;
import com.kbl.kundgolservice.util.ImageUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

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

    /*public PublicService fetchPublicServiceByName(String personName){
        return repository.findByPersonName(personName);
    }*/

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
}