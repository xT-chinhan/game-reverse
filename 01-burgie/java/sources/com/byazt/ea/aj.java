package com.byazt.ea;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.byazt.ch.g;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 61})
public class aj implements lb {
    public com.byazt.nc.hn.pr hn;
    public com.byazt.ik.hn<View> hw;
    public Context pr;

    public aj(Context context) {
        this.pr = context;
    }

    public void pr(com.byazt.nc.hn.pr prVar) {
        this.hn = prVar;
    }

    public void pr(final JSONObject jSONObject, final JSONObject jSONObject2, final com.byazt.sa.fw fwVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw(jSONObject, jSONObject2, fwVar);
        } else {
            com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.ea.aj.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.this.hw(jSONObject, jSONObject2, fwVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.sa.fw fwVar) {
        ho hoVar = new ho(this.pr);
        g gVar = new g();
        gVar.pr(this.pr);
        hoVar.pr("ugen_download_dialog", gVar);
        com.byazt.ik.hn<View> hnVarPr = hoVar.pr(jSONObject);
        this.hw = hnVarPr;
        if (hnVarPr != null) {
            hoVar.pr(this);
            hoVar.hw(jSONObject2);
        }
        if (fwVar == null) {
            return;
        }
        com.byazt.ik.hn<View> hnVar = this.hw;
        if (hnVar == null) {
            fwVar.pr(-1, "UGenWidget is null");
        } else {
            fwVar.pr(hnVar);
        }
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
                this.hn.c(null);
                break;
            case "closeDialog":
                this.hn.hn(null);
                break;
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
    }
}
