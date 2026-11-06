package com.anythink.core.common.v.a.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.ak;
import com.anythink.core.common.h.an;
import com.anythink.core.common.h.ao;
import com.anythink.core.common.h.by;
import com.anythink.core.common.l.c;
import com.anythink.core.common.l.m;
import com.anythink.core.common.l.s;
import com.anythink.core.common.v.a.b.d;
import com.anythink.core.e.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "an";
    private final Context b;
    private final l c;
    private final aj d;
    private final d e;
    private InterfaceC0055a f;

    /* JADX INFO: renamed from: com.anythink.core.common.v.a.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0055a {
        void a(List<ak> list, boolean z);

        void a(boolean z);
    }

    public a(Context context, l lVar, aj ajVar, d dVar) {
        this.b = context;
        this.c = lVar;
        this.e = dVar;
        this.d = ajVar;
    }

    public final void a(InterfaceC0055a interfaceC0055a) {
        this.f = interfaceC0055a;
    }

    public final void a(final boolean z) {
        try {
            new m(b()).a(0, (s) new c() { // from class: com.anythink.core.common.v.a.c.a.1
                @Override // com.anythink.core.common.l.s
                public final void onLoadFinish(int i, Object obj) {
                    JSONArray jSONArrayOptJSONArray;
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    try {
                        if ((obj instanceof JSONObject) && (jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray("u_d")) != null && jSONArrayOptJSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                copyOnWriteArrayList.add(ak.a(String.valueOf(jSONArrayOptJSONArray.optInt(i2)), com.anythink.core.common.v.a.a.C0054a.a));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    if (a.this.f != null) {
                        a.this.f.a(copyOnWriteArrayList, z);
                    }
                    a.b(a.this);
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadError(int i, String str, AdError adError) {
                    if (a.this.f != null) {
                        InterfaceC0055a interfaceC0055a = a.this.f;
                        adError.getCode();
                        adError.getDesc();
                        interfaceC0055a.a(z);
                    }
                    a.b(a.this);
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void a() {
        l lVar;
        d dVar = this.e;
        if (dVar == null || (lVar = this.c) == null) {
            return;
        }
        dVar.b(lVar.i());
    }

    private ao b() {
        l lVar;
        Map<String, Integer> mapB;
        Map<String, List<an.a>> mapA;
        List<an.a> list;
        Integer num;
        ao aoVar = new ao();
        aoVar.a(com.anythink.core.common.d.s.b().p());
        aoVar.b(com.anythink.core.common.d.s.b().q());
        aoVar.a(this.b);
        l lVar2 = this.c;
        if (lVar2 != null) {
            aoVar.b(lVar2.ax());
            aoVar.a(this.c.ah());
            aoVar.d(this.c.i());
        }
        aj ajVar = this.d;
        if (ajVar != null) {
            aoVar.c(ajVar.g());
        }
        d dVar = this.e;
        if (dVar != null && (lVar = this.c) != null) {
            an anVarA = dVar.a(lVar.i());
            if (anVarA != null) {
                mapB = anVarA.b();
                mapA = anVarA.a();
            } else {
                mapB = null;
                mapA = null;
            }
            Map<String, by> mapX = this.c.x();
            if (mapX != null) {
                Set<String> setKeySet = mapX.keySet();
                ArrayList arrayList = new ArrayList();
                for (String str : setKeySet) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        by byVar = mapX.get(str);
                        if (byVar != null) {
                            jSONObject.put("unitid", Integer.parseInt(byVar.G()));
                            jSONObject.put("nwfid", byVar.n());
                            jSONObject.put("ecpm", byVar.K());
                            jSONObject.put("unit_type", byVar.aU());
                        }
                        if (mapB != null && (num = mapB.get(str)) != null && num.intValue() > 0) {
                            jSONObject.put("request", num.intValue());
                        }
                        if (mapA != null && (list = mapA.get(str)) != null && !list.isEmpty()) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (an.a aVar : list) {
                                String strA = aVar.a();
                                if (!TextUtils.isEmpty(strA)) {
                                    jSONObject2.put(strA, aVar.b());
                                }
                            }
                            if (jSONObject2.length() > 0) {
                                jSONObject.put("error_code", jSONObject2);
                            }
                        }
                        arrayList.add(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
                aoVar.a(new JSONArray((Collection) arrayList));
            }
        }
        return aoVar;
    }

    static /* synthetic */ void b(a aVar) {
        l lVar;
        d dVar = aVar.e;
        if (dVar == null || (lVar = aVar.c) == null) {
            return;
        }
        dVar.b(lVar.i());
    }
}
