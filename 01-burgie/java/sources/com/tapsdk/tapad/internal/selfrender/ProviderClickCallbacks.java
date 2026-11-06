package com.tapsdk.tapad.internal.selfrender;

import android.view.View;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ProviderClickCallbacks {
    private static final int COMPLETE_TEMPLATE_ACTION_BASE = 10000;
    private static final int COMPLETE_TEMPLATE_ACTION_COUNT = 256;

    private ProviderClickCallbacks() {
    }

    private static boolean belongsTo(View view, List<View> list) {
        while (view != null) {
            if (list != null && list.contains(view)) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    public static boolean isCompleteTemplateAction(int i) {
        return i >= 10000 && i < 10256;
    }

    public static int resolve(View view, ProviderInteractionViews providerInteractionViews, int i, int i2) {
        View view2 = view;
        while (view2 != null) {
            Object tag = view2.getTag(R.id.tapad_dirichlet_provider_action_callback_tag);
            if (tag instanceof Integer) {
                Integer num = (Integer) tag;
                if (num.intValue() >= 0) {
                    return num.intValue();
                }
            }
            Object parent = view2.getParent();
            view2 = parent instanceof View ? (View) parent : null;
        }
        return (providerInteractionViews == null || !belongsTo(view, providerInteractionViews.getClickViews())) ? i2 : i;
    }
}
