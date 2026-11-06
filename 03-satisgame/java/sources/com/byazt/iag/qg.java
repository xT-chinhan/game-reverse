package com.byazt.iag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface qg<T> extends com.byazt.kb.n {

    public enum n {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    void n();

    void n(int i);

    void n(Drawable drawable);

    void n(T t, WeakReference<Context> weakReference, boolean z);

    void n(boolean z);

    void qg();

    View s();
}
