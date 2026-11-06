package com.smartdigimkt.n3;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.smartdigimkt.f3.a b;
    public final /* synthetic */ long c;
    public final /* synthetic */ com.smartdigimkt.p3.e d;
    public final /* synthetic */ e e;

    public d(e eVar, int i, com.smartdigimkt.f3.a aVar, long j, com.smartdigimkt.p3.e eVar2) {
        this.e = eVar;
        this.a = i;
        this.b = aVar;
        this.c = j;
        this.d = eVar2;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007c  */
    /* JADX WARN: Code duplicated, block: B:28:0x008b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0143  */
    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        String str;
        String str2;
        e eVar = this.e;
        int i = this.a;
        com.smartdigimkt.f3.a aVar = this.b;
        long jCurrentTimeMillis = this.c;
        eVar.getClass();
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        com.smartdigimkt.f3.b bVar = new com.smartdigimkt.f3.b();
        bVar.a = i;
        bVar.b = aVar;
        if (jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        bVar.c = jCurrentTimeMillis;
        boolean z = false;
        if (SDKContext.getInstance().i()) {
            bVar = null;
        } else {
            String str3 = aVarA.E;
            if (TextUtils.isEmpty(str3)) {
                map = aVarA.t;
                if (map != null) {
                    str = (String) map.get(String.valueOf(i));
                    if (!TextUtils.isEmpty(str)) {
                        str2 = aVar.d;
                        if (TextUtils.isEmpty(str2)) {
                            bVar = null;
                        } else {
                            bVar = null;
                        }
                    }
                }
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str3);
                    int length = jSONArray.length();
                    String strValueOf = String.valueOf(aVar.P);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            map = aVarA.t;
                            if (map != null && map.containsKey(String.valueOf(i))) {
                                str = (String) map.get(String.valueOf(i));
                                if (!TextUtils.isEmpty(str)) {
                                    str2 = aVar.d;
                                    if (TextUtils.isEmpty(str2) || str.contains(str2)) {
                                    }
                                }
                            }
                        } else if (!TextUtils.equals(strValueOf, jSONArray.optString(i2))) {
                            i2++;
                        }
                        bVar = null;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (bVar == null) {
            return;
        }
        com.smartdigimkt.p3.e eVar2 = this.d;
        if (eVar2 != null) {
            synchronized (eVar2) {
                this.e.a((com.smartdigimkt.f3.e) bVar, true);
            }
            return;
        }
        e eVar3 = this.e;
        int i3 = this.a;
        com.smartdigimkt.f3.a aVar2 = this.b;
        eVar3.getClass();
        int i4 = aVar2.P;
        if (i4 == 67 || i3 == 4 || i3 == 30 || i3 == 6) {
            z = true;
        } else if (i4 != 0 && !TextUtils.isEmpty(aVar2.d)) {
            if (TextUtils.isEmpty(aVar2.J) && TextUtils.isEmpty(aVar2.K)) {
                Map map2 = com.smartdigimkt.o4.e.c().a().v;
                Map map3 = map2 != null ? (Map) map2.get("" + i3) : null;
                if (map3 != null) {
                    if (map3.containsKey("0")) {
                        String str4 = (String) map3.get("0");
                        if (!TextUtils.isEmpty(str4) && str4.contains(aVar2.d)) {
                            z = true;
                        }
                    } else if (map3.containsKey(String.valueOf(aVar2.P))) {
                        String str5 = (String) map3.get(String.valueOf(aVar2.P));
                        if (!TextUtils.isEmpty(str5) && str5.contains(aVar2.d)) {
                            z = true;
                        }
                    }
                }
            } else {
                z = true;
            }
        }
        eVar3.a(bVar, z);
    }
}
