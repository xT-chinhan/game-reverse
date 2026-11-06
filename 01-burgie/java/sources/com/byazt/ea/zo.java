package com.byazt.ea;

import android.text.TextUtils;
import com.byazt.wt.y;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public static volatile zo pr;
    public com.byazt.cr.c hw = y.pr("ugeno_template_file");

    private zo() {
    }

    public static zo pr() {
        if (pr == null) {
            synchronized (zo.class) {
                if (pr == null) {
                    pr = new zo();
                }
            }
        }
        return pr;
    }

    public void pr(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.hw.pr("ugeno_".concat(String.valueOf(str)), str3);
        this.hw.pr("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject pr(String str, String str2) {
        String strHw = this.hw.hw("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(strHw)) {
            return null;
        }
        String strHw2 = this.hw.hw("ugeno__md5_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(strHw2) || !TextUtils.equals(strHw2, str2)) {
            return null;
        }
        try {
            return new JSONObject(strHw);
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean hw(String str, String str2) {
        return pr(str, str2) != null;
    }
}
