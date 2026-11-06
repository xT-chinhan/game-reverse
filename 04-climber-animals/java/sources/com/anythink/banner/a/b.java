package com.anythink.banner.a;

import android.content.Context;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.ab;
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
        if (this.b != null) {
            d dVar = this.a.get();
            if (dVar != null) {
                dVar.onBannerClose(this.b);
            }
            n trackingInfo = this.b.getTrackingInfo();
            ab.a(trackingInfo, j.r.e, j.r.m, "");
            if (trackingInfo != null) {
                e.a(trackingInfo, false);
            }
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdShow() {
        if (this.b != null) {
            com.anythink.core.common.v.c.a().a(this.b);
            d dVar = this.a.get();
            if (dVar != null) {
                dVar.onBannerShow(this.b, this.c);
            }
            n trackingInfo = this.b.getTrackingInfo();
            trackingInfo.a(this.b.getInternalNetworkInfoMap());
            ab.a(trackingInfo, j.r.c, j.r.m, "");
            com.anythink.core.common.u.c.a(t.b().g()).a(4, trackingInfo, this.b.getUnitGroupInfo());
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onBannerAdClicked() {
        CustomBannerAdapter customBannerAdapter = this.b;
        if (customBannerAdapter != null) {
            n trackingInfo = customBannerAdapter.getTrackingInfo();
            com.anythink.core.common.u.c.a(t.b().g()).a(6, trackingInfo);
            if (trackingInfo != null ? trackingInfo.aw() : false) {
                return;
            }
            com.anythink.core.common.v.c.a().b(this.b);
            ab.a(trackingInfo, j.r.d, j.r.m, "");
            d dVar = this.a.get();
            if (dVar != null) {
                dVar.onBannerClicked(this.b);
            }
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onDeeplinkCallback(boolean z) {
        d dVar = this.a.get();
        if (dVar != null) {
            dVar.onDeeplinkCallback(this.b, z);
        }
        CustomBannerAdapter customBannerAdapter = this.b;
        if (customBannerAdapter != null) {
            ab.a(customBannerAdapter.getTrackingInfo(), j.r.j, z ? j.r.m : j.r.n, "");
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        d dVar = this.a.get();
        if (dVar != null) {
            dVar.onDownloadConfirm(context, this.b, aTNetworkConfirmInfo);
        }
        CustomBannerAdapter customBannerAdapter = this.b;
        if (customBannerAdapter != null) {
            ab.a(customBannerAdapter.getTrackingInfo(), j.r.k, j.r.m, "");
        }
    }
}
