package com.byazt.i;

import android.content.Context;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 121})
public final class x {
    public static volatile com.byazt.j.hn hw;
    public static volatile com.byazt.j.hw pr;
    public static volatile boolean uc;
    public static volatile com.byazt.d.hn vk;
    public static volatile Context w;
    public static volatile Integer x;
    public static volatile boolean zo;
    public static volatile int hn = 3;
    public static final boolean c = ho.hn();
    public static volatile boolean fw = true;
    public static volatile int aj = 0;

    public static Context getContext() {
        return w;
    }

    public static void pr(boolean z) {
        zo = z;
    }

    public static void pr(int i) {
        aj = i;
    }

    public static void pr(com.byazt.j.hn hnVar, Context context) {
        if (hnVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        w = context.getApplicationContext();
        if (hw != null) {
            return;
        }
        com.byazt.j.hw hwVar = pr;
        if (hwVar != null && hwVar.pr.getAbsolutePath().equals(hnVar.pr.getAbsolutePath())) {
            throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
        }
        hw = hnVar;
        vk = com.byazt.d.hn.pr(context);
        hw.pr(new com.byazt.j.hn.pr() { // from class: com.byazt.i.x.1
            @Override // com.byazt.j.hn.pr
            public void pr(String str) {
                boolean z = x.c;
            }

            @Override // com.byazt.j.hn.pr
            public void pr(Set<String> set) {
                x.vk.pr(set, 0);
                boolean z = x.c;
            }
        });
        hn hnVarPr = hn.pr();
        hnVarPr.pr(hnVar);
        hnVarPr.pr(vk);
    }

    public static com.byazt.j.hn pr() {
        return hw;
    }

    public static com.byazt.j.hw hw() {
        return pr;
    }
}
