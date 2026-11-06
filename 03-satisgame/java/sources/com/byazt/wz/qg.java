package com.byazt.wz;

import com.byazt.nf.rv;
import com.byazt.tk.l;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsEncryptVersion, 26})
public class qg {
    public static volatile Random n = null;
    public static volatile boolean qg = false;

    public static boolean n() {
        return qg;
    }

    public static void qg() {
        n(rv.qg().vb(), true);
    }

    public static boolean n(float f, boolean z) {
        if (f <= 0.0f) {
            if (z) {
                qg = false;
            }
            return false;
        }
        int iNextInt = s().nextInt(10000);
        int i = (int) (f * 10000.0f);
        if (z) {
            qg = iNextInt < i;
        }
        return iNextInt < i;
    }

    private static Random s() {
        if (n != null) {
            return n;
        }
        Random randomN = l.n();
        n = randomN;
        return randomN;
    }
}
