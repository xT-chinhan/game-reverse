package com.byazt.vlj;

import android.app.Application;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_PRESENTATION_ID, 62})
public final class fw {
    public static boolean pr;
    public static boolean hw = false;
    public static boolean hn = false;
    public static boolean x = false;

    public static synchronized void pr(Context context, c cVar, boolean z, boolean z2) {
        pr(context, cVar, z, false, z2);
    }

    public static synchronized void pr(Context context, c cVar, boolean z, boolean z2, boolean z3) {
        pr(context, cVar, z, z, z2, z3);
    }

    public static synchronized void pr(final Context context, c cVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        if (pr) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("params must be not null.");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (com.byazt.wf.pr.hn(context)) {
            return;
        }
        zo.pr(context, cVar);
        com.byazt.se.c.pr(context);
        if (z || z2) {
            com.byazt.ey.pr prVarPr = com.byazt.ey.pr.pr();
            if (z) {
                prVarPr.pr(new com.byazt.ey.hn(context));
            }
            hw = true;
        }
        x = z3;
        pr = true;
        hn = z4;
        com.byazt.sds.fw.hw().post(new Runnable() { // from class: com.byazt.vlj.fw.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kvy.pr.pr().pr(context);
                com.byazt.tv.x.pr(context);
                if (z4) {
                    com.byazt.ah.uc.pr(context).pr();
                }
            }
        });
    }

    public static void pr(uc ucVar) {
        zo.hw().pr(ucVar);
    }

    public static void pr(Map<? extends String, ? extends String> map) {
        if (map != null && !map.isEmpty()) {
            zo.hw().pr(map);
        }
    }

    public static void pr(final com.byazt.yoc.hw hwVar) {
        com.byazt.sds.fw.hw().post(new Runnable() { // from class: com.byazt.vlj.fw.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yoc.pr.pr(hwVar);
            }
        });
    }

    public static void pr() {
        com.byazt.ey.pr.hw();
    }
}
