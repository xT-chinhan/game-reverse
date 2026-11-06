package com.byazt.wt;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
public class qi {
    public final com.byazt.hcx.aj pr = com.byazt.tf.hn.pr();

    public void pr(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pairPr;
        try {
            pairPr = com.byazt.mp.uc.pr().pr(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.byazt.ca.ho.pr(th.getMessage());
            pairPr = null;
        }
        if (pairPr != null && pairPr.first != null) {
            if (((Integer) pairPr.first).intValue() == 4) {
                this.pr.pr((byte[]) pairPr.second);
                this.pr.pr("x-pglcypher", String.valueOf(pairPr.first));
                return;
            } else {
                this.pr.pr((JSONObject) pairPr.second);
                return;
            }
        }
        com.byazt.xk.hw.pr().pr(-1, -1L, str, -1);
        this.pr.hw(rc.pr(jSONObject != null ? jSONObject.toString() : null).toString());
    }

    public void hw(JSONObject jSONObject, String str) {
        if (com.byazt.sd.a.hw().wo()) {
            pr(jSONObject, str);
        } else {
            this.pr.hw(rc.pr(jSONObject == null ? null : jSONObject.toString()).toString());
        }
    }

    public void hn(JSONObject jSONObject, String str) {
        if (com.byazt.sd.a.hw().tv()) {
            pr(jSONObject, str);
        } else {
            this.pr.hw(rc.pr(jSONObject == null ? null : jSONObject.toString()).toString());
        }
    }

    public void pr(String str) {
        this.pr.pr(str);
    }

    public void pr(com.byazt.hcx.fw fwVar) {
        this.pr.pr(fwVar);
    }

    public void pr(Map<String, Object> map) {
        this.pr.pr(map);
    }

    public com.byazt.hcx.aj pr() {
        return this.pr;
    }
}
