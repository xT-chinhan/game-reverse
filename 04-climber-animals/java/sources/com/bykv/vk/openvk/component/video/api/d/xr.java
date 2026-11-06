package com.bykv.vk.openvk.component.video.api.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public interface xr<T> extends com.bykv.vk.openvk.component.video.api.xr.ms {

    public enum ms {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    View ah();

    void ms();

    void ms(int i);

    void ms(Drawable drawable);

    void ms(T t, WeakReference<Context> weakReference, boolean z);

    void ms(boolean z);

    void xr();
}
