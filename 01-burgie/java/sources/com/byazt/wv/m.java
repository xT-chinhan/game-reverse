package com.byazt.wv;

import android.app.Activity;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 108})
public class m extends pr {
    public pr yb;

    public m(Activity activity, of ofVar) {
        super(activity, ofVar);
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(vk vkVar) {
        ArrayList<pj> arrayListA = jn.a(this.fw);
        if (arrayListA == null) {
            return new hw.pr(false, 0, "");
        }
        for (pj pjVar : arrayListA) {
            switch (pjVar.hn()) {
                case 1:
                    this.yb = new k(this.zo, this.fw, pjVar);
                    break;
                case 2:
                    this.yb = new w(this.zo, this.fw, pjVar);
                    break;
                case 3:
                    this.yb = new uc(this.zo, this.fw, pjVar);
                    break;
                case 4:
                    this.yb = new fw(this.zo, this.fw, pjVar);
                    break;
                case 5:
                    this.yb = new aj(this.zo, this.fw, pjVar);
                    break;
                case 6:
                    this.yb = new x(this.zo, this.fw, pjVar);
                    break;
            }
            pr prVar = this.yb;
            if (prVar != null) {
                prVar.pr(this.hn);
                this.yb.pr(this.pr);
                this.yb.hw(this.hw);
                this.yb.hw(this.x);
                this.yb.hn(this.k);
                this.yb.x(this.w);
                this.yb.hn(this.uc);
                this.yb.x(this.c);
                this.yb.pr(this.nt);
                this.yb.hw(zo());
                hw.pr prVarHw = this.yb.hw(vkVar);
                if (prVarHw.hn()) {
                    return prVarHw;
                }
            }
        }
        return new hw.pr(false, 0, "");
    }

    @Override // com.byazt.wv.hw
    public void hw(String str) {
        super.hw(str);
        pr prVar = this.yb;
        if (prVar == null) {
            return;
        }
        prVar.hw(str);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        pr prVar = this.yb;
        if (prVar == null) {
            return null;
        }
        String strPr = prVar.pr();
        try {
            JSONObject jSONObject = new JSONObject(strPr);
            jSONObject.put("is_need_click", this.c);
            return jSONObject.toString();
        } catch (JSONException e) {
            return strPr;
        }
    }
}
