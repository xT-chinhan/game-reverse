package com.anythink.banner.a;

import android.content.Context;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.b.e;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class b implements CustomBannerEventListener {
    WeakReference<d> a;
    CustomBannerAdapter b;
    boolean c;

    public b(d dVar, CustomBannerAdapter customBannerAdapter, boolean z) {
        this.c = false;
        this.a = new WeakReference<>(dVar);
        this.b = customBannerAdapter;
        this.c = z;
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdClose() {
        final CustomBannerAdapter customBannerAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(e.am, new Runnable() { // from class: com.anythink.banner.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (customBannerAdapter != null) {
                    com.anythink.core.common.u.c.a().c(customBannerAdapter);
                    d dVar = b.this.a.get();
                    if (dVar != null) {
                        dVar.onBannerClose(customBannerAdapter);
                    }
                    n trackingInfo = customBannerAdapter.getTrackingInfo();
                    aa.a(trackingInfo, i.s.e, i.s.m, "");
                    if (trackingInfo != null) {
                        f.a(trackingInfo, false);
                    }
                }
                s.b().ai();
            }
        }));
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdShow() {
        final CustomBannerAdapter customBannerAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(e.an, new Runnable() { // from class: com.anythink.banner.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                if (customBannerAdapter != null) {
                    com.anythink.core.common.u.c.a().a(customBannerAdapter);
                    d dVar = b.this.a.get();
                    if (dVar != null) {
                        dVar.onBannerShow(customBannerAdapter, b.this.c);
                    }
                    n trackingInfo = customBannerAdapter.getTrackingInfo();
                    trackingInfo.a(customBannerAdapter.getInternalNetworkInfoMap());
                    aa.a(trackingInfo, i.s.c, i.s.m, "");
                    ai.b(trackingInfo, customBannerAdapter);
                    com.anythink.core.common.t.e.a(s.b().g());
                    com.anythink.core.common.t.e.a(4, trackingInfo, customBannerAdapter.getUnitGroupInfo());
                }
            }
        }));
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdClicked() {
        final CustomBannerAdapter customBannerAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(e.al, new Runnable() { // from class: com.anythink.banner.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                CustomBannerAdapter customBannerAdapter2 = customBannerAdapter;
                if (customBannerAdapter2 != null) {
                    n trackingInfo = customBannerAdapter2.getTrackingInfo();
                    ai.c(trackingInfo, customBannerAdapter);
                    com.anythink.core.common.t.e.a(s.b().g());
                    com.anythink.core.common.t.e.a(6, trackingInfo);
                    if (trackingInfo != null ? trackingInfo.aB() : false) {
                        return;
                    }
                    com.anythink.core.common.u.c.a().b(customBannerAdapter);
                    aa.a(trackingInfo, i.s.d, i.s.m, "");
                    d dVar = b.this.a.get();
                    if (dVar != null) {
                        dVar.onBannerClicked(customBannerAdapter);
                    }
                }
            }
        }));
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onDeeplinkCallback(final boolean z) {
        final CustomBannerAdapter customBannerAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(e.ao, new Runnable() { // from class: com.anythink.banner.a.b.4
            @Override // java.lang.Runnable
            public final void run() {
                d dVar = b.this.a.get();
                if (dVar != null) {
                    dVar.onDeeplinkCallback(customBannerAdapter, z);
                }
                CustomBannerAdapter customBannerAdapter2 = customBannerAdapter;
                if (customBannerAdapter2 != null) {
                    aa.a(customBannerAdapter2.getTrackingInfo(), i.s.j, z ? i.s.m : i.s.n, "");
                }
            }
        }));
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onDownloadConfirm(final Context context, final ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        final CustomBannerAdapter customBannerAdapter = this.b;
        com.anythink.core.common.u.b.c.a().h(new com.anythink.core.common.u.b.d(e.ap, new Runnable() { // from class: com.anythink.banner.a.b.5
            @Override // java.lang.Runnable
            public final void run() {
                d dVar = b.this.a.get();
                if (dVar != null) {
                    dVar.onDownloadConfirm(context, customBannerAdapter, aTNetworkConfirmInfo);
                }
                CustomBannerAdapter customBannerAdapter2 = customBannerAdapter;
                if (customBannerAdapter2 != null) {
                    aa.a(customBannerAdapter2.getTrackingInfo(), i.s.k, i.s.m, "");
                }
            }
        }));
    }
}
