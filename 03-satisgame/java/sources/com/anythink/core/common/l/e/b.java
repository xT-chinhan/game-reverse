package com.anythink.core.common.l.e;

import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends i {
    List<String> a;
    int b;
    boolean c;
    private final String q = getClass().getSimpleName();

    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.l.e.i
    public final int b() {
        return 3;
    }

    @Override // com.anythink.core.common.l.e.i
    public final boolean d() {
        return false;
    }

    @Override // com.anythink.core.common.l.e.i
    public final void e() {
    }

    @Override // com.anythink.core.common.l.e.i
    protected final int f() {
        return 4;
    }

    public b(List<String> list) {
        this.a = list;
        this.b = list.size();
    }

    public final void g() {
        this.c = true;
    }

    private int m() {
        return this.b;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        return a(n());
    }

    private String n() {
        JSONObject jSONObjectK = super.k();
        JSONObject jSONObjectL = super.l();
        if (jSONObjectK != null) {
            try {
                jSONObjectK.put("app_id", s.b().p());
                jSONObjectK.put("nw_ver", com.anythink.core.common.u.l.h());
                JSONArray jSONArray = new JSONArray();
                List<String> list = this.a;
                if (list != null && list.size() > 0) {
                    for (String str : this.a) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(new JSONObject(str));
                        }
                    }
                }
                jSONObjectK.put(com.anythink.core.common.l.f.R, jSONArray);
            } catch (Exception unused) {
            }
        }
        if (jSONObjectL != null) {
            try {
                jSONObjectL.put(com.anythink.core.common.l.f.S, this.o);
                jSONObjectL.put(com.anythink.core.common.l.f.U, this.p);
            } catch (Exception unused2) {
            }
        }
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.u.j.a(jSONObjectK.toString());
        String strA2 = com.anythink.core.common.u.j.a(jSONObjectL.toString());
        map.put(com.anythink.core.common.l.f.P, "1.0");
        map.put(com.anythink.core.common.l.f.W, strA);
        map.put(com.anythink.core.common.l.f.X, strA2);
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
        map.put(com.anythink.core.common.l.f.Y, n.c(s.b().q() + sb.toString()));
        return new JSONObject(map).toString();
    }
}
