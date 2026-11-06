package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterRewardLoadRequest {
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int ORIENTATION_UNKNOWN = 0;
    private final int acceptedImageHeightPx;
    private final int acceptedImageWidthPx;
    private final AdapterLoadRequest common;
    private final int rewardAmount;
    private final String rewardExtra;
    private final String rewardName;
    private final int screenOrientation;
    private final boolean selfRendered;
    private final String userId;

    public AdapterRewardLoadRequest(AdapterLoadRequest adapterLoadRequest, int i, int i2, int i3, boolean z, int i4, String str, String str2, String str3) {
        if (adapterLoadRequest == null) {
            throw new IllegalArgumentException("missing common load request");
        }
        this.common = adapterLoadRequest;
        this.acceptedImageWidthPx = i;
        this.acceptedImageHeightPx = i2;
        this.screenOrientation = i3;
        this.selfRendered = z;
        this.rewardAmount = i4;
        this.rewardName = safe(str);
        this.userId = safe(str2);
        this.rewardExtra = safe(str3);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public int getAcceptedImageHeightPx() {
        return this.acceptedImageHeightPx;
    }

    public int getAcceptedImageWidthPx() {
        return this.acceptedImageWidthPx;
    }

    public AdapterLoadRequest getCommon() {
        return this.common;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardExtra() {
        return this.rewardExtra;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public int getScreenOrientation() {
        return this.screenOrientation;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isSelfRendered() {
        return this.selfRendered;
    }
}
