package com.anythink.banner.a;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.ar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "Bannera";
    private static final Map<String, a> e = new ConcurrentHashMap(3);
    private final Context b;
    private final String c;
    private final f d;

    public static a a(Context context, String str) {
        Map<String, a> map = e;
        a aVar = map.get(str);
        if (aVar == null) {
            synchronized (a.class) {
                if (aVar == null) {
                    aVar = new a(context, str);
                    map.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    private a(Context context, String str) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.d = f.a(context, str, "2");
    }

    public final void a(Context context, int i, com.anythink.core.common.d.a aVar, com.anythink.core.common.d.c cVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, Map<String, Object> map, ATAdRequest aTAdRequest) {
        ar arVar = new ar();
        arVar.d = cVar;
        arVar.f = aTAdMultipleLoadedListener;
        arVar.a(context);
        arVar.a(aTAdRequest);
        arVar.c = i;
        if (map != null) {
            try {
                arVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            arVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        this.d.b(this.b, "2", this.c, arVar, aVar);
    }

    public final List<ATAdInfo> a(Context context) {
        return this.d.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.d.a(context, map);
    }

    public final com.anythink.core.common.h.c a(Context context, boolean z, ae aeVar) {
        return this.d.b(context, false, z, aeVar);
    }

    public final void a(com.anythink.core.common.h.c cVar) {
        this.d.a(cVar);
    }

    public final boolean a() {
        return this.d.g();
    }

    public final View a(Context context, com.anythink.core.common.h.c cVar, CustomBannerAdapter customBannerAdapter, final b bVar, ATNativeAdCustomRender aTNativeAdCustomRender) {
        if (customBannerAdapter != null && cVar != null) {
            if (!customBannerAdapter.isMixNative()) {
                customBannerAdapter.setAdEventListener(bVar);
                return customBannerAdapter.getBannerView();
            }
            if (cVar.f() == null) {
                return null;
            }
            com.anythink.core.common.l.c.a.a aVarA = com.anythink.basead.mixad.b.b.a(customBannerAdapter, new com.anythink.core.common.l.d.a.C0085a().a(context).a(customBannerAdapter.getTrackingInfo()).a(cVar.f()).a(aTNativeAdCustomRender).a(new com.anythink.core.common.l.e.a(cVar) { // from class: com.anythink.banner.a.a.1
                @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
                public final void onAdImpressed() {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onBannerAdShow();
                    }
                }

                @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
                public final void onAdClicked(View view) {
                    super.onAdClicked(view);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onBannerAdClicked();
                    }
                }

                @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
                public final void onClose() {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onBannerAdClose();
                    }
                }

                @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
                public final void onDeeplinkCallback(boolean z) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.core.common.l.e.a, com.anythink.core.common.l.e.a.b
                public final void onDownloadConfirmCallback(Context context2, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onDownloadConfirm(context2, aTNetworkConfirmInfo);
                    }
                }
            }).a());
            if (aVarA instanceof com.anythink.core.common.l.c.a.b) {
                return ((com.anythink.core.common.l.c.a.b) aVarA).a();
            }
        }
        return null;
    }

    public static void a(String str) {
        e.remove(str);
    }
}
