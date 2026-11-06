package com.smartdigimkt.v2;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ p f;

    public i(p pVar, long j, String str, boolean z, int i, int i2) {
        this.f = pVar;
        this.a = j;
        this.b = str;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strD;
        synchronized (this.f.f) {
            try {
                strD = com.smartdigimkt.r4.e.d(this.b);
            } catch (Throwable unused) {
                this.f.getClass();
                StringBuilder sb = new StringBuilder("cur offset: ");
                this.f.getClass();
                com.smartdigimkt.n3.k.a("handleUpdateInspectInfo error", sb.append(y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", t.a.E)).append(", error string: ").append(this.b).toString(), SDKContext.getInstance().f(), "");
                strD = null;
            }
            LinkedHashMap linkedHashMapA = com.smartdigimkt.r4.k.a(strD);
            if (!this.c) {
                if (this.d == 1 || linkedHashMapA.size() == 0) {
                    String str = this.f.a;
                    y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", t.a.E, 0);
                } else {
                    this.f.getClass();
                    y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", t.a.E, y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", t.a.E) + linkedHashMapA.size());
                    String str2 = this.f.a;
                }
            }
            Context contextD = SDKContext.getInstance().d();
            if (contextD != null) {
                if (!this.f.i) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : linkedHashMapA.entrySet()) {
                        try {
                            String str3 = (String) entry.getKey();
                            String string = entry.getValue().toString();
                            b bVar = (b) this.f.e.get(str3);
                            if (bVar != null) {
                                arrayList.add(new c(contextD, string, str3, bVar.b, bVar.c, this.c));
                            } else {
                                arrayList.add(new c(contextD, string, str3, 0L, false, this.c));
                            }
                        } catch (Throwable unused2) {
                            this.f.getClass();
                        }
                    }
                    if (arrayList.size() > 0) {
                        if (this.c) {
                            this.f.k = new HashSet();
                            p pVar = this.f;
                            arrayList.size();
                            pVar.getClass();
                            for (int i = 0; i < arrayList.size(); i++) {
                                d dVar = (d) arrayList.get(i);
                                if (dVar instanceof d) {
                                    String str4 = dVar.c;
                                    if (!TextUtils.isEmpty(str4)) {
                                        this.f.k.add(str4);
                                    }
                                }
                            }
                            p pVar2 = this.f;
                            pVar2.l = pVar2.k.isEmpty();
                            p pVar3 = this.f;
                            if (pVar3.l) {
                                p.a(pVar3);
                            }
                        }
                        p.a(this.f, arrayList, true);
                    } else {
                        this.f.getClass();
                        if (this.c) {
                            this.f.getClass();
                            p.a(this.f);
                        }
                    }
                }
                int i2 = this.e;
                int size = this.f.h.size();
                int i3 = this.d;
                long j = this.a;
                com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
                cVar.a = "1004758";
                cVar.l = String.valueOf(i2);
                cVar.m = String.valueOf(size);
                cVar.n = String.valueOf(i3);
                cVar.o = String.valueOf(j);
                com.smartdigimkt.n3.k.a(cVar);
            } else {
                this.f.getClass();
            }
        }
    }
}
