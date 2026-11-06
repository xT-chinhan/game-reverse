package com.smartdigimkt.z;

import android.graphics.Rect;
import android.view.View;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final Random a = new Random();

    public static Rect a(View view) {
        if (view == null || !view.isShown() || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], view.getWidth() + i, view.getHeight() + iArr[1]);
    }
}
