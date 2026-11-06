package com.byazt.ca;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 2012})
public class HomeWatcherReceiver extends BroadcastReceiver {
    public pr pr;

    public interface pr {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON);
                if ("homekey".equals(stringExtra) || "recentapps".equals(stringExtra)) {
                    return;
                }
                "assist".equals(stringExtra);
            }
        } catch (Throwable th) {
            ho.hw("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
