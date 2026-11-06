package com.byazt.vlj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_PRESENTATION_ID, 13})
public class hw {
    public Map<hn, List<pr>> pr = new HashMap();
    public Map<String, String> hw = new HashMap();
    public final List<Object> hn = new CopyOnWriteArrayList();
    public final List<Object> x = new CopyOnWriteArrayList();
    public final List<Object> c = new CopyOnWriteArrayList();
    public final List<Object> uc = new CopyOnWriteArrayList();
    public uc fw = null;

    public List<pr> pr(hn hnVar) {
        return this.pr.get(hnVar);
    }

    public void pr(Map<? extends String, ? extends String> map) {
        this.hw.putAll(map);
    }

    public Map<String, String> pr() {
        return this.hw;
    }

    public List<Object> hw() {
        return this.x;
    }

    public List<Object> hn() {
        return this.uc;
    }

    public void pr(uc ucVar) {
        this.fw = ucVar;
    }

    public uc x() {
        return this.fw;
    }
}
