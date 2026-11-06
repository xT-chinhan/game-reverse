package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class y9 {
    public static AudioManager f;
    public final Context a;
    public f2 b;
    public g2 c;
    public v9 d;
    public boolean e = false;

    public y9(Context context) {
        this.a = context.getApplicationContext();
        f = (AudioManager) context.getApplicationContext().getSystemService(MediaFormat.KEY_AUDIO);
    }

    public final void a() {
        if (this.e) {
            return;
        }
        this.d = new v9(this);
        IntentFilter intentFilter = new IntentFilter();
        if (this.b != null) {
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        }
        if (this.c != null) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                this.a.registerReceiver(this.d, intentFilter, 2);
            } else {
                this.a.registerReceiver(this.d, intentFilter);
            }
        } catch (Exception e) {
        }
        this.e = true;
    }
}
