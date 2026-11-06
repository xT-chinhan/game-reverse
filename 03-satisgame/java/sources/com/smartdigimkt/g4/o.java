package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends d {
    public final List e;
    public final int g;
    public boolean f = false;
    public final String c = SDKContext.getInstance().a();
    public final String d = SDKContext.getInstance().b();

    public o(int i, ArrayList arrayList) {
        this.g = i;
        this.e = arrayList;
    }

    @Override // com.smartdigimkt.g4.d
    public final JSONObject b() {
        JSONObject jSONObjectB = super.b();
        JSONObject jSONObjectA = com.smartdigimkt.a4.a.a(6, (List) null);
        try {
            jSONObjectB.put("app_id", this.c);
            jSONObjectB.put(com.anythink.core.common.l.f.S, this.g);
            Iterator<String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectB.put(next, jSONObjectA.opt(next));
            }
        } catch (Throwable unused) {
        }
        return jSONObjectB;
    }

    @Override // com.smartdigimkt.g4.d
    public final int c() {
        return 6;
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        return d.a(i());
    }

    @Override // com.smartdigimkt.g4.d
    public final String i() {
        JSONObject jSONObject = new JSONObject();
        String strB = com.smartdigimkt.r4.e.b(b().toString());
        JSONArray jSONArray = new JSONArray();
        List<com.smartdigimkt.f3.b> list = this.e;
        if (list != null) {
            for (com.smartdigimkt.f3.b bVar : list) {
                JSONObject jSONObjectA = bVar.b.a(bVar.a);
                try {
                    jSONObjectA.put(com.anythink.core.common.l.f.br, bVar.c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f) {
                    try {
                        jSONObjectA.put(com.anythink.core.common.l.f.T, 1);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                jSONArray.put(jSONObjectA);
            }
        }
        String strB2 = com.smartdigimkt.r4.e.b(jSONArray.toString());
        String strA = com.smartdigimkt.r4.i.a(this.d + "api_ver=1.0&common=" + strB + "&data=" + strB2);
        try {
            jSONObject.put(com.anythink.core.common.l.f.Z, strB);
            jSONObject.put(com.anythink.core.common.l.f.R, strB2);
            jSONObject.put(com.anythink.core.common.l.f.P, "1.0");
            jSONObject.put(com.anythink.core.common.l.f.Y, strA);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 1;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        String str = aVarA != null ? aVarA.j : "";
        return TextUtils.isEmpty(str) ? "https://tk.statisticslinks.com/v2/open/a_tk" : str;
    }
}
