package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class na implements Runnable {
    public final /* synthetic */ oa a;

    public na(oa oaVar) {
        this.a = oaVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    @Override // java.lang.Runnable
    public final void run() {
        int currentPosition;
        pa paVar = this.a.a;
        paVar.getClass();
        try {
            int i = paVar.a;
            if (i != 4) {
                if (i == 9) {
                    int i2 = paVar.m + 1000;
                    paVar.m = i2;
                    if (i2 >= 0) {
                        paVar.a(11);
                        return;
                    }
                    int i3 = paVar.l + 1000;
                    paVar.l = i3;
                    j2 j2Var = (j2) paVar.g;
                    r2 r2Var = j2Var.v;
                    if (r2Var != null && j2Var.a.a == 4) {
                        l lVarA = l.a();
                        p pVar = r2Var.v;
                        lVarA.getClass();
                        l.b(i3, pVar);
                        return;
                    }
                    return;
                }
                return;
            }
            zb zbVar = paVar.f;
            if (zbVar != null) {
                try {
                    MediaPlayer mediaPlayer = zbVar.b;
                    if (mediaPlayer != null) {
                        currentPosition = mediaPlayer.getCurrentPosition();
                    } else {
                        currentPosition = 0;
                    }
                } catch (Exception e) {
                    r9.a("ssp_media", zbVar.a + ", getCurrentPosition: ", e);
                }
            } else {
                currentPosition = 0;
            }
            paVar.l = currentPosition;
            j2 j2Var2 = (j2) paVar.g;
            r2 r2Var2 = j2Var2.v;
            if (r2Var2 != null && j2Var2.a.a == 4) {
                l lVarA2 = l.a();
                p pVar2 = r2Var2.v;
                lVarA2.getClass();
                l.b(currentPosition, pVar2);
            }
        } catch (Exception e2) {
            int i4 = paVar.k.a;
        }
    }
}
