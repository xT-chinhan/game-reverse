package com.byazt.fp;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 109})
public class w {
    public static volatile float pr = -1.0f;
    public static volatile int hw = -1;
    public static volatile float hn = -1.0f;
    public static volatile int x = -1;
    public static volatile int c = -1;

    public static void pr(Context context) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (pr()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            pr = displayMetrics.density;
            hw = displayMetrics.densityDpi;
            hn = displayMetrics.scaledDensity;
            x = displayMetrics.widthPixels;
            c = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (x > c) {
                    int i = x;
                    x = c;
                    c = i;
                    return;
                }
                return;
            }
            if (x < c) {
                int i2 = x;
                x = c;
                c = i2;
            }
        }
    }

    private static boolean pr() {
        return pr < 0.0f || hw < 0 || hn < 0.0f || x < 0 || c < 0;
    }

    public static int hw(Context context) {
        pr(context);
        return hw;
    }

    public static int hn(Context context) {
        pr(context);
        return x;
    }

    public static int x(Context context) {
        pr(context);
        return c;
    }
}
