package com.tapsdk.tapad.internal.runtime.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class VideoContainerViewManager extends BaseViewManager<FrameLayout, VideoViewProps> {
    public static final String NAME = "video";
    public static final int VIEW_TYPE = 3;
    private final float mDensity;

    public VideoContainerViewManager(Context context) {
        this.mDensity = context.getResources().getDisplayMetrics().density;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public String getName() {
        return "video";
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public Class<VideoViewProps> getPropsClass() {
        return VideoViewProps.class;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public int getViewType() {
        return 3;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public FrameLayout createView(Context context, String str) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        return frameLayout;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void setStyle(FrameLayout frameLayout, String str, String str2) {
        applyBaseStyle(frameLayout, str, str2, this.mDensity);
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void updateProps(FrameLayout frameLayout, VideoViewProps videoViewProps) {
        if (videoViewProps == null) {
            return;
        }
        applyBaseProps(frameLayout, videoViewProps, this.mDensity);
    }
}
