package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SplashProviderHost {
    default void bindSplashSurface(Context context, FrameLayout frameLayout, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots) {
        bindSplashSurface(context, frameLayout, view, providerInteractionViews == null ? null : providerInteractionViews.allViews(), providerAttributionSlots);
    }

    void bindSplashSurface(Context context, FrameLayout frameLayout, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots);

    FrameLayout createSplashRoot(Context context);

    void onSplashCoreUnavailable();

    void onSplashSurfaceBindFailed(String str);

    default boolean updateSplashInteractionViews(ProviderInteractionViews providerInteractionViews) {
        return false;
    }
}
