package ar.com.plug.examen.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    private ResponseHelper(){
        throw new UnsupportedOperationException("Not allowed to instantiate MessageResponse.");
    }

    public static ResponseEntity<?> getHttpStatusResponse(int result) {
        if (result == 1)
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

