// TODO: copyright

package com.mongodb.crypt.capi;

import com.mongodb.crypt.internal.CAPI;
import com.mongodb.crypt.internal.CAPI.mongocrypt_status_t;

import static java.lang.String.format;

final class CAPIHelper {

    static mongocrypt_status_t createStatusPointer() {
        try {
            return CAPI.mongocrypt_status_new();
        } catch (Throwable t) {
            throw createError("status_create", t);
        }
    }

    static MongoCryptCAPIException createError(final String methodName, final Throwable t) {
        if (t instanceof MongoCryptCAPIException) {
            return (MongoCryptCAPIException) t;
        }
        return new MongoCryptCAPIException(format("Error from embedded server when calling '%s': %s", methodName, t.getMessage()), t);
    }

    static void createErrorFromStatus(final mongocrypt_status_t statusPointer) {
        createErrorFromStatus(statusPointer, CAPI.mongocrypt_status_code(statusPointer));
    }

    static MongoCryptCAPIException createErrorFromStatus(final mongocrypt_status_t statusPointer, final long errorCode) {
        throw new MongoCryptCAPIException((int) errorCode,  // TODO: unsafe cast
                CAPI.mongocrypt_status_message(statusPointer).toString(),
                null);
    }

    static void destroyStatusPointer(final mongocrypt_status_t statusPointer) {
        try {
            CAPI.mongocrypt_status_destroy(statusPointer);
        } catch (Throwable t) {
            throw createError("status_destroy", t);
        }
    }

    static void validateErrorCode(final mongocrypt_status_t statusPointer, final int errorCode) {
        if (errorCode != 0) {
            throw createErrorFromStatus(statusPointer, errorCode);
        }
    }

    private CAPIHelper() {
    }
}
