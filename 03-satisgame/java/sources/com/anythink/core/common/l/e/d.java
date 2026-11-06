package com.anythink.core.common.l.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.ah;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends i {
    private static final String a = "d";
    private final String b;
    private final String c;
    private volatile String q;
    private volatile String r;
    private volatile com.anythink.core.common.l.c.h s;
    private volatile long t;

    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return 13;
    }

    @Override // com.anythink.core.common.l.e.i
    public final int b() {
        return 3;
    }

    @Override // com.anythink.core.common.l.e.i
    public final boolean d() {
        return false;
    }

    public d(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        return a(this.q);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String strB = ah.b(this.c);
            String strP = s.b().p();
            if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strB)) {
                this.r = strP;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("path", strB);
                jSONObject.put(com.anythink.core.common.l.f.bU, str2);
                jSONObject.put("traceid", UUID.randomUUID().toString());
                jSONObject.put("app_id", strP);
                String strI = com.anythink.core.common.u.l.i();
                if (!TextUtils.isEmpty(strI)) {
                    jSONObject.put("ua", strI);
                }
                String string = jSONObject.toString();
                String strA = ah.a(strP, string, "{}", str, ah.b);
                return TextUtils.isEmpty(strA) ? "" : "{\"h\":" + string + ",\"q\":{},\"b\":" + str + ",\"mac\":\"" + strA + "\"}";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private void a(Object obj, com.anythink.core.common.l.s sVar) {
        this.q = null;
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                try {
                    ah.b bVarA = ah.a(str);
                    if (bVarA == null) {
                        sVar.onLoadError(0, "envelope parse failed", null);
                        return;
                    }
                    String strA = ah.a(this.r, bVarA.a, bVarA.b, ah.b);
                    if (strA != null && ah.a(strA, bVarA.c)) {
                        sVar.onLoadFinish(0, new JSONObject(bVarA.b));
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

    private String m() {
        return ah.b(this.c);
    }

    @Override // com.anythink.core.common.l.e.i
    public final com.anythink.core.common.l.c.h a_() {
        com.anythink.core.common.l.c.h hVar = this.s;
        return hVar != null ? hVar : n();
    }

    private void a(com.anythink.core.common.l.s sVar) {
        a(sVar, 0L);
    }

    public final void a(final com.anythink.core.common.l.s sVar, long j) {
        this.t = j > 0 ? SystemClock.elapsedRealtime() + j : 0L;
        this.s = n();
        this.q = this.s != null ? a(this.b, this.s.a()) : "";
        if (!TextUtils.isEmpty(this.q)) {
            a(new i.a() { // from class: com.anythink.core.common.l.e.d.1
                @Override // com.anythink.core.common.l.e.i.a
                public final void a(Object obj) {
                    com.anythink.core.common.l.s sVar2 = sVar;
                    if (sVar2 == null) {
                        return;
                    }
                    d.a(d.this, obj, sVar2);
                }

                @Override // com.anythink.core.common.l.e.i.a
                public final void a(Throwable th) {
                    com.anythink.core.common.l.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.onLoadError(0, th != null ? th.getMessage() : "", null);
                    }
                }
            });
        } else if (sVar != null) {
            sVar.onLoadError(0, "TCP envelope build failed", null);
        }
    }

    @Override // com.anythink.core.common.l.e.i
    public final long j() {
        return this.t;
    }

    private static com.anythink.core.common.l.c.h n() {
        try {
            com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
            if (bVarA == null) {
                return null;
            }
            String strAx = bVarA.ax();
            int iAy = bVarA.ay();
            if (!TextUtils.isEmpty(strAx) && iAy > 0) {
                return new com.anythink.core.common.l.c.h(strAx, iAy);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    static /* synthetic */ void a(d dVar, Object obj, com.anythink.core.common.l.s sVar) {
        dVar.q = null;
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                try {
                    ah.b bVarA = ah.a(str);
                    if (bVarA == null) {
                        sVar.onLoadError(0, "envelope parse failed", null);
                        return;
                    }
                    String strA = ah.a(dVar.r, bVarA.a, bVarA.b, ah.b);
                    if (strA != null && ah.a(strA, bVarA.c)) {
                        sVar.onLoadFinish(0, new JSONObject(bVarA.b));
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
