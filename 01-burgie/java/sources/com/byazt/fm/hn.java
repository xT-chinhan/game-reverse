package com.byazt.fm;

import android.text.TextUtils;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 20})
public abstract class hn {
    public k hn;
    public Map<String, Object> pr;
    public String x = null;
    public final Map<String, String> c = new HashMap();
    public String uc = null;
    public boolean fw = false;

    public abstract com.byazt.tf.x pr();

    public abstract void pr(com.byazt.elv.pr prVar);

    public hn(k kVar) {
        this.hn = kVar;
        hw(UUID.randomUUID().toString());
    }

    public void pr(String str) {
        this.uc = str;
    }

    public void hw(String str, String str2) {
        this.c.put(str, str2);
    }

    public void x(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.c.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void hw(String str) {
        this.x = str;
    }

    public String hw() {
        return this.x;
    }

    public void hn() {
        k kVar;
        if (this.x == null || (kVar = this.hn) == null) {
            return;
        }
        com.byazt.nzn.x xVarPr = kVar.pr();
        synchronized (xVarPr) {
            for (com.byazt.nzn.hw hwVar : xVarPr.hn()) {
                if (this.x.equals(hwVar.pr().pr())) {
                    hwVar.hn();
                }
            }
            for (com.byazt.nzn.hw hwVar2 : xVarPr.x()) {
                if (this.x.equals(hwVar2.pr().pr())) {
                    hwVar2.hn();
                }
            }
        }
        com.byazt.tf.pr.pr((Object) this.x);
    }

    public Map<String, Object> x() {
        return this.pr;
    }

    public void c(Map<String, Object> map) {
        this.pr = map;
    }

    public void pr(g.pr prVar) {
        if (prVar != null && this.c.size() > 0) {
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    prVar.hw(key, value);
                }
            }
        }
    }

    public void pr(boolean z) {
        this.fw = z;
    }
}
