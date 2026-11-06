package com.smartdigimkt.b2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.sdk.basead.ui.SwipeOverlayView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {
    public static ViewGroup a(ViewGroup viewGroup, int i, HashMap map, com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.e eVar;
        int i2;
        if (i != 5 || viewGroup == null) {
            if (i == 6) {
                Object obj = map.get("native_media_view");
                if (obj instanceof ViewGroup) {
                    return (ViewGroup) obj;
                }
                Object obj2 = map.get("shake_view_extra_container");
                if (obj2 instanceof ViewGroup) {
                    return (ViewGroup) obj2;
                }
                if (viewGroup != null) {
                    return viewGroup;
                }
            }
            return null;
        }
        if (i == 5 && aVar != null && (eVar = aVar.s) != null && ((i2 = eVar.F0) == 1 || i2 == 2)) {
            return viewGroup;
        }
        View viewFindViewById = viewGroup.findViewById(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_media_ad_main_image_container", "id"));
        if (viewFindViewById instanceof ViewGroup) {
            return (ViewGroup) viewFindViewById;
        }
        return null;
    }

    public static void b(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof u) {
                u uVar = (u) childAt;
                r rVar = uVar.a;
                if (rVar != null) {
                    viewGroup.removeOnLayoutChangeListener(rVar);
                    uVar.a = null;
                }
                for (int i = 0; i < uVar.getChildCount(); i++) {
                    uVar.getChildAt(i).removeCallbacks(null);
                }
                viewGroup.removeViewAt(childCount);
            }
        }
    }

    public static void b(ViewGroup viewGroup, SwipeOverlayView swipeOverlayView) {
        if (viewGroup == null || swipeOverlayView == null) {
            return;
        }
        Object tag = swipeOverlayView.getTag();
        if (tag instanceof View.OnLayoutChangeListener) {
            viewGroup.removeOnLayoutChangeListener((View.OnLayoutChangeListener) tag);
            swipeOverlayView.setTag(null);
        }
        swipeOverlayView.removeCallbacks(null);
    }

    public static FrameLayout a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        u uVar = new u(viewGroup);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        uVar.addView(frameLayout, new FrameLayout.LayoutParams(0, 0, 17));
        viewGroup.addView(uVar, new ViewGroup.LayoutParams(-1, -1));
        r rVar = new r(frameLayout);
        uVar.a = rVar;
        viewGroup.addOnLayoutChangeListener(rVar);
        if (viewGroup.getWidth() > 0 && viewGroup.getHeight() > 0) {
            rVar.onLayoutChange(viewGroup, 0, 0, viewGroup.getWidth(), viewGroup.getHeight(), 0, 0, 0, 0);
        }
        return frameLayout;
    }

    public static void a(ViewGroup viewGroup, SwipeOverlayView swipeOverlayView) {
        if (swipeOverlayView == null) {
            return;
        }
        t tVar = new t(swipeOverlayView);
        swipeOverlayView.setTag(tVar);
        viewGroup.addOnLayoutChangeListener(tVar);
        if (viewGroup.getWidth() <= 0 || viewGroup.getHeight() <= 0) {
            return;
        }
        tVar.onLayoutChange(viewGroup, 0, 0, viewGroup.getWidth(), viewGroup.getHeight(), 0, 0, 0, 0);
    }
}
