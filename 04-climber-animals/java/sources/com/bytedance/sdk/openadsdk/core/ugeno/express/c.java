package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.ah.ao;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.sdk.component.adexpress.xr.ab;
import com.bytedance.sdk.openadsdk.core.jw.p;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.rt;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.bv;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends d implements ms {
    private com.bytedance.adsdk.ugeno.xr.ah b;
    private hi i;
    private com.bytedance.adsdk.ugeno.xr.ah nw;
    private com.bytedance.adsdk.ugeno.xr.ah re;
    private com.bytedance.adsdk.ugeno.xr.ah t;
    private com.bytedance.adsdk.ugeno.xr.ah y;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d, com.bytedance.sdk.component.adexpress.dynamic.d
    public void ms(CharSequence charSequence, int i, int i2, boolean z) {
    }

    public c(Context context, lm lmVar, xr xrVar, ViewGroup viewGroup) {
        super(context, lmVar, xrVar, viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d
    protected JSONObject ms() {
        return this.ab.ka().optJSONObject("xTemplate");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d
    protected void xr(ab abVar) {
        u();
        this.f3502ms.ms((ub) this);
        this.f3502ms.ms((ao) this);
        rt rtVarPl = this.c.pl();
        try {
            if (rtVarPl != null) {
                this.ah = this.f3502ms.ms(this.d, this.ka, rtVarPl.ka());
            } else {
                this.ah = this.f3502ms.ms(this.d, this.ka, (JSONObject) null);
            }
            if (this.f3502ms.ms()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.f3502ms.xr()));
                this.ab.pc().ms(jSONObject);
                abVar.ms(138, "ugen unknown component");
                return;
            }
            if (this.ah != null) {
                com.bytedance.adsdk.ugeno.xr.ah<T> ahVarD = this.ah.d("RVCountdown");
                this.y = ahVarD;
                if (ahVarD == 0) {
                    this.y = this.ah.d("FVCountdown");
                }
                com.bytedance.adsdk.ugeno.xr.ah<T> ahVarD2 = this.ah.d("RVSkip");
                this.nw = ahVarD2;
                if (ahVarD2 == 0) {
                    this.nw = this.ah.d("FVSkip");
                }
                this.t = this.ah.d("CycleCountDownView");
                this.b = this.ah.d("RewardClickCountdown");
                this.re = this.ah.d("CycleSkip");
                if (this.qv == null) {
                    this.qv = new com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(this.ab.ka());
                }
                this.qv.ms(this.f3502ms, this.ah);
                this.qv.ms(this.y, this.nw, this.t, this.b, this.re);
            }
            this.ab.pc().xr();
            this.ab.pc().ah();
        } catch (NoClassDefFoundError unused) {
            if (abVar != null) {
                abVar.ms(140, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (abVar != null) {
                abVar.ms(139, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (abVar != null) {
                abVar.ms(141, "ugen other fail");
            }
        }
    }

    private void u() {
        com.bytedance.adsdk.ugeno.ah.hi hiVar = new com.bytedance.adsdk.ugeno.ah.hi();
        HashMap map = new HashMap();
        map.put("shake_value", Integer.valueOf(this.ab.qv()));
        map.put("calculation_method", Integer.valueOf(this.ab.i()));
        map.put("rotation_angle", Integer.valueOf(this.ab.t()));
        map.put("calculation_method_twist", Integer.valueOf(this.ab.w()));
        map.put("twist_config", this.ab.nw());
        map.put("image_info", this.ab.u());
        map.put("cache_dir", this.ab.h());
        map.put("shake_interact_conf", this.ab.b());
        map.put("twist_interact_conf", this.ab.re());
        hiVar.ms(map);
        hiVar.ms(this.xr);
        hiVar.ms(this.d);
        hiVar.xr(this.ka);
        this.f3502ms.ms(bv.aw, hiVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d
    protected com.bytedance.adsdk.ugeno.xr.ah ka() {
        if (this.ah == null) {
            return null;
        }
        return this.ah.d("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d
    protected JSONObject ch() {
        return this.ab.ka();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d, com.bytedance.adsdk.ugeno.ah.ub
    public void ms(final com.bytedance.adsdk.ugeno.xr.ah ahVar, final String str, final com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
        if (msVar == null) {
            return;
        }
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            if (this.zb == null || this.zb.get() == null) {
                return;
            }
            p.ms(this.zb, new com.bytedance.sdk.openadsdk.core.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.c.1
                @Override // com.bytedance.sdk.openadsdk.core.xr.ah
                public void ms() {
                    if (c.this.zb == null || c.this.zb.get() == null || !p.ms(c.this.zb.get())) {
                        return;
                    }
                    c.this.xr(ahVar, str, msVar);
                }
            });
            return;
        }
        xr(ahVar, str, msVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
        CharSequence text;
        String strXr = msVar.xr();
        if (com.bytedance.sdk.openadsdk.core.ugeno.express.ms.ms.f3511ms.contains(strXr)) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.ms.ms.ms(this.i, this.c, strXr, msVar);
            return;
        }
        strXr.hashCode();
        int i = 5;
        switch (strXr) {
            case "openAppPermission":
                i = 10;
                break;
            case "openCommonUrl":
                i = 13;
                break;
            case "openPrivacy":
                i = 7;
                break;
            case "resumeVideo":
                hi hiVar = this.i;
                if (hiVar != null) {
                    hiVar.ms(3);
                    return;
                }
                return;
            case "pauseVideo":
                hi hiVar2 = this.i;
                if (hiVar2 != null) {
                    hiVar2.ms(2);
                    return;
                }
                return;
            case "skip":
                i = 6;
                break;
            case "close":
                i = 8;
                break;
            case "openAppFunction":
                i = 12;
                break;
            case "videoControl":
                i = 4;
                break;
            case "convert":
                i = 2;
                break;
            case "muteVideo":
                break;
            case "openAppPolicy":
                i = 9;
                break;
            case "dislike":
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        i.ms msVarMs = new i.ms().d(this.sl.u()).ah(this.sl.ub()).xr(this.sl.ao()).ms(this.sl.h()).ms(ahVar.of()).xr(this.sl.sl()).ms(this.sl.zb());
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            try {
                jSONObject.put("convertActionType", 1);
            } catch (Throwable unused) {
            }
        }
        try {
            String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(msVar.ah().getOrDefault(TTDownloadField.TT_WEB_URL, ""), ch());
            String strMs2 = com.bytedance.adsdk.ugeno.d.xr.ms(msVar.ah().getOrDefault(TTDownloadField.TT_WEB_TITLE, ""), ch());
            jSONObject.put("openCommonWebUrl", strMs);
            jSONObject.put("openCommonWebTitle", strMs2);
        } catch (JSONException unused2) {
        }
        View viewNy = ahVar.ny();
        try {
            if ((viewNy instanceof TextView) && (text = ((TextView) viewNy).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused3) {
        }
        msVarMs.ms(jSONObject);
        i iVarMs = msVarMs.ms();
        if (this.ny != null) {
            this.ny.ms(viewNy, i, iVarMs);
        }
    }

    public void ms(String str, Map<String, String> map) {
        if (this.ah == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.ka.c.ms msVar = new com.bytedance.adsdk.ugeno.ka.c.ms();
        msVar.ms("custom");
        msVar.xr("emit");
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put(Common.System.NAME, str);
        msVar.ms(map2);
        com.bytedance.adsdk.ugeno.ka.xr.ms.C0195ms.ms(this.ah, "jsb", msVar).ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.ms
    public void ms(hi hiVar) {
        this.i = hiVar;
    }
}
