package ar.com.plug.examen.utils;

import org.springframework.http.ResponseEntity;

public class MessageResponse {
		
		String messsage;

	    public MessageResponse(String messsage) {
	        this.messsage = messsage;
	    }

	    public String getMesssage() {
	        return messsage;
	    }

	    public void setMesssage(String messsage) {
	        this.messsage = messsage;
	    }
	    
	    public static ResponseEntity<?> getIntegerResponseEntity(int result) {
	        if (result == 1) {
            return ResponseEntity.ok().body(new MessageResponse("Proceso correcto"));
        }
        return ResponseEntity.badRequest().build();
    }

}

