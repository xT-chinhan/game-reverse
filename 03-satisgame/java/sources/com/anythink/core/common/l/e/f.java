package com.anythink.core.common.l.e;

import com.anythink.core.common.d.s;
import com.anythink.core.common.h.au;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends i {
    List<au> a;

    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return 9;
    }

    @Override // com.anythink.core.common.l.e.i
    public final int b() {
        return 3;
    }

    @Override // com.anythink.core.common.l.e.i
    public final boolean d() {
        return false;
    }

    public f(List<au> list) {
        this.a = list;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        return a(m());
    }

    @Override // com.anythink.core.common.l.e.i
    public final com.anythink.core.common.l.c.h a_() {
        try {
            com.anythink.core.common.i.a();
            return new com.anythink.core.common.l.c.h(com.anythink.core.common.i.k(), com.anythink.core.common.i.l());
        } catch (Throwable unused) {
            return null;
        }
    }

    private String m() {
        try {
            JSONObject jSONObject = new JSONObject();
            com.anythink.core.common.l.f.a(s.b().g(), jSONObject);
            List<au> list = this.a;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (au auVar : this.a) {
                    if (auVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        auVar.b(jSONObject2);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("t_items", jSONArray);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void a(final com.anythink.core.common.l.s sVar) {
        a(new i.a() { // from class: com.anythink.core.common.l.e.f.1
            @Override // com.anythink.core.common.l.e.i.a
            public final void a(Object obj) {
                com.anythink.core.common.l.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.onLoadFinish(0, obj);
                }
            }

            @Override // com.anythink.core.common.l.e.i.a
            public final void a(Throwable th) {
                com.anythink.core.common.l.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.onLoadError(0, th != null ? th.getMessage() : "", null);
                }
            }
        });
    }
}
