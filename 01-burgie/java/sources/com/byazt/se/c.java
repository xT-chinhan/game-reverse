package com.byazt.se;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static volatile c pr;
    public x c;
    public Map<com.byazt.vlj.hn, hn> hn = new HashMap();
    public Context hw;
    public hw x;

    private c(Context context) {
        this.hw = context;
        this.x = new hw(this.hw);
        this.c = new x(this.hw);
    }

    public static c pr() {
        if (pr == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return pr;
    }

    public static void pr(Context context) {
        if (pr == null) {
            pr = new c(context);
        }
    }

    private hn pr(com.byazt.vlj.hn hnVar) {
        hn fwVar = this.hn.get(hnVar);
        if (fwVar != null) {
            return fwVar;
        }
        switch (AnonymousClass1.pr[hnVar.ordinal()]) {
            case 1:
                fwVar = new fw(this.hw, this.x, this.c);
                break;
            case 2:
                fwVar = new pr(this.hw, this.x, this.c);
                break;
            case 3:
                fwVar = new uc(this.hw, this.x, this.c);
                break;
        }
        if (fwVar != null) {
            this.hn.put(hnVar, fwVar);
        }
        return fwVar;
    }

    /* JADX INFO: renamed from: com.byazt.se.c$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 33})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.vlj.hn.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.vlj.hn.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.vlj.hn.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.vlj.hn.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public com.byazt.lee.pr pr(com.byazt.vlj.hn hnVar, com.byazt.lee.pr prVar) {
        hn hnVarPr;
        if (hnVar != null && (hnVarPr = pr(hnVar)) != null) {
            return hnVarPr.pr(prVar);
        }
        return prVar;
    }
}
