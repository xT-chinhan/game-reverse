package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ms.xr;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationLoaderConfig {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f3984ms;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
            if (valueSet2 != null) {
                this.f3984ms = valueSet2;
            } else {
                this.f3984ms = valueSet;
            }
        }
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean ms() {
        ValueSet valueSet = this.f3984ms;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public int getAdType() {
        if (ms()) {
            return this.f3984ms.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getADNName() {
        return ms() ? this.f3984ms.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getClassName() {
        return ms() ? this.f3984ms.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (ms()) {
            return (ValueSet) this.f3984ms.objectValue(8548, ValueSet.class);
        }
        return null;
    }

    public Context getContext() {
        if (ms()) {
            return (Context) this.f3984ms.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (ms()) {
            return (ValueSet) this.f3984ms.objectValue(8546, ValueSet.class);
        }
        return null;
    }

    public Function getGMCustomAdLoader() {
        if (ms()) {
            return xr.ms(this.f3984ms.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Object.class));
        }
        return null;
    }
}
