package com.afu.test62.controller;

import com.afu.test62.dto.BusinessDTO;
import com.afu.test62.model.TrxBusiness;
import com.afu.test62.repository.TrxBusinessRepo;
import com.afu.test62.service.TrxBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v3/business")
public class TrxBusinessController {

    @Autowired
    private TrxBusinessService trxBusinessService;
    @Autowired
    private TrxBusinessRepo trxBusinessRepo;

    @GetMapping("/search")
    public ResponseEntity<?> getBusiness(@RequestParam(value = "location", required = false) String location,
                                         @RequestParam(value = "latitude", required = false) Double latitude,
                                         @RequestParam(value = "longitude", required = false) Double longitude,
                                         @RequestParam(value = "term", required = false) String term,
                                         @RequestParam(value = "radius", required = false) Integer radius,
                                         @RequestParam(value = "categories", required = false) String[] categories,
                                         @RequestParam(value = "locale", required = false)  String locale,
                                         @RequestParam(value = "proce", required = false) Integer[] price,
                                         @RequestParam(value = "open_now", required = false) Boolean openNow,
                                         @RequestParam(value = "open_at", required = false) Integer openAt,
                                         @RequestParam(value = "attributes", required = false) String[] attributes,
                                         @RequestParam(value = "sort_by", required = false) String sortBy,
                                         @RequestParam(value = "device_platform", required = false) String devicePlatform,
                                         @RequestParam(value = "reservation_date", required = false) String reservationDate,
                                         @RequestParam(value = "reservation_time", required = false) String reservasionTime,
                                         @RequestParam(value = "reservation_covers", required = false)  Integer reservasionCovers,
                                         @RequestParam(value = "matches_party_size_param", required = false) Boolean matchesPartySizeParam,
                                         @RequestParam(value = "limit", required = false) Integer limit,
                                         @RequestParam(value = "offset", required = false)  Integer offset) {

        BusinessDTO response = trxBusinessService.getTrxBusiness(location, latitude, longitude, term, radius, categories, locale, price, openNow,
                openAt, attributes, sortBy, devicePlatform, reservationDate, reservasionTime, reservasionCovers, matchesPartySizeParam,limit,
                offset);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteBusiness(@RequestParam(value = "id_trx_business", required = false) Integer idTrxBusiness) {


        Optional<TrxBusiness> trxBusinessOpt = trxBusinessRepo.findById(idTrxBusiness);
        if(trxBusinessOpt.isPresent()) {
            trxBusinessOpt.get().setDeletedBy(1);
            trxBusinessRepo.softDelete(trxBusinessOpt.get());
        }

        return ResponseEntity.ok("Delete Success");
    }
}
