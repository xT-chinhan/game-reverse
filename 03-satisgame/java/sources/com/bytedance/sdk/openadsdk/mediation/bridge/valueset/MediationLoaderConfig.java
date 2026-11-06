package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.cp.n;
import com.byazt.qvu.s;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 1557, 2116})
public class MediationLoaderConfig {
    private ValueSet n;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            SparseArray sparseArray = (SparseArray) valueSet.objectValue(8424, SparseArray.class);
            ValueSet valueSetQg = (sparseArray == null || sparseArray.size() <= 0) ? null : s.n((SparseArray<Object>) sparseArray).qg();
            if (valueSetQg != null) {
                this.n = valueSetQg;
            } else {
                this.n = valueSet;
            }
        }
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean n() {
        ValueSet valueSet = this.n;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public int getAdType() {
        if (n()) {
            return this.n.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getADNName() {
        return n() ? this.n.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getClassName() {
        return n() ? this.n.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (n()) {
            return s.n((SparseArray<Object>) this.n.objectValue(8548, SparseArray.class)).qg();
        }
        return null;
    }

    public Context getContext() {
        if (n()) {
            return (Context) this.n.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (n()) {
            return s.n((SparseArray<Object>) this.n.objectValue(8546, SparseArray.class)).qg();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> getGMCustomAdLoader() {
        if (n()) {
            return MediationValueUtil.covertToFunction(this.n.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Object.class));
        }
        return null;
    }

    public int getManagerLoaderType() {
        if (n()) {
            return this.n.intValue(8561);
        }
        return 0;
    }
}
