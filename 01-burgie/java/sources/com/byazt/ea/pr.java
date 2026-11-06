package com.byazt.ea;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.byazt.ca.iu;
import com.byazt.ch.g;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.hg.of;
import com.byazt.sd.nl;
import com.byazt.vkw.qi;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 37})
public class pr implements lb, qi.pr, hw {
    public of c;
    public com.byazt.sa.fw fw;
    public com.byazt.nc.fw.pr hn;
    public Context hw;
    public com.byazt.ik.hn<View> pr;
    public nl x;
    public AtomicBoolean zo = new AtomicBoolean(false);
    public final iu uc = new iu(Looper.getMainLooper(), this);

    public pr(Context context, of ofVar) {
        this.hw = context;
        this.c = ofVar;
    }

    public void pr(com.byazt.nc.fw.pr prVar) {
        this.hn = prVar;
    }

    @Override // com.byazt.ch.lb
    public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        JSONObject jSONObjectHn;
        if (ntVar == null || this.hn == null) {
            return;
        }
        if (ntVar.hw() != 1 || (jSONObjectHn = ntVar.hn()) == null) {
        }
        switch (jSONObjectHn.optString("type")) {
            case "downloadEvent":
                this.hn.pr(null);
                break;
            case "openAppPermission":
                this.hn.hw(null);
                break;
            case "openAppPolicy":
                this.hn.x(null);
                break;
            case "openAppFunctionDesc":
                this.hn.pr();
                break;
            case "closeDialog":
                this.hn.hn(null);
                break;
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
    }

    public void pr(final JSONObject jSONObject, final JSONObject jSONObject2, final com.byazt.sa.fw fwVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw(jSONObject, jSONObject2, fwVar);
        } else {
            com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.ea.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.hw(jSONObject, jSONObject2, fwVar);
                }
            });
        }
    }

    private JSONObject pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_dl_dialog")) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, jSONObjectOptJSONObject.opt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
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
    public void hw(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.sa.fw fwVar) {
        this.fw = fwVar;
        ho hoVar = new ho(this.hw);
        g gVar = new g();
        gVar.pr(this.hw);
        HashMap map = new HashMap();
        nl nlVar = new nl(this.hw);
        this.x = nlVar;
        nlVar.pr(this.hn);
        this.x.pr(this);
        this.x.hw(pr(jSONObject2));
        String strHw = ls.hw(this.c);
        this.x.hn(ls.x(strHw));
        this.x.pr(strHw);
        map.put("key_js_object", this.x);
        map.put("key_material", this.c);
        gVar.hw(jSONObject2);
        gVar.pr(map);
        hoVar.pr("easy_dl_dialog", gVar);
        com.byazt.ik.hn<View> hnVarPr = hoVar.pr(jSONObject);
        this.pr = hnVarPr;
        if (hnVarPr == null) {
            com.byazt.sa.fw fwVar2 = this.fw;
            if (fwVar2 != null) {
                fwVar2.pr(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        hoVar.pr(this);
        hoVar.hw(jSONObject2);
        iu iuVar = this.uc;
        if (iuVar != null) {
            iuVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private void hw() {
        iu iuVar = this.uc;
        if (iuVar == null) {
            return;
        }
        iuVar.removeMessages(1);
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        if (message == null || message.what != 1 || this.zo.get()) {
            return;
        }
        if (this.fw != null) {
            this.zo.set(true);
            this.fw.pr(10, "load time out");
        }
        hw();
    }

    @Override // com.byazt.ea.hw
    public void pr() {
        hw();
        if (!this.zo.get() && this.fw != null) {
            this.zo.set(true);
            this.fw.pr(this.pr);
        }
    }

    @Override // com.byazt.ea.hw
    public void pr(int i, String str) {
        hw();
        if (!this.zo.get() && this.fw != null) {
            this.zo.set(true);
            this.fw.pr(i, str);
        }
    }
}
