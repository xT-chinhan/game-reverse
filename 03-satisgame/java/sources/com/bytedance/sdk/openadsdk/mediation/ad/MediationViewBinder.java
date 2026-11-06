package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.cp.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 763, 1500})
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

    @n(n = {0, 55, 56, 57, 58, 763, 1632})
    public static class Builder {
        protected int cp;
        protected int d;
        protected int fs;
        protected int l;
        protected int n;
        protected int oa;
        protected int q;
        protected int qg;
        protected int rv;
        protected int s;
        protected Map<String, Integer> sz;
        protected int tj;
        protected int w;
        protected int x;

        public Builder(int i) {
            this.sz = Collections.emptyMap();
            this.n = i;
            this.sz = new HashMap();
        }

        public Builder titleId(int i) {
            this.qg = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.rv = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.tj = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.cp = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.d = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.w = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.fs = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.x = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.s = i;
            return this;
        }

        public Builder callToActionId(int i) {
            this.q = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.l = i;
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.sz = new HashMap(map);
            return this;
        }

        public Builder addExtra(String str, int i) {
            this.sz.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.oa = i;
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }
    }

    protected MediationViewBinder(Builder builder) {
        this.layoutId = builder.n;
        this.titleId = builder.qg;
        this.decriptionTextId = builder.s;
        this.callToActionId = builder.q;
        this.iconImageId = builder.l;
        this.mainImageId = builder.w;
        this.mediaViewId = builder.x;
        this.sourceId = builder.fs;
        this.extras = builder.sz;
        this.groupImage1Id = builder.tj;
        this.groupImage2Id = builder.cp;
        this.groupImage3Id = builder.d;
        this.logoLayoutId = builder.rv;
        this.shakeViewContainerId = builder.oa;
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
