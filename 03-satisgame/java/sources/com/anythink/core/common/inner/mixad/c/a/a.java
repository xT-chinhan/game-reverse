package com.anythink.core.common.inner.mixad.c.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.k.e.a.b;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private ATNativeAdInfo a;
    private x b;
    private w<?> c;
    private Context d;
    private WeakReference<Context> e;
    private boolean f;
    private String g;
    private int h;
    private boolean i;
    private b j;
    private View k;
    private int l;
    private int m;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }

    public final ATNativeAdInfo a() {
        return this.a;
    }

    public final x b() {
        return this.b;
    }

    public final w<?> c() {
        return this.c;
    }

    public final boolean d() {
        return this.f;
    }

    public final String e() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public final boolean g() {
        return this.i;
    }

    public final b h() {
        return this.j;
    }

    public final View i() {
        return this.k;
    }

    public final void a(View view) {
        this.k = view;
    }

    public final Context j() {
        Context context = this.d;
        WeakReference<Context> weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            context = this.e.get();
        }
        return context == null ? s.b().g() : context;
    }

    public final int k() {
        return this.l;
    }

    public final int l() {
        return this.m;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.mixad.c.a.a$a, reason: collision with other inner class name */
    public static class C0024a {
        private Context a;
        private ATNativeAdInfo b;
        private x c;
        private w<?> d;
        private boolean e;
        private String f;
        private int g;
        private boolean h;
        private b i;
        private View j;
        private int k;
        private int l;

        public final C0024a a(a aVar) {
            if (aVar != null) {
                this.a = aVar.j();
                this.d = aVar.c();
                this.c = aVar.b();
                this.i = aVar.h();
                this.b = aVar.a();
                this.j = aVar.i();
                this.h = aVar.g();
                this.e = aVar.d();
                this.g = aVar.f();
                this.f = aVar.e();
                this.k = aVar.k();
                this.l = aVar.l();
            }
            return this;
        }

        public final C0024a a(ATNativeAdInfo aTNativeAdInfo) {
            this.b = aTNativeAdInfo;
            return this;
        }

        private b b() {
            return this.i;
        }

        public final C0024a a(b bVar) {
            this.i = bVar;
            return this;
        }

        public final C0024a a(x xVar) {
            this.c = xVar;
            return this;
        }

        public final C0024a a(w<?> wVar) {
            this.d = wVar;
            return this;
        }

        public final C0024a a(boolean z) {
            this.e = z;
            return this;
        }

        public final C0024a a(String str) {
            this.f = str;
            return this;
        }

        public final C0024a a(int i) {
            this.g = i;
            return this;
        }

        public final C0024a a(Context context) {
            this.a = context;
            return this;
        }

        public final C0024a b(boolean z) {
            this.h = z;
            return this;
        }

        private C0024a a(View view) {
            this.j = view;
            return this;
        }

        public final C0024a b(int i) {
            this.k = i;
            return this;
        }

        public final C0024a c(int i) {
            this.l = i;
            return this;
        }

        public final a a() {
            a aVar = new a((byte) 0);
            Context context = this.a;
            if (context instanceof Activity) {
                aVar.e = new WeakReference(this.a);
            } else {
                aVar.d = context;
            }
            aVar.a = this.b;
            aVar.k = this.j;
            aVar.i = this.h;
            aVar.j = this.i;
            aVar.c = this.d;
            aVar.b = this.c;
            aVar.f = this.e;
            aVar.h = this.g;
            aVar.g = this.f;
            aVar.l = this.k;
            aVar.m = this.l;
            return aVar;
        }
    }
}
