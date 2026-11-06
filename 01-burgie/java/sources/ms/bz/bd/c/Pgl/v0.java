package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {
    public static boolean pr(String... strArr) {
        try {
            Context contextHw = pblp.pr().hw();
            for (String str : strArr) {
                if (contextHw.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
