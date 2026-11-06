package com.tapsdk.tapad.group.adapter;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterNativeCreativeSession extends AdapterAdSession {
    public static final int IMAGE_MODE_BIG = 1;
    public static final int IMAGE_MODE_VIDEO = 2;
    public static final int INTERACTION_DOWNLOAD = 1;
    public static final int INTERACTION_UNKNOWN = 0;

    long getApkSizeBytes();

    default AdapterAppComplianceInfo getComplianceInfo() {
        return AdapterAppComplianceInfo.EMPTY;
    }

    default List<String> getDecisionTags() {
        return Collections.EMPTY_LIST;
    }

    String getDescription();

    default long getDurationMillis() {
        return 0L;
    }

    String getIconUrl();

    int getImageMode();

    default List<AdapterNativeImage> getImages() {
        return Collections.EMPTY_LIST;
    }

    int getInteractionType();

    String getTitle();

    default boolean isVideoMutedByDefault() {
        return false;
    }

    default boolean supportsVideoMuteControl() {
        return false;
    }
}
