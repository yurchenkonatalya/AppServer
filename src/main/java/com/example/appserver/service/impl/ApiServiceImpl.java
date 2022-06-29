package com.example.appserver.service.impl;

import com.example.appserver.dto.ValidDto;
import com.example.appserver.service.ApiService;
import com.example.appserver.util.JsonParser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {
    @Value("http://localhost:8100/api/users/auth/checkToken")
    private String apiUri;

    private OkHttpClient client;

    @PostConstruct
    public void init() {
        client = new OkHttpClient();
    }

    @Override
    public ValidDto checkAccessToken(String token) {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(apiUri).newBuilder();

        urlBuilder.addQueryParameter("token", token);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        log.info(request.toString());
        Call call = client.newCall(request);
        log.error("yyyyyyyy");
        try {
            log.error("qqqqqqq");
            Response response = call.execute();
            return JsonParser.simpleParser(Objects.requireNonNull(response.body()).string(), ValidDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
