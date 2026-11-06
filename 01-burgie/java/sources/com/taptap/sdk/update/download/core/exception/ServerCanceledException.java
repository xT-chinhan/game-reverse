package com.taptap.sdk.update.download.core.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ServerCanceledException extends IOException {
    private final int responseCode;

    public ServerCanceledException(int responseCode, long currentOffset) {
        super("Response code can't handled on internal " + responseCode + " with current offset " + currentOffset);
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}
