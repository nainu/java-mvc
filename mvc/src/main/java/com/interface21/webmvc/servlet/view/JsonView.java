package com.interface21.webmvc.servlet.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interface21.web.http.MediaType;
import com.interface21.webmvc.servlet.View;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class JsonView implements View {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void render(final Map<String, ?> model,
                       final HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        response.addHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);

        objectMapper.writeValue(response.getOutputStream(), getSource(model));
    }

    private Object getSource(Map<String, ?> model) {
        if (model.size() == 1) {
            return model.values()
                        .stream()
                        .findFirst()
                        .get();
        }
        return model;
    }
}
