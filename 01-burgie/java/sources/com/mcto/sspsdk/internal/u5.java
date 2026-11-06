package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.mcto.sspsdk.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class u5 extends View implements eb {
    public boolean a;
    public boolean b;
    public final d8 c;
    public final fb d;
    public final AtomicBoolean e;
    public t5 f;
    public float g;
    public float h;

    public u5(Context context, d8 d8Var) {
        Looper looper;
        super(context);
        synchronized (s9.class) {
            if (s9.a == null) {
                HandlerThread handlerThread = new HandlerThread("ssp_emptyView");
                s9.a = handlerThread;
                handlerThread.start();
            }
            looper = s9.a.getLooper();
        }
        this.d = new fb(looper, this);
        this.e = new AtomicBoolean(true);
        this.g = -999.0f;
        this.h = -999.0f;
        setId(R.id.qy_empty_view_id);
        this.c = d8Var;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public final void a() {
        if (!this.a || this.b) {
            return;
        }
        this.b = true;
        this.d.sendEmptyMessage(1);
    }

    public final void b() {
        if (this.b) {
            this.b = false;
            this.d.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        this.e.get();
        this.e.getAndSet(false);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        t5 t5Var;
        super.onDetachedFromWindow();
        b();
        this.e.get();
        if (this.e.getAndSet(true) || (t5Var = this.f) == null) {
            return;
        }
        t5Var.a();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        a();
        this.e.get();
        this.e.getAndSet(false);
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        t5 t5Var;
        super.onStartTemporaryDetach();
        b();
        this.e.get();
        if (this.e.getAndSet(true) || (t5Var = this.f) == null) {
            return;
        }
        t5Var.a();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        t5 t5Var = this.f;
        if (t5Var != null) {
            t5Var.onWindowFocusChanged(z);
        }
        if (z) {
            a();
        } else {
            b();
        }
    }

    @Override // com.mcto.sspsdk.internal.eb
    public final void a(Message message) {
        if (message.what == 1 && this.a) {
            try {
                if (c8.a(this.c) == 0) {
                    this.a = false;
                    b();
                    kh.a.a(new s5(this));
                    return;
                }
            } catch (Throwable th) {
            }
            fb fbVar = this.d;
            this.c.getClass();
            fbVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
