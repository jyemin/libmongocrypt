// TODO: copyright

package com.mongodb.crypt.internal;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

//CHECKSTYLE:OFF
public class CAPI {

    public static class cstring extends PointerType {
        public cstring() {
            super();
        }

        public cstring(Pointer address) {
            super(address);
        }

        public cstring(String string) {
            Pointer m = new Memory(string.length() + 1);
            m.setString(0, string);
            setPointer(m);
        }

        public String toString() {
            return getPointer().getString(0);
        }
    }


    public static class mongocrypt_status_t extends PointerType {
        public mongocrypt_status_t() {
            super();
        }

        public mongocrypt_status_t(Pointer address) {
            super(address);
        }
    }


    public static class mongocrypt_opts_t extends PointerType {
        public mongocrypt_opts_t() {
            super();
        }

        public mongocrypt_opts_t(Pointer address) {
            super(address);
        }
    }


    public static class mongocrypt_opt_t extends PointerType {
        public mongocrypt_opt_t() {
            super();
        }

        public mongocrypt_opt_t(Pointer address) {
            super(address);
        }
    }


    public static class mongocrypt_binary_t extends PointerType {
        public mongocrypt_binary_t() {
            super();
        }

        public mongocrypt_binary_t(Pointer address) {
            super(address);
        }
    }


    public static class mongocrypt_t extends PointerType {
        public mongocrypt_t() {
            super();
        }

        public mongocrypt_t(Pointer address) {
            super(address);
        }
    }


    public static class mongocrypt_request_t extends PointerType {
        public mongocrypt_request_t() {
            super();
        }

        public mongocrypt_request_t(Pointer address) {
            super(address);
        }
    }


    public static class mongocrypt_key_query_t extends PointerType {
        public mongocrypt_key_query_t() {
            super();
        }

        public mongocrypt_key_query_t(Pointer address) {
            super(address);
        }
    }


    /*
        const char *
        mongocrypt_version (void)
     */
    public static native void
    mongocrypt_version();


    /*
        void
        mongocrypt_init (void);
     */
    public static native void
    mongocrypt_init();


    /*
        void
        mongocrypt_cleanup (void);
     */
    public static native void
    mongocrypt_cleanup();


    /*
        mongocrypt_opts_t *
        mongocrypt_opts_new (void);
     */
    public static native mongocrypt_opts_t
    mongocrypt_opts_new();


    /*
        void
        mongocrypt_opts_destroy (mongocrypt_opts_t *opts);
     */
    public static native void
    mongocrypt_opts_destroy(mongocrypt_opts_t opts);


    /*
     TODO: This may be problematic.  Perhaps a separate function for each value type

        void
        mongocrypt_opts_set_opt (mongocrypt_opts_t *opts,
                                 mongocrypt_opt_t opt,
                                 void *value);
     */
    public static native void
    mongocrypt_opts_set_opt(mongocrypt_opts_t opts,
                            mongocrypt_opt_t opt,
                            Pointer value);


    /*
        mongocrypt_t *
        mongocrypt_new (mongocrypt_opts_t *opts,
                        mongocrypt_status_t *status);
     */
    public static native mongocrypt_t
    mongocrypt_new(mongocrypt_opts_t opts,
                   mongocrypt_status_t status);


    /*
        void
        mongocrypt_destroy (mongocrypt_t *crypt);
     */
    public static native void
    mongocrypt_destroy(mongocrypt_t crypt);


    /*
        mongocrypt_status_t *
        mongocrypt_status_new (void)
     */
    public static native mongocrypt_status_t
    mongocrypt_status_new();


    /*
        void
        mongocrypt_status_destroy (mongocrypt_status_t *status)
     */
    public static native void
    mongocrypt_status_destroy(mongocrypt_status_t status);


    /*
        const char *
        mongocrypt_status_message (mongocrypt_status_t *status)
     */
    public static native cstring
    mongocrypt_status_message(mongocrypt_status_t status);


    /*
        uint32_t
        mongocrypt_status_code (mongocrypt_status_t *status)
     */
    public static native long
    mongocrypt_status_code(mongocrypt_status_t status);


    /*
        const mongocrypt_binary_t *
        mongocrypt_key_query_filter (const mongocrypt_key_query_t *key_query);
    */
    public static native mongocrypt_binary_t
    mongocrypt_key_query_filter(mongocrypt_key_query_t key_query);


    /*
        const char *
        mongocrypt_key_query_keyvault_name (const mongocrypt_key_query_t *key_query);
     */
    public static native cstring
    mongocrypt_key_query_keyvault_name(mongocrypt_key_query_t key_query);


    /*
        bool
        mongocrypt_request_needs_keys (mongocrypt_request_t *request);
     */
    public static native boolean
    mongocrypt_request_needs_keys(mongocrypt_request_t request);

    
    /*
        const mongocrypt_key_query_t *
        mongocrypt_request_next_key_query (mongocrypt_request_t *request,
                                           mongocrypt_opts_t *opts);
     */
    public static native mongocrypt_key_query_t
    mongocrypt_request_next_key_query(mongocrypt_request_t request,
                                      mongocrypt_opts_t opts);


    /*
        bool
        mongocrypt_request_add_keys (mongocrypt_request_t *request,
                                     const mongocrypt_opts_t *opts,
                                     const mongocrypt_binary_t *responses,
                                     uint32_t num_responses,
                                     mongocrypt_status_t *status);
     */
    public static native boolean
    mongocrypt_request_add_keys(mongocrypt_request_t request,
                                mongocrypt_opts_t opts,
                                mongocrypt_binary_t responses,
                                long num_responses,
                                mongocrypt_status_t status);

    
    /*
        void
        mongocrypt_request_destroy (mongocrypt_request_t *request);
     */
    public static native void
    mongocrypt_request_destroy(mongocrypt_request_t request);
    

    /*
        mongocrypt_request_t *
        mongocrypt_encrypt_start( mongocrypt_t *crypt,
                                  const mongocrypt_opts_t *opts,
                                  const mongocrypt_binary_t *schema,
                                  const mongocrypt_binary_t *cmd,
                                  mongocrypt_status_t *status)
    */
    public static native mongocrypt_request_t
    mongocrypt_encrypt_start(mongocrypt_t crypt,
                             mongocrypt_opts_t opts,
                             mongocrypt_binary_t schema,
                             mongocrypt_binary_t cmd,
                             mongocrypt_status_t status);


    /*
       bool
       mongocrypt_encrypt_finish (mongocrypt_request_t *request,
                                  const mongocrypt_opts_t *opts,
                                  mongocrypt_binary_t *encrypted_cmd,
                                  mongocrypt_status_t *status)
    */
    public static native boolean
    mongocrypt_encrypt_finish(mongocrypt_request_t request,
                              mongocrypt_opts_t opts,
                              mongocrypt_binary_t encrypted_cmd,
                              mongocrypt_status_t status);


    /*
       mongocrypt_request_t *
       mongocrypt_decrypt_start (mongocrypt_t *crypt,
                                 const mongocrypt_opts_t *opts,
                                 const mongocrypt_binary_t *encrypted_docs,
                                 uint32_t num_docs,
                                 mongocrypt_status_t *status)
    */
    public static native mongocrypt_request_t
    mongocrypt_decrypt_start(mongocrypt_t crypt,
                             mongocrypt_opts_t opts,
                             mongocrypt_binary_t encrypted_docs,
                             long num_docs,
                             mongocrypt_status_t status);


    /*
       bool
       mongocrypt_decrypt_finish (mongocrypt_request_t *request,
                                  const mongocrypt_opts_t *opts,
                                  mongocrypt_binary_t **docs,
                                  mongocrypt_status_t *status)
     */
    public static native boolean
    mongocrypt_decrypt_finish(mongocrypt_request_t request,
                              mongocrypt_opts_t opts,
                              mongocrypt_binary_t docs,   // TODO: pointer to pointer
                              mongocrypt_status_t status);


    // TODO: don't use stub
    private static final String NATIVE_LIBRARY_NAME = "mongocrypt-stub";

    static {
        // TODO: move this where we have the library path
        NativeLibrary.addSearchPath(NATIVE_LIBRARY_NAME, "/Users/jeff/libmongocrypt/cmake-build");
        Native.register(CAPI.class, NATIVE_LIBRARY_NAME);
    }

}
