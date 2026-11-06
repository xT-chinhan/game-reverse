package com.byazt.uc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements com.byazt.uk.n {
    public final com.byazt.mn.s n;

    public cy(com.byazt.mn.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return this.n;
    }

    @Override // com.byazt.uk.n
    public String qg() {
        return this.n.n();
    }

    public String toString() {
        return qg();
    }
}
