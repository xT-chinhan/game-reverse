package com.byazt.se;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 121})
public class x {
    public int pr;

    public x(Context context) {
        try {
            pr(context);
        } catch (Throwable th) {
        }
    }

    private void pr(Context context) {
        context.registerReceiver(new pr(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int pr() {
        return this.pr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private class pr extends BroadcastReceiver {
        private pr() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    x.this.pr = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable th) {
            }
        }
    }
}
