package com.anythink.core.common.w.a.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ai;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.am;
import com.anythink.core.common.h.an;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.m.b;
import com.anythink.core.common.m.q;
import com.anythink.core.common.w.a.b.d;
import com.anythink.core.d.l;
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
    private static final String a = "am";
    private final Context b;
    private final l c;
    private final ai d;
    private final d e;
    private InterfaceC0107a f;

    /* JADX INFO: renamed from: com.anythink.core.common.w.a.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0107a {
        void a(List<aj> list, boolean z);

        void a(boolean z);
    }

    public a(Context context, l lVar, ai aiVar, d dVar) {
        this.b = context;
        this.c = lVar;
        this.e = dVar;
        this.d = aiVar;
    }

    public final void a(InterfaceC0107a interfaceC0107a) {
        this.f = interfaceC0107a;
    }

    public final void a(final boolean z) {
        try {
            new com.anythink.core.common.m.l(c()).a(0, (q) new b() { // from class: com.anythink.core.common.w.a.c.a.1
                @Override // com.anythink.core.common.m.q
                public final void onLoadFinish(int i, Object obj) {
                    JSONArray jSONArrayOptJSONArray;
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    try {
                        if ((obj instanceof JSONObject) && (jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray("u_d")) != null && jSONArrayOptJSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                copyOnWriteArrayList.add(aj.a(String.valueOf(jSONArrayOptJSONArray.optInt(i2)), com.anythink.core.common.w.a.a.C0106a.a));
                            }
                        }
                    } catch (Throwable th) {
                        String unused = a.a;
                        Object[] objArr = new Object[1];
                        th.getMessage();
                    }
                    if (a.this.f != null) {
                        a.this.f.a(copyOnWriteArrayList, z);
                    }
                    a.b(a.this);
                }

                @Override // com.anythink.core.common.m.q
                public final void onLoadError(int i, String str, AdError adError) {
                    if (a.this.f != null) {
                        InterfaceC0107a interfaceC0107a = a.this.f;
                        adError.getCode();
                        adError.getDesc();
                        interfaceC0107a.a(z);
                    }
                    a.b(a.this);
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void b() {
        l lVar;
        d dVar = this.e;
        if (dVar == null || (lVar = this.c) == null) {
            return;
        }
        dVar.b(lVar.i());
    }

    private an c() {
        l lVar;
        Map<String, Integer> mapB;
        Map<String, List<am.a>> mapA;
        List<am.a> list;
        Integer num;
        an anVar = new an();
        anVar.a(t.b().p());
        anVar.b(t.b().q());
        anVar.a(this.b);
        l lVar2 = this.c;
        if (lVar2 != null) {
            anVar.b(lVar2.ay());
            anVar.a(this.c.ai());
            anVar.d(this.c.i());
        }
        ai aiVar = this.d;
        if (aiVar != null) {
            anVar.c(aiVar.g());
        }
        d dVar = this.e;
        if (dVar != null && (lVar = this.c) != null) {
            am amVarA = dVar.a(lVar.i());
            if (amVarA != null) {
                mapB = amVarA.b();
                mapA = amVarA.a();
            } else {
                mapB = null;
                mapA = null;
            }
            Map<String, bv> mapW = this.c.w();
            if (mapW != null) {
                Set<String> setKeySet = mapW.keySet();
                ArrayList arrayList = new ArrayList();
                for (String str : setKeySet) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        bv bvVar = mapW.get(str);
                        if (bvVar != null) {
                            jSONObject.put("unitid", Integer.parseInt(bvVar.z()));
                            jSONObject.put("nwfid", bvVar.g());
                            jSONObject.put("ecpm", bvVar.D());
                            jSONObject.put("unit_type", bvVar.aM());
                        }
                        if (mapB != null && (num = mapB.get(str)) != null && num.intValue() > 0) {
                            jSONObject.put("request", num.intValue());
                        }
                        if (mapA != null && (list = mapA.get(str)) != null && !list.isEmpty()) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (am.a aVar : list) {
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
                    } catch (Throwable th) {
                        Object[] objArr = new Object[1];
                        th.getMessage();
                    }
                }
                anVar.a(new JSONArray((Collection) arrayList));
            }
        }
        return anVar;
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
