package com.byazt.gf;

import android.text.TextUtils;
import com.byazt.jy.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 121})
public class x {
    public static x pr;
    public final Map<String, fw> hw = new ConcurrentHashMap();

    private x() {
    }

    public static x pr() {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new x();
                }
            }
        }
        return pr;
    }

    private void pr(List<fw> list) {
        if (list != null) {
            for (fw fwVar : list) {
                if (fwVar != null && !TextUtils.isEmpty(fwVar.pr())) {
                    this.hw.put(fwVar.pr(), fwVar);
                }
            }
        }
    }

    public void pr(JSONArray jSONArray) {
        pr(com.byazt.uw.x.pr(jSONArray));
    }

    public fw pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hw.get(str);
    }
}
