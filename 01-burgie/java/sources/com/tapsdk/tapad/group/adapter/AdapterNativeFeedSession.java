package com.tapsdk.tapad.group.adapter;

import android.app.Activity;
import android.view.View;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterNativeFeedSession extends AdapterAdSession {
    void bind(Activity activity, AdapterNativeFeedBinding adapterNativeFeedBinding);

    default void cancelDownload() {
    }

    default void confirmDownload() {
    }

    String getApkSize();

    long getApkSizeBytes();

    default AdapterAppComplianceInfo getComplianceInfo() {
        return AdapterAppComplianceInfo.EMPTY;
    }

    String getDescription();

    String getIconUrl();

    int getImageMode();

    default List<AdapterNativeImage> getImages() {
        return Collections.EMPTY_LIST;
    }

    int getInteractionType();

    View getMediaView();

    float getScore();

    String getTitle();

    default void pauseDownload() {
    }

    default void resumeDownload() {
    }
}
