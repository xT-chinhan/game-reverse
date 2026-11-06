package com.anythink.core.common.m.d;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {
    List<String> a;
    int b;
    boolean c;
    private final String l = getClass().getSimpleName();

    @Override // com.anythink.core.common.m.d.d
    public final int c() {
        return 2;
    }

    @Override // com.anythink.core.common.m.d.d
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.m.d.d
    public final boolean f() {
        return false;
    }

    @Override // com.anythink.core.common.m.d.d
    protected final int g() {
        return 4;
    }

    public a(List<String> list) {
        this.a = list;
        this.b = list.size();
    }

    public final void a() {
        this.c = true;
    }

    public final int b() {
        return this.b;
    }

    @Override // com.anythink.core.common.m.d.d
    public final byte[] e() {
        return a(j());
    }

    private String j() {
        JSONObject jSONObjectH = super.h();
        JSONObject jSONObjectI = super.i();
        if (jSONObjectH != null) {
            try {
                jSONObjectH.put("app_id", t.b().p());
                jSONObjectH.put("nw_ver", m.h());
                JSONArray jSONArray = new JSONArray();
                List<String> list = this.a;
                if (list != null && list.size() > 0) {
                    for (String str : this.a) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(new JSONObject(str));
                        }
                    }
                }
                jSONObjectH.put("data", jSONArray);
            } catch (Exception unused) {
            }
        }
        if (jSONObjectI != null) {
            try {
                jSONObjectI.put(com.anythink.core.common.m.e.S, this.j);
                jSONObjectI.put(com.anythink.core.common.m.e.U, this.k);
            } catch (Exception unused2) {
            }
        }
        HashMap map = new HashMap();
        String strA = k.a(jSONObjectH.toString());
        String strA2 = k.a(jSONObjectI.toString());
        map.put(com.anythink.core.common.m.e.P, "1.0");
        map.put("p", strA);
        map.put(com.anythink.core.common.m.e.W, strA2);
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
        map.put(com.anythink.core.common.m.e.X, o.c(t.b().q() + sb.toString()));
        return new JSONObject(map).toString();
    }

    @Override // com.anythink.core.common.m.d.d
    public final void a(String str, String str2, String str3, int i) {
        if (this.c) {
            com.anythink.core.common.t.a().a(3, "", "", j(), aq.a(1001));
        }
    }
}
