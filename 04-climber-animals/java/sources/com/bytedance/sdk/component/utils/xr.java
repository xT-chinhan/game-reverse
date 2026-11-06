package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    public interface ms {
        void ms();

        void ms(Throwable th);
    }

    public static boolean ms(Context context, Intent intent, ms msVar) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                }
                context.startActivity(intent);
                if (msVar == null) {
                    return true;
                }
                msVar.ms();
                return true;
            } catch (Throwable th) {
                if (msVar != null) {
                    msVar.ms(th);
                }
            }
        }
        return false;
    }

    public static boolean ms(Context context, Intent intent, ms msVar, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            intent.putExtra("start_only_for_android", true);
        }
        return ms(context, intent, msVar);
    }

    public static void startActivity(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return;
        }
        if (z) {
            intent.putExtra("start_only_for_android", true);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        context.startActivity(intent);
    }

    public static Activity ms(View view) {
        View viewFindViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (viewFindViewById = rootView.findViewById(R.id.content)) == null || (context = viewFindViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}
