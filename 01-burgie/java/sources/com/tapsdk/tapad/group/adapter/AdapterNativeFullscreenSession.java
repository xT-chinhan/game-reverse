package com.tapsdk.tapad.group.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterNativeFullscreenSession extends AdapterNativeCreativeSession {
    void bind(Activity activity, AdapterNativeFullscreenBinding adapterNativeFullscreenBinding);

    FrameLayout createActivityRoot(Activity activity);

    default void setVideoMuted(boolean z) {
    }

    default boolean updateFullscreenCreativeViews(List<View> list) {
        return false;
    }

    default boolean updateFullscreenInteractionViews(List<View> list, List<View> list2, List<View> list3) {
        return updateFullscreenCreativeViews(list2);
    }
}
