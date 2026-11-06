package com.mcto.sspsdk.internal;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class k9 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public k9(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j9 j9Var = i9.a;
        StringBuilder sb = new StringBuilder("\nSetLogTime: ");
        AtomicInteger atomicInteger = gj.a;
        j9Var.a(sb.append(System.currentTimeMillis() / 1000).append("  requestId:").append(this.a).append("\n").append(this.b).append("\n\n").toString());
    }
}
