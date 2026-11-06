package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 {
    public static boolean ms(String... strArr) {
        try {
            Context contextXr = pblv.ms().xr();
            for (String str : strArr) {
                if (contextXr.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
