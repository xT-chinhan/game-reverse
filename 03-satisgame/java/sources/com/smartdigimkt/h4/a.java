package com.smartdigimkt.h4;

import android.text.TextUtils;
import com.smartdigimkt.n3.a0;
import com.smartdigimkt.r4.i;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    public final List c;
    public final int d;
    public boolean e;

    public a(ArrayList arrayList) {
        this.c = arrayList;
        this.d = arrayList.size();
    }

    @Override // com.smartdigimkt.h4.d
    public final int a() {
        return 2;
    }

    @Override // com.smartdigimkt.h4.d
    public final byte[] b() {
        return d.a(c());
    }

    public final String c() {
        JSONObject jSONObjectA = com.smartdigimkt.a4.a.a(4, null, "");
        JSONObject jSONObjectA2 = com.smartdigimkt.a4.a.a(4, (List) null);
        try {
            jSONObjectA.put("app_id", SDKContext.getInstance().a());
            JSONArray jSONArray = new JSONArray();
            List list = this.c;
            if (list != null && list.size() > 0) {
                for (String str : this.c) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(new JSONObject(str));
                    }
                }
            }
            jSONObjectA.put(com.anythink.core.common.l.f.R, jSONArray);
        } catch (Exception unused) {
        }
        try {
            jSONObjectA2.put(com.anythink.core.common.l.f.S, this.a);
            jSONObjectA2.put(com.anythink.core.common.l.f.U, this.b);
        } catch (Exception unused2) {
        }
        HashMap map = new HashMap();
        String strB = com.smartdigimkt.r4.e.b(jSONObjectA.toString());
        String strB2 = com.smartdigimkt.r4.e.b(jSONObjectA2.toString());
        map.put(com.anythink.core.common.l.f.P, "1.0");
        map.put(com.anythink.core.common.l.f.W, strB);
        map.put(com.anythink.core.common.l.f.X, strB2);
        ArrayList<String> arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str2);
            sb.append("=");
            sb.append(map.get(str2));
        }
        map.put(com.anythink.core.common.l.f.Y, i.a(SDKContext.getInstance().b() + sb.toString()));
        return new JSONObject(map).toString();
    }

    @Override // com.smartdigimkt.h4.d
    public final void a(int i, String str, String str2) {
        if (this.e) {
            a0.a().a(3, "", "", c(), com.smartdigimkt.f3.d.a(1001));
        }
    }
}
