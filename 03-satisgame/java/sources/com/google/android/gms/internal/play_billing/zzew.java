package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzew extends zzey {
    private int zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzew(byte[] bArr, int i, int i2, boolean z, zzex zzexVar) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zzb = 0;
    }

    public final int zza(int i) throws zzgc {
        int i2 = this.zzd;
        this.zzd = 0;
        int i3 = this.zzb + this.zzc;
        this.zzb = i3;
        if (i3 > 0) {
            this.zzc = i3;
            this.zzb = i3 - i3;
        } else {
            this.zzc = 0;
        }
        return i2;
    }
}
