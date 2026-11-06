package com.bytedance.sdk.component.xr.ms;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends x implements Cloneable {
    static final List<zb> x = com.bytedance.sdk.component.xr.ms.xr.ch.ms(zb.HTTP_2, zb.HTTP_1_1);
    public TimeUnit ab;
    public TimeUnit ah;
    public long c;
    public Set<String> ch;
    public long d;
    public re.ms hi;
    public TimeUnit ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public List<ny> f1618ms;
    public List<zb> ny;
    public Bundle sl;
    public long xr;

    public d ms() {
        return null;
    }

    public xr ms(u uVar) {
        return null;
    }

    public sl() {
        this(new ms());
    }

    public sl(ms msVar) {
        this.xr = msVar.ah;
        this.d = msVar.ka;
        this.c = msVar.ab;
        this.ah = msVar.d;
        this.ka = msVar.c;
        this.ab = msVar.x;
        this.f1618ms = msVar.f1619ms;
        this.ny = msVar.ny;
        this.ch = msVar.ch;
    }

    public sl(re.ms msVar) {
        this.xr = msVar.i;
        this.d = msVar.w;
        this.c = msVar.yu;
        this.ah = msVar.g;
        this.ka = msVar.of;
        this.ab = msVar.p;
        this.ch = msVar.cv;
        this.hi = msVar;
    }

    public static final class ms {
        public long ab;
        public long ah;
        public TimeUnit c;
        public Set<String> ch;
        public TimeUnit d;
        public Bundle hi;
        public long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final List<ny> f1619ms;
        List<zb> ny;
        private re.ms sl;
        public TimeUnit x;
        public com.bytedance.sdk.component.xr.ms.ms.ms.ms xr;

        public ms() {
            this.f1619ms = new ArrayList();
            this.ah = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.d = TimeUnit.MILLISECONDS;
            this.ka = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.c = TimeUnit.MILLISECONDS;
            this.ab = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.x = TimeUnit.MILLISECONDS;
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr()) {
                this.sl = new re.ms();
            }
        }

        public ms(String str) {
            this.f1619ms = new ArrayList();
            this.ah = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.d = TimeUnit.MILLISECONDS;
            this.ka = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.c = TimeUnit.MILLISECONDS;
            this.ab = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.x = TimeUnit.MILLISECONDS;
            this.ny = sl.x;
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr()) {
                this.sl = new re.ms();
            }
        }

        public ms(sl slVar) {
            this.f1619ms = new ArrayList();
            this.ah = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.d = TimeUnit.MILLISECONDS;
            this.ka = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.c = TimeUnit.MILLISECONDS;
            this.ab = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.x = TimeUnit.MILLISECONDS;
            this.ah = slVar.xr;
            this.d = slVar.ah;
            this.ka = slVar.d;
            this.c = slVar.ka;
            this.ab = slVar.c;
            this.x = slVar.ab;
            this.ny = slVar.ny;
            this.ch = slVar.ch;
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr()) {
                this.sl = slVar.hi;
            }
            re.ms msVar = this.sl;
            if (msVar != null) {
                msVar.i = (int) slVar.xr;
                this.sl.g = slVar.ah;
                this.sl.w = (int) slVar.d;
                this.sl.of = slVar.ka;
                this.sl.yu = (int) slVar.c;
                this.sl.p = slVar.ab;
                this.sl.cv = slVar.ch;
                this.sl.le = slVar.sl;
            }
        }

        public ms ms(long j, TimeUnit timeUnit) {
            re.ms msVar;
            this.ah = j;
            this.d = timeUnit;
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr() && (msVar = this.sl) != null) {
                msVar.ms(this.ah, timeUnit);
            }
            return this;
        }

        public ms xr(long j, TimeUnit timeUnit) {
            re.ms msVar;
            this.ka = j;
            this.c = timeUnit;
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr() && (msVar = this.sl) != null) {
                msVar.xr(this.ka, timeUnit);
            }
            return this;
        }

        public ms ah(long j, TimeUnit timeUnit) {
            re.ms msVar;
            this.ab = j;
            this.x = timeUnit;
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr() && (msVar = this.sl) != null) {
                msVar.ah(this.ab, timeUnit);
            }
            return this;
        }

        public ms ms(com.bytedance.sdk.component.xr.ms.ms.ms.ms msVar) {
            re.ms msVar2;
            this.xr = msVar;
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr() && (msVar2 = this.sl) != null) {
                msVar2.ms(new com.bytedance.sdk.component.xr.ms.ms.ms.ah(msVar));
            }
            return this;
        }

        public ms ms(final ny nyVar) {
            re.ms msVar;
            this.f1619ms.add(nyVar);
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr() && (msVar = this.sl) != null) {
                msVar.ms(new t() { // from class: com.bytedance.sdk.component.xr.ms.sl.ms.1
                    @Override // com.bytedance.sdk.component.ah.xr.t
                    public cv ms(t.ms msVar2) throws IOException {
                        return ((com.bytedance.sdk.component.xr.ms.ms.ms.ny) nyVar.ms(new com.bytedance.sdk.component.xr.ms.ms.ms.ka(msVar2))).f1608ms;
                    }
                });
            }
            return this;
        }

        public ms ms(Set<String> set) {
            this.ch = set;
            re.ms msVar = this.sl;
            if (msVar != null) {
                msVar.ms(set);
            }
            return this;
        }

        public ms ms(List<zb> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(zb.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(zb.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(zb.SPDY_3);
            this.ny = Collections.unmodifiableList(arrayList);
            return this;
        }

        public ms ms(Bundle bundle) {
            this.hi = bundle;
            re.ms msVar = this.sl;
            if (msVar != null) {
                msVar.le = bundle;
            }
            return this;
        }

        public sl ms() {
            if (com.bytedance.sdk.component.xr.ms.ms.ms.ms().xr()) {
                return com.bytedance.sdk.component.xr.ms.ms.ms.ms(this.sl);
            }
            return com.bytedance.sdk.component.xr.ms.ms.ms.ms(this);
        }
    }

    public ms xr() {
        return new ms(this);
    }
}
