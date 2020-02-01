package com.hase.huatuo.healthcheck.service;

import com.hase.huatuo.healthcheck.model.response.AreaReport;
import com.hase.huatuo.healthcheck.model.response.BuildingReport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthReportService {

    public static final String isDummy = "true";

    public ResponseEntity<List<AreaReport>> enquiry(final String isDummy){
        List<AreaReport> areaReportResponses = new ArrayList<>();
        if(isDummy.equalsIgnoreCase(isDummy)){
            AreaReport areaReportResponse = new AreaReport();
            areaReportResponse.setArea("GZ");
            List<BuildingReport> buildingReportResponses = new ArrayList<>();
            buildingReportResponses.add(generateBuildingReport("tko","10", "20", "30"));
            buildingReportResponses.add(generateBuildingReport("tko1","11", "21", "32"));
            areaReportResponse.setBuildingReports(buildingReportResponses);
            areaReportResponses.add(areaReportResponse);
            AreaReport areaReportResponseXA = new AreaReport();
            areaReportResponseXA.setArea("XA");
            List<BuildingReport> buildingReportResponsesXA = new ArrayList<>();
            buildingReportResponsesXA.add(generateBuildingReport("F3","10", "20", "30"));
            buildingReportResponsesXA.add(generateBuildingReport("F4","11", "21", "32"));
            areaReportResponseXA.setBuildingReports(buildingReportResponsesXA);
            areaReportResponses.add(areaReportResponseXA);

        } else {

        }
        return ResponseEntity.ok(areaReportResponses);
    }


    public static BuildingReport generateBuildingReport(String buildingName, String confirmed, String fever, String suspect){
        BuildingReport buildingReportResponse = new BuildingReport();
        buildingReportResponse.setBuildingName(buildingName);
        buildingReportResponse.setConfirmed(confirmed);
        buildingReportResponse.setFever(fever);
        buildingReportResponse.setSuspect(suspect);
        return buildingReportResponse;
    }
}
