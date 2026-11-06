package com.smartdigimkt.o4;

import com.smartdigimkt.sdk.api.AdError;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements com.smartdigimkt.a4.b {
    public final String a;
    public final com.smartdigimkt.a4.b b;
    public final Map c;

    public r(String str, q qVar, ConcurrentHashMap concurrentHashMap) {
        this.a = str;
        this.b = qVar;
        this.c = concurrentHashMap;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
        com.smartdigimkt.a4.b bVar = this.b;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        com.smartdigimkt.a4.b bVar = this.b;
        if (bVar != null) {
            bVar.a(i, obj);
        }
        Map map = this.c;
        if (map != null) {
            map.remove(this.a);
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        com.smartdigimkt.a4.b bVar = this.b;
        if (bVar != null) {
            bVar.a(i, str, adError);
        }
        Map map = this.c;
        if (map != null) {
            map.remove(this.a);
        }
    }
}
