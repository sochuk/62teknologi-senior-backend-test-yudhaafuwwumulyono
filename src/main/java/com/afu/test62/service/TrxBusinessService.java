package com.afu.test62.service;

import com.afu.test62.dto.BusinessDTO;

import java.util.List;

public interface TrxBusinessService {
    BusinessDTO getTrxBusiness(String location, Double latitude, Double longitude, String term, Integer radius,
                                     String[] categories, String locale, Integer[] price, Boolean openNow, Integer openAt, String[] attributes,
                                     String sortBy, String devicePlatform, String reservationDate, String reservasionTime, Integer reservasionCovers,
                                     Boolean matchesPartySizeParam, Integer limit, Integer offset);
}
