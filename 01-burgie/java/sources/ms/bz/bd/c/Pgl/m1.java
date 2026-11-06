package ms.bz.bd.c.Pgl;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
final class m1 implements w0.pblb {
    m1() {
    }

    public final String[] pr() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        String str = Build.CPU_ABI2;
        return !(str == null || str.length() == 0) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
