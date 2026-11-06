package com.byazt.fk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 37})
public class pr {
    public ConcurrentHashMap<String, Object> pr = new ConcurrentHashMap<>();

    public void pr(String str, String str2) {
        if (str != null && str2 != null) {
            this.pr.put(str, str2);
        }
    }

    public String pr(String str) {
        return hw(str, "");
    }

    private String hw(String str, String str2) {
        if (str != null && this.pr.containsKey(str)) {
            return (String) this.pr.get(str);
        }
        return str2;
    }

    public void pr(String str, int i) {
        if (str != null) {
            this.pr.put(str, Integer.valueOf(i));
        }
    }

    public int hw(String str) {
        return hw(str, 0);
    }

    private int hw(String str, int i) {
        if (str != null && this.pr.containsKey(str)) {
            return ((Integer) this.pr.get(str)).intValue();
        }
        return i;
    }
}
