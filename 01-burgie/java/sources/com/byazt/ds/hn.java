package com.byazt.ds;

import android.os.Build;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 20})
public class hn {
    public static void pr(final com.byazt.tia.hw hwVar, final com.byazt.hja.pr prVar) {
        boolean zHw = com.byazt.wel.pr.pr().hw();
        if (!zHw && Build.VERSION.SDK_INT >= 29) {
            m.hn();
        }
        boolean zHw2 = com.byazt.wel.pr.pr().hw();
        if (!zHw && zHw2 && hwVar != null) {
            hwVar.k(true);
        }
        prVar.pr();
        com.byazt.p000do.pr.hw("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(zHw2)));
        if (!zHw2) {
            com.byazt.wel.pr.pr().pr(new com.byazt.wel.pr.InterfaceC0223pr() { // from class: com.byazt.ds.hn.1
                @Override // com.byazt.wel.pr.InterfaceC0223pr
                public void hw() {
                    com.byazt.p000do.pr.hw("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                    com.byazt.wel.pr.pr().hw(this);
                    if (!m.hw(hwVar)) {
                        hwVar.m(true);
                        com.byazt.mf.pr.pr().pr("install_delay_invoke", hwVar);
                        prVar.pr();
                    }
                }

                @Override // com.byazt.wel.pr.InterfaceC0223pr
                public void hn() {
                }
            });
        }
    }
}
