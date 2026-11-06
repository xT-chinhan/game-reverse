package com.anythink.core.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.u.z;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class q {
    public static final String a = "MsgManager";
    private static volatile q b;
    private Context c;
    private boolean d;

    private q(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        this.d = false;
    }

    public static q a(Context context) {
        if (b == null) {
            synchronized (q.class) {
                if (b == null) {
                    b = new q(context);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0037 A[FALL_THROUGH, PHI: r3
      0x0037: PHI (r3v6 boolean) = (r3v1 boolean), (r3v7 boolean), (r3v0 boolean), (r3v9 boolean) binds: [B:30:0x007c, B:24:0x0062, B:12:0x0034, B:18:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    public final void a(int i, com.anythink.core.common.h.o oVar, com.anythink.core.e.b bVar) {
        String str;
        try {
            System.currentTimeMillis();
            if (com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(oVar.b.aQ()) == null) {
                return;
            }
            String strN = ((com.anythink.core.common.h.n) oVar.b).N();
            if (TextUtils.isEmpty(strN)) {
                return;
            }
            boolean z = false;
            if (i == 4) {
                z = ((com.anythink.core.common.h.n) oVar.b).I() == 1;
                Map<String, String> mapO = bVar.O();
                if (mapO != null) {
                    str = mapO.get("show");
                } else {
                    str = null;
                }
            } else if (i == 6) {
                z = ((com.anythink.core.common.h.n) oVar.b).J() == 1;
                Map<String, String> mapO2 = bVar.O();
                if (mapO2 != null) {
                    str = mapO2.get("click");
                } else {
                    str = null;
                }
            } else {
                switch (i) {
                    case 18:
                    case 19:
                    case 20:
                        z = ((com.anythink.core.common.h.n) oVar.b).m() == 1;
                        Map<String, String> mapO3 = bVar.O();
                        if (mapO3 != null) {
                            str = mapO3.get("dl");
                            break;
                        }
                    default:
                        str = null;
                        break;
                }
            }
            if (!z || TextUtils.isEmpty(str)) {
                return;
            }
            String string = z.a().toString();
            String string2 = oVar.a().toString();
            com.anythink.core.common.h.n nVar = (com.anythink.core.common.h.n) oVar.b;
            if (this.c != null) {
                Intent intent = new Intent(str);
                intent.putExtra(com.anythink.core.common.l.f.Z, string);
                intent.putExtra(com.anythink.core.common.l.f.R, string2);
                intent.putExtra("adsourceId", strN);
                intent.putExtra("networkType", String.valueOf(nVar.Z()));
                intent.putExtra(com.anythink.core.common.f.a.C0017a.d, nVar.aS());
                intent.putExtra("showid", nVar.A());
                intent.putExtra("tktype", i);
                intent.putExtra("extra_info", com.anythink.core.common.d.k.a(nVar, (ATBaseAdAdapter) null).toString());
                intent.setPackage(this.c.getPackageName());
                com.anythink.core.common.d.m.a(this.c).a(intent);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final com.anythink.core.e.b bVar) {
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bI, new Runnable() { // from class: com.anythink.core.common.q$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(bVar);
            }
        }));
    }

    public final void a(final com.anythink.core.e.b bVar) {
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bH, new Runnable() { // from class: com.anythink.core.common.q$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(bVar);
            }
        }), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(com.anythink.core.e.b bVar) {
        try {
            Context context = this.c;
            if (context == null) {
                return;
            }
            String packageName = context.getPackageName();
            String str = "";
            for (int i = 0; i < 2; i++) {
                str = str + packageName;
            }
            String strC = com.anythink.core.common.u.n.c(str);
            Intent intent = new Intent(strC);
            intent.putExtra(strC, bVar.K());
            intent.putExtra(com.anythink.core.common.l.f.R, z.a().toString());
            intent.putExtra("denied", com.anythink.core.common.d.s.b().f());
            intent.putExtra("tksw", bVar.k());
            intent.setPackage(packageName);
            com.anythink.core.common.d.m.a(this.c).a(intent);
            com.anythink.core.common.t.f.a(bVar.k());
        } catch (Throwable unused) {
        }
    }

    private void a(int i, String str, String str2, String str3, String str4, com.anythink.core.common.h.n nVar) {
        if (this.c == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra(com.anythink.core.common.l.f.Z, str2);
            intent.putExtra(com.anythink.core.common.l.f.R, str3);
            intent.putExtra("adsourceId", str4);
            intent.putExtra("networkType", String.valueOf(nVar.Z()));
            intent.putExtra(com.anythink.core.common.f.a.C0017a.d, nVar.aS());
            intent.putExtra("showid", nVar.A());
            intent.putExtra("tktype", i);
            intent.putExtra("extra_info", com.anythink.core.common.d.k.a(nVar, (ATBaseAdAdapter) null).toString());
            intent.setPackage(this.c.getPackageName());
            com.anythink.core.common.d.m.a(this.c).a(intent);
        } catch (Throwable unused) {
        }
    }

    public final void a(boolean z) {
        this.d = z;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0054 A[FALL_THROUGH] */
    public final void a(final Map<String, Object> map, final com.anythink.core.common.h.n nVar, final int i) {
        String str;
        if (this.d) {
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
            if (i == 4) {
                Map<String, String> mapO = bVarB.O();
                if (mapO != null) {
                    str = mapO.get("show");
                } else {
                    str = null;
                }
            } else if (i == 6) {
                Map<String, String> mapO2 = bVarB.O();
                if (mapO2 != null) {
                    str = mapO2.get("click");
                } else {
                    str = null;
                }
            } else {
                switch (i) {
                    case 18:
                    case 19:
                    case 20:
                        Map<String, String> mapO3 = bVarB.O();
                        if (mapO3 != null) {
                            str = mapO3.get("dl");
                            break;
                        }
                    default:
                        str = null;
                        break;
                }
            }
            final String str2 = str;
            if (this.c == null) {
                return;
            }
            if (str2 == null) {
                if (com.anythink.core.common.d.s.b().G()) {
                    Log.d(a, "sendAdxTraminiInfo: fail with empty action,businessType is ".concat(String.valueOf(i)));
                    return;
                }
                return;
            }
            com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bJ, new Runnable() { // from class: com.anythink.core.common.q.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Intent intent = new Intent(str2);
                        intent.putExtra("tktype", i);
                        com.anythink.core.common.d.k kVarA = com.anythink.core.common.d.k.a(nVar, (ATBaseAdAdapter) null);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("info_string", kVarA.toString());
                        jSONObject.put("info_result", map != null);
                        Map map2 = map;
                        if (map2 != null) {
                            jSONObject.put("ad_title", com.anythink.core.common.u.p.a((Map<String, Object>) map2, com.anythink.core.bridge.a.b.m, ""));
                            jSONObject.put("ad_desc", com.anythink.core.common.u.p.a((Map<String, Object>) map, com.anythink.core.bridge.a.b.n, ""));
                            jSONObject.put("ad_image_url", com.anythink.core.common.u.p.a((Map<String, Object>) map, com.anythink.core.bridge.a.b.o, ""));
                            jSONObject.put("ad_video_url", com.anythink.core.common.u.p.a((Map<String, Object>) map, com.anythink.core.bridge.a.b.p, ""));
                            jSONObject.put("ad_click_url", com.anythink.core.common.u.p.a((Map<String, Object>) map, com.anythink.core.bridge.a.b.q, ""));
                            jSONObject.put("ad_package_name", com.anythink.core.common.u.p.a((Map<String, Object>) map, com.anythink.core.bridge.a.b.r, ""));
                        }
                        intent.putExtra("adx_extra_info", jSONObject.toString());
                        intent.setPackage(q.this.c.getPackageName());
                        com.anythink.core.common.d.m.a(q.this.c).a(intent);
                    } catch (Throwable th) {
                        if (com.anythink.core.common.d.s.b().G()) {
                            Log.d(q.a, "sendAdxTraminiInfo: fail with throwable" + th.getMessage());
                        }
                    }
                }
            }));
        }
    }
}
