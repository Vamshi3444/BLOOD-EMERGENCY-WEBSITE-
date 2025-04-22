package com.Vamshii.BloodProject.Service;

import com.Vamshii.BloodProject.Model.PersonInfo;
import com.Vamshii.BloodProject.Model.RequestForBlood;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply = true)
public class PersonInfoConverter implements AttributeConverter<PersonInfo, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(PersonInfo attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting RequestForBlood to String", e);
        }
    }

    @Override
    public PersonInfo convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, PersonInfo.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting String to RequestForBlood", e);
        }
    }
}
