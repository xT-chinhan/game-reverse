package com.byazt.ri;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 697, 13})
public class hw {
    public static Activity pr(View view) {
        if (view == null) {
            return null;
        }
        Activity activityPr = pr(view.getContext());
        if (activityPr != null) {
            return activityPr;
        }
        Object parent = view.getParent();
        if ((parent instanceof View) && (activityPr = pr((View) parent)) != null) {
            return activityPr;
        }
        View rootView = view.getRootView();
        if (rootView != null) {
            Context context = rootView.getContext();
            Activity activityPr2 = pr(context);
            if (activityPr2 != null) {
                return activityPr2;
            }
            return hw(context);
        }
        return activityPr;
    }

    private static Activity pr(Context context) {
        Context baseContext;
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == null || baseContext == context) {
            return null;
        }
        return pr(baseContext);
    }

    private static Activity hw(Context context) {
        if (context == null || !context.getClass().getName().contains("DecorContext")) {
            return null;
        }
        try {
            Field declaredField = context.getClass().getDeclaredField("mActivity");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(context);
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
