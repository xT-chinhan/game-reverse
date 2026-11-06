package com.byazt.aqe;

import android.app.Activity;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends n {
    public n hd;

    public oa(Activity activity, pk pkVar) {
        super(activity, pkVar);
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        ArrayList<ry> arrayListA = cx.a(this.x);
        if (arrayListA == null) {
            return new qg.n(false, 0, "");
        }
        for (ry ryVar : arrayListA) {
            switch (ryVar.s()) {
                case 1:
                    this.hd = new d(this.fs, this.x, ryVar);
                    break;
                case 2:
                    this.hd = new cp(this.fs, this.x, ryVar);
                    break;
                case 3:
                    this.hd = new w(this.fs, this.x, ryVar);
                    break;
                case 4:
                    this.hd = new x(this.fs, this.x, ryVar);
                    break;
                case 5:
                    this.hd = new rv(this.fs, this.x, ryVar);
                    break;
                case 6:
                    this.hd = new q(this.fs, this.x, ryVar);
                    break;
            }
            n nVar = this.hd;
            if (nVar != null) {
                nVar.n(this.s);
                this.hd.n(this.n);
                this.hd.qg(this.qg);
                this.hd.qg(this.q);
                this.hd.s(this.d);
                this.hd.q(this.cp);
                this.hd.s(this.w);
                this.hd.q(this.l);
                this.hd.n(this.cy);
                this.hd.qg(fs());
                qg.n nVarQg = this.hd.qg(tjVar);
                if (nVarQg.s()) {
                    return nVarQg;
                }
            }
        }
        return new qg.n(false, 0, "");
    }

    @Override // com.byazt.aqe.qg
    public void qg(String str) {
        super.qg(str);
        n nVar = this.hd;
        if (nVar == null) {
            return;
        }
        nVar.qg(str);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        n nVar = this.hd;
        if (nVar == null) {
            return null;
        }
        String strN = nVar.n();
        try {
            JSONObject jSONObject = new JSONObject(strN);
            jSONObject.put("is_need_click", this.l);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return strN;
        }
    }
}
