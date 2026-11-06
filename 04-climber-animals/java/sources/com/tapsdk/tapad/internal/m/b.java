package com.tapsdk.tapad.internal.m;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class b<T> extends Handler {
    private Set<T> a;
    private final c.InterfaceC0623c b;
    private final c.b c;
    private final c.a<T> d;
    private final long e;

    private b() {
        super(Looper.getMainLooper());
        this.a = new HashSet();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0L;
    }

    public b(Looper looper, c.InterfaceC0623c interfaceC0623c, c.b bVar, c.a<T> aVar, long j) {
        super(looper);
        this.a = new HashSet();
        this.b = interfaceC0623c;
        this.c = bVar;
        this.d = aVar;
        this.e = j;
    }

    private void a(int i, View view, T t) {
        this.a.add(t);
        this.d.a(i, view);
    }

    private void a(T t, int i, View view) {
        this.c.a(i, view);
        a(i, view, t);
    }

    void a() {
        this.a.clear();
    }

    public void b() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            int i = message.what;
            View view = (View) message.obj;
            T tA = this.d.a(i, view);
            c.InterfaceC0623c interfaceC0623c = this.b;
            if (interfaceC0623c == null || interfaceC0623c.a(i, view)) {
                a(tA, i, view);
            } else if (this.e > 0) {
                sendMessageDelayed(Message.obtain(message), this.e);
            }
        }
    }
}
