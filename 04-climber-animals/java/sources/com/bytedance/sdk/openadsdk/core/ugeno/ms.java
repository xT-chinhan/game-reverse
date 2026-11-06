package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.adsdk.ugeno.ah.hi;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ub, le.ms, xr {
    private com.bytedance.sdk.openadsdk.core.ugeno.ab.ab ab;
    private com.bytedance.sdk.openadsdk.core.widget.ab.ms ah;
    private pc d;
    private lm ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xr.ah<View> f3557ms;
    private Context xr;
    private AtomicBoolean x = new AtomicBoolean(false);
    private final le c = new le(Looper.getMainLooper(), this);

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
    }

    public ms(Context context, lm lmVar) {
        this.xr = context;
        this.ka = lmVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.widget.ab.ms msVar) {
        this.ah = msVar;
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        JSONObject jSONObjectAh;
        if (zbVar == null || this.ah == null) {
            return;
        }
        if (zbVar.xr() != 1 || (jSONObjectAh = zbVar.ah()) == null) {
        }
        String strOptString = jSONObjectAh.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.ah.xr(null);
                break;
            case "openAppFunctionDesc":
                this.ah.ms();
                break;
            case "closeDialog":
                this.ah.ah(null);
                break;
            case "downloadEvent":
                this.ah.ms(null);
                break;
            case "openAppPolicy":
                this.ah.d(null);
                break;
        }
    }

    public void ms(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr(jSONObject, jSONObject2, abVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.xr(jSONObject, jSONObject2, abVar);
                }
            });
        }
    }

    private JSONObject ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_dl_dialog")) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("app_name", jSONObjectOptJSONObject.opt("app_name"));
            jSONObject2.put("app_version", jSONObjectOptJSONObject.opt("app_version"));
            jSONObject2.put("developer_name", jSONObjectOptJSONObject.opt("developer_name"));
            jSONObject2.put("package_name", jSONObjectOptJSONObject.opt("package_name"));
            jSONObject2.put("score", jSONObjectOptJSONObject.opt("score"));
            jSONObject2.put("icon_url", jSONObjectOptJSONObject.opt("icon_url"));
            jSONObject2.put(BundleKey.DESCRIPTION, jSONObjectOptJSONObject.opt(BundleKey.DESCRIPTION));
            jSONObject2.put("creative_tags", jSONObjectOptJSONObject.opt("creative_tags"));
            jSONObject2.put("easy_pl_material", jSONObjectOptJSONObject.opt("easy_pl_material"));
            jSONObject3.put("ugen_download_dialog", jSONObject2);
            return jSONObject3;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar) {
        this.ab = abVar;
        sl slVar = new sl(this.xr);
        hi hiVar = new hi();
        hiVar.ms(this.xr);
        HashMap map = new HashMap();
        pc pcVar = new pc(this.xr);
        this.d = pcVar;
        pcVar.ms(this.ah);
        this.d.ms(this);
        this.d.xr(ms(jSONObject2));
        String strXr = f.xr(this.ka);
        this.d.ah(f.xr(strXr));
        this.d.ms(strXr);
        map.put("key_js_object", this.d);
        map.put("key_material", this.ka);
        hiVar.xr(jSONObject2);
        hiVar.ms(map);
        slVar.ms("easy_dl_dialog", hiVar);
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs = slVar.ms(jSONObject);
        this.f3557ms = ahVarMs;
        if (ahVarMs == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar2 = this.ab;
            if (abVar2 != null) {
                abVar2.ms(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        slVar.ms(this);
        slVar.xr(jSONObject2);
        le leVar = this.c;
        if (leVar != null) {
            leVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private void xr() {
        le leVar = this.c;
        if (leVar == null) {
            return;
        }
        leVar.removeMessages(1);
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message == null || message.what != 1 || this.x.get()) {
            return;
        }
        if (this.ab != null) {
            this.x.set(true);
            this.ab.ms(10, "load time out");
        }
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xr
    public void ms() {
        xr();
        if (this.x.get() || this.ab == null) {
            return;
        }
        this.x.set(true);
        this.ab.ms(this.f3557ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xr
    public void ms(int i, String str) {
        xr();
        if (this.x.get() || this.ab == null) {
            return;
        }
        this.x.set(true);
        this.ab.ms(i, str);
    }
}
