package com.tapsdk.tapad.internal.download.m.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class c extends IOException {
    public static final c a = new a();

    static class a extends c {
        a() {
            super(null);
        }

        @Override // java.lang.Throwable
        public void printStackTrace() {
            throw new IllegalAccessError("Stack is ignored for signal");
        }
    }

    private c() {
        super("Interrupted");
    }

    /* synthetic */ c(a aVar) {
        this();
    }
}
