// TODO: copyright

package com.mongodb.crypt.capi;


import static java.lang.String.format;

/**
 * Top level Exception for all Mongo Crypt CAPI exceptions
 */
public class MongoCryptCAPIException extends RuntimeException {
    private static final long serialVersionUID = -5524416583514807953L;
    private final int code;

    /**
     * @param msg   the message
     * @param cause the cause
     */
    public MongoCryptCAPIException(final String msg, final Throwable cause) {
        super(msg, cause);
        this.code = -1;
    }

    /**
     * @param code the error code
     * @param msg  the message
     * @param cause the cause
     */
    public MongoCryptCAPIException(final int code, final String msg, final Throwable cause) {
        super(msg, cause);
        this.code = code;
    }
    
    /**
     * Constructs a new instance
     *
     * @param errorCode the error code
     * @param subErrorCode the sub category error code
     * @param reason the reason for the exception
     * @param cause the cause
     */
    public MongoCryptCAPIException(final int errorCode, final int subErrorCode, final String reason, final Throwable cause) {
        this(errorCode, format("%s (%s:%s)", reason, errorCode, subErrorCode), cause);
    }

    /**
     * @return the error code for the exception.
     */
    public int getCode() {
        return code;
    }
}
