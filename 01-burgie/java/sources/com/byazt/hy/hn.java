package com.byazt.hy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 20})
public class hn implements x {
    @Override // com.byazt.hy.x
    public String pr() {
        return "Lottie://state";
    }

    @Override // com.byazt.hy.x
    public boolean pr(com.byazt.mu.pr.C0137pr c0137pr, Map<String, Object> map) {
        Map<String, Object> mapPr;
        if (c0137pr == null || (mapPr = c0137pr.pr()) == null || mapPr.isEmpty()) {
            return false;
        }
        Object obj = mapPr.get("id");
        if (obj == null) {
            obj = mapPr.get(Common.System.NAME);
        }
        Object obj2 = mapPr.get("state");
        if (obj == null) {
            return false;
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        if (!pr(obj, map.get("id"))) {
            return false;
        }
        if (obj2 != null && !pr(obj2, map.get("state"))) {
            return false;
        }
        return true;
    }

    private static boolean pr(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return String.valueOf(obj).equals(String.valueOf(obj2));
    }
}
