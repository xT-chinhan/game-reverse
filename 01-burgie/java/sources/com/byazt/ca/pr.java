package com.byazt.ca;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 37})
public class pr {

    /* JADX INFO: renamed from: com.byazt.ca.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0030pr {
        void pr();

        void pr(Throwable th);
    }

    public static boolean pr(Context context, Intent intent, InterfaceC0030pr interfaceC0030pr) {
        if (context == null || intent == null) {
            return false;
        }
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
            if (interfaceC0030pr != null) {
                interfaceC0030pr.pr();
                return true;
            }
            return true;
        } catch (Throwable th) {
            if (interfaceC0030pr != null) {
                interfaceC0030pr.pr(th);
            }
            return false;
        }
    }

    public static boolean pr(Context context, Intent intent, InterfaceC0030pr interfaceC0030pr, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        }
        return pr(context, intent, interfaceC0030pr);
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

    public static Activity pr(View view) {
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
