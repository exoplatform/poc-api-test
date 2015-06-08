package org.exoplatform.client.retrofit;

/**
 * Created by rosso on 6/5/15.
 */
public class HttpRestClientException extends RuntimeException {

    private final int status;

    public HttpRestClientException(int status) {
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
