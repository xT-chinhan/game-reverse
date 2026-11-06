package com.onevcat.uniwebview;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: renamed from: com.onevcat.uniwebview.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0701b {
    public final FrameLayout a;
    public final Activity b;
    public final View c;
    public int d;
    public int e;
    public final FrameLayout.LayoutParams f;
    public float g;

    public C0701b(X x, Activity activity) {
        this.a = x;
        this.b = activity;
        View childAt = x.getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "mContent.getChildAt(0)");
        this.c = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.onevcat.uniwebview.b$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                C0701b.a(this.f$0);
            }
        });
        ViewGroup.LayoutParams layoutParams = x.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        this.f = (FrameLayout.LayoutParams) layoutParams;
        this.g = childAt.getRootView().getHeight();
    }

    public static final void a(C0701b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.b.getResources().getConfiguration().orientation;
        Rect rect = new Rect();
        this$0.c.getWindowVisibleDisplayFrame(rect);
        int iCoerceAtLeast = RangesKt.coerceAtLeast(0, (rect.bottom - rect.top) - ((int) this$0.a.getY()));
        if (i != this$0.e) {
            this$0.e = i;
            this$0.d = iCoerceAtLeast;
            return;
        }
        if (iCoerceAtLeast != this$0.d) {
            FrameLayout.LayoutParams layoutParams = this$0.f;
            float f = this$0.g;
            float y = this$0.c.getY() + f;
            int height = this$0.c.getRootView().getHeight();
            Rect rect2 = new Rect();
            this$0.c.getWindowVisibleDisplayFrame(rect2);
            layoutParams.height = (int) (f - RangesKt.coerceAtLeast(0.0f, (y + (height - RangesKt.coerceAtLeast(0, (rect2.bottom - rect2.top) - ((int) this$0.a.getY())))) - this$0.c.getRootView().getHeight()));
            this$0.a.requestLayout();
            this$0.d = iCoerceAtLeast;
        }
    }
}
