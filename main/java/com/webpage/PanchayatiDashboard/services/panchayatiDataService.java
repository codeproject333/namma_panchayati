package com.webpage.PanchayatiDashboard.services;

import com.webpage.PanchayatiDashboard.models.work;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class panchayatiDataService {
    private static String PANCHAYAT_DATA_URL = "https://raw.githubusercontent.com/soumyabani123/panchayati_schemes/main/Est_Expwork%20(1).csv";

    private List<work> allwork = new ArrayList<>();

    public List<work> getAllwork() {
        return allwork;
    }

    @PostConstruct

    public void fetchVirusData() throws IOException, InterruptedException {
        List<work> newwork = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(PANCHAYAT_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records) {
            work works = new work();

            works.setWork(record.get("work"));
            works.setStatus(record.get("status"));
            works.setYear(record.get("year"));
            works.setGaram(record.get("garam"));
            works.setWork_type(record.get("work type"));
            works.setTotal(record.get("Total"));
            System.out.println(works);
            newwork.add(works);
        }
        this.allwork=newwork;

    }
}
