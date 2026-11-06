package com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f4036ms;

    public abstract List<Object> getAdLoadInfo();

    public abstract ms getBestEcpm();

    public abstract List<ms> getCacheList();

    public abstract List<ms> getMultiBiddingEcpm();

    public abstract ms getShowEcpm();

    public abstract boolean isReady();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f4036ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f4036ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        return com.bykv.ms.ms.ms.ms.xr.ms().xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 270001:
                return (T) Boolean.class.cast(Boolean.valueOf(isReady()));
            case 270002:
                return (T) getAdLoadInfo();
            case 270003:
                return (T) getMultiBiddingEcpm();
            case 270004:
                return (T) getBestEcpm();
            case 270005:
                return (T) getCacheList();
            case 270006:
                return (T) getShowEcpm();
            default:
                return null;
        }
    }
}
