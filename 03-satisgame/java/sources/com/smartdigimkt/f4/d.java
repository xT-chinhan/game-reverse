package com.smartdigimkt.f4;

import android.text.TextUtils;
import com.smartdigimkt.n3.a0;
import com.smartdigimkt.sdk.api.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    public boolean r;
    public final int s;

    public d(int i, ArrayList arrayList) {
        super(new com.smartdigimkt.g4.b(i, arrayList));
        this.s = arrayList.size();
    }

    @Override // com.smartdigimkt.f4.b
    public final void a(int i, com.smartdigimkt.a4.b bVar) {
        com.smartdigimkt.g4.d dVar = this.d;
        if (!TextUtils.isEmpty(dVar != null ? dVar.k() : "")) {
            super.a(0, bVar);
        } else if (bVar != null) {
            ((com.smartdigimkt.n3.o) bVar).a(0, Integer.valueOf(this.s));
        }
    }

    @Override // com.smartdigimkt.f4.b
    public final Object a(Object obj) {
        return Integer.valueOf(this.s);
    }

    @Override // com.smartdigimkt.f4.b
    public final void a(AdError adError) {
        if (!this.r || this.d == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            Map mapE = this.d.e();
            if (mapE != null) {
                try {
                    HashMap map = (HashMap) mapE;
                    for (String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                } catch (Exception unused) {
                }
            }
            String string = jSONObject.toString();
            String strI = this.d.i();
            String strK = this.d.k();
            a0.a().a(this.d.j(), strK, string, strI, com.smartdigimkt.f3.d.a(1001));
        } catch (Throwable unused2) {
        }
    }
}
