package com.byazt.gox;

import android.text.TextUtils;
import com.byazt.ec.g;
import com.byazt.ec.w;
import com.byazt.xa.aj;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends hw {
    public boolean c;
    public static final long[] hw = {920000};
    public static final long[] hn = {920000};
    public static final long[] x = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    public c(x xVar) {
        super(xVar);
        this.c = true;
    }

    @Override // com.byazt.gox.hw
    public long pr() {
        return this.pr.x().m() + ((long) (this.pr.uc().hn() ? 21600000 : 43200000));
    }

    @Override // com.byazt.gox.hw
    public long[] hw() {
        switch (this.pr.x().k()) {
            case 0:
                return x;
            case 1:
                return hn;
            case 2:
                return hw;
            default:
                w.hw((Throwable) null);
                return hn;
        }
    }

    @Override // com.byazt.gox.hw
    public boolean hn() throws JSONException {
        JSONObject jSONObjectPr;
        JSONObject jSONObject = new JSONObject();
        aj ajVarX = this.pr.x();
        JSONObject jSONObjectPr2 = ajVarX.pr();
        JSONObject jSONObject2 = null;
        if (jSONObjectPr2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (ajVarX) {
                jSONObjectPr = g.pr(jSONObjectPr2);
            }
            jSONObject.put("header", jSONObjectPr);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(jSONObjectPr.optString("device_id")) && g.hn() && this.c) {
                this.c = false;
                return false;
            }
            JSONObject jSONObjectPr3 = this.pr.x().pr();
            com.byazt.yj.hn hnVarPr = com.byazt.yj.pr.pr(com.byazt.yj.hw.pr(this.pr.getContext(), jSONObjectPr3, this.pr.fw().pr(), true, com.byazt.zrg.pr.x()), jSONObject);
            if (hnVarPr != null && hnVarPr.pr() != null) {
                try {
                    jSONObject2 = new JSONObject(hnVarPr.pr());
                } catch (JSONException e) {
                }
            }
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString("device_id", "");
                boolean zPr = this.pr.x().pr(jSONObject2, strOptString, jSONObject2.optString("install_id", ""), jSONObject2.optString("ssid", ""));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
                jSONObject3.put("headers", hnVarPr.hw());
                g.hw(jSONObject, jSONObject3);
                com.byazt.wx.pr.hw("__kite", "start:" + g.c());
                try {
                    if (g.c()) {
                        new com.byazt.xg.hw(this.pr.getContext()).pr(jSONObjectPr3, strOptString);
                    }
                } catch (Throwable th) {
                    com.byazt.wx.pr.pr("__kite", "error:" + g.c(), th);
                }
                return zPr;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("headers", hnVarPr.hw());
            g.hw(jSONObject, jSONObject4);
        } else {
            w.hw((Throwable) null);
        }
        return false;
    }

    @Override // com.byazt.gox.hw
    public String x() {
        return "r";
    }
}
