package com.bytedance.sdk.component.x.ms;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ka {
    private com.bytedance.sdk.component.x.xr.d.xr.ms ab;
    private String ah;
    private com.bytedance.sdk.component.x.xr.d.xr.ms c;
    private boolean ch;
    private Context d;
    private d hi;
    private com.bytedance.sdk.component.x.xr.d.xr.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private c f1543ms;
    private com.bytedance.sdk.component.x.xr.d.xr.ms ny;
    private AtomicBoolean sl;
    private int u;
    private com.bytedance.sdk.component.x.xr.d.xr.ms x;
    private ch xr;
    private int zb;

    private ms() {
        this.sl = new AtomicBoolean(false);
        this.zb = 200;
        this.u = 10;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public com.bytedance.sdk.component.x.xr.d.xr.ms ms() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public Context getContext() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public c xr() {
        return this.f1543ms;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public void ms(c cVar) {
        this.f1543ms = cVar;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public void ms(boolean z) {
        this.sl.set(z);
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public boolean ah() {
        return this.sl.get();
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public d d() {
        return this.hi;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public String ka() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public com.bytedance.sdk.component.x.xr.d.xr.ms c() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public com.bytedance.sdk.component.x.xr.d.xr.ms ab() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public com.bytedance.sdk.component.x.xr.d.xr.ms x() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public com.bytedance.sdk.component.x.xr.d.xr.ms ny() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public ch ch() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.x.ms.ka
    public boolean hi() {
        return this.ch;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.x.ms.ms$ms, reason: collision with other inner class name */
    public static class C0254ms {
        private d ab;
        private com.bytedance.sdk.component.x.xr.d.xr.ms ah;
        private boolean c;
        private com.bytedance.sdk.component.x.xr.d.xr.ms d;
        private com.bytedance.sdk.component.x.xr.d.xr.ms ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ch f1544ms;
        private String sl;
        private c x;
        private com.bytedance.sdk.component.x.xr.d.xr.ms xr;
        private Context zb;
        private final AtomicBoolean ny = new AtomicBoolean(false);
        private int ch = 5000;
        private int hi = 10;

        public C0254ms ms(Context context) {
            this.zb = context;
            return this;
        }

        public C0254ms ms(String str) {
            this.sl = str;
            return this;
        }

        public C0254ms ms(boolean z) {
            this.ny.set(z);
            return this;
        }

        public C0254ms ms(c cVar) {
            this.x = cVar;
            return this;
        }

        public C0254ms ms(d dVar) {
            this.ab = dVar;
            return this;
        }

        public C0254ms xr(boolean z) {
            this.c = z;
            return this;
        }

        public C0254ms ms(com.bytedance.sdk.component.x.xr.d.xr.ms msVar) {
            this.xr = msVar;
            return this;
        }

        public C0254ms xr(com.bytedance.sdk.component.x.xr.d.xr.ms msVar) {
            this.ah = msVar;
            return this;
        }

        public C0254ms ah(com.bytedance.sdk.component.x.xr.d.xr.ms msVar) {
            this.d = msVar;
            return this;
        }

        public ms ms() {
            ms msVar = new ms();
            msVar.xr = this.f1544ms;
            msVar.ka = this.xr;
            msVar.c = this.ah;
            msVar.ab = this.d;
            msVar.x = this.ka;
            msVar.ch = this.c;
            msVar.hi = this.ab;
            msVar.f1543ms = this.x;
            msVar.sl = this.ny;
            msVar.ah = this.sl;
            msVar.d = this.zb;
            msVar.u = this.hi;
            msVar.zb = this.ch;
            return msVar;
        }
    }
}
