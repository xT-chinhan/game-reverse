package com.tapsdk.tapad.internal.selfrender;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ProviderInterstitialSession {

    public interface HostEvents extends AdapterAdEventSink {
        void onPresentationStarted(Activity activity);
    }

    public static final class LoadFacts {
        private final String requestId;
        private final String trackId;

        public LoadFacts(String str, String str2) {
            this.requestId = safe(str);
            this.trackId = safe(str2);
        }

        private static String safe(String str) {
            return str == null ? "" : str;
        }

        public String requestId() {
            return this.requestId;
        }

        public JSONObject toJson() {
            return new JSONObject().put(Constants.Bidding.REQUEST_ID, this.requestId).put("track_id", this.trackId).put("auto_close_ms", 0).put("wall_time_ms", System.currentTimeMillis());
        }

        public String trackId() {
            return this.trackId;
        }
    }

    default void bindInterstitial(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
        bindInterstitial(activity, frameLayout, viewGroup, providerInteractionViews == null ? null : providerInteractionViews.allViews(), providerAttributionSlots, providerEventSink);
    }

    void bindInterstitial(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink);

    FrameLayout createInterstitialRoot(Activity activity);

    LoadFacts interstitialLoadFacts();

    byte[] normalizedInterstitialCreative();

    void releaseInterstitialProvider();

    default void setInterstitialVideoMuted(boolean z) {
    }

    default boolean updateInterstitialCreativeViews(List<View> list) {
        return false;
    }

    default boolean updateInterstitialInteractionViews(List<View> list, List<View> list2, List<View> list3) {
        return updateInterstitialCreativeViews(list2);
    }
}
