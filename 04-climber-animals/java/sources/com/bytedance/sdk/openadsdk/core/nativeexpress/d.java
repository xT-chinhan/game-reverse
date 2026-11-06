package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private List<lm> ab;
    private Context ah;
    private List<lm> c;
    private com.bytedance.sdk.openadsdk.t.ms.xr.ms.c d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr f2960ms;
    private ms x;
    private final AtomicBoolean ka = new AtomicBoolean(false);
    private int ny = 5;
    private ScheduledFuture<?> ch = null;
    private ScheduledFuture<?> hi = null;
    private AtomicBoolean sl = new AtomicBoolean(false);
    private final com.bytedance.sdk.openadsdk.core.yu xr = com.bytedance.sdk.openadsdk.core.re.ms();

    public interface ms {
        void ms();

        void ms(List<lm> list);
    }

    private d(Context context) {
        if (context != null) {
            this.ah = context.getApplicationContext();
        } else {
            this.ah = com.bytedance.sdk.openadsdk.core.re.getContext();
        }
    }

    public static d ms(Context context) {
        return new d(context);
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, int i, com.bytedance.sdk.openadsdk.t.ms.xr.ms.c cVar, int i2) {
        ms(xrVar, i, cVar, null, i2);
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, int i, com.bytedance.sdk.openadsdk.t.ms.xr.ms.c cVar, ms msVar, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.ka.get()) {
            com.bytedance.sdk.component.utils.sl.d("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.ny = i;
        this.ka.set(true);
        this.f2960ms = xrVar;
        this.d = cVar;
        this.x = msVar;
        ms(xrVar, jCurrentTimeMillis);
    }

    private void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final long j) {
        if (xrVar == null) {
            return;
        }
        e eVar = new e();
        eVar.c = 2;
        Object obj = this.d;
        if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.ms.xr)) {
            eVar.x = ((com.bytedance.sdk.openadsdk.core.ms.xr) obj).ms();
        }
        this.xr.ms(xrVar, eVar, this.ny, new com.bytedance.sdk.openadsdk.core.yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.1
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                d.this.ms(i, str);
                xrVar2.ms(i);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                if (msVar.xr() == null || msVar.xr().isEmpty()) {
                    d.this.ms(-3, com.bytedance.sdk.openadsdk.core.ny.ms(-3));
                    xrVar2.ms(-3);
                    com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                } else {
                    d.this.c = new CopyOnWriteArrayList(msVar.xr());
                    d.this.ab = new CopyOnWriteArrayList(msVar.xr());
                    d.this.ms(xrVar);
                    d.this.ms(j);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (this.c == null) {
            return;
        }
        String strKa = (xrVar == null || !(xrVar.t() == 3 || xrVar.t() == 4)) ? null : com.bytedance.sdk.openadsdk.op.ny.ka();
        for (lm lmVar : this.c) {
            com.bytedance.sdk.openadsdk.core.video.ah.ms.xr(lmVar);
            if (lmVar.jl() && lmVar.fk() != null && !lmVar.fk().isEmpty()) {
                for (g gVar : lmVar.fk()) {
                    if (!TextUtils.isEmpty(gVar.ms())) {
                        com.bytedance.sdk.openadsdk.core.re.ka.ms().ah().ms(new com.bytedance.sdk.openadsdk.zb.xr(gVar.ms(), gVar.ab()), com.bytedance.sdk.openadsdk.core.re.ms.ms.xr(), gVar.xr(), gVar.ah(), strKa);
                    }
                }
            }
            if (!TextUtils.isEmpty(qr.ms(lmVar))) {
                if (com.bytedance.sdk.openadsdk.core.re.xr().d(String.valueOf(f.ny(lmVar))) && com.bytedance.sdk.openadsdk.core.re.xr().ue()) {
                    com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, lmVar);
                    dVarMs.ms("material_meta", lmVar);
                    dVarMs.ms("ad_slot", Integer.valueOf(xrVar != null ? xrVar.t() : 0));
                    com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final long j) {
        this.sl.set(false);
        if (this.ka.getAndSet(false)) {
            com.bytedance.sdk.openadsdk.op.ab.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ab == null || d.this.ab.size() <= 0) {
                        if (d.this.d != null) {
                            d.this.d.ms(108, com.bytedance.sdk.openadsdk.core.ny.ms(108));
                            d.this.ms(108);
                        }
                        if (d.this.x != null) {
                            d.this.x.ms();
                        }
                        d.this.xr();
                        return;
                    }
                    if (d.this.d != null) {
                        d dVar = d.this;
                        if (!dVar.ms((List<lm>) dVar.ab)) {
                            d.this.xr(j);
                        } else {
                            d.this.ka(j);
                        }
                    }
                    if (d.this.x != null) {
                        d.this.x.ms(d.this.ab);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(List<lm> list) {
        if (list != null && list.size() != 0) {
            Iterator<lm> it = list.iterator();
            while (it.hasNext()) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ny(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final long j) {
        com.bytedance.sdk.openadsdk.core.sl.ms.ms(this.ab, new com.bytedance.sdk.component.adexpress.ms.xr.ab.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.3
            @Override // com.bytedance.sdk.component.adexpress.ms.xr.ab.ms
            public void ms() {
                d.this.ah(j);
            }

            @Override // com.bytedance.sdk.component.adexpress.ms.xr.ab.ms
            public void xr() {
                d.this.ah(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(final long j) {
        if (this.sl.get()) {
            return;
        }
        this.sl.set(true);
        com.bytedance.sdk.openadsdk.op.ab.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.d(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) {
        List<com.bytedance.sdk.openadsdk.ao.xr.xr.u> listMs = ms();
        if (!listMs.isEmpty()) {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ab.get(0), f.xr(this.f2960ms.t()), j);
            this.d.ms(listMs);
        } else {
            this.d.ms(104, com.bytedance.sdk.openadsdk.core.ny.ms(104));
            ms(104);
        }
        xr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(final long j) {
        com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(this.ab, new ao() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.5
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ao
            public void ms() {
                d.this.ah(j);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ao
            public void xr() {
                d.this.ah(j);
            }
        });
    }

    private List<com.bytedance.sdk.openadsdk.ao.xr.xr.u> ms() {
        if (this.ny != 5) {
            ArrayList arrayList = new ArrayList(this.ab.size());
            Iterator<lm> it = this.ab.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.ao.xr.xr.u uVarMs = ms(it.next());
                if (uVarMs != null) {
                    arrayList.add(uVarMs);
                }
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (lm lmVar : this.ab) {
            if (lmVar != null) {
                arrayList2.add(lmVar);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        if (arrayList2.size() > 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.openadsdk.ao.xr.xr.u uVarMs2 = ms((lm) it2.next());
                if (uVarMs2 != null) {
                    arrayList3.add(uVarMs2);
                }
            }
            arrayList2.clear();
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final int i) {
        com.bytedance.sdk.openadsdk.core.t.u.ms().ka(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.6
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarC = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(d.this.ny).ah(d.this.f2960ms.d()).c((d.this.c == null || d.this.c.size() <= 0) ? "" : f.zb((lm) d.this.c.get(0)));
                xrVarC.xr(i).ab(com.bytedance.sdk.openadsdk.core.ny.ms(i));
                return xrVarC;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str) {
        if (this.ka.getAndSet(false)) {
            com.bytedance.sdk.openadsdk.t.ms.xr.ms.c cVar = this.d;
            if (cVar != null) {
                cVar.ms(i, str);
            }
            ms msVar = this.x;
            if (msVar != null) {
                msVar.ms();
            }
            xr();
        }
    }

    private com.bytedance.sdk.openadsdk.ao.xr.xr.u ms(lm lmVar) {
        if (this.ah == null) {
            return null;
        }
        boolean z = qr.u(lmVar) != null;
        int i = this.ny;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.ah(this.ah, lmVar, this.f2960ms);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.xr(this.ah, lmVar, this.f2960ms);
        }
        if (i == 5) {
            if (z) {
                return new w(this.ah, lmVar, this.f2960ms);
            }
            return new re(this.ah, lmVar, this.f2960ms);
        }
        if (i == 9) {
            return new i(this.ah, lmVar, this.f2960ms);
        }
        com.bytedance.sdk.component.utils.sl.xr("ExpressAdLoadManager", "not support adslog:" + this.ny);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        List<lm> list = this.c;
        if (list != null) {
            list.clear();
        }
        List<lm> list2 = this.ab;
        if (list2 != null) {
            list2.clear();
        }
        ms(true);
        xr(true);
    }

    private void ms(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.ch;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            com.bytedance.sdk.component.utils.sl.d("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=".concat(String.valueOf(this.ch.cancel(z))));
        } catch (Throwable unused) {
        }
    }

    private void xr(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.hi;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.hi.cancel(z);
        } catch (Throwable unused) {
        }
    }

    public static class xr implements ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final ms f2967ms;

        public xr(ms msVar) {
            this.f2967ms = msVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms
        public void ms(final List<lm> list) {
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.f2967ms.ms(list);
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms
        public void ms() {
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.d.xr.2
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.f2967ms.ms();
                }
            });
        }
    }
}
