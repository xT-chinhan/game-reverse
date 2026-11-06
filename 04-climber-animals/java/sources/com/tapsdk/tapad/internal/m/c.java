package com.tapsdk.tapad.internal.m;

import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tapsdk.tapad.internal.utils.TapADLogger;

/* JADX INFO: loaded from: classes3.dex */
public class c<T> {
    private static final String j = "ImpressionHelper";
    private HandlerThread a;
    private RecyclerView c;
    private com.tapsdk.tapad.internal.m.b<T> d;
    private b f;
    private InterfaceC0623c g;
    private a<T> h;
    private volatile boolean b = false;
    private long e = 0;
    private com.tapsdk.tapad.internal.m.a<T> i = null;

    public interface a<T> {
        T a(int i, View view);
    }

    public interface b {
        void a(int i, View view);
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.m.c$c, reason: collision with other inner class name */
    public interface InterfaceC0623c {
        boolean a(int i, View view);
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread("ImpressionHelperHanThreading", 5);
        this.a = handlerThread;
        handlerThread.start();
    }

    private Looper a() {
        return this.a.getLooper();
    }

    c<T> a(long j2) {
        this.e = j2;
        return this;
    }

    public c<T> a(a<T> aVar) {
        this.h = aVar;
        return this;
    }

    public c<T> a(b bVar) {
        this.f = bVar;
        return this;
    }

    public c<T> a(InterfaceC0623c interfaceC0623c) {
        this.g = interfaceC0623c;
        return this;
    }

    public synchronized void a(RecyclerView recyclerView) {
        try {
            if (recyclerView == null) {
                TapADLogger.w("impressionHelper can not bind not existed recyclerView");
                return;
            }
            if (this.b) {
                TapADLogger.w("impressionHelper can not bind twice");
                return;
            }
            if (!this.a.isAlive()) {
                HandlerThread handlerThread = new HandlerThread("ImpressionHelperHanThreading", 5);
                this.a = handlerThread;
                handlerThread.start();
            }
            if (this.f == null) {
                return;
            }
            com.tapsdk.tapad.internal.m.b<T> bVar = new com.tapsdk.tapad.internal.m.b<>(a(), this.g, this.f, this.h, this.e);
            this.d = bVar;
            com.tapsdk.tapad.internal.m.a<T> aVar = new com.tapsdk.tapad.internal.m.a<>(recyclerView, bVar, this.e);
            this.i = aVar;
            recyclerView.addOnChildAttachStateChangeListener(aVar);
            this.c = recyclerView;
            this.b = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        RecyclerView recyclerView;
        if (!this.b) {
            TapADLogger.w("no need to unbind");
            return;
        }
        com.tapsdk.tapad.internal.m.a<T> aVar = this.i;
        if (aVar != null && (recyclerView = this.c) != null) {
            recyclerView.removeOnChildAttachStateChangeListener(aVar);
        }
        this.c = null;
        this.d.removeCallbacksAndMessages(null);
        this.b = false;
    }
}
