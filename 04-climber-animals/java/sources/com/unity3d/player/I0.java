package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class I0 implements Runnable {
    I0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC0840c.a();
        } catch (Exception e) {
            AbstractC0886z.Log(6, "Exception when hiding Activity Indicator " + e);
        }
    }
}
