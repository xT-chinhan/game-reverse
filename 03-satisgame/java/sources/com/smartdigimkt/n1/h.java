package com.smartdigimkt.n1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.PanelView;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
    public final View a;
    public final int e;
    public final int f;
    public int[][] p;
    public final WeakHashMap g = new WeakHashMap();
    public final WeakHashMap h = new WeakHashMap();
    public final LinkedHashSet i = new LinkedHashSet();
    public final int[] j = new int[2];
    public final Rect k = new Rect();
    public final Rect l = new Rect();
    public final Rect m = new Rect();
    public final Rect n = new Rect();
    public Rect o = new Rect();
    public final int c = 9;
    public final int[] b = new int[20];
    public final ArrayList d = new ArrayList(20);

    public h(View view) {
        this.a = view;
        this.e = com.smartdigimkt.r4.k.a(view.getContext(), "myoffer_splash_ad_bottom_container", "id");
        this.f = com.smartdigimkt.r4.k.a(view.getContext(), "myoffer_panel_view_blank", "id");
        String[] strArr = {"myoffer_btn_close_id", "myoffer_count_down_view_id", "myoffer_btn_countdown_close_id", "myoffer_btn_close_header_view_id", "myoffer_btn_mute_id", "myoffer_feedback_ll_id", "myoffer_splash_skip_area", "myoffer_header_panel_view_id", "myoffer_splash_endcard_count_down_text"};
        String[] strArr2 = {"myoffer_banner_view_id", "myoffer_banner_view_for_anim_player_id", "myoffer_splash_ad_bottom_container", "myoffer_splash_ad_cta_layout", "myoffer_splash_endcard_cta", "myoffer_splash_endcard_shake_hint_text", "myoffer_four_element_container_bg", "myoffer_four_element_container", "myoffer_ad_logo_container", "myoffer_fl_invalid_btn", "myoffer_include_invalid_button_full_screen"};
        int i = 0;
        while (true) {
            int[] iArr = this.b;
            if (i >= iArr.length) {
                return;
            }
            int i2 = this.c;
            iArr[i] = com.smartdigimkt.r4.k.a(view.getContext(), i < i2 ? strArr[i] : strArr2[i - i2], "id");
            this.d.add(new ArrayList());
            i++;
        }
    }

    public final void a(View view) {
        int id = view.getId();
        int i = -1;
        if (id != -1 && id != 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.b;
                if (i2 >= iArr.length) {
                    break;
                }
                if (iArr[i2] == id) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        if (i >= 0) {
            ((List) this.d.get(i)).add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                a(viewGroup.getChildAt(i3));
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.isLayoutRequested() || this.a.getWidth() == 0 || this.a.getHeight() == 0) {
            return;
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((List) it.next()).clear();
        }
        a(this.a);
        a(0, this.c, 1);
        a(this.c, this.b.length, 2);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        view.requestApplyInsets();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01be  */
    public final void a(int i, int i2, int i3) {
        int i4;
        View view;
        this.i.clear();
        while (i < i2) {
            for (Object parent : (List) this.d.get(i)) {
                while (true) {
                    view = (View) parent;
                    if (!(view.getParent() instanceof LinearLayout) || view.getParent() == this.a || ((LinearLayout) view.getParent()).getOrientation() != 0) {
                        break;
                    } else {
                        parent = view.getParent();
                    }
                }
                if (view != this.a) {
                    this.i.add(view);
                }
            }
            i++;
        }
        for (View view2 : this.i) {
            if (view2.getVisibility() != 8 && (view2.getParent() instanceof View)) {
                View view3 = (View) view2.getParent();
                View view4 = view3;
                while (true) {
                    if (view4 != this.a && view4 != null) {
                        if (this.i.contains(view4)) {
                            break;
                        } else {
                            view4 = view4.getParent() instanceof View ? (View) view4.getParent() : null;
                        }
                    } else {
                        if (!(view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            break;
                        }
                        i iVar = (i) this.g.get(view2);
                        if (iVar == null) {
                            iVar = new i();
                            this.g.put(view2, iVar);
                        }
                        boolean z = view2 instanceof PanelView;
                        if (z) {
                            PanelView panelView = (PanelView) view2;
                            if (panelView.isFullScreenEndCardLayout()) {
                                iVar.a(view2, this.n);
                                if (!view2.isLayoutRequested()) {
                                    int i5 = this.f;
                                    View viewFindViewById = i5 != 0 ? panelView.findViewById(i5) : null;
                                    if (viewFindViewById == null && panelView.getChildCount() > 0) {
                                        viewFindViewById = panelView.getChildAt(0);
                                    }
                                    if (viewFindViewById == null) {
                                        break;
                                    }
                                    j jVar = (j) this.h.get(viewFindViewById);
                                    if (jVar == null) {
                                        jVar = new j();
                                        this.h.put(viewFindViewById, jVar);
                                    }
                                    Rect rectA = a(viewFindViewById, this.a.getRootView());
                                    int paddingLeft = (viewFindViewById.getPaddingLeft() + rectA.left) - (viewFindViewById.getPaddingLeft() == jVar.b.left ? jVar.a.left : 0);
                                    int paddingTop = (viewFindViewById.getPaddingTop() + rectA.top) - (viewFindViewById.getPaddingTop() == jVar.b.top ? jVar.a.top : 0);
                                    int paddingRight = (viewFindViewById.getPaddingRight() + rectA.right) - (viewFindViewById.getPaddingRight() == jVar.b.right ? jVar.a.right : 0);
                                    int paddingBottom = (viewFindViewById.getPaddingBottom() + rectA.bottom) - (viewFindViewById.getPaddingBottom() == jVar.b.bottom ? jVar.a.bottom : 0);
                                    if (paddingLeft != viewFindViewById.getPaddingLeft() || paddingTop != viewFindViewById.getPaddingTop() || paddingRight != viewFindViewById.getPaddingRight() || paddingBottom != viewFindViewById.getPaddingBottom()) {
                                        viewFindViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                    }
                                    jVar.b.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                    jVar.a.set(rectA);
                                    if (!viewFindViewById.isLayoutRequested() && (viewFindViewById instanceof ViewGroup)) {
                                        a((ViewGroup) viewFindViewById);
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        if (i3 == 1 && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                            int[] rules = ((RelativeLayout.LayoutParams) view2.getLayoutParams()).getRules();
                            if (rules[12] == 0 || rules[10] != 0) {
                                i4 = i3;
                            } else {
                                i4 = 2;
                            }
                        } else {
                            i4 = i3;
                        }
                        Rect rectA2 = a(view3, this.a.getRootView());
                        this.l.set(rectA2.left, (i4 & 1) != 0 ? rectA2.top : 0, rectA2.right, (i4 & 2) != 0 ? rectA2.bottom : 0);
                        if (z) {
                            ViewGroup viewGroup = (ViewGroup) view2;
                            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                                View childAt = viewGroup.getChildAt(i6);
                                if (childAt instanceof ViewGroup) {
                                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                                    for (int i7 = 0; i7 < viewGroup2.getChildCount(); i7++) {
                                        View childAt2 = viewGroup2.getChildAt(i7);
                                        if (childAt2.getVisibility() != 8 && (childAt2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                                            i iVar2 = (i) this.g.get(childAt2);
                                            if (iVar2 == null) {
                                                iVar2 = new i();
                                                this.g.put(childAt2, iVar2);
                                            }
                                            this.m.setEmpty();
                                            a(childAt2, iVar2, this.m, i4);
                                            iVar2.a(childAt2, this.m);
                                        }
                                    }
                                }
                            }
                        } else if (this.e != 0 && view2.getId() == this.e && (view2 instanceof ViewGroup)) {
                            ViewGroup viewGroup3 = (ViewGroup) view2;
                            for (int i8 = 0; i8 < viewGroup3.getChildCount(); i8++) {
                                View childAt3 = viewGroup3.getChildAt(i8);
                                if (childAt3.getVisibility() != 8 && (childAt3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                                    i iVar3 = (i) this.g.get(childAt3);
                                    if (iVar3 == null) {
                                        iVar3 = new i();
                                        this.g.put(childAt3, iVar3);
                                    }
                                    this.m.setEmpty();
                                    a(childAt3, iVar3, this.m, i4);
                                    iVar3.a(childAt3, this.m);
                                }
                            }
                        } else {
                            a(view2, iVar, this.l, i4);
                        }
                        iVar.a(view2, this.l);
                        break;
                    }
                }
            }
        }
    }

    public final void a(View view, i iVar, Rect rect, int i) {
        if (this.p == null) {
            return;
        }
        view.getLocationInWindow(this.j);
        int i2 = this.j[0];
        int i3 = i2 - iVar.a.left;
        int width = view.getWidth() + i2 + iVar.a.right;
        if ((i & 2) != 0) {
            int height = ((view.getHeight() + this.j[1]) + iVar.a.bottom) - rect.bottom;
            rect.left = Math.max(rect.left, k.a(this.p[2], i3, height, true, true));
            rect.right = Math.max(rect.right, k.a(this.p[3], width, height, false, true));
        }
        if ((i & 1) != 0) {
            int i4 = (this.j[1] - iVar.a.top) + rect.top;
            rect.left = Math.max(rect.left, k.a(this.p[0], i3, i4, true, false));
            rect.right = Math.max(rect.right, k.a(this.p[1], width, i4, false, false));
        }
    }

    public final void a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() != 8) {
                boolean z = (childAt instanceof LinearLayout) && ((LinearLayout) childAt).getOrientation() == 0;
                if ((childAt instanceof ViewGroup) && !(childAt instanceof CTAButtonLayout) && !z) {
                    a((ViewGroup) childAt);
                } else if (childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    i iVar = (i) this.g.get(childAt);
                    if (iVar == null) {
                        iVar = new i();
                        this.g.put(childAt, iVar);
                    }
                    this.m.setEmpty();
                    a(childAt, iVar, this.m, 3);
                    iVar.a(childAt, this.m);
                }
            }
        }
    }

    public final Rect a(View view, View view2) {
        view.getLocationInWindow(this.j);
        this.k.set(Math.min(view.getWidth(), Math.max(0, this.o.left - this.j[0])), Math.min(view.getHeight(), Math.max(0, this.o.top - this.j[1])), Math.min(view.getWidth(), Math.max(0, ((view.getWidth() + this.j[0]) - view2.getWidth()) + this.o.right)), Math.min(view.getHeight(), Math.max(0, ((view.getHeight() + this.j[1]) - view2.getHeight()) + this.o.bottom)));
        return this.k;
    }
}
