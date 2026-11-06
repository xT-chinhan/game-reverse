package com.anythink.core.common.w;

import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATCustomLoadListenerExt;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.n;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements ATCustomLoadListenerExt {
    private static final String a = "a";
    private final n b;
    private final String c;
    private final Map<String, Object> d;
    private final ATCustomLoadListener e;
    private volatile boolean f = false;

    public a(n nVar, String str, Map<String, Object> map, ATCustomLoadListener aTCustomLoadListener) {
        this.b = nVar;
        this.c = str;
        this.e = aTCustomLoadListener;
        this.d = map;
    }

    private boolean a() {
        Map<String, Object> map = this.d;
        if (map == null) {
            return false;
        }
        try {
            Object obj = map.get("ad_s_reqf_mode");
            if (obj != null) {
                return obj.toString().equals("2");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public void onAdDataLoaded() {
        ATCustomLoadListener aTCustomLoadListener = this.e;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdDataLoaded();
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public void onAdCacheLoaded(BaseAd... baseAdArr) {
        if (this.f) {
            return;
        }
        this.f = true;
        ATCustomLoadListener aTCustomLoadListener = this.e;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(baseAdArr);
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public void onAdLoadError(String str, String str2) {
        ATCustomLoadListener aTCustomLoadListener = this.e;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError(str, str2);
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListenerExt
    public void onAdDataLoadedWithAds(BaseAd... baseAdArr) {
        ATCustomLoadListener aTCustomLoadListener = this.e;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdDataLoaded();
        }
        if (a()) {
            n nVar = this.b;
            if (nVar != null) {
                nVar.d();
            }
            onAdCacheLoaded(baseAdArr);
        }
    }
}
