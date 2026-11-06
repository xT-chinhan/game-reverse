package com.mcto.sspsdk.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class m9 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ HashMap c;

    public m9(int i, String str, HashMap map) {
        this.a = str;
        this.b = i;
        this.c = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StringBuilder sbAppend = new StringBuilder("[iad download event] [").append(gj.a()).append("]; download key:").append(this.a).append("; event:").append(i.a(this.b)).append("; ");
        for (Map.Entry entry : this.c.entrySet()) {
            sbAppend.append(entry.getKey()).append(":").append(entry.getValue()).append("; ");
        }
        sbAppend.append("\n");
        i9.a.a(sbAppend.toString());
    }
}
