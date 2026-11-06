package com.byazt.yx;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface n {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<s> getFlexLinesInternal();

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

    int n(int i, int i2, int i3);

    int n(View view);

    int n(View view, int i, int i2);

    View n(int i);

    void n(View view, int i, int i2, s sVar);

    void n(s sVar);

    boolean n();

    int qg(int i, int i2, int i3);

    View qg(int i);

    void setFlexLines(List<s> list);
}
