package com.smartdigimkt.p3;

import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ e a;

    public b(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int[] iArr;
        String string;
        this.a.b();
        e eVar = this.a;
        synchronized (eVar) {
            g gVar = eVar.e;
            boolean z = eVar.o && !eVar.p;
            if (!gVar.h) {
                gVar.h = true;
                if (!gVar.f || !gVar.g) {
                    int i = gVar.f ? 0 : gVar.c;
                    int i2 = gVar.g ? 0 : gVar.d;
                    if (!gVar.f && (i == 0 || z)) {
                        i |= 128;
                    }
                    if (!gVar.g && i2 == 0) {
                        i2 |= 128;
                    }
                    iArr = new int[]{i, i2};
                }
            }
            iArr = null;
        }
        if (iArr == null) {
            return;
        }
        com.smartdigimkt.f3.a aVar = eVar.d;
        com.smartdigimkt.b3.c cVar = eVar.c;
        int i3 = eVar.b.c;
        int i4 = iArr[0];
        TreeSet treeSet = new TreeSet();
        for (int i5 = 1; i5 <= 8; i5++) {
            if (((1 << (i5 - 1)) & i4) != 0) {
                treeSet.add(Integer.valueOf(i5));
            }
        }
        int i6 = iArr[1];
        TreeSet treeSet2 = new TreeSet();
        for (int i7 = 1; i7 <= 8; i7++) {
            if (((1 << (i7 - 1)) & i6) != 0) {
                treeSet2.add(Integer.valueOf(i7));
            }
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(i3), String.valueOf(66));
        cVar2.a = "3000023";
        cVar2.a(aVar);
        cVar2.l = cVar == null ? "" : cVar.a;
        cVar2.m = String.valueOf(i3);
        String str = cVar instanceof com.smartdigimkt.b3.l ? ((com.smartdigimkt.b3.l) cVar).c0 : "";
        if (str == null) {
            str = "";
        }
        cVar2.n = str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tk30", com.smartdigimkt.n3.k.a(treeSet));
            jSONObject.put("tk4", com.smartdigimkt.n3.k.a(treeSet2));
            string = jSONObject.toString();
        } catch (JSONException unused) {
            string = "{\"tk30\":[],\"tk4\":[]}";
        }
        cVar2.o = string;
        com.smartdigimkt.n3.k.a(cVar2);
    }
}
