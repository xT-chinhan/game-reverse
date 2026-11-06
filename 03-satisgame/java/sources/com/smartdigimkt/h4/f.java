package com.smartdigimkt.h4;

import com.smartdigimkt.n3.a0;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.r4.i;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends d {
    public final List c;

    public f(ArrayList arrayList) {
        this.c = arrayList;
    }

    @Override // com.smartdigimkt.h4.d
    public final int a() {
        return 8;
    }

    @Override // com.smartdigimkt.h4.d
    public final byte[] b() {
        List list = this.c;
        return (list == null || list.size() <= 0) ? new byte[0] : d.a(a(false));
    }

    @Override // com.smartdigimkt.h4.d
    public final void a(int i, String str, String str2) {
        String str3 = str2 + ":" + i;
        List list = this.c;
        k.a("tk", "", str, str3, (String) null, String.valueOf(list != null ? list.size() : 0), String.valueOf(1));
        a0.a().a(3, "", "", a(true), com.smartdigimkt.f3.d.a(1000));
    }

    public final String a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectA = com.smartdigimkt.a4.a.a(6, null, "");
        JSONObject jSONObjectA2 = com.smartdigimkt.a4.a.a(6, (List) null);
        try {
            jSONObjectA.put("app_id", SDKContext.getInstance().a());
            jSONObjectA.put(com.anythink.core.common.l.f.S, this.a);
            jSONObjectA.put(com.anythink.core.common.l.f.U, this.b);
            Iterator<String> itKeys = jSONObjectA2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectA.put(next, jSONObjectA2.opt(next));
            }
        } catch (JSONException unused) {
        }
        String strB = com.smartdigimkt.r4.e.b(jSONObjectA.toString());
        JSONArray jSONArray = new JSONArray();
        List<com.smartdigimkt.f3.b> list = this.c;
        if (list != null) {
            for (com.smartdigimkt.f3.b bVar : list) {
                JSONObject jSONObjectA3 = bVar.b.a(bVar.a);
                try {
                    jSONObjectA3.put(com.anythink.core.common.l.f.br, bVar.c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (z) {
                    try {
                        jSONObjectA3.put(com.anythink.core.common.l.f.T, 1);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                jSONArray.put(jSONObjectA3);
            }
        }
        String strB2 = com.smartdigimkt.r4.e.b(jSONArray.toString());
        String strA = i.a(SDKContext.getInstance().b() + "api_ver=1.0&common=" + strB + "&data=" + strB2);
        try {
            jSONObject.put(com.anythink.core.common.l.f.Z, strB);
            jSONObject.put(com.anythink.core.common.l.f.R, strB2);
            jSONObject.put(com.anythink.core.common.l.f.P, "1.0");
            jSONObject.put(com.anythink.core.common.l.f.Y, strA);
        } catch (Exception unused2) {
        }
        return jSONObject.toString();
    }
}
