package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    public static class Builder {
        protected int ab;
        protected int ah;
        protected int c;
        protected int ch;
        protected int d;
        protected int hi;
        protected int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        protected int f3955ms;
        protected int ny;
        protected int sl;
        protected Map<String, Integer> u;
        protected int x;
        protected int xr;
        protected int zb;

        public Builder(int i) {
            this.u = Collections.emptyMap();
            this.f3955ms = i;
            this.u = new HashMap();
        }

        public Builder titleId(int i) {
            this.xr = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.ny = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.ch = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.hi = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.sl = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.c = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.x = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.ab = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.ah = i;
            return this;
        }

        public Builder callToActionId(int i) {
            this.d = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.ka = i;
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.u = new HashMap(map);
            return this;
        }

        public Builder addExtra(String str, int i) {
            this.u.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.zb = i;
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }
    }

    protected MediationViewBinder(Builder builder) {
        this.layoutId = builder.f3955ms;
        this.titleId = builder.xr;
        this.decriptionTextId = builder.ah;
        this.callToActionId = builder.d;
        this.iconImageId = builder.ka;
        this.mainImageId = builder.c;
        this.mediaViewId = builder.ab;
        this.sourceId = builder.x;
        this.extras = builder.u;
        this.groupImage1Id = builder.ch;
        this.groupImage2Id = builder.hi;
        this.groupImage3Id = builder.sl;
        this.logoLayoutId = builder.ny;
        this.shakeViewContainerId = builder.zb;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }
}
