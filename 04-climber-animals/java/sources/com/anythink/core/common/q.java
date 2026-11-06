package com.anythink.core.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.v.aa;
import com.efs.sdk.base.core.util.NetworkUtil;
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
      0x0037: PHI (r3v7 boolean) = (r3v1 boolean), (r3v8 boolean), (r3v0 boolean), (r3v10 boolean) binds: [B:30:0x007c, B:24:0x0062, B:12:0x0034, B:18:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    public final void a(int i, com.anythink.core.common.h.o oVar, com.anythink.core.d.b bVar) {
        String str;
        try {
            System.currentTimeMillis();
            if (com.anythink.core.d.n.a(com.anythink.core.common.d.t.b().g()).a(oVar.b.aI()) == null) {
                return;
            }
            String strM = ((com.anythink.core.common.h.n) oVar.b).M();
            if (TextUtils.isEmpty(strM)) {
                return;
            }
            boolean z = false;
            if (i == 4) {
                z = ((com.anythink.core.common.h.n) oVar.b).H() == 1;
                Map<String, String> mapX = bVar.X();
                if (mapX != null) {
                    str = mapX.get("show");
                } else {
                    str = null;
                }
            } else if (i == 6) {
                z = ((com.anythink.core.common.h.n) oVar.b).I() == 1;
                Map<String, String> mapX2 = bVar.X();
                if (mapX2 != null) {
                    str = mapX2.get("click");
                } else {
                    str = null;
                }
            } else {
                switch (i) {
                    case 18:
                    case 19:
                    case 20:
                        z = ((com.anythink.core.common.h.n) oVar.b).l() == 1;
                        Map<String, String> mapX3 = bVar.X();
                        if (mapX3 != null) {
                            str = mapX3.get("dl");
                            break;
                        }
                    default:
                        str = null;
                        break;
                }
            }
            if (z && !TextUtils.isEmpty(str)) {
                JSONObject jSONObjectA = aa.a();
                jSONObjectA.toString();
                oVar.a().toString();
                String string = jSONObjectA.toString();
                String string2 = oVar.a().toString();
                com.anythink.core.common.h.n nVar = (com.anythink.core.common.h.n) oVar.b;
                if (this.c != null) {
                    try {
                        Intent intent = new Intent(str);
                        intent.putExtra(com.anythink.core.common.m.e.Y, string);
                        intent.putExtra("data", string2);
                        intent.putExtra("adsourceId", strM);
                        intent.putExtra("networkType", String.valueOf(nVar.Y()));
                        intent.putExtra("format", nVar.aK());
                        intent.putExtra("showid", nVar.z());
                        intent.putExtra("tktype", i);
                        intent.putExtra(com.anythink.core.common.e.b.a.f, com.anythink.core.common.d.l.a(nVar, (com.anythink.core.common.d.f) null).toString());
                        intent.setPackage(this.c.getPackageName());
                        com.anythink.core.common.d.n.a(this.c).a(intent);
                    } catch (Throwable unused) {
                    }
                }
            }
            System.currentTimeMillis();
        } catch (Throwable unused2) {
        }
    }

    public final void a(final com.anythink.core.d.b bVar) {
        com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.q.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (q.this.c == null) {
                        return;
                    }
                    String packageName = q.this.c.getPackageName();
                    String str = "";
                    for (int i = 0; i < 2; i++) {
                        str = str + packageName;
                    }
                    String strC = com.anythink.core.common.v.o.c(str);
                    Intent intent = new Intent(strC);
                    intent.putExtra(strC, bVar.S());
                    intent.putExtra("data", aa.a().toString());
                    intent.putExtra(NetworkUtil.NETWORK_CLASS_DENIED, com.anythink.core.common.d.t.b().f());
                    intent.putExtra("tksw", bVar.r());
                    intent.setPackage(packageName);
                    com.anythink.core.common.d.n.a(q.this.c).a(intent);
                    com.anythink.core.common.u.e.a(bVar.r());
                } catch (Throwable unused) {
                }
            }
        }, 1000L);
    }

    private void a(int i, String str, String str2, String str3, String str4, com.anythink.core.common.h.n nVar) {
        if (this.c == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra(com.anythink.core.common.m.e.Y, str2);
            intent.putExtra("data", str3);
            intent.putExtra("adsourceId", str4);
            intent.putExtra("networkType", String.valueOf(nVar.Y()));
            intent.putExtra("format", nVar.aK());
            intent.putExtra("showid", nVar.z());
            intent.putExtra("tktype", i);
            intent.putExtra(com.anythink.core.common.e.b.a.f, com.anythink.core.common.d.l.a(nVar, (com.anythink.core.common.d.f) null).toString());
            intent.setPackage(this.c.getPackageName());
            com.anythink.core.common.d.n.a(this.c).a(intent);
        } catch (Throwable unused) {
        }
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(com.anythink.core.common.h.w wVar, com.anythink.core.common.h.n nVar, int i) {
        String str;
        if (this.d) {
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
            if (i != 4) {
                if (i == 6) {
                    Map<String, String> mapX = bVarB.X();
                    str = mapX != null ? mapX.get("click") : null;
                } else {
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                            Map<String, String> mapX2 = bVarB.X();
                            str = mapX2 == null ? null : mapX2.get("dl");
                            break;
                        default:
                            str = null;
                            break;
                    }
                }
            } else {
                Map<String, String> mapX3 = bVarB.X();
                str = mapX3 != null ? mapX3.get("show") : null;
            }
            if (this.c == null) {
                return;
            }
            if (str == null) {
                if (com.anythink.core.common.d.t.b().F()) {
                    Log.d(a, "sendAdxTraminiInfo: fail with empty action,businessType is ".concat(String.valueOf(i)));
                    return;
                }
                return;
            }
            try {
                Intent intent = new Intent(str);
                intent.putExtra("tktype", i);
                com.anythink.core.common.d.l lVarA = com.anythink.core.common.d.l.a(nVar, (com.anythink.core.common.d.f) null);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("info_string", lVarA.toString());
                jSONObject.put("info_result", wVar != null);
                if (wVar != null) {
                    jSONObject.put("ad_title", wVar.x());
                    jSONObject.put("ad_desc", wVar.y());
                    jSONObject.put("ad_image_url", wVar.A());
                    jSONObject.put("ad_video_url", wVar.E());
                    jSONObject.put("ad_click_url", wVar.H());
                    jSONObject.put("ad_package_name", wVar.I());
                }
                intent.putExtra("adx_extra_info", jSONObject.toString());
                intent.setPackage(this.c.getPackageName());
                com.anythink.core.common.d.n.a(this.c).a(intent);
            } catch (Throwable th) {
                if (com.anythink.core.common.d.t.b().F()) {
                    Log.d(a, "sendAdxTraminiInfo: fail with throwable" + th.getMessage());
                }
            }
        }
    }
}
