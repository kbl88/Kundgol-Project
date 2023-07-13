/*
package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.PublicService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PublicServiceService {
    public PublicService uploadImage(MultipartFile file) throws IOException {
        PublicService pImage = new PublicService();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        return imageRepo.save(pImage);
    }

    public byte[] downloadImage(String fileName){
        Optional<PublicService> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
}
*/
