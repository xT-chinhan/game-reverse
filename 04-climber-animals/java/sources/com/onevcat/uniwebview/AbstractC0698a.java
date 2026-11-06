package com.onevcat.uniwebview;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.onevcat.uniwebview.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0698a {
    public static final AlertDialog.Builder a(AlertDialog.Builder builder, EditText... editTexts) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(editTexts, "editTexts");
        LinearLayout linearLayout = new LinearLayout(builder.getContext());
        linearLayout.setOrientation(1);
        for (EditText editText : editTexts) {
            linearLayout.addView(editText);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) ((16.0f / 2) * Resources.getSystem().getDisplayMetrics().density);
        int i = (int) 48.0f;
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(builder.getContext());
        frameLayout.addView(linearLayout);
        builder.setView(frameLayout);
        return builder;
    }
}
