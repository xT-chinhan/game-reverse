package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface FullscreenProviderHost {
    default void bindFullscreenSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots) {
        bindFullscreenSurface(activity, frameLayout, viewGroup, view, providerInteractionViews == null ? null : providerInteractionViews.allViews(), providerAttributionSlots);
    }

    void bindFullscreenSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots);

    FrameLayout createFullscreenRoot(Activity activity);

    void onFullscreenCoreUnavailable();

    void onFullscreenSurfaceBindFailed(String str);

    String providerSurfaceFormat();

    default boolean updateFullscreenActionViews(List<View> list) {
        return false;
    }

    default boolean updateFullscreenInteractionViews(ProviderInteractionViews providerInteractionViews) {
        return updateFullscreenActionViews(providerInteractionViews == null ? null : providerInteractionViews.allViews());
    }
}
