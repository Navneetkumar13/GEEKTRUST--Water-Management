package com.geektrust.backend.exceptions;

public class WaterBillException extends RuntimeException {

    public static final String INVALID_COMMAND = "INVALID_COMMAND";
    private static final long serialVersionUID = -195628261663783819L;

    public WaterBillException() {
        super();
      }

      public WaterBillException(String message) {
        super(message);
      }
}
