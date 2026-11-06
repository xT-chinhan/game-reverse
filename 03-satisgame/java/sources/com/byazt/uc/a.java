package com.byazt.uc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a implements com.byazt.uk.n {
    public final String n;

    public a(String str) {
        this.n = str;
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        return this.n;
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return com.byazt.mn.w.STRING;
    }

    @Override // com.byazt.uk.n
    public String qg() {
        return "'" + this.n + "'";
    }

    public String toString() {
        return qg();
    }
}
