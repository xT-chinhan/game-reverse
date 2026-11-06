package com.byazt.gqi;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface pr {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<hn> getFlexLinesInternal();

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

    int hw(int i, int i2, int i3);

    View hw(int i);

    int pr(int i, int i2, int i3);

    int pr(View view);

    int pr(View view, int i, int i2);

    View pr(int i);

    void pr(View view, int i, int i2, hn hnVar);

    void pr(hn hnVar);

    boolean pr();

    void setFlexLines(List<hn> list);
}
