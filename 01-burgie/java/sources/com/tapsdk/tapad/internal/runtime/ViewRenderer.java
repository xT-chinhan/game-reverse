package com.tapsdk.tapad.internal.runtime;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public interface ViewRenderer {

    public interface TouchCallback {
        void onTouch(int i, float f, float f2, float f3, float f4, int i2, int i3, int i4, long j);
    }

    void addChild(int i, int i2);

    int allocateHandle();

    boolean attachVideoView(int i, int i2, View view, ViewGroup.LayoutParams layoutParams, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener, boolean z, Runnable runnable);

    int createView(int i, String str);

    void createViewForHandle(int i, int i2, String str);

    void destroyView(int i);

    void detachVideoView(int i);

    View getView(int i);

    int getViewByID(String str);

    void hideView(int i);

    float[] measureText(String str, float f, float f2, boolean z);

    void overlayCreate(int i, String str, int i2);

    void overlayDestroy(int i);

    void overlayDestroyAll();

    void overlayDismiss(int i, int i2);

    void overlayShow(int i, int i2, int i3);

    void overlayUpdate(int i, String str);

    void popupDismiss(int i);

    void popupShow(int i, int i2, int i3, int i4, int i5);

    float queryView(int i, int i2);

    void queryViewAll(int i, float[] fArr);

    void removeChild(int i, int i2);

    void setImage(int i, String str);

    void setLayout(int i, float f, float f2, float f3, float f4);

    void setOnClick(int i, Runnable runnable);

    void setOnTouch(int i, TouchCallback touchCallback);

    void setOnTouch(int i, TouchCallback touchCallback, int i2);

    void setStyle(int i, String str, String str2);

    void setText(int i, String str);

    void showView(int i);
}
