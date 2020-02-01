package com.hase.huatuo.healthcheck.service;

import com.hase.huatuo.healthcheck.model.HealthInfo;
import com.hase.huatuo.healthcheck.model.response.AreaReport;
import com.hase.huatuo.healthcheck.model.response.BuildingReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HealthReportService {

    public static final String IS_DUMMY = "true";

    public static final String FEVER = "4";

    public static final String SUSPECT = "2";

    public static final String CONFIRMED = "1";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String HEALTH_STATISTIC_SQL = "SELECT  city, workplace,health_status, SUM(1) AS total FROM health_info h WHERE h.health_status IN('1', '2', '4') group BY h.city, h.workplace,h.health_status";

    public ResponseEntity<List<AreaReport>> enquiry(final String isDummy){
        List<AreaReport> areaReportResponses = new ArrayList<>();
        if(IS_DUMMY.equalsIgnoreCase(isDummy)){
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
            RowMapper<HealthInfo> healthInfoRowMapper = BeanPropertyRowMapper.newInstance(HealthInfo.class);
            List<HealthInfo> healthInfos = jdbcTemplate.query(HEALTH_STATISTIC_SQL, healthInfoRowMapper, null);
            Iterator<Map.Entry<String, List<HealthInfo>>> entryIterator = healthInfos.stream().collect(Collectors.groupingBy(h -> h.getCity())).entrySet().iterator();
            while (entryIterator.hasNext()){
                Map.Entry<String, List<HealthInfo>> entry = entryIterator.next();
                AreaReport areaReport = new AreaReport();
                areaReport.setArea(entry.getKey());
                areaReport.setBuildingReports(transformHealthListToBuildingList(entry.getValue()));
                areaReportResponses.add(areaReport);
            }
        }
        return ResponseEntity.ok(areaReportResponses);
    }

    public List<BuildingReport> transformHealthListToBuildingList(final List<HealthInfo> healthInfos){
        List<BuildingReport> buildingReports = new ArrayList<>();
        Iterator<Map.Entry<String, List<HealthInfo>>> entryIterator = healthInfos.stream().collect(Collectors.groupingBy(h -> h.getCity()+"_" + h.getWorkplace())).entrySet().iterator();
        while (entryIterator.hasNext()){
            BuildingReport br = new BuildingReport();
            br.setConfirmed("0");
            br.setFever("0");
            br.setSuspect("0");
            entryIterator.next().getValue().forEach(h -> {
                br.setBuildingName(h.getWorkplace());
                if(FEVER.equalsIgnoreCase(h.getHealthStatus())){
                    br.setFever(h.getTotal());
                }
                if(SUSPECT.equalsIgnoreCase(h.getHealthStatus())){
                    br.setSuspect(h.getTotal());
                }
                if(CONFIRMED.equalsIgnoreCase(h.getHealthStatus())){
                    br.setConfirmed(h.getTotal());
                }
            });
            buildingReports.add(br);
        }
        return buildingReports;
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
