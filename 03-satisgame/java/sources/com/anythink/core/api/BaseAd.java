package com.anythink.core.api;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.basead.b.b;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAd implements IATThirdPartyMaterial {
    public abstract void clear(View view);

    public abstract void destroy();

    public abstract ViewGroup getCustomAdContainer();

    public abstract n getDetail();

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract Map<String, Object> getNetworkInfoMap();

    public abstract boolean isNativeExpress();

    public boolean isValid() {
        return true;
    }

    public abstract void pauseVideo();

    public abstract void registerListener(View view, ATNativeAdInfo.AdPrepareInfo adPrepareInfo);

    public abstract void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams);

    public abstract void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams, b bVar);

    public abstract void resumeVideo();

    public abstract void setDevParams(Map<String, Object> map);

    public abstract void setNativeEventListener(com.anythink.core.common.d.n nVar);

    public abstract void setNetworkInfoMap(Map<String, Object> map);

    public abstract void setTrackingInfo(n nVar);

    public abstract void setVideoMute(boolean z);

    protected final void runOnMainThread(Runnable runnable) {
        s.b();
        s.b(runnable);
    }
}
