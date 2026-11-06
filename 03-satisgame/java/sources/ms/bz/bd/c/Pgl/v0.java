package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {
    public static boolean n(String... strArr) {
        try {
            Context contextQg = pblp.n().qg();
            for (String str : strArr) {
                if (contextQg.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
