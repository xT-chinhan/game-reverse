package com.tapsdk.tapad.internal.runtime.view;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface RewardExitGuardNativeSurface {
    void addExitGuardFallbackChild(View view);

    void renderExitGuardPayload(String str);

    void setExitGuardClickAction(Runnable runnable);
}
