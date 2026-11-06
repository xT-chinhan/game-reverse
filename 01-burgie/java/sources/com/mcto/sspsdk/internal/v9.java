package com.mcto.sspsdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.text.TextUtils;
import com.mcto.sspsdk.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class v9 extends BroadcastReceiver {
    public final WeakReference a;

    public v9(y9 y9Var) {
        this.a = new WeakReference(y9Var);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        y9 y9Var;
        g2 g2Var;
        f2 f2Var;
        if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || (y9Var = (y9) this.a.get()) == null || (g2Var = y9Var.c) == null) {
                return;
            }
            if (!TextUtils.equals(ha.a(), "1")) {
                g2Var.a.a();
                return;
            } else {
                j2 j2Var = g2Var.a;
                j2Var.a(j2Var.b());
                return;
            }
        }
        y9 y9Var2 = (y9) this.a.get();
        if (y9Var2 == null || (f2Var = y9Var2.b) == null) {
            return;
        }
        AudioManager audioManager = y9.f;
        float streamVolume = audioManager != null ? audioManager.getStreamVolume(3) : -1.0f;
        j2 j2Var2 = f2Var.a;
        j2Var2.s = streamVolume == 0.0f;
        j2Var2.a.a(streamVolume);
        j2 j2Var3 = f2Var.a;
        j2Var3.e.setImageResource(j2Var3.s ? R.drawable.qy_ic_volume_off_with_bg : R.drawable.qy_ic_volume_on_with_bg);
    }
}
