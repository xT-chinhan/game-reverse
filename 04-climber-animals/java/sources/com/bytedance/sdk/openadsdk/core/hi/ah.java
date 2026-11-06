package com.bytedance.sdk.openadsdk.core.hi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.basead.c.b;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.az;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.ul;
import com.tapsdk.tapad.e.a;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private Context ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f2569ms;
    private String xr;

    public ah(lm lmVar, String str, Context context) {
        this.f2569ms = lmVar;
        this.xr = str;
        this.ah = context;
    }

    private h xr() {
        lm lmVar = this.f2569ms;
        if (lmVar == null) {
            return new h();
        }
        return lmVar.tc();
    }

    public Boolean ms(final int i, JSONObject jSONObject) {
        h hVarXr = xr();
        String strXr = hVarXr.xr();
        try {
            jSONObject.putOpt("url", strXr);
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strXr)) {
            String strMs = ms(this.f2569ms, hVarXr.xr());
            h.ms((String) null);
            Uri uri = Uri.parse(strMs);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            f.xr(intent);
            boolean zXr = f.xr(this.ah);
            try {
                jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(zXr));
            } catch (Exception unused2) {
            }
            boolean z = false;
            if (zXr) {
                boolean zMs = f.ms(this.ah, intent);
                try {
                    jSONObject.putOpt("installed", Boolean.valueOf(zMs));
                } catch (Exception unused3) {
                }
                if (zMs) {
                    f.ms(false, this.f2569ms, this.xr);
                    ms(intent, System.currentTimeMillis());
                    com.bytedance.sdk.component.utils.xr.ms(this.ah, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.1
                        @Override // com.bytedance.sdk.component.utils.xr.ms
                        public void ms() {
                            com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.f2569ms, ah.this.xr, "deeplink_success_realtime", (Throwable) null);
                            ah.this.ms(0);
                        }

                        @Override // com.bytedance.sdk.component.utils.xr.ms
                        public void ms(Throwable th) {
                            if (ah.this.f2569ms != null && !ah.this.f2569ms.sh()) {
                                ul.ms(ah.this.ah, ah.this.f2569ms.ir(), ah.this.f2569ms, i, ah.this.xr);
                                sl.ah("WebHelper", "openDetailPage() -> mContext.startActivity(intent) fail :", th);
                            }
                            com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.f2569ms, ah.this.xr, "deeplink_fail_realtime", th);
                            ah.this.ms(3);
                        }
                    }, TextUtils.equals("main", UMModuleRegister.INNER));
                    HashMap map = new HashMap();
                    map.put("source", "DeepLinkConverter_new");
                    com.bytedance.sdk.openadsdk.core.zb.ah.x(this.f2569ms, this.xr, "open_url_app", map);
                    com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(this.f2569ms, this.xr, false);
                    return Boolean.TRUE;
                }
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f2569ms, this.xr, "deeplink_fail_realtime", (Throwable) null);
                ms(1);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    com.bytedance.sdk.openadsdk.core.zb.ah.x(this.f2569ms, this.xr, "open_url_app", null);
                    boolean zMs2 = f.ms(false, this.f2569ms, this.xr);
                    try {
                        com.bytedance.sdk.component.utils.xr.startActivity(this.ah, intent, TextUtils.equals("main", UMModuleRegister.INNER));
                        ms(intent, jCurrentTimeMillis);
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f2569ms, this.xr, "deeplink_success_realtime", (Throwable) null);
                        com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(this.f2569ms, this.xr, false);
                        ms(0);
                        try {
                            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.live.ka.ms.ms(strXr)));
                            String strI = f.i(this.f2569ms);
                            if (strI != null && strI.length() > 0) {
                                jSONObject.putOpt("installed_other", Boolean.valueOf(f.ms(strI)));
                            }
                            jSONObject.putOpt(b.a.A, strI);
                        } catch (Throwable unused4) {
                        }
                        return Boolean.TRUE;
                    } catch (Throwable th) {
                        th = th;
                        z = zMs2;
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f2569ms, this.xr, "deeplink_fail_realtime", th);
                        ms(3);
                        if (z) {
                            return Boolean.FALSE;
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        lm lmVar = this.f2569ms;
        if (lmVar == null || lmVar.cn() != 1) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f2569ms, this.xr, 1, 1, i, g.c());
    }

    public void ms(final Intent intent, final long j) {
        final com.bytedance.sdk.openadsdk.core.jw.ms msVarD;
        lm lmVar = this.f2569ms;
        if (lmVar == null || intent == null || this.ah == null || !lmVar.gz() || (msVarD = com.bytedance.sdk.openadsdk.core.ch.ub().d()) == null) {
            return;
        }
        msVarD.ms(new com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.2
            @Override // com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms
            public void ms() {
                if (System.currentTimeMillis() - j <= a.f) {
                    ah.this.ms(intent);
                }
                com.bytedance.sdk.openadsdk.core.jw.ms msVar = msVarD;
                if (msVar != null) {
                    msVar.ah();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final Intent intent) {
        lm lmVar = this.f2569ms;
        if (lmVar == null || this.ah == null || intent == null) {
            return;
        }
        String strAh = lmVar.zh() != null ? this.f2569ms.zh().ah() : "";
        com.bytedance.sdk.openadsdk.core.jw.c.ms(this.ah, this.f2569ms.df(), strAh, TextUtils.isEmpty(strAh) ? "是否立即打开应用" : "是否立即打开".concat(String.valueOf(strAh)), "立即打开", "退出", new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.3
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                HashMap map = new HashMap();
                map.put("source", "DeepLinkConverter_new");
                com.bytedance.sdk.openadsdk.core.zb.ah.x(ah.this.f2569ms, ah.this.xr, "open_url_app", map);
                com.bytedance.sdk.component.utils.xr.ms(ah.this.ah, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.3.1
                    @Override // com.bytedance.sdk.component.utils.xr.ms
                    public void ms() {
                        com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(ah.this.f2569ms, ah.this.xr, false);
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.f2569ms, ah.this.xr, "deeplink_success_realtime", (Throwable) null);
                    }

                    @Override // com.bytedance.sdk.component.utils.xr.ms
                    public void ms(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.f2569ms, ah.this.xr, "deeplink_fail_realtime", th);
                    }
                }, TextUtils.equals("main", UMModuleRegister.INNER));
            }
        });
    }

    public static String ms(lm lmVar, String str) {
        com.bytedance.sdk.openadsdk.core.nw.f fVarDm;
        if (TextUtils.isEmpty(str) || lmVar == null || !xn.ms(lmVar) || (fVarDm = lmVar.dm()) == null) {
            return str;
        }
        try {
            String strAh = fVarDm.ah();
            String strD = fVarDm.d();
            Map<String, String> mapMs = az.ms(str);
            mapMs.put("live_short_touch_params", strAh);
            mapMs.put("extra_pangle_scheme_params", strD);
            String strMs = az.ms(str, mapMs);
            com.bytedance.sdk.openadsdk.core.xr.ms().ms("is_reward_deep_link_to_live", true);
            return strMs;
        } catch (Exception unused) {
            return str;
        }
    }

    public boolean ms(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar, boolean z, boolean z2) {
        h hVarXr = xr();
        HashMap map = new HashMap();
        map.put("source", "DeepLinkConverter_new");
        boolean z3 = false;
        if (hVarXr.ka() == 2 && !lm.xr(this.f2569ms) && ahVar != null) {
            if (ahVar.ah() && ahVar.ms(z, z2)) {
                z3 = true;
            }
            boolean z4 = (z3 || !ahVar.ms(f.y(this.f2569ms), z2)) ? z3 : true;
            com.bytedance.sdk.openadsdk.core.zb.ah.x(this.f2569ms, this.xr, "open_fallback_url", map);
            return z4;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.x(this.f2569ms, this.xr, "open_fallback_url", map);
        return false;
    }

    public String ms() {
        h hVarXr = xr();
        if (hVarXr.ka() == 1) {
            return hVarXr.d();
        }
        return this.f2569ms.ir();
    }
}
