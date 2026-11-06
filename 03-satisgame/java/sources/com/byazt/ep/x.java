package com.byazt.ep;

import android.content.Context;
import com.byazt.tk.ou;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 21})
public class x implements com.byazt.uy.q.n {
    public ou n;
    public com.byazt.ih.s qg;

    public x(Context context, com.byazt.ih.s sVar) {
        this.n = new ou(context, 1, com.byazt.vyf.s.cy().q());
        this.qg = sVar;
    }

    private int s() {
        JSONObject jSONObjectTj;
        com.byazt.ih.s sVar = this.qg;
        if (sVar == null || (jSONObjectTj = sVar.tj()) == null) {
            return 0;
        }
        return jSONObjectTj.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.uy.q.n
    public void n() {
        ou ouVar = this.n;
        if (ouVar != null) {
            ouVar.n(s());
        }
    }

    @Override // com.byazt.uy.q.n
    public void qg() {
        ou ouVar = this.n;
        if (ouVar != null) {
            ouVar.qg(s());
        }
    }

    @Override // com.byazt.uy.q.n
    public void n(float f) {
        ou ouVar = this.n;
        if (ouVar != null) {
            ouVar.n(f);
        }
    }

    @Override // com.byazt.uy.q.n
    public void n(final com.byazt.uy.q.qg qgVar) {
        ou ouVar = this.n;
        if (ouVar != null) {
            ouVar.n(new ou.n() { // from class: com.byazt.ep.x.1
                @Override // com.byazt.tk.ou.n
                public void n(int i) {
                    com.byazt.uy.q.qg qgVar2 = qgVar;
                    if (qgVar2 != null) {
                        qgVar2.n(i);
                    }
                }
            });
        }
    }
}
