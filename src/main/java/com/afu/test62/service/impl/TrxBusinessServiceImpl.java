package com.afu.test62.service.impl;

import com.afu.test62.dto.BusinessDTO;
import com.afu.test62.model.Business;
import com.afu.test62.model.Category;
import com.afu.test62.model.TrxBusiness;
import com.afu.test62.repository.BusinessRepo;
import com.afu.test62.repository.CategoryRepo;
import com.afu.test62.repository.TrxBusinessRepo;
import com.afu.test62.service.TrxBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrxBusinessServiceImpl implements TrxBusinessService {

    @Autowired
    private TrxBusinessRepo trxBusinessRepo;

    @Autowired
    private BusinessRepo businessRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public BusinessDTO getTrxBusiness(String location, Double latitude, Double longitude, String term, Integer radius, String[] categories, String locale, Integer[] price, Boolean openNow, Integer openAt, String[] attributes, String sortBy, String devicePlatform, String reservationDate, String reservasionTime, Integer reservasionCovers, Boolean matchesPartySizeParam, Integer limit, Integer offset) {
        BusinessDTO businessDTO = new BusinessDTO();
        List<Map<String, Object>> listBusiness = new ArrayList<Map<String, Object>>();
        Map<String, Object> mapBusiness = new HashMap<String, Object>();
        List<TrxBusiness> trxBusinessesList = trxBusinessRepo.findAll();
        if(trxBusinessesList.size() > 0){
            for (TrxBusiness trxBusiness : trxBusinessesList) {
                Optional<List<Business>> optBusinessList = businessRepo.findByTrxBusinessId(trxBusiness.getId());
                if(optBusinessList.isPresent()){
                    for(Business business : optBusinessList.get()){
                        mapBusiness.put("alias", business.getAlias());
                        mapBusiness.put("categories", categoryRepo.findByBusinessId(business.getId()).get());
                        mapBusiness.put("coordinates", business.getCoordinates());
                        mapBusiness.put("display_phone", business.getDisplayPhone());
                        mapBusiness.put("distance", business.getDistance());
                        mapBusiness.put("id", business.getId());
                        mapBusiness.put("image_url", business.getImageUrl());
                        mapBusiness.put("is_closed", business.getIsClosed());
                        mapBusiness.put("location", business.getLocation());
                        mapBusiness.put("name", business.getName());
                        mapBusiness.put("phone", business.getPhone());
                        mapBusiness.put("price", business.getPrice());
                        mapBusiness.put("rating", business.getRating());
                        mapBusiness.put("review_count", business.getReviewCount());
                        mapBusiness.put("transactions", business.getTransactions());
                        mapBusiness.put("url", business.getUrl());
                    }
                    listBusiness.add(mapBusiness);
                    businessDTO.setBusinesses(listBusiness);
                    businessDTO.setRegion(trxBusiness.getRegion());
                    businessDTO.setTotal(trxBusiness.getTotal());
                }
            }
        }
        return businessDTO;
    }
}
