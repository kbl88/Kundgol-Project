package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.dto.*;
import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.ServiceView;
import com.kbl.kundgolservice.repository.PersonRepository;
import com.kbl.kundgolservice.repository.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ReportRepository reportRepository;


    public ResponseDto fetchReportByName(String name){
        Optional<Person> person = Optional.ofNullable(personRepository.findByPersonName(name));
        List<ServiceView> service= new ArrayList<>();
        if (person.isPresent()){
            service = reportRepository.findByPersonIdAndPlace(person.get().getPersonId(),person.get().getPlaceCode(), person.get().getWardCode());
        }
        if (service.size()>1) {
            logger.info("Size: {}", service.size());
            return buildResoponse(service);
        }
        return new ResponseDto();
    }

    public ResponseDto fetchGeneralReport(String placeCode, String wardCode){
        List<ServiceView> service= new ArrayList<>();
        if (wardCode.equals("WD-ALL")){
            service = reportRepository.findByPlace(placeCode);
        } else {
            service = reportRepository.findByWard(placeCode,wardCode);
        }
        if (service.size()>1) {
            logger.info("Size: {}", service.size());
            return buildResoponse(service);
        }
        return new ResponseDto();
    }

    public ResponseDto buildResoponse(List<ServiceView> serviceViewList){
        ResponseDto responseDto = new ResponseDto();
        List<ServiceView> personServiceList = serviceViewList.stream()
                .filter(s -> s.getPersonId() != null).collect(Collectors.toList());
        if(personServiceList.size()>0){
            PersonDto personDto = buildPersonDto(personServiceList);
            responseDto.setPersonDto(personDto);
        }
        List<ServiceView> wardServiceList = serviceViewList.stream()
                .filter(s-> s.getWardCode() != null && !s.getWardCode().equals("WD-ALL") && s.getPersonId()==null)
                .collect(Collectors.toList());
        if(wardServiceList.size()>0){
            WardDto wardDto = buildWardDto(wardServiceList);
            responseDto.setWardDtoList(wardDto);
        }

        List<ServiceView> placeServiceList = serviceViewList.stream()
                .filter(s->s.getWardCode() != null && s.getWardCode().equals("WD-ALL") )
                .collect(Collectors.toList());
        if(placeServiceList.size()>0){
            PlaceDto placeDto = buildPlaceDto(placeServiceList);
            responseDto.setPlaceDtoList(placeDto);
        }

        List<ServiceView> talukServiceList = serviceViewList.stream()
                .filter(s->s.getPlaceCode().equals("PL-ALL") )
                .collect(Collectors.toList());
        if(placeServiceList.size()>0){
            TalukDto talukDto = buildTalukDto(talukServiceList);
            responseDto.setTalukDtoList(talukDto);
        }


        return responseDto;

    }
    public PersonDto buildPersonDto(List<ServiceView> personServiceList){
        PersonDto person= new PersonDto();
        ServiceView personService = personServiceList.get(0);
        person.setPersonId(personService.getPersonId());
        person.setPersonName(personService.getPersonName());
        person.setPersonNameK(personService.getPersonNamek());
        person.setAadhaarNo(personService.getAadhaarNo());
        person.setContactNo(personService.getContactNo());
        person.setAddress(personService.getAddress());
        List<ServiceDto> serviceList = buildServiceDto(personServiceList);
        person.setServiceDtoList(serviceList);
        return person;
    }
    public WardDto buildWardDto(List<ServiceView> wardServiceList){
        WardDto wardDto =  new WardDto();
        ServiceView serviceView = wardServiceList.get(0);
        wardDto.setWardCode(serviceView.getWardCode());
        wardDto.setWardName(serviceView.getWardName());
        wardDto.setWardNameK(serviceView.getWardNamek());
        List<ServiceDto> serviceList = buildServiceDto(wardServiceList);
        wardDto.setServiceDtoList(serviceList);
        return wardDto;
    }

    public PlaceDto buildPlaceDto(List<ServiceView> placeServiceList){
        PlaceDto placeDto = new PlaceDto();
        ServiceView serviceView = placeServiceList.get(0);
        placeDto.setPlaceCode(serviceView.getPlaceCode());
        placeDto.setPlaceName(serviceView.getPlaceName());
        placeDto.setPlaceNameK(serviceView.getPlaceNamek());
        List<CategoryDto> categoryDtoList = buildCategoryDto(placeServiceList);
        placeDto.setCategoryDtoList(categoryDtoList);
        return placeDto;
    }
    public TalukDto buildTalukDto(List<ServiceView> talukServiceList){
        TalukDto talukDto = new TalukDto();
        talukDto.setName("ತಾಲೂಕಿನ ಅಭಿವೃದ್ಧಿ:");
        List<CategoryDto> categoryDtoList = buildCategoryDto(talukServiceList);
        talukDto.setCategoryDtoList(categoryDtoList);
        return talukDto;
    }

    public List<CategoryDto> buildCategoryDto(List<ServiceView> serviceViewList){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        Map<String, List<ServiceView>> categoryMap = serviceViewList.stream().collect(Collectors.groupingBy(ServiceView::getCategoryCode));
        AtomicInteger counter = new AtomicInteger(1);
        categoryMap.forEach((k,v)->{
            ServiceView serviceViewCat = v.get(0);
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(counter.getAndIncrement());
            categoryDto.setCategoryName(serviceViewCat.getCategoryName());
            categoryDto.setCategoryNameK(serviceViewCat.getCategoryNamek());
            List<ServiceDto> serviceDtoList = buildServiceDto(v);
            categoryDto.setServiceDtoList(serviceDtoList);
            categoryDtoList.add(categoryDto);
        });

        return categoryDtoList;

    }
    public List<ServiceDto> buildServiceDto(List<ServiceView> serviceViewList){

        List<ServiceDto> serviceList = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(1);
        serviceViewList.forEach(serviceView ->
                        serviceList.add(new ServiceDto(counter.getAndIncrement(),
                                serviceView.getMessageTitle(),serviceView.getMessage())));

        return serviceList;
    }

}
