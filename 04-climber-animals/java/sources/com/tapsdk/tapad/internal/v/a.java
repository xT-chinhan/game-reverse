package com.tapsdk.tapad.internal.v;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static void a(Dialog dialog) {
        try {
            View viewFindViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundColor(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
