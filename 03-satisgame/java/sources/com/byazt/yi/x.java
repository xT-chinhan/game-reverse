package com.byazt.yi;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 21})
public class x {
    public long l;
    public int n;
    public Object q;
    public int qg;
    public int s;
    public Handler w;

    private x(int i, int i2, int i3, Object obj, long j, Handler handler) {
        this.n = i;
        this.qg = i2;
        this.s = i3;
        this.q = obj;
        this.l = j;
        this.w = handler;
    }

    public static x n(Message message) {
        return new x(message.what, message.arg1, message.arg2, message.obj, qg(message), message.getTarget());
    }

    public static Message n(Handler handler, x xVar) {
        Handler handler2 = xVar.w;
        if (handler2 != null) {
            return handler2.obtainMessage(xVar.n, xVar.qg, xVar.s, xVar.q);
        }
        return handler.obtainMessage(xVar.n, xVar.qg, xVar.s, xVar.q);
    }

    public static long n(x xVar) {
        return xVar.l;
    }

    private static long qg(Message message) {
        if (message == null) {
            return 0L;
        }
        return Math.max(message.getWhen() - SystemClock.uptimeMillis(), 0L);
    }
}
