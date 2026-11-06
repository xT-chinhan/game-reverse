package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 1656, 2566})
public abstract class MediationCustomNativeLoader extends MediationCustomAdBaseLoader {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public final boolean isNativeAd() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8223);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public final boolean isExpressRender() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8222);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public final void callLoadSuccess(List<? extends MediationCustomNativeAd> list) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8303, list);
            this.mGmAdLoader.apply(sparseArray);
        }
    }
}
