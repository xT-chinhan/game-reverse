package com.byazt.kru;

import com.byazt.rx.q;
import com.byazt.xz.cy;
import com.byazt.xz.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 8})
public class s implements q {
    public final cy n;

    public s(cy cyVar) {
        this.n = cyVar;
    }

    @Override // com.byazt.rx.q
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.rx.qg qgVar) {
        cy cyVar = this.n;
        if (cyVar == null) {
            return false;
        }
        return cyVar.n(str, str2, i, map, map2, n(qgVar));
    }

    @Override // com.byazt.rx.q
    public void n(String str, String str2, Map<String, Object> map, com.byazt.rx.qg qgVar) {
        cy cyVar = this.n;
        if (cyVar == null) {
            return;
        }
        cyVar.n(str, str2, "", map, n(qgVar));
    }

    @Override // com.byazt.rx.q
    public void n(String str, String str2, int i, int i2) {
        cy cyVar = this.n;
        if (cyVar == null) {
            return;
        }
        cyVar.n(str, str2, i, i2);
    }

    @Override // com.byazt.rx.q
    public void n(String str, String str2, int i, boolean z) {
        cy cyVar = this.n;
        if (cyVar == null) {
            return;
        }
        cyVar.n(str, str2, i, z);
    }

    @Override // com.byazt.rx.q
    public void n(String str, String str2, int i, String str3) {
        cy cyVar = this.n;
        if (cyVar == null) {
            return;
        }
        cyVar.n(str, str2, i, str3);
    }

    private l n(final com.byazt.rx.qg qgVar) {
        if (qgVar == null) {
            return null;
        }
        return new l() { // from class: com.byazt.kru.s.1
            @Override // com.byazt.xz.l
            public void n() {
                qgVar.n();
            }

            @Override // com.byazt.xz.l
            public void n(Map<String, Object> map) {
                qgVar.n(map);
            }
        };
    }
}
