package com.smartdigimkt.i2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;
import com.smartdigimkt.sdk.basead.ui.SplashBottomShakeTextHintView;
import com.smartdigimkt.sdk.basead.ui.SplashShakeTextHintView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static boolean a(HashMap map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("click_type");
        if (!(obj instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Integer) obj).intValue();
        return iIntValue == 4 || iIntValue == 19;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    public static void a(View view, int i, int i2, int i3, String str) {
        int id;
        TextView textView;
        if (view != null && ((id = view.getId()) == i || id == i2 || id == i3 || (view instanceof SplashShakeTextHintView))) {
            if (str != null && view.getVisibility() == 0) {
                if (view instanceof SplashShakeTextHintView) {
                    ((SplashShakeTextHintView) view).showDefaultCta(str);
                } else {
                    if ((view instanceof SplashBottomShakeTextHintView) && (view.getParent() instanceof View) && (textView = (TextView) ((View) view.getParent()).findViewById(com.smartdigimkt.r4.k.a(view.getContext(), "myoffer_splash_ad_bottom_slide_title", "id"))) != null) {
                        textView.setText(str);
                    }
                    if (view instanceof BaseShakeView) {
                        ((BaseShakeView) view).releaseShakeListener();
                    }
                    view.setVisibility(8);
                }
            } else {
                if (view instanceof BaseShakeView) {
                    ((BaseShakeView) view).releaseShakeListener();
                }
                view.setVisibility(8);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                a(viewGroup.getChildAt(i4), i, i2, i3, str);
            }
        }
    }
}
