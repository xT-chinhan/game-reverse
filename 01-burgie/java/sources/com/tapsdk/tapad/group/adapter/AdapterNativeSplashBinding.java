package com.tapsdk.tapad.group.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tapsdk.tapad.group.views.DirichletAdNativeContainer;
import com.tapsdk.tapad.group.views.NativeContainerAccess;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionMirror;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterNativeSplashBinding {
    private final FrameLayout.LayoutParams adLogoLayoutParams;
    private ProviderAttributionMirror attributionBinding;
    private final ProviderAttributionSlots attributionSlots;
    private final List<View> clickViews;
    private final List<View> creativeViews;
    private final FrameLayout hostContainer;

    public AdapterNativeSplashBinding(FrameLayout frameLayout, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams) {
        this(frameLayout, list, list2, layoutParams, null);
    }

    private static List<View> immutableViews(List<View> list) {
        return (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
    }

    public static AdapterNativeSplashBinding withDynamicAttributionSlots(FrameLayout frameLayout, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, ProviderAttributionSlots providerAttributionSlots) {
        return new AdapterNativeSplashBinding(frameLayout, list, list2, layoutParams, providerAttributionSlots == null ? new ProviderAttributionSlots() : providerAttributionSlots);
    }

    public boolean applyProviderAttributionBitmap(Bitmap bitmap) {
        ProviderAttributionMirror providerAttributionMirror = this.attributionBinding;
        return providerAttributionMirror != null && providerAttributionMirror.applyBitmap(bitmap);
    }

    public boolean attachProviderAttributionView(FrameLayout.LayoutParams layoutParams) {
        ProviderAttributionMirror providerAttributionMirror = this.attributionBinding;
        return providerAttributionMirror != null && providerAttributionMirror.attachView(layoutParams);
    }

    public FrameLayout.LayoutParams getAdLogoLayoutParams() {
        if (this.adLogoLayoutParams == null) {
            return null;
        }
        return new FrameLayout.LayoutParams(this.adLogoLayoutParams);
    }

    public List<View> getClickViews() {
        return this.clickViews;
    }

    public List<View> getCreativeViews() {
        return this.creativeViews;
    }

    public FrameLayout getHostContainer() {
        return this.hostContainer;
    }

    public void installProviderContainer(FrameLayout frameLayout) {
        if (frameLayout == null) {
            throw new IllegalArgumentException("missing provider Splash container");
        }
        ProviderAttributionMirror providerAttributionMirror = this.attributionBinding;
        if (providerAttributionMirror != null) {
            providerAttributionMirror.release();
            this.attributionBinding = null;
        }
        FrameLayout frameLayout2 = this.hostContainer;
        if (frameLayout2 instanceof DirichletAdNativeContainer) {
            NativeContainerAccess.replaceProviderContainer((DirichletAdNativeContainer) frameLayout2, frameLayout);
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < this.hostContainer.getChildCount(); i2++) {
                arrayList.add(this.hostContainer.getChildAt(i2));
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
            this.hostContainer.removeAllViews();
            this.hostContainer.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        }
        ProviderAttributionSlots providerAttributionSlots = this.attributionSlots;
        if (providerAttributionSlots != null) {
            this.attributionBinding = new ProviderAttributionMirror(frameLayout, providerAttributionSlots);
        }
    }

    public void release() {
        ProviderAttributionMirror providerAttributionMirror = this.attributionBinding;
        if (providerAttributionMirror != null) {
            providerAttributionMirror.release();
            this.attributionBinding = null;
        }
    }

    private AdapterNativeSplashBinding(FrameLayout frameLayout, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, ProviderAttributionSlots providerAttributionSlots) {
        if (frameLayout == null) {
            throw new IllegalArgumentException("missing Splash host container");
        }
        this.hostContainer = frameLayout;
        this.clickViews = immutableViews(list);
        this.creativeViews = immutableViews(list2);
        this.adLogoLayoutParams = layoutParams;
        this.attributionSlots = providerAttributionSlots;
    }
}
