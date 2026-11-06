package com.byazt.t;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.byazt.rz.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL, 13})
public class w {
    public static Handler n = new Handler(Looper.getMainLooper());

    public static void n(final com.byazt.h.qg qgVar, final fs fsVar) {
        boolean zQg = com.byazt.b.n.n().qg();
        if (!zQg && Build.VERSION.SDK_INT >= 29) {
            oa.s();
        }
        boolean zQg2 = com.byazt.b.n.n().qg();
        boolean z = !zQg && zQg2;
        if (qgVar != null) {
            qgVar.d(z);
        }
        fsVar.n(z);
        if (qgVar == null) {
            return;
        }
        qg(qgVar, tj(qgVar));
        if (zQg2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.b.n.n().n(new com.byazt.b.n.InterfaceC0133n() { // from class: com.byazt.t.w.1
            @Override // com.byazt.b.n.InterfaceC0133n
            public void s() {
            }

            @Override // com.byazt.b.n.InterfaceC0133n
            public void qg() {
                com.byazt.b.n.n().qg(this);
                com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.t.w.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zS = oa.s(qgVar.l());
                        long jL = w.l(qgVar);
                        if (!zS || jL >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            if (System.currentTimeMillis() - jCurrentTimeMillis > w.fs(qgVar)) {
                                com.byazt.vj.n.n().n("deeplink_delay_timeout", qgVar);
                                return;
                            }
                            qgVar.d(true);
                            com.byazt.vj.n.n().n("deeplink_delay_invoke", qgVar);
                            fsVar.n(true);
                            w.qg(qgVar, w.tj(qgVar));
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final com.byazt.h.qg qgVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.t.w.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (oa.s(qgVar.l())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!qgVar.yw()) {
                            i2 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                    } catch (JSONException unused) {
                    }
                    com.byazt.vj.n.n().n("deeplink_success_2", jSONObject, qgVar);
                    return;
                }
                w.qg(qgVar, i - 1);
            }
        }, rv(qgVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long fs(com.byazt.h.qg qgVar) {
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).n("app_link_check_timeout", 300000L);
    }

    private static int rv(com.byazt.h.qg qgVar) {
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).n("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int tj(com.byazt.h.qg qgVar) {
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).n("app_link_check_count", 10);
    }

    public static boolean n(com.byazt.h.qg qgVar) {
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).qg("app_link_opt_switch") == 1;
    }

    public static boolean qg(com.byazt.h.qg qgVar) {
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).qg("app_link_opt_install_switch") == 1;
    }

    public static boolean s(com.byazt.h.qg qgVar) {
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).qg("app_link_opt_invoke_switch") == 1;
    }

    public static boolean q(com.byazt.h.qg qgVar) {
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).qg("app_link_opt_dialog_switch") == 1;
    }

    public static long l(com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return 3000L;
        }
        return com.byazt.rz.l.n((com.byazt.h.n) qgVar).n("app_link_opt_back_time_limit", 3) * 1000;
    }
}
