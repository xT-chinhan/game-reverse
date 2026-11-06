package com.byazt.kg;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 62})
public class fw {
    public long c;
    public int hn;
    public int hw;
    public int pr;
    public Handler uc;
    public Object x;

    private fw(int i, int i2, int i3, Object obj, long j, Handler handler) {
        this.pr = i;
        this.hw = i2;
        this.hn = i3;
        this.x = obj;
        this.c = j;
        this.uc = handler;
    }

    public static fw pr(Message message) {
        return new fw(message.what, message.arg1, message.arg2, message.obj, hw(message), message.getTarget());
    }

    public static Message pr(Handler handler, fw fwVar) {
        Handler handler2 = fwVar.uc;
        if (handler2 != null) {
            return handler2.obtainMessage(fwVar.pr, fwVar.hw, fwVar.hn, fwVar.x);
        }
        return handler.obtainMessage(fwVar.pr, fwVar.hw, fwVar.hn, fwVar.x);
    }

    public static long pr(fw fwVar) {
        return fwVar.c;
    }

    private static long hw(Message message) {
        if (message == null) {
            return 0L;
        }
        return Math.max(message.getWhen() - SystemClock.uptimeMillis(), 0L);
    }
}
