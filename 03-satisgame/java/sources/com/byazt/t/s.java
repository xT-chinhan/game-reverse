package com.byazt.t;

import android.os.Build;
import com.byazt.rz.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL, 8})
public class s {
    public static void n(final com.byazt.h.qg qgVar, final com.byazt.gs.n nVar) {
        boolean zQg = com.byazt.b.n.n().qg();
        if (!zQg && Build.VERSION.SDK_INT >= 29) {
            oa.s();
        }
        boolean zQg2 = com.byazt.b.n.n().qg();
        if (!zQg && zQg2 && qgVar != null) {
            qgVar.d(true);
        }
        nVar.n();
        com.byazt.fe.n.qg("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(zQg2)));
        if (zQg2) {
            return;
        }
        com.byazt.b.n.n().n(new com.byazt.b.n.InterfaceC0133n() { // from class: com.byazt.t.s.1
            @Override // com.byazt.b.n.InterfaceC0133n
            public void s() {
            }

            @Override // com.byazt.b.n.InterfaceC0133n
            public void qg() {
                com.byazt.fe.n.qg("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.byazt.b.n.n().qg(this);
                if (oa.qg(qgVar)) {
                    return;
                }
                qgVar.oa(true);
                com.byazt.vj.n.n().n("install_delay_invoke", qgVar);
                nVar.n();
            }
        });
    }
}
