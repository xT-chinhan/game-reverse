package com.anythink.core.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.bm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private static final String a = "o";
    private n b;

    public o(n nVar) {
        this.b = nVar;
    }

    public o() {
    }

    public final void a(Context context, final bm bmVar) {
        if (bmVar == null) {
            return;
        }
        a(context, bmVar, new com.anythink.core.common.m.q() { // from class: com.anythink.core.d.o.1
            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str, AdError adError) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                l lVarA;
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        jSONObject.put(l.a.ac, System.currentTimeMillis());
                        int iOptInt = jSONObject.optInt(l.a.av, 0);
                        if (o.this.b != null && (lVarA = o.this.b.a(bmVar.d(), iOptInt)) != null) {
                            lVarA.a(jSONObject, bmVar.d());
                        }
                    } catch (Throwable th) {
                        Log.e(o.a, "parse place strategy error:" + th.getMessage());
                    }
                    l lVarA2 = l.a(bmVar.d(), jSONObject);
                    if (o.this.b == null || lVarA2 == null) {
                        return;
                    }
                    String unused = o.a;
                    bmVar.d();
                    bmVar.h();
                    lVarA2.bb();
                    n nVar = o.this.b;
                    String strD = bmVar.d();
                    if (lVarA2.at() != 1) {
                        jSONObject = null;
                    }
                    nVar.a(strD, lVarA2, jSONObject, lVarA2.bb());
                }
            }
        });
    }

    public final void a(final Context context, final bm bmVar, com.anythink.core.common.m.q qVar) {
        Object[] objArr = new Object[1];
        if (bmVar == null) {
            return;
        }
        com.anythink.core.common.d.t.b().T();
        if (bmVar.n()) {
            com.anythink.core.common.g.c.a();
            if (com.anythink.core.common.g.c.c()) {
                final com.anythink.core.common.m.n nVar = new com.anythink.core.common.m.n(qVar);
                com.anythink.core.common.i.a();
                String strC = com.anythink.core.common.i.c();
                final String strF = com.anythink.core.common.v.q.f(strC);
                new com.anythink.core.common.m.s(context, bmVar).a(strC).a(0, (com.anythink.core.common.m.q) nVar);
                com.anythink.core.common.g.c.a().a(new com.anythink.core.common.g.d() { // from class: com.anythink.core.d.o.2
                    @Override // com.anythink.core.common.g.d
                    public final void a(String str) {
                        String unused = o.a;
                        Object[] objArr2 = new Object[2];
                        if (!TextUtils.isEmpty(str) && !str.equals(strF)) {
                            boolean zA = nVar.a();
                            String unused2 = o.a;
                            Object[] objArr3 = new Object[2];
                            Boolean.valueOf(zA);
                            bmVar.d();
                            if (zA) {
                                return;
                            }
                            com.anythink.core.common.g.c.a();
                            com.anythink.core.common.i.a();
                            String strB = com.anythink.core.common.g.c.b(com.anythink.core.common.i.c(), str);
                            String unused3 = o.a;
                            Object[] objArr4 = new Object[1];
                            new com.anythink.core.common.m.s(context, bmVar).a(strB).s().a(0, (com.anythink.core.common.m.q) nVar);
                            return;
                        }
                        String str2 = String.format("The cdnDomain(%s) is not equal to curPlDomain(%s).", str, strF);
                        nVar.onLoadError(0, str2, ErrorCode.getErrorCode(ErrorCode.exception, "", str2));
                    }
                });
                return;
            }
        }
        new com.anythink.core.common.m.s(context, bmVar).a(0, qVar);
    }
}
