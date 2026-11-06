package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;

/* JADX INFO: loaded from: classes3.dex */
public interface i3 {
    void destroyPlayerView(int i);

    long getVideoCurrentPosition();

    void initPlayerView(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.u1.c cVar2);

    void pauseVideo();

    void resumeVideo();

    void setATImproveClickViewController(com.smartdigimkt.b2.c cVar);

    void setAutoPlay(String str);

    void setIsMuted(boolean z);

    void setPlayerOnClickListener(View.OnClickListener onClickListener);

    void setVideoListener(SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener);
}
