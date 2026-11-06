package com.byazt.uc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends hd {
    public oa() {
        super(com.byazt.mn.s.MULTI);
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        Object objN;
        Object objN2 = this.n.n(map);
        if (objN2 == null || (objN = this.qg.n(map)) == null) {
            return null;
        }
        return com.byazt.qh.x.n((Number) objN2, (Number) objN);
    }
}
