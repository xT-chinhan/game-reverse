package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
interface ms {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<ah> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int ms(int i, int i2, int i3);

    int ms(View view);

    int ms(View view, int i, int i2);

    View ms(int i);

    void ms(View view, int i, int i2, ah ahVar);

    void ms(ah ahVar);

    boolean ms();

    void setFlexLines(List<ah> list);

    int xr(int i, int i2, int i3);

    View xr(int i);
}
