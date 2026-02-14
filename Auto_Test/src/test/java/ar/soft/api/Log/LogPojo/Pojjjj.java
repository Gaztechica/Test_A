package ar.soft.api.Log.LogPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pojjjj {

    public record Pojo(
           @JsonProperty("creationDate") String creationDate,
             @JsonProperty("data") String data,
             @JsonProperty("accountId") String accountId
//            @JsonProperty("accountEmail") String accountEmail,
//           @JsonProperty("id") Integer id
    ) {


    }
}
