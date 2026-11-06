package com.byazt.xwj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.llp.tj;
import com.byazt.tk.hd;
import com.byazt.vgx.w;
import com.byazt.wr.s;
import com.bykv.vk.component.ttvideo.player.C;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1367, 19})
public class n implements com.byazt.wj.n {
    public final tj cp;
    public final JSONObject d;
    public com.byazt.zx.qg fs;
    public final String l;
    public boolean q;
    public final Context qg;
    public Map<String, Object> rv;
    public Map<String, Object> tj;
    public final int w;
    public String x;
    public boolean n = false;
    public final Map<String, Object> s = new HashMap();

    public n(tj tjVar, Context context, String str, int i, Map<String, Object> map, Map<String, Object> map2, JSONObject jSONObject) {
        this.cp = tjVar;
        this.qg = context;
        this.l = str;
        this.w = i;
        this.rv = map;
        this.tj = map2;
        this.d = jSONObject;
    }

    @Override // com.byazt.wj.n
    public boolean n(Map<String, Object> map) {
        tj tjVar = this.cp;
        if (tjVar == null) {
            com.byazt.ukb.qg.n(this.rv, s.q);
            return false;
        }
        return n(com.byazt.ukb.n.n(this.n, com.byazt.ukb.qg.n(tjVar, this.rv), this.q, this.s));
    }

    public void n(com.byazt.zx.qg qgVar) {
        this.fs = qgVar;
    }

    public boolean n(Class cls) {
        this.n = false;
        com.byazt.eji.s.n().n("landing_page", "native", 0, n());
        if (this.cp.rv() == 2) {
            return qg(this.cp.fs());
        }
        if (this.fs != null && new qg(this.fs).n(new HashMap())) {
            return true;
        }
        Intent intent = new Intent(this.qg, (Class<?>) cls);
        if (!(this.qg instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", this.cp.x());
        n(intent);
        com.byazt.tk.n.n(this.qg, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.xwj.n.1
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
                n.this.rv.put("is_open_web_page", Boolean.TRUE);
            }
        });
        return true;
    }

    private JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.cp.F_());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.cp.l()));
            jSONObject.putOpt("req_id", this.cp.ou());
            jSONObject.putOpt("uchain", Boolean.TRUE);
            jSONObject.putOpt("uchain_old", Boolean.TRUE);
            jSONObject.putOpt("interaction_type", Integer.valueOf(this.cp.rv()));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean qg(String str) {
        if (!hd.n(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(this.qg instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.tk.n.n(this.qg, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void n(String str) {
        this.x = str;
    }

    private void n(Intent intent) {
        if (this.cp == null) {
            return;
        }
        Map<String, Object> map = this.rv;
        if (map != null) {
            this.s.putAll(map);
        }
        Map<String, Object> map2 = this.tj;
        if (map2 != null) {
            this.s.putAll(map2);
        }
        this.s.remove("context");
        if (TextUtils.isEmpty(this.x)) {
            this.x = this.cp.fs();
        }
        this.s.put(ImagesContract.URL, this.x);
        this.s.put("gecko_id", this.cp.s());
        this.s.put("web_title", this.cp.E_());
        this.s.put("sdk_version", Integer.valueOf(com.byazt.nf.tj.l));
        this.s.put("adid", this.cp.q());
        this.s.put("log_extra", this.cp.F_());
        this.s.put(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, this.cp.qg());
        this.s.put("event_tag", this.l);
        int i = this.w;
        int i2 = -1;
        if (i != -1) {
            this.s.put("landing_page_source", Integer.valueOf(i));
        }
        this.s.put("is_outer_click", Boolean.TRUE);
        tj tjVar = this.cp;
        if (tjVar instanceof pk) {
            w.n(this.s, (pk) tjVar);
        } else {
            JSONObject jSONObject = this.d;
            if (jSONObject != null) {
                w.n(this.s, jSONObject, tjVar.py());
            }
        }
        Object objRemove = this.s.remove("landing_page_source");
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i2 = Integer.parseInt(objRemove.toString());
            } catch (Exception unused) {
            }
        }
        intent.putExtra("landing_page_source", i2);
        for (Map.Entry<String, Object> entry : this.s.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && !"log_extra".equals(key)) {
                intent.putExtra(key, value.toString());
            }
        }
        intent.putExtra("web_dl_factors", com.byazt.ukb.qg.qg(this.rv));
    }
}
