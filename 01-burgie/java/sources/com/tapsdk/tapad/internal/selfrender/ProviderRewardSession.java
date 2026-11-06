package com.tapsdk.tapad.internal.selfrender;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ProviderRewardSession {

    public interface HostEvents extends AdapterAdEventSink {
        void onPresentationStarted(Activity activity);

        void onRewardVerified(boolean z, int i, String str, int i2, String str2, String str3);
    }

    default void bindReward(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
        bindReward(activity, frameLayout, viewGroup, providerInteractionViews == null ? null : providerInteractionViews.allViews(), providerAttributionSlots, providerEventSink);
    }

    void bindReward(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink);

    FrameLayout createRewardRoot(Activity activity);

    byte[] normalizedRewardCreative();

    void releaseRewardProvider();

    default void setRewardVideoMuted(boolean z) {
    }

    default boolean updateRewardCreativeViews(List<View> list) {
        return false;
    }

    default boolean updateRewardInteractionViews(List<View> list, List<View> list2, List<View> list3) {
        return updateRewardCreativeViews(list2);
    }
}
