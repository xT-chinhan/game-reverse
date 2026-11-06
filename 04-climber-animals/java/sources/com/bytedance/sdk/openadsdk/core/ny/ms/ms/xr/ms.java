package com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ny;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms {
    private String ab;
    private lm ah;
    private boolean c;
    private String ch;
    private Object d;
    private com.bytedance.sdk.openadsdk.core.video.xr.xr hi;
    private Map<String, Object> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3152ms = false;
    private boolean ny = false;
    private int x;
    private Context xr;

    public ms(lm lmVar, Context context, String str, int i) {
        this.ah = lmVar;
        this.xr = context;
        this.ab = str;
        this.x = i;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar) {
        this.hi = xrVar;
    }

    public void ms(boolean z) {
        this.f3152ms = z;
    }

    public void xr(boolean z) {
        this.c = z;
    }

    public void ah(boolean z) {
        this.ny = z;
    }

    public Class<?> ms() {
        boolean z = this.f3152ms;
        this.f3152ms = false;
        if (this.d instanceof ny) {
            if (ch.c(this.ah)) {
                return TTNativePageActivity.class;
            }
            return TTWebPageActivity.class;
        }
        if (lm.xr(this.ah) && !z && !ms(this.d) && f.ka(this.ah)) {
            if (ch.c(this.ah)) {
                return TTNativePageActivity.class;
            }
            lm lmVar = this.ah;
            if (lmVar != null && lmVar.ab()) {
                return TTWebPageActivity.class;
            }
            return xr(TTVideoWebPageActivity.class);
        }
        if (ch.c(this.ah)) {
            return TTNativePageActivity.class;
        }
        return TTWebPageActivity.class;
    }

    private static boolean ms(Object obj) {
        if (obj == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms)) {
            return false;
        }
        try {
            return ((com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms) obj).m_();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void xr(Map<String, Object> map) {
        this.ka = map;
    }

    public boolean ms(Class cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.ah.lx());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.ah.ku()));
            jSONObject.putOpt("req_id", this.ah.eu());
            jSONObject.putOpt("uchain", Boolean.TRUE);
            jSONObject.putOpt("uchain_old", Boolean.TRUE);
            jSONObject.putOpt("interaction_type", Integer.valueOf(this.ah.jr()));
        } catch (JSONException unused) {
        }
        u.ms().ms("landing_page", "native", 0, jSONObject);
        if (this.ah.jr() == 2) {
            return xr(this.ah.ir());
        }
        if (this.hi != null && new xr(this.hi).ms(new HashMap())) {
            return true;
        }
        Intent intent = new Intent(this.xr, (Class<?>) cls);
        if (!(this.xr instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("has_phone_num_status", this.ah.ah());
        xr();
        if (this.ka == null) {
            this.ka = new HashMap();
        }
        for (Map.Entry<String, Object> entry : this.ka.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.xr.ms(this.xr, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.ms.1
            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms() {
            }

            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms(Throwable th) {
            }
        });
        return true;
    }

    private boolean xr(String str) {
        if (!com.bytedance.sdk.component.utils.u.ms(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(this.xr instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.bytedance.sdk.component.utils.xr.ms(this.xr, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void ms(String str) {
        this.ch = str;
    }

    private void xr() {
        if (this.ny && this.ah != null) {
            if (this.ka == null) {
                this.ka = new HashMap();
            }
            if (TextUtils.isEmpty(this.ch)) {
                this.ch = this.ah.ir();
            }
            this.ka.put("url", this.ch);
            this.ka.put("gecko_id", this.ah.so());
            this.ka.put("web_title", this.ah.eh());
            this.ka.put("sdk_version", Integer.valueOf(g.xr));
            this.ka.put("adid", this.ah.df());
            this.ka.put("log_extra", this.ah.lx());
            this.ka.put("icon_url", this.ah.qd() == null ? null : this.ah.qd().ms());
            this.ka.put("event_tag", this.ab);
            this.ka.put("source", Integer.valueOf(this.x));
            this.ka.put("is_outer_click", Boolean.TRUE);
            f.ms(this.ka, this.ah);
        }
    }

    private com.bytedance.sdk.openadsdk.core.multipro.xr.ms ah() {
        Object obj;
        if (!lm.xr(this.ah) || (obj = this.d) == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVarR_ = obj instanceof com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms ? ((com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms) obj).r_() : null;
        if (msVarR_ != null) {
            this.ka.put("multi_process_data", msVarR_.ms().toString());
        }
        Object obj2 = this.d;
        if (!(obj2 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.xr)) {
            return msVarR_;
        }
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVarHi = ((com.bytedance.sdk.openadsdk.core.nativeexpress.xr) obj2).hi();
        if (msVarHi != null) {
            this.ka.put("multi_process_data", msVarHi.ms().toString());
        }
        return msVarHi;
    }

    private Class xr(Class cls) {
        int i;
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVarAh = ah();
        if (msVarAh != null) {
            this.ka.put("video_is_auto_play", Boolean.valueOf(msVarAh.d));
        }
        if (!TTVideoWebPageActivity.class.equals(cls)) {
            return cls;
        }
        if (msVarAh == null && !this.c) {
            return cls;
        }
        try {
            if (msVarAh != null) {
                i = (int) ((msVarAh.ab / msVarAh.ka) * 100.0f);
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
                msVar.ab = 100L;
                msVar.f2932ms = true;
                msVar.d = f.nw(this.ah);
                this.ka.put("multi_process_data", msVar.ms().toString());
                i = 100;
            }
            if (this.ah.jj() == 0) {
                return TTVideoScrollWebPageActivity.class;
            }
            return (this.ah.jj() <= 0 || i <= this.ah.jj() || !f.nw(this.ah)) ? cls : TTVideoScrollWebPageActivity.class;
        } catch (Throwable unused) {
            return cls;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ny.ms.ms.ms
    public boolean ms(Map<String, Object> map) {
        if (this.ah == null) {
            return false;
        }
        return ms((Class) ms());
    }
}
