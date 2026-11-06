package com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.basead.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.az;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.re;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.ul;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.e.a;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    private String ah;
    private boolean ch;
    private Context d;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah hi;
    private h ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms f3130ms;
    private boolean ny;
    private String sl;
    private lm xr;
    private com.bytedance.sdk.openadsdk.core.video.xr.xr zb;
    private boolean c = false;
    private boolean ab = false;
    private Bridge x = ch.ub().ul();

    public ah(com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar, lm lmVar, String str, h hVar, Context context) {
        this.f3130ms = msVar;
        this.xr = lmVar;
        this.ah = str;
        this.d = context;
        this.ka = hVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar) {
        this.zb = xrVar;
    }

    public void ms(boolean z) {
        this.c = z;
    }

    public void xr(boolean z) {
        this.ab = z;
    }

    public void ah(boolean z) {
        this.ny = z;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar) {
        this.hi = ahVar;
    }

    public void ms(String str) {
        this.sl = str;
    }

    private h ms() {
        h hVar = this.ka;
        return hVar == null ? new h() : hVar;
    }

    public Boolean ms(Map<String, Object> map, String str, JSONObject jSONObject) {
        String strAh = ah(str);
        if (TextUtils.isEmpty(strAh)) {
            return null;
        }
        h.ms((String) null);
        Uri uri = Uri.parse(strAh);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (this.c) {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.xr, this.ah, "lp_open_dpl", xr(strAh));
        }
        boolean zXr = f.xr(this.d);
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.c));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(zXr));
        } catch (Exception unused) {
        }
        if (zXr) {
            boolean zMs = f.ms(this.d, intent);
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(zMs));
            } catch (Exception unused2) {
            }
            if (zMs) {
                return ms(map, intent, true, jSONObject);
            }
            ms(map, true, (Throwable) null);
            ms(1);
            return null;
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.live.ka.ms.ms(strAh)));
            String strI = f.i(this.xr);
            if (strI != null && strI.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(f.ms(strI)));
            }
            jSONObject.putOpt(b.a.A, strI);
        } catch (Throwable unused3) {
        }
        return ms(map, intent, false, jSONObject);
    }

    private Boolean ms(JSONObject jSONObject) {
        Boolean boolValueOf;
        try {
            jSONObject.putOpt(TTDownloadField.TT_TAG, this.sl);
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(this.sl) || !re.ms(this.xr, this.sl)) {
            return null;
        }
        int iXr = re.xr(this.xr, this.sl);
        if (iXr == 1) {
            boolValueOf = Boolean.valueOf(xr());
        } else {
            boolValueOf = ms(new HashMap(), re.ah(this.xr, this.sl), jSONObject);
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(iXr));
            jSONObject.putOpt("dpl_result", boolValueOf);
        } catch (JSONException unused2) {
        }
        return boolValueOf;
    }

    private boolean xr() {
        String strAh = re.ah(this.xr, this.sl);
        lm lmVar = this.xr;
        Context context = this.d;
        String str = this.ah;
        com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms(lmVar, context, str, f.xr(str));
        msVar.ah(true);
        msVar.ms(strAh);
        msVar.ms(this.zb);
        return msVar.ms((Map<String, Object>) new HashMap());
    }

    private Boolean ms(final Map<String, Object> map, Intent intent, final boolean z, JSONObject jSONObject) {
        f.xr(intent);
        ms(intent);
        HashMap map2 = new HashMap();
        map2.put("source", "DeepLinkConverter");
        if (this.ab) {
            boolean zMs = ms(this.ah, "open_fallback_url", this.xr, map);
            if (!zMs) {
                com.bytedance.sdk.openadsdk.core.zb.ah.x(this.xr, this.ah, "open_url_app", map2);
            }
            try {
                jSONObject.putOpt("intercept", Boolean.valueOf(zMs));
            } catch (JSONException unused) {
            }
        } else {
            com.bytedance.sdk.openadsdk.core.zb.ah.x(this.xr, this.ah, "open_url_app", map2);
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.xr.ms(this.d, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ah.1
            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms() {
                atomicBoolean.set(true);
                if (ah.this.c) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.xr, ah.this.ah, "lp_openurl", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.xr, ah.this.ah, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.xr, ah.this.ah, "deeplink_success_realtime", (Throwable) null);
                }
                com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(ah.this.xr, ah.this.ah, ah.this.c);
                ah.this.ms(0);
            }

            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms(Throwable th) {
                atomicBoolean.set(false);
                ah.this.ms((Map<String, Object>) map, z, th);
                ah.this.ms(3);
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        lm lmVar = this.xr;
        if (lmVar == null || lmVar.cn() != 1) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, 1, 1, i, g.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Map<String, Object> map, boolean z, Throwable th) {
        if (this.ab && !z) {
            com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.xr, this.ah, "open_fallback_download");
        }
        if (this.ab) {
            com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.xr, this.ah, "lp_openurl_failed");
            if (!this.ch && !ms(this.ah, "open_fallback_url", this.xr, map)) {
                this.ch = true;
                com.bytedance.sdk.openadsdk.core.zb.ah.x(this.xr, this.ah, "open_fallback_url", null);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.zb.ah.x(this.xr, this.ah, "open_fallback_url", null);
        }
        if (this.ny) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, (this.ab && this.c) ? "lp_deeplink_fail_realtime" : "deeplink_fail_realtime", th);
    }

    private boolean ms(String str, String str2, lm lmVar, Map<String, Object> map) {
        if (this.x == null) {
            return false;
        }
        return ((Boolean) this.x.call(2, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_TAG_INTERCEPT, str).ms(TTDownloadField.TT_LABEL, str2).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ms.ah(map))).ms(TTDownloadField.TT_META, lmVar.rm().toString())).xr(), Boolean.class)).booleanValue();
    }

    protected String xr(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || TextUtils.isEmpty(uri.getScheme())) ? "" : uri.getScheme().toLowerCase(Locale.US);
    }

    public void ms(final Intent intent) {
        final com.bytedance.sdk.openadsdk.core.jw.ms msVarD;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        lm lmVar = this.xr;
        if (lmVar == null || intent == null || this.d == null) {
            return;
        }
        h hVarTc = lmVar.tc();
        if (hVarTc != null && hVarTc.ah() == 2 && !hVarTc.ms() && com.bytedance.sdk.openadsdk.core.xr.ms().xr("dpl_reject_by_dialog", false)) {
            ul.ms(this.xr, this.ah);
        } else if (this.xr.gz() && (msVarD = ch.ub().d()) != null) {
            msVarD.ms(new com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ah.2
                @Override // com.bytedance.sdk.openadsdk.core.jw.ms.InterfaceC0293ms
                public void ms() {
                    if (System.currentTimeMillis() - jCurrentTimeMillis <= a.f) {
                        ah.this.xr(intent);
                    }
                    com.bytedance.sdk.openadsdk.core.jw.ms msVar = msVarD;
                    if (msVar != null) {
                        msVar.ah();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final Intent intent) {
        lm lmVar = this.xr;
        if (lmVar == null || this.d == null || intent == null) {
            return;
        }
        String strAh = lmVar.zh() != null ? this.xr.zh().ah() : "";
        com.bytedance.sdk.openadsdk.core.jw.c.ms(this.d, this.xr.df(), strAh, TextUtils.isEmpty(strAh) ? "是否立即打开应用" : "是否立即打开".concat(String.valueOf(strAh)), "立即打开", "退出", new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ah.3
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                HashMap map = new HashMap();
                map.put("source", "DeepLinkConverter");
                com.bytedance.sdk.openadsdk.core.zb.ah.x(ah.this.xr, ah.this.ah, "open_url_app", map);
                com.bytedance.sdk.component.utils.xr.ms(ah.this.d, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms.ah.3.1
                    @Override // com.bytedance.sdk.component.utils.xr.ms
                    public void ms() {
                        com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(ah.this.xr, ah.this.ah, false);
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.xr, ah.this.ah, "deeplink_success_realtime", (Throwable) null);
                    }

                    @Override // com.bytedance.sdk.component.utils.xr.ms
                    public void ms(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.xr, ah.this.ah, "deeplink_fail_realtime", th);
                    }
                }, TextUtils.equals("main", UMModuleRegister.INNER));
            }
        });
    }

    private String ah(String str) {
        lm lmVar;
        com.bytedance.sdk.openadsdk.core.nw.f fVarDm;
        if (TextUtils.isEmpty(str) || (lmVar = this.xr) == null || !xn.ms(lmVar) || (fVarDm = this.xr.dm()) == null) {
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

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(Map<String, Object> map) {
        Object objValueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean boolMs = ms(jSONObject);
            boolean z = true;
            try {
                if (boolMs == null || !boolMs.booleanValue()) {
                    h hVarMs = ms();
                    if (hVarMs == null) {
                        hVarMs = this.xr.tc();
                    }
                    if (hVarMs == null || TextUtils.isEmpty(hVarMs.xr())) {
                        try {
                            jSONObject.putOpt("dpl_null", Boolean.TRUE);
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar = this.f3130ms;
                        z = msVar != null && msVar.ms(map);
                        jSONObject.putOpt("uchain", Boolean.TRUE);
                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xr.ku()));
                        jSONObject.putOpt("req_id", this.xr.eu());
                        objValueOf = Boolean.valueOf(this.xr.ms());
                    } else {
                        String strXr = hVarMs.xr();
                        Boolean boolMs2 = ms(map, strXr, jSONObject);
                        try {
                            jSONObject.putOpt("dpl_result", boolMs2);
                            jSONObject.putOpt("url", strXr);
                        } catch (Exception unused2) {
                        }
                        if (hVarMs.ka() != 2 || this.hi == null || this.ab || (boolMs2 != null && boolMs2.booleanValue())) {
                            if (boolMs2 != null && !this.ab) {
                                boolean zBooleanValue = boolMs2.booleanValue();
                                try {
                                    jSONObject.putOpt("uchain", Boolean.TRUE);
                                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xr.ku()));
                                    jSONObject.putOpt("req_id", this.xr.eu());
                                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.xr.ms()));
                                } catch (Exception unused3) {
                                }
                                u.ms().ms("open_detail_page", "native", 0, jSONObject);
                                return zBooleanValue;
                            }
                            if (!this.ab || (boolMs2 != null && boolMs2.booleanValue())) {
                                try {
                                    jSONObject.putOpt("uchain", Boolean.TRUE);
                                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xr.ku()));
                                    jSONObject.putOpt("req_id", this.xr.eu());
                                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.xr.ms()));
                                } catch (Exception unused4) {
                                }
                                u.ms().ms("open_detail_page", "native", 0, jSONObject);
                                return false;
                            }
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xr.ku()));
                                jSONObject.putOpt("req_id", this.xr.eu());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.xr.ms()));
                            } catch (Exception unused5) {
                            }
                            u.ms().ms("open_detail_page", "native", 0, jSONObject);
                            com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms msVar2 = this.f3130ms;
                            return msVar2 != null && msVar2.ms(map);
                        }
                        this.hi.d(false);
                        this.hi.ms(this.xr, com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms(map));
                        jSONObject.putOpt("uchain", Boolean.TRUE);
                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xr.ku()));
                        jSONObject.putOpt("req_id", this.xr.eu());
                        objValueOf = Boolean.valueOf(this.xr.ms());
                    }
                } else {
                    try {
                        jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    } catch (Exception unused6) {
                    }
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xr.ku()));
                    jSONObject.putOpt("req_id", this.xr.eu());
                    objValueOf = Boolean.valueOf(this.xr.ms());
                }
                jSONObject.putOpt("web_meta", objValueOf);
            } catch (Exception unused7) {
            }
            u.ms().ms("open_detail_page", "native", 0, jSONObject);
            return z;
        } catch (Throwable th) {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xr.ku()));
                jSONObject.putOpt("req_id", this.xr.eu());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.xr.ms()));
            } catch (Exception unused8) {
            }
            u.ms().ms("open_detail_page", "native", 0, jSONObject);
            throw th;
        }
    }
}
