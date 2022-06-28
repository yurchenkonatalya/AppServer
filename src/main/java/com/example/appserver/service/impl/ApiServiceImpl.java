package com.example.appserver.service.impl;

import com.example.appserver.dto.JwtResponse;
import com.example.appserver.service.ApiService;
import com.example.appserver.util.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Objects;

@Service
public class ApiServiceImpl implements ApiService {
    @Value("http://localhost:8100/api/users/auth/isTokenValid")
    private String apiUri;

    private OkHttpClient client;

    @PostConstruct
    public void init(){
        client = new OkHttpClient();
    }

    @Override
    public JwtResponse checkAccessToken(String token) {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(apiUri).newBuilder();

        urlBuilder.addQueryParameter("token", token);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return JsonParser.simpleParser(Objects.requireNonNull(response.body()).string(), JwtResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
