package com.mar.sdk;

import com.mar.sdk.gg.push.CrossPushStyle;
import com.mar.sdk.gg.push.PushStyle;

/* JADX INFO: loaded from: classes2.dex */
public interface IMutualPush extends IPlugin {
    void showCrossPush(CrossPushStyle crossPushStyle);

    void showGame(PushStyle pushStyle);
}
