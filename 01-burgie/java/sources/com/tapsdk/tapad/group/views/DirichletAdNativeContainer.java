package com.tapsdk.tapad.group.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DirichletAdNativeContainer extends FrameLayout {
    private FrameLayout oldContainer;

    public DirichletAdNativeContainer(Context context) {
        super(context);
    }

    private static void collectMovableChildren(FrameLayout frameLayout, View view, List<View> list) {
        for (int i = 0; i < frameLayout.getChildCount(); i++) {
            View childAt = frameLayout.getChildAt(i);
            if (childAt != view && childAt != null && !childAt.getClass().getName().startsWith("com.qq.e") && !list.contains(childAt)) {
                list.add(childAt);
            }
        }
    }

    public synchronized void replaceProviderContainer(FrameLayout frameLayout) {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout2 = this.oldContainer;
        if (frameLayout2 != null) {
            collectMovableChildren(frameLayout2, null, arrayList);
            collectMovableChildren(this, this.oldContainer, arrayList);
        } else {
            collectMovableChildren(this, null, arrayList);
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            View view = (View) obj;
            ViewParent parent = view.getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).removeView(view);
            }
            frameLayout.addView(view);
        }
        removeAllViews();
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.oldContainer = frameLayout;
        requestLayout();
    }

    public DirichletAdNativeContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DirichletAdNativeContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DirichletAdNativeContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
