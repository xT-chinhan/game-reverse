package com.bytedance.sdk.component.c.ah;

import android.content.Context;
import com.bytedance.sdk.component.c.h;
import com.bytedance.sdk.component.c.nw;
import com.bytedance.sdk.component.c.qv;
import com.bytedance.sdk.component.c.sl;
import com.bytedance.sdk.component.c.y;
import com.bytedance.sdk.component.c.zb;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements zb {
    private h ab;
    private com.bytedance.sdk.component.c.d ah;
    private com.bytedance.sdk.component.c.ah c;
    private qv d;
    private y ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private sl f1163ms;
    private nw ny;
    private com.bytedance.sdk.component.c.xr x;
    private ExecutorService xr;

    private ka(ms msVar) {
        this.f1163ms = msVar.f1164ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah;
        this.d = msVar.d;
        this.ka = msVar.ka;
        this.c = msVar.c;
        this.x = msVar.x;
        this.ab = msVar.ab;
        this.ny = msVar.ny;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public sl ms() {
        return this.f1163ms;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public ExecutorService xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public com.bytedance.sdk.component.c.d d() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public qv ka() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public y c() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public com.bytedance.sdk.component.c.ah ab() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public h x() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public nw ah() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.component.c.zb
    public com.bytedance.sdk.component.c.xr ny() {
        return this.x;
    }

    public static ka ms(Context context) {
        return new ms().ms();
    }

    public static class ms {
        private h ab;
        private com.bytedance.sdk.component.c.d ah;
        private com.bytedance.sdk.component.c.ah c;
        private qv d;
        private y ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private sl f1164ms;
        private nw ny;
        private com.bytedance.sdk.component.c.xr x;
        private ExecutorService xr;

        public ms ms(com.bytedance.sdk.component.c.xr xrVar) {
            this.x = xrVar;
            return this;
        }

        public ms ms(ExecutorService executorService) {
            this.xr = executorService;
            return this;
        }

        public ms ms(com.bytedance.sdk.component.c.d dVar) {
            this.ah = dVar;
            return this;
        }

        public ka ms() {
            return new ka(this);
        }
    }
}
