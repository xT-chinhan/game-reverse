package com.anythink.core.common.inner.ui.e;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public interface a {
        void a();
    }

    private static void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 0;
        view.setLayoutParams(layoutParams);
    }

    private static boolean a(long j, x xVar) {
        if (xVar != null && xVar.t != null && xVar.t.U() < 0) {
            return true;
        }
        if (j <= 0) {
            return false;
        }
        return xVar == null || xVar.t == null || System.currentTimeMillis() - j > xVar.t.U();
    }
}
