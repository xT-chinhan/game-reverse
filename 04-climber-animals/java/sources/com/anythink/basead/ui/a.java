package com.anythink.basead.ui;

import android.view.View;
import com.anythink.basead.j.e;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.anythink.basead.ui.a$a, reason: collision with other inner class name */
    public interface InterfaceC0052a {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdStartPlay(long j);

        void onVideoError(String str, String str2);
    }

    void destroyPlayerView(int i);

    long getVideoCurrentPosition();

    void initPlayerView(w wVar, x xVar, com.anythink.basead.ui.component.a.InterfaceC0058a interfaceC0058a, e eVar);

    void pauseVideo();

    void resumeVideo();

    void setATImproveClickViewController(com.anythink.basead.ui.improveclick.a aVar);

    void setAutoPlay(String str);

    void setIsMuted(boolean z);

    void setPlayerOnClickListener(View.OnClickListener onClickListener);

    void setVideoListener(InterfaceC0052a interfaceC0052a);
}
