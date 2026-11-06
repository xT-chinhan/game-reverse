package com.anythink.core.common.k.d;

import android.content.Context;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.IATBaseAdAdapter;
import com.anythink.core.common.h.n;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private Context a;
    private BaseAd b;
    private n c;
    private ATNativeAdCustomRender d;
    private com.anythink.core.common.k.e.a.b e;
    private com.anythink.core.common.k.b.a.b f;
    private boolean g;
    private b h;
    private int i;
    private int j;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }

    public final Context a() {
        return this.a;
    }

    public final BaseAd b() {
        return this.b;
    }

    public final ATNativeAdCustomRender c() {
        return this.d;
    }

    public final com.anythink.core.common.k.e.a.b d() {
        return this.e;
    }

    public final int e() {
        b bVar = this.h;
        if (bVar != null) {
            return bVar.e();
        }
        return -1;
    }

    private int l() {
        b bVar = this.h;
        if (bVar != null) {
            return bVar.b();
        }
        return -1;
    }

    public final IATBaseAdAdapter f() {
        b bVar = this.h;
        if (bVar != null) {
            return bVar.r();
        }
        return null;
    }

    public final n g() {
        return this.c;
    }

    public final boolean h() {
        return this.g;
    }

    public final com.anythink.core.common.k.b.a.b i() {
        return this.f;
    }

    public final void a(b bVar) {
        this.h = bVar;
    }

    public final int a(String str) {
        b bVar = this.h;
        return Math.max(bVar != null ? ((Integer) bVar.a(str, 5)).intValue() : 5, 3);
    }

    public final int j() {
        return this.i;
    }

    public final int k() {
        return this.j;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.k.d.a$a, reason: collision with other inner class name */
    public static class C0028a {
        private Context a;
        private BaseAd b;
        private n c;
        private ATNativeAdCustomRender d;
        private com.anythink.core.common.k.e.a.b e;
        private com.anythink.core.common.k.b.a.b f;
        private boolean g;
        private int h;
        private int i;

        public final C0028a a(Context context) {
            this.a = context;
            return this;
        }

        public final C0028a a(BaseAd baseAd) {
            this.b = baseAd;
            return this;
        }

        public final C0028a a(ATNativeAdCustomRender aTNativeAdCustomRender) {
            this.d = aTNativeAdCustomRender;
            return this;
        }

        public final C0028a a(com.anythink.core.common.k.e.a.b bVar) {
            this.e = bVar;
            return this;
        }

        public final C0028a a(n nVar) {
            this.c = nVar;
            return this;
        }

        public final C0028a a(boolean z) {
            this.g = z;
            return this;
        }

        public final C0028a a(com.anythink.core.common.k.b.a.b bVar) {
            this.f = bVar;
            return this;
        }

        public final C0028a a(int i) {
            this.h = i;
            return this;
        }

        public final C0028a b(int i) {
            this.i = i;
            return this;
        }

        public final a a() {
            a aVar = new a((byte) 0);
            aVar.a = this.a;
            aVar.b = this.b;
            aVar.d = this.d;
            aVar.e = this.e;
            aVar.f = this.f;
            aVar.c = this.c;
            aVar.g = this.g;
            aVar.i = this.h;
            aVar.j = this.i;
            return aVar;
        }
    }
}
