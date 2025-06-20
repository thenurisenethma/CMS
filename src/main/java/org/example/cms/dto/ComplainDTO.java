package org.example.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ComplainDTO {
    private int id;
    private String complain;
    private String status;


    public ComplainDTO(String complain) {
        this.complain = complain;
    }

    public ComplainDTO(int id, String complain) {
        this.id = id;
        this.complain = complain;
    }
}
