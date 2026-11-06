package com.kwad.sdk.api.util;

import com.kwad.sdk.api.SDKApiHolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ApiSafeRunnable implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            doTask();
        } catch (Throwable th) {
            SDKApiHolder.report(th);
        }
    }
}
