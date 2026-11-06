package com.byazt.wt;

import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 108})
public class m {
    public static volatile m pr = null;
    public com.byazt.cr.c hw;

    public static m pr() {
        if (pr == null) {
            synchronized (m.class) {
                if (pr == null) {
                    pr = new m();
                }
            }
        }
        return pr;
    }

    public void pr(Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean z = (intent.getFlags() & 8388608) == 8388608;
        com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.wt.m.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int iHw = m.this.hw().hw("all_activity_count", 0) + 1;
                if (z) {
                    int iHw2 = m.this.hw().hw("hide_activity_count", 0) + 1;
                    if (iHw2 >= 10) {
                        m.this.pr(iHw);
                        iHw = 0;
                    } else {
                        i = iHw2;
                    }
                    m.this.hw().pr("hide_activity_count", i);
                }
                m.this.hw().pr("all_activity_count", iHw);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.cr.c hw() {
        if (this.hw == null) {
            this.hw = y.pr("hide_recent_activity_recorder");
        }
        return this.hw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final int i) {
        com.byazt.xk.hw.pr().pr("hide_activity_record", new com.byazt.ttf.pr() { // from class: com.byazt.wt.m.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ac", i);
                return jSONObject2;
            }
        });
    }
}
