// TODO: copyright

package com.mongodb.crypt.capi;

import com.mongodb.crypt.internal.CAPI;

public class MongoCryptImpl implements MongoCrypt {
    private final CAPI.mongocrypt_t mongoCrypt;
    /**
     * TODO: add options
     */
    public MongoCryptImpl() {
        // TODO: add options, handle errors
        CAPI.mongocrypt_opts_t opts = null;
        CAPI.mongocrypt_status_t status = null;
        try {
            opts = CAPI.mongocrypt_opts_new();
            status = CAPIHelper.createStatusPointer();
            mongoCrypt = CAPI.mongocrypt_new(opts, status);
            if (mongoCrypt == null) {
                CAPIHelper.createErrorFromStatus(status);
            }
        } finally {
            CAPI.mongocrypt_opts_destroy(opts); // TODO: is this the right pattern?
            CAPI.mongocrypt_status_destroy(status);
        }
    }

    @Override
    public void close() {
        CAPI.mongocrypt_destroy(mongoCrypt);
    }
}
