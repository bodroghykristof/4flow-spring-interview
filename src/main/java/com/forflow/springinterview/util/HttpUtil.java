package com.forflow.springinterview.util;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class HttpUtil {

    private static final String QUERY_PARAMETER_LIST_OPEN_CHAR = "?";
    private static final String QUERY_PARAMETER_LIST_SEPARATOR_CHAR = "=";

    public static String addQueryParameters(String url, Map<String, String> parameters) {
        if (url == null || parameters.isEmpty()) return url;
        boolean questionMarkAdded = false;
        StringBuilder urlBuilder = new StringBuilder(url);
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            if (!questionMarkAdded) {
                urlBuilder.append(QUERY_PARAMETER_LIST_OPEN_CHAR);
                questionMarkAdded = true;
            }
            urlBuilder.append(entry.getKey()).append(QUERY_PARAMETER_LIST_SEPARATOR_CHAR).append(entry.getValue());
        }
        return urlBuilder.toString();
    }

}
