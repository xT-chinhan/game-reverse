package com.byazt.tki;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a implements com.byazt.awu.pr {
    public final String pr;

    public a(String str) {
        this.pr = str;
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        return this.pr;
    }

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return com.byazt.yiq.uc.STRING;
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        return "'" + this.pr + "'";
    }

    public String toString() {
        return hw();
    }
}
