package com.Vamshii.BloodProject.Service;

import com.Vamshii.BloodProject.Model.RequestForBlood;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RequestForBloodConverter implements AttributeConverter<RequestForBlood, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(RequestForBlood attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting RequestForBlood to String", e);
        }
    }

    @Override
    public RequestForBlood convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, RequestForBlood.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting String to RequestForBlood", e);
        }
    }
}
