package com.byazt.gox;

import com.byazt.ec.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 20})
public class hn extends hw {
    public hn(x xVar) {
        super(xVar);
    }

    @Override // com.byazt.gox.hw
    public long pr() {
        return this.pr.hn().zo() + 21600000;
    }

    @Override // com.byazt.gox.hw
    public long[] hw() {
        return c.hn;
    }

    @Override // com.byazt.gox.hw
    public boolean hn() throws JSONException {
        JSONObject jSONObjectPr = this.pr.x().pr();
        if (this.pr.x().k() != 0 && jSONObjectPr != null && this.pr.hn().zo() + 21600000 <= System.currentTimeMillis()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", jSONObjectPr);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject jSONObjectHw = com.byazt.yj.pr.hw(com.byazt.yj.pr.pr(com.byazt.yj.hw.pr(this.pr.getContext(), this.pr.x().pr(), this.pr.fw().hn(), true, com.byazt.zrg.pr.x()), com.byazt.yj.pr.hn), jSONObject);
            com.byazt.zrg.pr.k().pr(!g.pr(jSONObjectHw, this.pr.hn().fw()), jSONObjectHw);
            if (jSONObjectHw != null) {
                this.pr.hn().pr(jSONObjectHw);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.byazt.gox.hw
    public String x() {
        return an.aF;
    }
}
