package com.anythink.banner.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdCreateConfig;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.as;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "Bannera";
    private static final Map<String, a> f = new ConcurrentHashMap(3);
    ATAdCreateConfig b;
    private final Context c;
    private final String d;
    private final f e;

    private static a a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, a> map = f;
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
        this(context, str, null);
    }

    public final boolean a() {
        ATAdCreateConfig aTAdCreateConfig = this.b;
        return aTAdCreateConfig != null && aTAdCreateConfig.isMultiton();
    }

    public final f b() {
        return this.e;
    }

    public a(Context context, String str, ATAdCreateConfig aTAdCreateConfig) {
        this.c = context.getApplicationContext();
        this.d = str;
        this.b = aTAdCreateConfig;
        if (aTAdCreateConfig != null) {
            if (aTAdCreateConfig.isMultiton()) {
                f fVar = new f(context, str, "2");
                this.e = fVar;
                fVar.u();
                return;
            }
            this.e = f.a(context, str, "2");
            return;
        }
        this.e = f.a(context, str, "2");
    }

    public final void a(Context context, int i, com.anythink.core.common.d.a aVar, com.anythink.core.common.d.c cVar, ATAdMultipleLoadedListener aTAdMultipleLoadedListener, Map<String, Object> map, ATAdRequest aTAdRequest) {
        as asVar = new as();
        asVar.d = cVar;
        asVar.f = aTAdMultipleLoadedListener;
        asVar.a(context);
        asVar.a(aTAdRequest);
        asVar.c = i;
        if (map != null) {
            try {
                asVar.g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        if (aTAdRequest != null) {
            asVar.l = aTAdRequest.getATAdxBidFloorInfo();
        }
        this.e.b(this.c, "2", this.d, asVar, aVar);
    }

    private String e() {
        f fVar = this.e;
        return fVar != null ? fVar.m() : "";
    }

    public final List<ATAdInfo> a(Context context) {
        return this.e.a(context);
    }

    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        return this.e.a(context, map);
    }

    public final com.anythink.core.common.h.c a(Context context, boolean z, ae aeVar) {
        return this.e.b(context, false, z, aeVar);
    }

    public final void a(com.anythink.core.common.h.c cVar) {
        this.e.a(cVar);
    }

    public final boolean c() {
        return this.e.l();
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
            com.anythink.core.common.k.c.a.a aVarA = com.anythink.core.common.inner.mixad.b.b.a(customBannerAdapter, new com.anythink.core.common.k.d.a.C0028a().a(context).a(customBannerAdapter.getTrackingInfo()).a(cVar.f()).a(aTNativeAdCustomRender).a(new com.anythink.core.common.k.e.a(cVar) { // from class: com.anythink.banner.a.a.1
                @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
                public final void onAdImpressed() {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onBannerAdShow();
                    }
                }

                @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
                public final void onAdClicked(View view) {
                    super.onAdClicked(view);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onBannerAdClicked();
                    }
                }

                @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
                public final void onClose() {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onBannerAdClose();
                    }
                }

                @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
                public final void onDeeplinkCallback(boolean z) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.core.common.k.e.a, com.anythink.core.common.k.e.a.b
                public final void onDownloadConfirmCallback(Context context2, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onDownloadConfirm(context2, aTNetworkConfirmInfo);
                    }
                }
            }).a());
            if (aVarA instanceof com.anythink.core.common.k.c.a.b) {
                return ((com.anythink.core.common.k.c.a.b) aVarA).a();
            }
        }
        return null;
    }

    public static void a(String str) {
        Map<String, a> map = f;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.remove(str);
    }

    public final void a(int i) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    public final void a(List<ATAdInfo> list) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(list);
        }
    }

    public final void a(Map<String, Object> map) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(map);
        }
    }

    public final void d() {
        f fVar;
        ATAdCreateConfig aTAdCreateConfig = this.b;
        if (aTAdCreateConfig == null || !aTAdCreateConfig.isMultiton() || (fVar = this.e) == null) {
            return;
        }
        fVar.p();
    }

    public final void b(Map<String, Object> map) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.b(map);
        }
    }
}
