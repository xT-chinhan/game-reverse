package com.byazt.aqe;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.gct.hu;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends n {
    public String hd;

    @Override // com.byazt.aqe.qg
    public int x() {
        return 5;
    }

    public rv(Activity activity, pk pkVar, ry ryVar) {
        super(activity, pkVar, ryVar);
        hu huVarMt = this.x.mt();
        if (huVarMt != null) {
            this.hd = huVarMt.n();
        }
    }

    @Override // com.byazt.aqe.qg
    public boolean w() {
        String str = this.hd;
        return (str == null || str.equals("0") || TextUtils.isEmpty(this.hd)) ? false : true;
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        return s(tjVar);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.hd);
            boolean z = false;
            try {
                if (Double.parseDouble(this.hd) != 0.0d) {
                    z = true;
                }
            } catch (NumberFormatException unused) {
            }
            jSONObject.put("is_display_unit", z);
        } catch (JSONException unused2) {
        }
        return jSONObject.toString();
    }
}
