package com.byazt.ds;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 5})
public class uc {
    public static Handler pr = new Handler(Looper.getMainLooper());

    public static void pr(final com.byazt.tia.hw hwVar, final zo zoVar) {
        boolean zHw = com.byazt.wel.pr.pr().hw();
        if (!zHw && Build.VERSION.SDK_INT >= 29) {
            m.hn();
        }
        boolean zHw2 = com.byazt.wel.pr.pr().hw();
        boolean z = !zHw && zHw2;
        if (hwVar != null) {
            hwVar.k(z);
        }
        zoVar.pr(z);
        if (hwVar == null) {
            return;
        }
        hw(hwVar, vk(hwVar));
        if (zHw2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.wel.pr.pr().pr(new com.byazt.wel.pr.InterfaceC0223pr() { // from class: com.byazt.ds.uc.1
            @Override // com.byazt.wel.pr.InterfaceC0223pr
            public void hw() {
                com.byazt.wel.pr.pr().hw(this);
                com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.ds.uc.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zHn = m.hn(hwVar.c());
                        long jC = uc.c(hwVar);
                        if (!zHn || jC >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            if (System.currentTimeMillis() - jCurrentTimeMillis > uc.zo(hwVar)) {
                                com.byazt.mf.pr.pr().pr("deeplink_delay_timeout", hwVar);
                                return;
                            }
                            hwVar.k(true);
                            com.byazt.mf.pr.pr().pr("deeplink_delay_invoke", hwVar);
                            zoVar.pr(true);
                            uc.hw(hwVar, uc.vk(hwVar));
                        }
                    }
                });
            }

            @Override // com.byazt.wel.pr.InterfaceC0223pr
            public void hn() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(final com.byazt.tia.hw hwVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.ds.uc.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (!m.hn(hwVar.c())) {
                    uc.hw(hwVar, i - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!hwVar.lv()) {
                        i2 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                } catch (JSONException e) {
                }
                com.byazt.mf.pr.pr().pr("deeplink_success_2", jSONObject, hwVar);
            }
        }, aj(hwVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long zo(com.byazt.tia.hw hwVar) {
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).pr("app_link_check_timeout", 300000L);
    }

    private static int aj(com.byazt.tia.hw hwVar) {
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).pr("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int vk(com.byazt.tia.hw hwVar) {
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).pr("app_link_check_count", 10);
    }

    public static boolean pr(com.byazt.tia.hw hwVar) {
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).hw("app_link_opt_switch") == 1;
    }

    public static boolean hw(com.byazt.tia.hw hwVar) {
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).hw("app_link_opt_install_switch") == 1;
    }

    public static boolean hn(com.byazt.tia.hw hwVar) {
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).hw("app_link_opt_invoke_switch") == 1;
    }

    public static boolean x(com.byazt.tia.hw hwVar) {
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).hw("app_link_opt_dialog_switch") == 1;
    }

    public static long c(com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
            return 3000L;
        }
        return com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).pr("app_link_opt_back_time_limit", 3) * 1000;
    }
}
