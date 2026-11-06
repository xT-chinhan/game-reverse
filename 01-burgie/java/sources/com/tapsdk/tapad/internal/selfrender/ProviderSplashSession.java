package com.tapsdk.tapad.internal.selfrender;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ProviderSplashSession {

    public interface HostEvents extends AdapterAdEventSink {
        void onPresentationStarted(Activity activity);

        void onSplashBound(View view, long j);

        void onSplashSkipped();

        void onSplashTimeOver();
    }

    public static final class LoadFacts {
        private final List<String> decisionTags;
        private final String requestId;
        private final String trackId;

        public LoadFacts(String str, String str2, List<String> list) {
            this.requestId = safe(str);
            this.trackId = safe(str2);
            this.decisionTags = snapshotTags(list);
        }

        private static String safe(String str) {
            return str == null ? "" : str;
        }

        private static List<String> snapshotTags(List<String> list) {
            if (list == null || list.isEmpty()) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String strSafe = safe(it.next());
                if (!strSafe.isEmpty()) {
                    arrayList.add(strSafe);
                    if (arrayList.size() == 3) {
                        break;
                    }
                }
            }
            return Collections.unmodifiableList(arrayList);
        }

        public JSONObject toJson() {
            return new JSONObject().put(Constants.Bidding.REQUEST_ID, this.requestId).put("track_id", this.trackId).put("wall_time_ms", System.currentTimeMillis()).put("native_self_render", true).put("decision_tags", new JSONArray((Collection) this.decisionTags));
        }
    }

    default void bindSplash(Activity activity, FrameLayout frameLayout, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
        bindSplash(activity, frameLayout, view, providerInteractionViews == null ? null : providerInteractionViews.allViews(), providerAttributionSlots, providerEventSink);
    }

    void bindSplash(Activity activity, FrameLayout frameLayout, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink);

    FrameLayout createSplashRoot(Context context);

    byte[] normalizedSplashCreative();

    boolean performSplashMotionAction(View view, int i, List<View> list);

    void releaseSplashProvider();

    default void setSplashVideoMuted(boolean z) {
    }

    default boolean updateSplashInteractionViews(List<View> list, List<View> list2, List<View> list3) {
        return false;
    }
}
