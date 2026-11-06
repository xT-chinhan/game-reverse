package com.ss.android.downloadlib.xr;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    public void ms(final com.ss.android.downloadad.api.ms.xr xrVar, final ab abVar, int i) {
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.xr.xr.1
            @Override // java.lang.Runnable
            public void run() {
                if (ny.ms(xrVar)) {
                    abVar.ms(false);
                } else if (!c.ms(xrVar)) {
                    abVar.ms(false);
                } else {
                    c.ms(xrVar, new x() { // from class: com.ss.android.downloadlib.xr.xr.1.1
                        @Override // com.ss.android.downloadlib.xr.x
                        public void ms(boolean z) {
                            abVar.ms(z);
                        }
                    });
                }
            }
        }, i);
    }
}
