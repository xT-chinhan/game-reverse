package com.byazt.tk;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 19})
public class n {

    /* JADX INFO: renamed from: com.byazt.tk.n$n, reason: collision with other inner class name */
    public interface InterfaceC0352n {
        void n();

        void n(Throwable th);
    }

    public static boolean n(Context context, Intent intent, InterfaceC0352n interfaceC0352n) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                }
                context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
                if (interfaceC0352n == null) {
                    return true;
                }
                interfaceC0352n.n();
                return true;
            } catch (Throwable th) {
                if (interfaceC0352n != null) {
                    interfaceC0352n.n(th);
                }
            }
        }
        return false;
    }

    public static boolean n(Context context, Intent intent, InterfaceC0352n interfaceC0352n, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        }
        return n(context, intent, interfaceC0352n);
    }

    public static void startActivity(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return;
        }
        if (z) {
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        context.startActivity(intent);
    }

    public static Activity n(View view) {
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
