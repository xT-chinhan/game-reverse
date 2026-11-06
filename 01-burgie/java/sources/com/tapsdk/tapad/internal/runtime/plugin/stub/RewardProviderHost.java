package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface RewardProviderHost extends FullscreenProviderHost {
    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    default void bindFullscreenSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots) {
        bindRewardSurface(activity, frameLayout, viewGroup, view, list, providerAttributionSlots);
    }

    void bindRewardSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots);

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    default FrameLayout createFullscreenRoot(Activity activity) {
        return createRewardRoot(activity);
    }

    FrameLayout createRewardRoot(Activity activity);

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    default void onFullscreenCoreUnavailable() {
        onRewardCoreUnavailable();
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    default void onFullscreenSurfaceBindFailed(String str) {
        onRewardSurfaceBindFailed(str);
    }

    void onRewardCoreUnavailable();

    void onRewardSurfaceBindFailed(String str);

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    default String providerSurfaceFormat() {
        return "reward";
    }
}
