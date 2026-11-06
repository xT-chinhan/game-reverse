package com.tapsdk.tapad.internal.runtime.view;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes3.dex */
public class LinearContainerViewManager extends BaseViewManager<LinearLayout, ContainerViewProps> {
    public static final String NAME = "linear";
    public static final int VIEW_TYPE = 103;
    private final float mDensity;

    public LinearContainerViewManager(Context context) {
        this.mDensity = context.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    private int parseGravity(String str) {
        switch (str) {
            case "center":
                return 17;
            case "center_vertical":
                return 16;
            case "center_horizontal":
                return 1;
            case "end":
            case "right":
                return GravityCompat.END;
            case "bottom":
                return 80;
            case "start":
            case "left":
            default:
                return GravityCompat.START;
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public String getName() {
        return NAME;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public Class<ContainerViewProps> getPropsClass() {
        return ContainerViewProps.class;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public int getViewType() {
        return 103;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public LinearLayout createView(Context context, String str) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void setStyle(LinearLayout linearLayout, String str, String str2) {
        if (applyBaseStyle(linearLayout, str, str2, this.mDensity)) {
            return;
        }
        str.getClass();
        if (str.equals("orientation")) {
            linearLayout.setOrientation("vertical".equals(str2) ? 1 : 0);
        } else if (str.equals("gravity")) {
            linearLayout.setGravity(parseGravity(str2));
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void updateProps(LinearLayout linearLayout, ContainerViewProps containerViewProps) {
        if (containerViewProps == null) {
            return;
        }
        applyBaseProps(linearLayout, containerViewProps, this.mDensity);
        String str = containerViewProps.orientation;
        if (str != null) {
            linearLayout.setOrientation("vertical".equals(str) ? 1 : 0);
        }
        String str2 = containerViewProps.gravity;
        if (str2 != null) {
            linearLayout.setGravity(parseGravity(str2));
        }
        Boolean bool = containerViewProps.clipChildren;
        if (bool != null) {
            linearLayout.setClipChildren(bool.booleanValue());
            linearLayout.setClipToPadding(containerViewProps.clipChildren.booleanValue());
        }
    }
}
