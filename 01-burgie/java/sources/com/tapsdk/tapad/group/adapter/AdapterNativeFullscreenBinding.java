package com.tapsdk.tapad.group.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionMirror;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterNativeFullscreenBinding {
    private final ProviderAttributionMirror attributionBinding;
    private final List<View> clickViews;
    private final List<View> creativeViews;
    private final List<View> directDownloadViews;
    private final FrameLayout hostRoot;
    private final ViewGroup mediaSlot;

    public AdapterNativeFullscreenBinding(FrameLayout frameLayout, ViewGroup viewGroup, List<View> list) {
        this(frameLayout, viewGroup, list, list, Collections.EMPTY_LIST, new ProviderAttributionSlots());
    }

    private static void collectLegacyLogoViews(View view, List<ImageView> list) {
        if (view == null) {
            return;
        }
        Object tag = view.getTag(R.id.tapad_dirichlet_debug_key_tag);
        if ((view instanceof ImageView) && (tag instanceof String)) {
            String str = (String) tag;
            if (str.endsWith(".ad_badge.icon") || str.endsWith(".ad_badge.logo") || str.endsWith(".ad_tag.icon") || str.endsWith(".ad_tag.logo")) {
                list.add((ImageView) view);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                collectLegacyLogoViews(viewGroup.getChildAt(i), list);
            }
        }
    }

    private static ProviderAttributionSlots fixedSlots(List<ViewGroup> list) {
        ProviderAttributionSlots providerAttributionSlots = new ProviderAttributionSlots();
        if (list != null) {
            Iterator<ViewGroup> it = list.iterator();
            while (it.hasNext()) {
                providerAttributionSlots.register(it.next());
            }
        }
        return providerAttributionSlots;
    }

    private static List<View> immutableViews(List<View> list) {
        return (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
    }

    public static AdapterNativeFullscreenBinding withDynamicAttributionSlots(FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, ProviderAttributionSlots providerAttributionSlots) {
        return new AdapterNativeFullscreenBinding(frameLayout, viewGroup, list, list, Collections.EMPTY_LIST, providerAttributionSlots == null ? new ProviderAttributionSlots() : providerAttributionSlots);
    }

    public boolean applyProviderAttributionBitmap(Bitmap bitmap) {
        return this.attributionBinding.applyBitmap(bitmap);
    }

    public boolean attachProviderAttributionView(FrameLayout.LayoutParams layoutParams) {
        return this.attributionBinding.attachView(layoutParams);
    }

    public FrameLayout.LayoutParams createProviderAttributionLayoutParams(int i, int i2) {
        return this.attributionBinding.createLayoutParams(i, i2);
    }

    @Deprecated
    public List<ImageView> getAdLogoViews() {
        ArrayList arrayList = new ArrayList();
        List<ViewGroup> slots = this.attributionBinding.getSlots();
        if (slots.isEmpty()) {
            collectLegacyLogoViews(this.hostRoot, arrayList);
        } else {
            Iterator<ViewGroup> it = slots.iterator();
            while (it.hasNext()) {
                collectLegacyLogoViews(it.next(), arrayList);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<ViewGroup> getAttributionSlots() {
        return this.attributionBinding.getSlots();
    }

    public List<View> getClickViews() {
        return this.clickViews;
    }

    public List<View> getCreativeViews() {
        return this.creativeViews;
    }

    public List<View> getDirectDownloadViews() {
        return this.directDownloadViews;
    }

    public FrameLayout getHostRoot() {
        return this.hostRoot;
    }

    public ViewGroup getMediaSlot() {
        return this.mediaSlot;
    }

    public void release() {
        this.attributionBinding.release();
    }

    public AdapterNativeFullscreenBinding(FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, List<ViewGroup> list2) {
        this(frameLayout, viewGroup, list, list, Collections.EMPTY_LIST, fixedSlots(list2));
    }

    private AdapterNativeFullscreenBinding(FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, ProviderAttributionSlots providerAttributionSlots) {
        if (frameLayout != null && viewGroup != null) {
            this.hostRoot = frameLayout;
            this.mediaSlot = viewGroup;
            this.clickViews = immutableViews(list);
            this.creativeViews = immutableViews(list2);
            this.directDownloadViews = immutableViews(list3);
            this.attributionBinding = new ProviderAttributionMirror(frameLayout, providerAttributionSlots);
            return;
        }
        throw new IllegalArgumentException("missing native full-screen host surface");
    }

    public static AdapterNativeFullscreenBinding withDynamicAttributionSlots(FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, ProviderAttributionSlots providerAttributionSlots) {
        ProviderAttributionSlots providerAttributionSlots2;
        if (providerAttributionSlots != null) {
            providerAttributionSlots2 = providerAttributionSlots;
        } else {
            providerAttributionSlots2 = new ProviderAttributionSlots();
        }
        return new AdapterNativeFullscreenBinding(frameLayout, viewGroup, list, list2, list3, providerAttributionSlots2);
    }
}
