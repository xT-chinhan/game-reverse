package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo;
import com.bytedance.sdk.openadsdk.mediation.ms.ms;

/* JADX INFO: loaded from: classes2.dex */
public class MediationCustomizeVideoImpl extends ms implements Bridge, IMediationCustomizeVideo {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TTFeedAd.CustomizeVideo f3980ms;

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public MediationCustomizeVideoImpl(TTFeedAd.CustomizeVideo customizeVideo) {
        this.f3980ms = customizeVideo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8165) {
            reportVideoStart();
            return null;
        }
        if (i == 8168) {
            reportVideoFinish();
            return null;
        }
        if (i == 8166) {
            reportVideoPause(valueSet.longValue(8074));
            return null;
        }
        if (i == 8167) {
            reportVideoContinue(valueSet.longValue(8074));
            return null;
        }
        if (i == 8169) {
            reportVideoBreak(valueSet.longValue(8074));
            return null;
        }
        if (i == 8170) {
            reportVideoAutoStart();
            return null;
        }
        if (i == 8171) {
            reportVideoStartError(valueSet.intValue(8014), valueSet.intValue(8075));
            return null;
        }
        if (i != 8172) {
            return null;
        }
        reportVideoError(valueSet.longValue(8074), valueSet.intValue(8014), valueSet.intValue(8075));
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8165) {
            reportVideoStart();
            return null;
        }
        if (i == 8168) {
            reportVideoFinish();
            return null;
        }
        if (i == 8166) {
            reportVideoPause(((Long) objectValue(sparseArray.get(8074), Long.class, 0L)).longValue());
            return null;
        }
        if (i == 8167) {
            reportVideoContinue(((Long) objectValue(sparseArray.get(8074), Long.class, 0L)).longValue());
            return null;
        }
        if (i == 8169) {
            reportVideoBreak(((Long) objectValue(sparseArray.get(8074), Long.class, 0L)).longValue());
            return null;
        }
        if (i == 8170) {
            reportVideoAutoStart();
            return null;
        }
        if (i == 8171) {
            reportVideoStartError(((Integer) objectValue(sparseArray.get(8014), Integer.class, 0)).intValue(), ((Integer) objectValue(sparseArray.get(8075), Integer.class, 0)).intValue());
            return null;
        }
        if (i != 8172) {
            return null;
        }
        reportVideoError(((Long) objectValue(sparseArray.get(8074), Long.class, 0L)).longValue(), ((Integer) objectValue(sparseArray.get(8014), Integer.class, 0)).intValue(), ((Integer) objectValue(sparseArray.get(8075), Integer.class, 0)).intValue());
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoPause(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoContinue(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoBreak(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f3980ms;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i, i2);
        }
    }
}
