package com.smartdigimkt.z0;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements ThreadFactory {
    public final /* synthetic */ String a = "Loader:ExtractorMediaPeriod";

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.a);
    }
}
