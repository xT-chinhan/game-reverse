package com.bytedance.sdk.openadsdk.mediation.bridge.custom.fullvideo;

import android.app.Activity;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.byazt.cp.n;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 2266, 2267})
public abstract class MediationCustomFullVideoLoader extends MediationCustomAdBaseLoader {
    public abstract void showAd(Activity activity);

    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess(double d) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8409, Double.valueOf(d));
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess(Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8075, map);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess(double d, Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8409, Double.valueOf(d));
            sparseArray.put(8075, map);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callAdVideoCache() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8112);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callFullVideoAdShow() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PointerIconCompat.TYPE_TEXT));
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callFullVideoAdClick() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_TEXT));
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callFullVideoAdClosed() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callFullVideoComplete() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 1026);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callFullVideoError() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PointerIconCompat.TYPE_GRABBING));
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callFullVideoSkippedVideo() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 1037);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callFullVideoRewardVerify(MediationRewardItem mediationRewardItem) {
        if (this.mGmAdLoader == null || mediationRewardItem == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(PointerIconCompat.TYPE_ZOOM_IN));
        sparseArray.put(-99999985, String.class);
        sparseArray.put(8017, Boolean.valueOf(mediationRewardItem.rewardVerify()));
        sparseArray.put(8018, Float.valueOf(mediationRewardItem.getAmount()));
        sparseArray.put(8019, mediationRewardItem.getRewardName());
        sparseArray.put(8075, mediationRewardItem.getCustomData());
        this.mGmAdLoader.apply(sparseArray);
    }

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 8113) {
            if (i != 8121) {
                return null;
            }
            w.s(MediationConstant.TAG, "MediationCustomBaseLoader isReadyCondition");
            return (T) n(isReadyCondition());
        }
        w.s(MediationConstant.TAG, "MediationCustomFullVideoLoader showAd");
        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
        if (activity == null) {
            return null;
        }
        showAd(activity);
        return null;
    }
}
