package com.mcto.sspsdk;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IQyBanner {

    public interface IAdInteractionListener {
        void onAdClick();

        void onAdClose();

        void onAdComplete();

        void onAdPlayError();

        void onAdShow();

        void onAdStart();

        void onAdStop();

        void onRenderSuccess();
    }

    void destroy();

    Map<String, String> getAdExtra();

    View getBannerView();

    QyBannerStyle getQyBannerStyle();

    String getRenderType();

    void setBannerInteractionListener(IAdInteractionListener iAdInteractionListener);
}
