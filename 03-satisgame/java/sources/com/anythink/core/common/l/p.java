package com.anythink.core.common.l;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class p extends c {
    private static final String a = "p";
    private final s c;
    private volatile boolean g;
    private volatile boolean h;
    private final Object b = new Object();
    private final AtomicInteger d = new AtomicInteger(0);
    private final List<a> e = new ArrayList();
    private int f = Math.max(1, 2);

    protected void a(int i) {
    }

    protected void a(int i, Object obj) {
    }

    public p(s sVar) {
        this.c = sVar;
    }

    @Override // com.anythink.core.common.l.s
    public void onLoadFinish(int i, Object obj) {
        a(i, obj);
        synchronized (this.b) {
            this.h = true;
            if (this.c != null && !this.g) {
                this.g = true;
                this.c.onLoadFinish(i, obj);
            }
        }
    }

    @Override // com.anythink.core.common.l.s
    public void onLoadError(int i, String str, AdError adError) {
        a(i);
        synchronized (this.b) {
            this.e.add(new a(i, str, adError));
            if (this.d.incrementAndGet() >= this.f) {
                c();
            }
        }
    }

    public final void a() {
        synchronized (this.b) {
            if (this.g) {
                return;
            }
            int i = this.f;
            if (i > 1) {
                this.f = i - 1;
            }
            if (this.d.get() >= this.f && !this.e.isEmpty()) {
                c();
            }
        }
    }

    private void b(int i, Object obj) {
        this.h = true;
        if (this.c == null || this.g) {
            return;
        }
        this.g = true;
        this.c.onLoadFinish(i, obj);
    }

    private void c() {
        if (this.c == null || this.g) {
            return;
        }
        this.g = true;
        StringBuilder sb = new StringBuilder();
        AdError errorCode = null;
        for (a aVar : new ArrayList(this.e)) {
            if (aVar != null) {
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(aVar.b);
                } else {
                    sb.append(",");
                    sb.append(aVar.b);
                }
                errorCode = aVar.c;
            }
        }
        this.e.clear();
        if (errorCode == null) {
            errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", "");
        }
        this.c.onLoadError(0, sb.toString(), errorCode);
    }

    public final boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.h;
        }
        return z;
    }

    private static class a {
        int a;
        String b;
        AdError c;

        public a(int i, String str, AdError adError) {
            this.a = i;
            this.b = str;
            this.c = adError;
        }
    }
}
