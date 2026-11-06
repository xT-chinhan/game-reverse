package com.baidu.mobads.sdk.api;

import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public interface ShakeViewContainer {
    void destroy();

    RelativeLayout getContainer();

    void pause();

    void resume();
}
