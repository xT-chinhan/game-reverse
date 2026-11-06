package com.byazt.sd;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public class b implements Function {
    public static volatile b pr;

    private b() {
    }

    public static b pr() {
        if (pr == null) {
            synchronized (b.class) {
                if (pr == null) {
                    pr = new b();
                }
            }
        }
        return pr;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) obj;
            switch (((Integer) sparseArray.get(-99999987)).intValue()) {
                case 1:
                    Bundle bundle = (Bundle) sparseArray.get(0);
                    com.byazt.vkw.vk vkVar = (com.byazt.vkw.vk) com.byazt.zs.uc.pr("boost");
                    if (vkVar != null) {
                        return vkVar.pr(bundle);
                    }
                    return null;
                default:
                    return null;
            }
        }
        return null;
    }
}
