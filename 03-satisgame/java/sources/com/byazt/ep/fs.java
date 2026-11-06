package com.byazt.ep;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 101})
public final class fs {
    public static volatile fs n;
    public com.byazt.gwu.s qg = com.byazt.lk.l.qg(com.byazt.vgx.s.q(), "ugeno_template_file", 0, com.byazt.p001if.n.n());

    private fs() {
    }

    public static fs n() {
        if (n == null) {
            synchronized (fs.class) {
                if (n == null) {
                    n = new fs();
                }
            }
        }
        return n;
    }

    public void n(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.qg.n("ugeno_".concat(String.valueOf(str)), str3);
        this.qg.n("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject n(String str, String str2) {
        String strQg = this.qg.qg("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        String strQg2 = this.qg.qg("ugeno__md5_".concat(String.valueOf(str)), "");
        if (!TextUtils.isEmpty(strQg2) && TextUtils.equals(strQg2, str2)) {
            try {
                return new JSONObject(strQg);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public boolean qg(String str, String str2) {
        return n(str, str2) != null;
    }
}
