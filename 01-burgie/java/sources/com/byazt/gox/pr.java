package com.byazt.gox;

import com.byazt.ec.g;
import com.byazt.ec.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 37})
public class pr extends hw {
    public long hw;

    public pr(x xVar) {
        super(xVar);
    }

    @Override // com.byazt.gox.hw
    public long pr() {
        long jLb = this.pr.hn().lb();
        if (jLb < 600000) {
            jLb = 600000;
        }
        return this.hw + jLb;
    }

    @Override // com.byazt.gox.hw
    public long[] hw() {
        return c.hn;
    }

    @Override // com.byazt.gox.hw
    public boolean hn() throws JSONException {
        JSONObject jSONObjectPr = this.pr.x().pr();
        if (this.pr.x().k() != 0 && jSONObjectPr != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.pr.x().pr());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", jCurrentTimeMillis);
            JSONObject jSONObjectHn = com.byazt.yj.pr.hn(com.byazt.yj.pr.pr(com.byazt.yj.hw.pr(this.pr.getContext(), this.pr.x().pr(), this.pr.fw().x(), true, com.byazt.zrg.pr.x()), com.byazt.yj.pr.hn), jSONObject);
            if (jSONObjectHn != null) {
                com.byazt.zrg.pr.k().hw(!g.pr(com.byazt.zrg.pr.uc(), jSONObjectHn), jSONObjectHn);
                if (w.hw) {
                    w.pr("getAbConfig ".concat(String.valueOf(jSONObjectHn)), null);
                }
                this.pr.x().pr(jSONObjectHn);
                this.hw = jCurrentTimeMillis;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.byazt.gox.hw
    public String x() {
        return "ab";
    }
}
