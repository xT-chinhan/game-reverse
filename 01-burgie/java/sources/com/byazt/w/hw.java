package com.byazt.w;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface hw<T> extends com.byazt.iw.pr {

    public enum pr {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    View hn();

    void hw();

    void pr();

    void pr(int i);

    void pr(Drawable drawable);

    void pr(T t, WeakReference<Context> weakReference, boolean z);

    void pr(boolean z);
}
