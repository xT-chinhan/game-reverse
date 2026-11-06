package com.mcto.sspsdk;

import android.app.Activity;
import com.mcto.sspsdk.internal.l7;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IQyFullScreenAd extends l7 {

    public interface AdInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdShow();

        void onError(int i, String str);

        void onVideoComplete();
    }

    void destroy();

    @Override // com.mcto.sspsdk.internal.l7
    /* synthetic */ Map getAdExtra();

    boolean isValid();

    @Override // com.mcto.sspsdk.internal.l7
    /* synthetic */ void loss(Map map);

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void showAd(Activity activity);

    /* synthetic */ void win(Map map);
}
