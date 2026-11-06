package com.bytedance.sdk.openadsdk.core.component.ms;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.ny;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.op.ch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f2050ms;
    private final yu xr = re.ms();

    public static ms ms() {
        if (f2050ms == null) {
            synchronized (ms.class) {
                if (f2050ms == null) {
                    f2050ms = new ms();
                }
            }
        }
        return f2050ms;
    }

    private ms() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ms(final Context context, final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah ahVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        e eVar = new e();
        if (ahVar != 0 && (ahVar instanceof com.bytedance.sdk.openadsdk.core.ms.xr)) {
            eVar.x = ((com.bytedance.sdk.openadsdk.core.ms.xr) ahVar).ms();
        }
        this.xr.ms(xrVar, eVar, 5, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ms.1
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                ahVar.ms(i, str);
                xrVar2.ms(i);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(final com.bytedance.sdk.openadsdk.core.nw.ms msVar, final com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                ab.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ms.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.ms(msVar, context, xrVar, jCurrentTimeMillis, ahVar, xrVar2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, Context context, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, long j, com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah ahVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
        if (msVar.xr() != null && !msVar.xr().isEmpty()) {
            List<lm> listXr = msVar.xr();
            ArrayList arrayList = new ArrayList(listXr.size());
            Iterator<lm> it = listXr.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                lm next = it.next();
                if (next.jl()) {
                    arrayList.add(new ah(context, next, 5, xrVar));
                }
                if (!lm.ms(next) || ch.ms(next)) {
                    if (!TextUtils.isEmpty(qr.ms(next))) {
                        if (re.xr().d(String.valueOf(f.ny(next))) && re.xr().ue()) {
                            if (qr.u(next) != null) {
                                qr.u(next).ka(1);
                            }
                            if (qr.ub(next) != null) {
                                qr.ub(next).ka(1);
                            }
                            d dVarMs = qr.ms(4, next);
                            dVarMs.ms("material_meta", next);
                            dVarMs.ms("ad_slot", Integer.valueOf(xrVar != null ? xrVar.t() : 0));
                            com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms) null);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(listXr.get(0), f.xr(xrVar.t()), j);
                ahVar.ms(arrayList);
                return;
            } else {
                ahVar.ms(-4, ny.ms(-4));
                xrVar2.ms(-4);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                return;
            }
        }
        ahVar.ms(-3, ny.ms(-3));
        xrVar2.ms(-3);
        com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void xr(final Context context, final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah ahVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        e eVar = new e();
        if (ahVar != 0 && (ahVar instanceof com.bytedance.sdk.openadsdk.core.ms.xr)) {
            eVar.x = ((com.bytedance.sdk.openadsdk.core.ms.xr) ahVar).ms();
        }
        this.xr.ms(xrVar, eVar, 6, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                ahVar.ms(i, str);
                xrVar2.ms(i);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(final com.bytedance.sdk.openadsdk.core.nw.ms msVar, final com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                ab.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ms.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr(msVar, context, xrVar, jCurrentTimeMillis, ahVar, xrVar2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.sdk.openadsdk.core.nw.ms msVar, Context context, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, long j, com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah ahVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
        if (msVar.xr() != null && !msVar.xr().isEmpty()) {
            List<lm> listXr = msVar.xr();
            ArrayList arrayList = new ArrayList(listXr.size());
            Iterator<lm> it = listXr.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                lm next = it.next();
                if (next.jl()) {
                    arrayList.add(new ah(context, next, 6, xrVar));
                }
                if (!lm.ms(next) || ch.ms(next)) {
                    if (!TextUtils.isEmpty(qr.ms(next))) {
                        if (re.xr().d(String.valueOf(f.ny(next))) && re.xr().ue()) {
                            if (qr.u(next) != null) {
                                qr.u(next).ka(1);
                            }
                            if (qr.u(next) != null) {
                                qr.u(next).ka(1);
                            }
                            d dVarMs = qr.ms(4, next);
                            dVarMs.ms("material_meta", next);
                            dVarMs.ms("ad_slot", Integer.valueOf(xrVar != null ? xrVar.t() : 0));
                            com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms) null);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(listXr.get(0), f.xr(xrVar.t()), j);
                ahVar.ms(arrayList);
                return;
            } else {
                ahVar.ms(-4, ny.ms(-4));
                xrVar2.ms(-4);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                return;
            }
        }
        ahVar.ms(-3, ny.ms(-3));
        xrVar2.ms(-3);
        com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ms(final Context context, final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.xr xrVar2) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        e eVar = new e();
        if (xrVar2 != 0 && (xrVar2 instanceof com.bytedance.sdk.openadsdk.core.ms.xr)) {
            eVar.x = ((com.bytedance.sdk.openadsdk.core.ms.xr) xrVar2).ms();
        }
        this.xr.ms(xrVar, eVar, 9, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ms.3
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar3) {
                xrVar2.ms(i, str);
                xrVar3.ms(i);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(final com.bytedance.sdk.openadsdk.core.nw.ms msVar, final com.bytedance.sdk.openadsdk.core.nw.xr xrVar3) {
                ab.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ms.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.ms(msVar, context, xrVar, jCurrentTimeMillis, xrVar2, xrVar3);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, Context context, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, long j, com.bytedance.sdk.openadsdk.t.ms.xr.ms.xr xrVar2, com.bytedance.sdk.openadsdk.core.nw.xr xrVar3) {
        if (msVar.xr() != null && !msVar.xr().isEmpty()) {
            List<lm> listXr = msVar.xr();
            ArrayList arrayList = new ArrayList(listXr.size());
            Iterator<lm> it = listXr.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                lm next = it.next();
                if (next.jl()) {
                    arrayList.add(new xr(context, next, 9, xrVar));
                }
                if (!TextUtils.isEmpty(qr.ms(next))) {
                    if (re.xr().d(String.valueOf(f.ny(next))) && re.xr().ue()) {
                        if (qr.u(next) != null) {
                            qr.u(next).ka(1);
                        }
                        if (qr.ub(next) != null) {
                            qr.ub(next).ka(1);
                        }
                        d dVarMs = qr.ms(4, next);
                        dVarMs.ms("material_meta", next);
                        dVarMs.ms("ad_slot", Integer.valueOf(xrVar != null ? xrVar.t() : 0));
                        com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms) null);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(listXr.get(0), f.xr(xrVar.t()), j);
                xrVar2.ms(arrayList);
                return;
            } else {
                xrVar2.ms(-4, ny.ms(-4));
                xrVar3.ms(-4);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar3);
                return;
            }
        }
        xrVar2.ms(-3, ny.ms(-3));
        xrVar3.ms(-3);
        com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar3);
    }
}
