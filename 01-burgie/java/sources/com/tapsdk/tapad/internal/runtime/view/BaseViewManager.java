package com.tapsdk.tapad.internal.runtime.view;

import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tapsdk.tapad.internal.runtime.view.ViewProps;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseViewManager<T extends View, P extends ViewProps> implements ViewManager<T, P> {
    protected static final String TAG = "ViewManager";

    private GradientDrawable.Orientation gradientOrientation(String str) {
        if ("tb".equals(str) || "vertical".equals(str)) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        if ("lr".equals(str) || "horizontal".equals(str)) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        return "bl_tr".equals(str) ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.TOP_BOTTOM;
    }

    private boolean needsBackgroundUpdate(ViewProps viewProps) {
        return (viewProps.backgroundColor == null && !viewProps.hasGradient() && viewProps.borderRadius == null && !viewProps.hasIndividualCorners() && viewProps.borderWidth == null) ? false : true;
    }

    public void applyBaseProps(T t, ViewProps viewProps, float f) {
        if (viewProps == null) {
            return;
        }
        Float f2 = viewProps.opacity;
        if (f2 != null) {
            t.setAlpha(f2.floatValue());
        }
        Float f3 = viewProps.elevation;
        if (f3 != null) {
            t.setElevation(dp2px(f3.floatValue(), f));
        }
        if (needsBackgroundUpdate(viewProps)) {
            updateBackground(t, viewProps, f);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0044  */
    public boolean applyBaseStyle(T t, String str, String str2, float f) {
        str.getClass();
        switch (str) {
            case "opacity":
            case "alpha":
                t.setAlpha(Float.parseFloat(str2));
                return true;
            case "elevation":
                t.setElevation(dp2px(Float.parseFloat(str2), f));
                return true;
            case "backgroundColor":
                setBackgroundColor(t, parseColor(str2));
                return true;
            case "borderRadius":
                setCornerRadius(t, Float.parseFloat(str2), f);
                return true;
            default:
                return false;
        }
    }

    public int dp2px(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }

    public int parseColor(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public void setBackgroundColor(View view, int i) {
        if (view.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) view.getBackground()).setColor(i);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        view.setBackground(gradientDrawable);
    }

    public void setCornerRadius(View view, float f, float f2) {
        GradientDrawable gradientDrawable;
        if (view.getBackground() instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) view.getBackground();
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
        }
        gradientDrawable.setCornerRadius(dp2px(f, f2));
        view.setBackground(gradientDrawable);
    }

    public void updateBackground(View view, ViewProps viewProps, float f) {
        boolean z;
        final float fDp2px;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (viewProps.hasGradient()) {
            gradientDrawable.setColors(new int[]{parseColor(viewProps.gradientStartColor), parseColor(viewProps.gradientEndColor)});
            gradientDrawable.setOrientation(gradientOrientation(viewProps.gradientDirection));
        } else {
            String str = viewProps.backgroundColor;
            if (str != null) {
                gradientDrawable.setColor(parseColor(str));
            }
        }
        if (viewProps.hasIndividualCorners()) {
            Float f2 = viewProps.borderRadiusTopLeft;
            fDp2px = f2 != null ? dp2px(f2.floatValue(), f) : 0.0f;
            Float f3 = viewProps.borderRadiusTopRight;
            float fDp2px2 = f3 != null ? dp2px(f3.floatValue(), f) : 0.0f;
            Float f4 = viewProps.borderRadiusBottomRight;
            float fDp2px3 = f4 != null ? dp2px(f4.floatValue(), f) : 0.0f;
            Float f5 = viewProps.borderRadiusBottomLeft;
            float fDp2px4 = f5 != null ? dp2px(f5.floatValue(), f) : 0.0f;
            gradientDrawable.setCornerRadii(new float[]{fDp2px, fDp2px, fDp2px2, fDp2px2, fDp2px3, fDp2px3, fDp2px4, fDp2px4});
            if (fDp2px == fDp2px2 && fDp2px2 == fDp2px3 && fDp2px3 == fDp2px4) {
                z = false;
            } else {
                z = true;
                fDp2px = 0.0f;
            }
        } else {
            Float f6 = viewProps.borderRadius;
            if (f6 == null || f6.floatValue() <= 0.0f) {
                z = false;
                fDp2px = 0.0f;
            } else {
                fDp2px = dp2px(viewProps.borderRadius.floatValue(), f);
                gradientDrawable.setCornerRadius(fDp2px);
                z = false;
            }
        }
        if (fDp2px > 0.0f) {
            view.setClipToOutline(true);
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tapsdk.tapad.internal.runtime.view.BaseViewManager.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), fDp2px);
                }
            });
        } else if (z) {
            view.setClipToOutline(false);
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        Float f7 = viewProps.borderWidth;
        if (f7 != null && f7.floatValue() > 0.0f && viewProps.borderColor != null) {
            gradientDrawable.setStroke(dp2px(viewProps.borderWidth.floatValue(), f), parseColor(viewProps.borderColor));
        }
        view.setBackground(gradientDrawable);
    }
}
