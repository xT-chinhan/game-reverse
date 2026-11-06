package com.mcto.sspsdk;

import android.app.Activity;
import com.mcto.sspsdk.internal.l7;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IQyRewardVideoAd extends l7 {
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    public interface IAdInteractionListener {
        void onAdClick();

        void onAdClose();

        @Deprecated
        void onAdNextShow();

        void onAdShow();

        void onRewardVerify(HashMap<String, Object> map);

        void onVideoComplete();

        void onVideoError(int i, String str);
    }

    void destroy();

    @Override // com.mcto.sspsdk.internal.l7
    /* synthetic */ Map getAdExtra();

    int getAdId();

    boolean isValid();

    @Override // com.mcto.sspsdk.internal.l7
    /* synthetic */ void loss(Map map);

    void setRewardVideoAdInteractionListener(IAdInteractionListener iAdInteractionListener);

    boolean showRewardVideoAd(Activity activity);

    /* synthetic */ void win(Map map);
}
