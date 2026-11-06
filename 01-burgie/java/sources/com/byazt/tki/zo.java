package com.byazt.tki;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends yb {
    public zo() {
        super(com.byazt.yiq.hn.LT_EQ);
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        Object objPr;
        Object objPr2 = this.pr.pr(map);
        if (objPr2 == null || (objPr = this.hw.pr(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.byazt.qc.hn.pr(objPr2, (Number) objPr)).booleanValue());
    }
}
