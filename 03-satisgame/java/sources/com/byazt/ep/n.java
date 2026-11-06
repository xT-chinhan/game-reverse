package com.byazt.ep;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.vh.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.constants.BundleKey;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 19})
public class n implements cd, wo.n, qg {
    public pk l;
    public com.byazt.ih.s<View> n;
    public com.byazt.gcl.s q;
    public Context qg;
    public com.byazt.mr.x.n s;
    public com.byazt.ozc.x x;
    public AtomicBoolean fs = new AtomicBoolean(false);
    public final t w = new t(Looper.getMainLooper(), this);

    @Override // com.byazt.vh.cd
    public void n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
    }

    public n(Context context, pk pkVar) {
        this.qg = context;
        this.l = pkVar;
    }

    public void n(com.byazt.mr.x.n nVar) {
        this.s = nVar;
    }

    @Override // com.byazt.vh.cd
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
        JSONObject jSONObjectS;
        if (cyVar == null || this.s == null) {
            return;
        }
        if (cyVar.qg() != 1 || (jSONObjectS = cyVar.s()) == null) {
        }
        String strOptString = jSONObjectS.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.s.qg(null);
                break;
            case "openAppFunctionDesc":
                this.s.n();
                break;
            case "closeDialog":
                this.s.s(null);
                break;
            case "downloadEvent":
                this.s.n(null);
                break;
            case "openAppPolicy":
                this.s.q(null);
                break;
        }
    }

    public void n(final JSONObject jSONObject, final JSONObject jSONObject2, final com.byazt.ozc.x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(jSONObject, jSONObject2, xVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.ep.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.qg(jSONObject, jSONObject2, xVar);
                }
            });
        }
    }

    private JSONObject n(JSONObject jSONObject) {
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
            jSONObject2.put(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, jSONObjectOptJSONObject.opt(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL));
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
    public void qg(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ozc.x xVar) {
        this.x = xVar;
        k kVar = new k(this.qg);
        sz szVar = new sz();
        szVar.n(this.qg);
        HashMap map = new HashMap();
        com.byazt.gcl.s sVar = new com.byazt.gcl.s(this.qg);
        this.q = sVar;
        sVar.n(this.s);
        this.q.n(this);
        this.q.qg(n(jSONObject2));
        String strQg = com.byazt.vgx.w.qg(this.l);
        this.q.s(com.byazt.vgx.w.q(strQg));
        this.q.n(strQg);
        map.put("key_js_object", this.q);
        map.put("key_material", this.l);
        szVar.qg(jSONObject2);
        szVar.qg(map);
        kVar.n("easy_dl_dialog", szVar);
        com.byazt.ih.s<View> sVarN = kVar.n(jSONObject);
        this.n = sVarN;
        if (sVarN == null) {
            com.byazt.ozc.x xVar2 = this.x;
            if (xVar2 != null) {
                xVar2.n(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        kVar.n(this);
        kVar.qg(jSONObject2);
        t tVar = this.w;
        if (tVar != null) {
            tVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private void qg() {
        t tVar = this.w;
        if (tVar == null) {
            return;
        }
        tVar.removeMessages(1);
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message == null || message.what != 1 || this.fs.get()) {
            return;
        }
        if (this.x != null) {
            this.fs.set(true);
            this.x.n(10, "load time out");
        }
        qg();
    }

    @Override // com.byazt.ep.qg
    public void n() {
        qg();
        if (this.fs.get() || this.x == null) {
            return;
        }
        this.fs.set(true);
        this.x.n(this.n);
    }

    @Override // com.byazt.ep.qg
    public void n(int i, String str) {
        qg();
        if (this.fs.get() || this.x == null) {
            return;
        }
        this.fs.set(true);
        this.x.n(i, str);
    }
}
