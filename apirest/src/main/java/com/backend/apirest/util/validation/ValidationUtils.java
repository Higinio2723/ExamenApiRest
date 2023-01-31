package com.backend.apirest.util.validation;

import java.sql.Timestamp;

public class ValidationUtils {

    private ValidationUtils(){

    }

    public static Long timestamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

}
