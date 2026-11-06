package com.anythink.core.common.l.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.ah;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends i {
    private static final String a = "g";
    private final String b;
    private volatile String c;
    private volatile String q;
    private volatile com.anythink.core.common.l.c.h r;
    private volatile com.anythink.core.common.l.c.h s;
    private volatile String t;
    private volatile long u;

    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return 12;
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
    public final boolean i() {
        return true;
    }

    public g(String str) {
        this.b = str;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        return a(this.c);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String strP = s.b().p();
            com.anythink.core.common.i.a();
            String strB = ah.b(com.anythink.core.common.i.b(true));
            if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strB)) {
                this.q = strP;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("path", strB);
                jSONObject.put(com.anythink.core.common.l.f.bU, str2);
                jSONObject.put("traceid", UUID.randomUUID().toString());
                jSONObject.put("app_id", strP);
                String string = jSONObject.toString();
                String strA = ah.a(strP, string, "{}", str, ah.a);
                return TextUtils.isEmpty(strA) ? "" : "{\"h\":" + string + ",\"q\":{},\"b\":" + str + ",\"mac\":\"" + strA + "\"}";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private void a(Object obj, com.anythink.core.common.l.s sVar) {
        this.c = null;
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                try {
                    ah.b bVarA = ah.a(str);
                    if (bVarA == null) {
                        sVar.onLoadError(0, "envelope parse failed", null);
                        return;
                    }
                    String strA = ah.a(this.q, bVarA.a, bVarA.b, ah.a);
                    if (strA != null && ah.a(strA, bVarA.c)) {
                        JSONObject jSONObject = new JSONObject(bVarA.b);
                        int iOptInt = jSONObject.optInt("code", 0);
                        if (iOptInt != 0) {
                            sVar.onLoadError(0, "business code ".concat(String.valueOf(iOptInt)), null);
                            return;
                        }
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.d.i.e.e);
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                        }
                        sVar.onLoadFinish(0, jSONObjectOptJSONObject);
                        return;
                    }
                    sVar.onLoadError(0, "response MAC verify failed", null);
                    return;
                } catch (Throwable unused) {
                    sVar.onLoadError(0, "response handle exception", null);
                    return;
                }
            }
        }
        sVar.onLoadError(0, "empty response", null);
    }

    private static String m() {
        com.anythink.core.common.i.a();
        return ah.b(com.anythink.core.common.i.b(true));
    }

    @Override // com.anythink.core.common.l.e.i
    public final com.anythink.core.common.l.c.h a_() {
        try {
            if (this.r != null) {
                return this.r;
            }
            Context contextG = s.b().g();
            String strC = com.anythink.core.common.g.c.a().c(contextG);
            int iE = com.anythink.core.common.g.c.a().e(contextG);
            if (!TextUtils.isEmpty(strC) && iE > 0) {
                return new com.anythink.core.common.l.c.h(strC, iE);
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.l.e.i
    public final com.anythink.core.common.l.c.h h() {
        return this.s;
    }

    @Override // com.anythink.core.common.l.e.i
    public final void a(com.anythink.core.common.l.c.h hVar) {
        if (hVar == null || TextUtils.isEmpty(hVar.a()) || hVar.b() <= 0) {
            throw new IllegalStateException("TCP endpoint is empty");
        }
        String str = hVar.a() + ":" + hVar.b();
        if (!TextUtils.equals(str, this.t) || TextUtils.isEmpty(this.c)) {
            this.c = a(this.b, hVar.a());
            this.t = str;
            if (TextUtils.isEmpty(this.c)) {
                throw new IllegalStateException("TCP envelope build failed for endpoint " + hVar.a());
            }
        }
    }

    @Override // com.anythink.core.common.l.e.i
    public final long j() {
        return this.u;
    }

    private void n() {
        Context contextG = s.b().g();
        String strC = com.anythink.core.common.g.c.a().c(contextG);
        int iE = com.anythink.core.common.g.c.a().e(contextG);
        String strD = com.anythink.core.common.g.c.a().d(contextG);
        int iF = com.anythink.core.common.g.c.a().f(contextG);
        com.anythink.core.common.l.c.h hVar = null;
        this.r = (TextUtils.isEmpty(strC) || iE <= 0) ? null : new com.anythink.core.common.l.c.h(strC, iE);
        if (!TextUtils.isEmpty(strD) && iF > 0) {
            hVar = new com.anythink.core.common.l.c.h(strD, iF);
        }
        this.s = hVar;
    }

    private void a(com.anythink.core.common.l.s sVar) {
        a(sVar, 0L);
    }

    public final void a(final com.anythink.core.common.l.s sVar, long j) {
        try {
            n();
            this.u = j > 0 ? SystemClock.elapsedRealtime() + j : 0L;
            a(this.r != null ? this.r : this.s);
            a(new i.a() { // from class: com.anythink.core.common.l.e.g.1
                @Override // com.anythink.core.common.l.e.i.a
                public final void a(Object obj) {
                    com.anythink.core.common.l.s sVar2 = sVar;
                    if (sVar2 == null) {
                        return;
                    }
                    g.a(g.this, obj, sVar2);
                }

                @Override // com.anythink.core.common.l.e.i.a
                public final void a(Throwable th) {
                    com.anythink.core.common.l.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.onLoadError(0, th != null ? th.getMessage() : "", null);
                    }
                }
            });
        } catch (Throwable th) {
            if (sVar != null) {
                sVar.onLoadError(0, th.getMessage(), null);
            }
        }
    }

    static /* synthetic */ void a(g gVar, Object obj, com.anythink.core.common.l.s sVar) {
        gVar.c = null;
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                try {
                    ah.b bVarA = ah.a(str);
                    if (bVarA == null) {
                        sVar.onLoadError(0, "envelope parse failed", null);
                        return;
                    }
                    String strA = ah.a(gVar.q, bVarA.a, bVarA.b, ah.a);
                    if (strA != null && ah.a(strA, bVarA.c)) {
                        JSONObject jSONObject = new JSONObject(bVarA.b);
                        int iOptInt = jSONObject.optInt("code", 0);
                        if (iOptInt != 0) {
                            sVar.onLoadError(0, "business code ".concat(String.valueOf(iOptInt)), null);
                            return;
                        }
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.d.i.e.e);
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                        }
                        sVar.onLoadFinish(0, jSONObjectOptJSONObject);
                        return;
                    }
                    sVar.onLoadError(0, "response MAC verify failed", null);
                    return;
                } catch (Throwable unused) {
                    sVar.onLoadError(0, "response handle exception", null);
                    return;
                }
            }
        }
        sVar.onLoadError(0, "empty response", null);
    }
}
