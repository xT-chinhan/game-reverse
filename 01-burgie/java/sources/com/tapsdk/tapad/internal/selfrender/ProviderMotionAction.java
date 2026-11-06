package com.tapsdk.tapad.internal.selfrender;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderMotionAction {
    private ProviderMotionAction() {
    }

    private static boolean isRewardIntentSource(int i) {
        return (i >= 0 && i <= 9) || i == 12 || i == 13 || i == 15 || i == 16;
    }

    public static boolean isRewardMotionSource(int i) {
        return i >= 2 && i <= 9;
    }

    private static boolean perform(View view, List<View> list) {
        if (performOne(view)) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (View view2 : list) {
            if (view2 != view && performOne(view2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean performOne(View view) {
        return view != null && view.isEnabled() && view.isClickable() && view.hasOnClickListeners() && view.performClick();
    }

    public static boolean performReward(int i, View view, List<View> list) {
        if (isRewardMotionSource(i)) {
            return perform(view, list);
        }
        return false;
    }

    public static boolean performRewardIntent(int i, View view, List<View> list) {
        if (isRewardIntentSource(i)) {
            return perform(view, list);
        }
        return false;
    }

    public static boolean performShake(int i, View view, List<View> list) {
        if (i <= 0) {
            return false;
        }
        return perform(view, list);
    }
}
