package com.byazt.pd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 24, 5})
public class q {
    public int n;

    public q(Context context) {
        try {
            n(context);
        } catch (Throwable unused) {
        }
    }

    private void n(Context context) {
        context.registerReceiver(new n(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int n() {
        return this.n;
    }

    @com.byazt.cp.n(n = {0, 1, 24, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private class n extends BroadcastReceiver {
        private n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    q.this.n = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
