package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class n9 implements Runnable {
    public final /* synthetic */ p a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public n9(int i, p pVar, String str) {
        this.a = pVar;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mh mhVarC = this.a.c();
        if (mhVarC == null) {
            return;
        }
        StringBuilder sbAppend = new StringBuilder("[iad event] [").append(gj.a()).append("]; requestId:").append(mhVarC.f).append("; creativeId:").append(this.a.v).append("; event:").append(i.a(this.b)).append("; ");
        ConcurrentHashMap concurrentHashMap = this.a.K;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                sbAppend.append(entry.getKey()).append(":").append(entry.getValue()).append("; ");
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            sbAppend.append(this.c);
        }
        sbAppend.append("\n");
        i9.a.a(sbAppend.toString());
    }
}
