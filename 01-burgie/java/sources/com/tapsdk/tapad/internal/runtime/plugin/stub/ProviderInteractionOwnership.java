package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.R;

/* JADX INFO: loaded from: classes3.dex */
final class ProviderInteractionOwnership {
    private ProviderInteractionOwnership() {
    }

    public static void transfer(View view) {
        if (view == null || Boolean.TRUE.equals(view.getTag(R.id.tapad_dirichlet_core_action_tag))) {
            return;
        }
        view.setOnClickListener(null);
        view.setOnLongClickListener(null);
        view.setOnTouchListener(null);
        view.setClickable(false);
        view.setLongClickable(false);
        view.setFocusable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                transfer(viewGroup.getChildAt(i));
            }
        }
    }
}
