package com.tapsdk.tapad.internal.runtime.view;

import android.content.Context;
import android.view.View;
import com.tapsdk.tapad.internal.runtime.view.ViewProps;

/* JADX INFO: loaded from: classes3.dex */
public interface ViewManager<T extends View, P extends ViewProps> {
    T createView(Context context, String str);

    String getName();

    Class<P> getPropsClass();

    int getViewType();

    default void onViewDestroy(T t) {
    }

    void setStyle(T t, String str, String str2);

    void updateProps(T t, P p);
}
