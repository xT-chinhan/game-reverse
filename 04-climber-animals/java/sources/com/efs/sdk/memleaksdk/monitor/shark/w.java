package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    public static final w a = new w() { // from class: com.efs.sdk.memleaksdk.monitor.internal.w.1
        @Override // com.efs.sdk.memleaksdk.monitor.shark.w
        public void a() throws IOException {
        }
    };
    private boolean b;
    private long c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
