package com.tapsdk.tapad.internal.utils;

import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.TapAdResp;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static WeakReference<TapAdConfig> a;

    public static boolean a(AdInfo adInfo, InteractionInfo interactionInfo) {
        return adInfo.btnInteractionInfo.extractHotZoneInVideo() && a(interactionInfo);
    }

    public static boolean a(InteractionInfo interactionInfo) {
        return interactionInfo != null && (TapAdResp.TriggerStyle.TriggerStyle_hot_area.getNumber() == interactionInfo.triggerStyle || TapAdResp.TriggerStyle.TriggerStyle_hot_area_and_shake.getNumber() == interactionInfo.triggerStyle);
    }

    public static boolean b(InteractionInfo interactionInfo) {
        WeakReference<TapAdConfig> weakReference;
        return (interactionInfo == null || (weakReference = a) == null || weakReference.get() == null || !a.get().shakeEnabled || (TapAdResp.TriggerStyle.TriggerStyle_shake.getNumber() != interactionInfo.triggerStyle && TapAdResp.TriggerStyle.TriggerStyle_hot_area_and_shake.getNumber() != interactionInfo.triggerStyle)) ? false : true;
    }

    public static boolean c(InteractionInfo interactionInfo) {
        return interactionInfo != null && interactionInfo.extractShakeV2Enable();
    }
}
