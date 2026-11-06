package com.byazt.nf;

import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.vf.py;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, 847})
public class AdSdkInitializerHolder implements com.byazt.vf.rv, Function {
    public static volatile com.byazt.vyf.n n;
    public static volatile Object qg;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        return n((Bundle) sparseArray.get(1));
    }

    public static Object getNewInstance(Bundle bundle) {
        py pyVar;
        if (n == null) {
            synchronized (AdSdkInitializerHolder.class) {
                if (n == null) {
                    n = new com.byazt.vyf.n(bundle);
                    if (tj.n.booleanValue() && (pyVar = (py) com.byazt.qp.q.n("m")) != null) {
                        qg = pyVar.getDispatchAdSdkInitializer(bundle, n);
                    }
                }
            }
        }
        return qg != null ? qg : n;
    }

    public static boolean n() {
        return qg != null;
    }

    public static boolean qg() {
        if (n != null) {
            return n.n();
        }
        return false;
    }

    @Override // com.byazt.vf.rv
    public Object n(Bundle bundle) {
        return getNewInstance(bundle);
    }
}
