package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbc extends zzbo {
    zzbc() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzbo
    public final long zza() {
        return SystemClock.elapsedRealtime() * C.MICROS_PER_SECOND;
    }
}
