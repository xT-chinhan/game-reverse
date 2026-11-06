package com.anythink.core.common.m;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class n extends b {
    private static final String a = "n";
    private final q c;
    private volatile boolean g;
    private volatile boolean h;
    private final Object b = new Object();
    private final AtomicInteger d = new AtomicInteger(0);
    private final List<a> e = new ArrayList();
    private final int f = 2;

    public n(q qVar) {
        this.c = qVar;
    }

    @Override // com.anythink.core.common.m.q
    public void onLoadFinish(int i, Object obj) {
        synchronized (this.b) {
            Object[] objArr = new Object[1];
            Boolean.valueOf(this.g);
            this.h = true;
            if (this.c != null && !this.g) {
                this.g = true;
                this.c.onLoadFinish(i, obj);
            }
        }
    }

    @Override // com.anythink.core.common.m.q
    public void onLoadError(int i, String str, AdError adError) {
        synchronized (this.b) {
            this.e.add(new a(i, str, adError));
            int iIncrementAndGet = this.d.incrementAndGet();
            Object[] objArr = new Object[4];
            Integer.valueOf(iIncrementAndGet);
            Boolean.valueOf(this.g);
            Integer.valueOf(this.f);
            if (iIncrementAndGet == this.f) {
                Object[] objArr2 = new Object[2];
                Boolean.valueOf(this.g);
                Integer.valueOf(this.f);
                if (this.c != null && !this.g) {
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
            }
        }
    }

    private void a(int i, Object obj) {
        Object[] objArr = new Object[1];
        Boolean.valueOf(this.g);
        this.h = true;
        if (this.c == null || this.g) {
            return;
        }
        this.g = true;
        this.c.onLoadFinish(i, obj);
    }

    private void b() {
        Object[] objArr = new Object[2];
        Boolean.valueOf(this.g);
        Integer.valueOf(this.f);
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

    public final boolean a() {
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
