package com.byazt.lo;

import com.byazt.sx.s;
import com.byazt.xz.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 19})
public class n implements s {
    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "stateChange".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, l lVar) {
        if (lVar == null) {
            return true;
        }
        lVar.n(map2);
        return true;
    }
}
