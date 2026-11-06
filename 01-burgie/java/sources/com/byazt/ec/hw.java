package com.byazt.ec;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 13})
public class hw implements com.byazt.zrg.x {
    public static volatile hw pr;
    public final CopyOnWriteArraySet<com.byazt.zrg.x> hw = new CopyOnWriteArraySet<>();

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    private hw() {
    }

    @Override // com.byazt.zrg.x
    public void pr(String str, String str2, String str3) {
        Iterator<com.byazt.zrg.x> it = this.hw.iterator();
        while (it.hasNext()) {
            it.next().pr(str, str2, str3);
        }
    }

    @Override // com.byazt.zrg.x
    public void pr(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<com.byazt.zrg.x> it = this.hw.iterator();
        while (it.hasNext()) {
            it.next().pr(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.byazt.zrg.x
    public void pr(boolean z, JSONObject jSONObject) {
        Iterator<com.byazt.zrg.x> it = this.hw.iterator();
        while (it.hasNext()) {
            it.next().pr(z, jSONObject);
        }
    }

    @Override // com.byazt.zrg.x
    public void hw(boolean z, JSONObject jSONObject) {
        Iterator<com.byazt.zrg.x> it = this.hw.iterator();
        while (it.hasNext()) {
            it.next().hw(z, jSONObject);
        }
    }
}
