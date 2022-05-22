package com.forflow.springinterview.dto.wftgeodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GeoDBError implements Serializable {

    private static final long serialVersionUID = 5517194164842618018L;

    private String code;
    private String message;

    @Override
    public String toString() {
        return "GeoDBError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
