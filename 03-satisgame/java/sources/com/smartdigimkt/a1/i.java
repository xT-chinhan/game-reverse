package com.smartdigimkt.a1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Choreographer.FrameCallback, Handler.Callback {
    public static final i e = new i();
    public volatile long a = -9223372036854775807L;
    public final Handler b;
    public Choreographer c;
    public int d;

    public i() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.b = handler;
        handler.sendEmptyMessage(0);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        if (this.c != null) {
            this.a = j;
            this.c.postFrameCallbackDelayed(this, 500L);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            try {
                this.c = Choreographer.getInstance();
            } catch (Throwable unused) {
            }
            return true;
        }
        if (i == 1) {
            Choreographer choreographer = this.c;
            if (choreographer != null) {
                int i2 = this.d + 1;
                this.d = i2;
                if (i2 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        Choreographer choreographer2 = this.c;
        if (choreographer2 != null) {
            int i3 = this.d - 1;
            this.d = i3;
            if (i3 == 0) {
                choreographer2.removeFrameCallback(this);
                this.a = -9223372036854775807L;
            }
        }
        return true;
    }
}
