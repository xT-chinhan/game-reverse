package com.byazt.ss;

import com.byazt.vh.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1334, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends n {
    public tj(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
        super(sVar, str, nVar);
    }

    @Override // com.byazt.ss.n
    public void n() {
        sz szVarF;
        if (this.s == null || this.w == null || this.w.isEmpty() || (szVarF = this.s.f()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.w);
        linkedHashMap.remove("emitCustomEvent");
        szVarF.n(szVarF.n((Map<String, Object>) linkedHashMap));
    }
}
