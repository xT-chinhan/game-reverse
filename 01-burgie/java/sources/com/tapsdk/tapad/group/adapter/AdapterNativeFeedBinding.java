package com.tapsdk.tapad.group.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tapsdk.tapad.group.views.DirichletAdNativeContainer;
import com.tapsdk.tapad.group.views.NativeContainerAccess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterNativeFeedBinding {
    private final List<View> clickViews;
    private final FrameLayout container;
    private final List<View> creativeViews;
    private final boolean doubleWindow;
    private final FrameLayout.LayoutParams logoLayoutParams;
    private final boolean selfDoubleWindow;

    public AdapterNativeFeedBinding(FrameLayout frameLayout, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, boolean z, boolean z2) {
        if (frameLayout == null) {
            throw new IllegalArgumentException("missing native feed container");
        }
        this.container = frameLayout;
        this.clickViews = immutableViews(list);
        this.creativeViews = immutableViews(list2);
        this.logoLayoutParams = layoutParams;
        this.doubleWindow = z;
        this.selfDoubleWindow = z2;
    }

    private static List<View> immutableViews(List<View> list) {
        return (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
    }

    public void addOverlay(View view) {
        if (view != null) {
            this.container.addView(view, this.logoLayoutParams);
        }
    }

    public List<View> getClickViews() {
        return this.clickViews;
    }

    public FrameLayout getContainer() {
        return this.container;
    }

    public List<View> getCreativeViews() {
        return this.creativeViews;
    }

    public FrameLayout.LayoutParams getLogoLayoutParams() {
        return this.logoLayoutParams;
    }

    public void installProviderContainer(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        FrameLayout frameLayout2 = this.container;
        if (frameLayout2 instanceof DirichletAdNativeContainer) {
            NativeContainerAccess.replaceProviderContainer((DirichletAdNativeContainer) frameLayout2, frameLayout);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < this.container.getChildCount(); i2++) {
            arrayList.add(this.container.getChildAt(i2));
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            View view = (View) obj;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            frameLayout.addView(view);
        }
        this.container.removeAllViews();
        this.container.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    public boolean isDoubleWindow() {
        return this.doubleWindow;
    }

    public boolean isSelfDoubleWindow() {
        return this.selfDoubleWindow;
    }
}
