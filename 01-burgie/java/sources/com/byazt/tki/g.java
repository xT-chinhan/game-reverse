package com.byazt.tki;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g extends yb {
    public g() {
        super(com.byazt.yiq.hn.NOT_EQ);
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        Object objPr = this.pr.pr(map);
        Object objPr2 = this.hw.pr(map);
        if (objPr == null && objPr2 == null) {
            return Boolean.FALSE;
        }
        if (objPr == null && objPr2 != null) {
            return Boolean.TRUE;
        }
        if (objPr != null && objPr2 == null) {
            return Boolean.TRUE;
        }
        if ((objPr instanceof Number) && (objPr2 instanceof Number)) {
            return Boolean.valueOf(!com.byazt.qc.hw.pr((Number) objPr, (Number) objPr2));
        }
        return Boolean.valueOf(!objPr.equals(objPr2));
    }
}
