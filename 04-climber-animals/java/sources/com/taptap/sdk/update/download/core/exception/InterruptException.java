package com.taptap.sdk.update.download.core.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class InterruptException extends IOException {
    public static final InterruptException SIGNAL = new InterruptException() { // from class: com.taptap.sdk.update.download.core.exception.InterruptException.1
        @Override // java.lang.Throwable
        public void printStackTrace() {
            throw new IllegalAccessError("Stack is ignored for signal");
        }
    };

    private InterruptException() {
        super("Interrupted");
    }
}
