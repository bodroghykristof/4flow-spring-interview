package com.forflow.springinterview.model.dto.wftgeodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GeoDBErrorResponse implements Serializable {

    private static final long serialVersionUID = 7365410002782830754L;

    private List<GeoDBError> errors;

    @Override
    public String toString() {
        return "GeoDBErrorResponse{" +
                "errors=" + errors +
                '}';
    }

}
