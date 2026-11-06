package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 1438, 1922})
public class MediationLoaderConfig {
    private ValueSet pr;

    private MediationLoaderConfig(ValueSet valueSet) {
        ValueSet valueSetHw;
        if (valueSet != null) {
            SparseArray sparseArray = (SparseArray) valueSet.objectValue(8424, SparseArray.class);
            if (sparseArray != null && sparseArray.size() > 0) {
                valueSetHw = hn.pr((SparseArray<Object>) sparseArray).hw();
            } else {
                valueSetHw = null;
            }
            if (valueSetHw != null) {
                this.pr = valueSetHw;
            } else {
                this.pr = valueSet;
            }
        }
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean pr() {
        ValueSet valueSet = this.pr;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public int getAdType() {
        if (pr()) {
            return this.pr.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getADNName() {
        return pr() ? this.pr.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getClassName() {
        return pr() ? this.pr.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (pr()) {
            return hn.pr((SparseArray<Object>) this.pr.objectValue(8548, SparseArray.class)).hw();
        }
        return null;
    }

    public Context getContext() {
        if (pr()) {
            return (Context) this.pr.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (pr()) {
            return hn.pr((SparseArray<Object>) this.pr.objectValue(8546, SparseArray.class)).hw();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> getGMCustomAdLoader() {
        if (pr()) {
            return MediationValueUtil.covertToFunction(this.pr.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Object.class));
        }
        return null;
    }

    public int getManagerLoaderType() {
        if (pr()) {
            return this.pr.intValue(8561);
        }
        return 0;
    }
}
