package com.ss.android.socialbase.downloader.ny;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    private int ah;
    private int d = 10;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f4789ms;
    private ms xr;

    public boolean ms(long j, long j2) {
        synchronized (this) {
            ms msVar = this.f4789ms;
            if (msVar != null) {
                if (j >= msVar.f4790ms && j2 >= msVar.xr) {
                    ms msVar2 = msVar.ah;
                    if (msVar2 != null && j2 - msVar2.xr < 1000) {
                        msVar.f4790ms = j;
                        msVar.xr = j2;
                        return true;
                    }
                }
                return false;
            }
            ms msVarMs = ms();
            msVarMs.f4790ms = j;
            msVarMs.xr = j2;
            if (msVar != null) {
                msVarMs.ah = msVar;
                msVar.d = msVarMs;
            }
            this.f4789ms = msVarMs;
            return true;
        }
    }

    public long xr(long j, long j2) {
        synchronized (this) {
            ms msVar = this.f4789ms;
            if (msVar == null) {
                return -1L;
            }
            ms msVarMs = ms(j);
            if (msVarMs == null) {
                return -1L;
            }
            long j3 = msVar.f4790ms - msVarMs.f4790ms;
            long j4 = j2 - msVarMs.xr;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private ms ms() {
        ms msVar;
        int i = this.ah;
        if (i >= this.d && (msVar = this.xr) != null) {
            ms msVar2 = msVar.d;
            msVar.d = null;
            this.xr = msVar2;
            if (msVar2 != null) {
                msVar2.ah = null;
            }
            return msVar;
        }
        this.ah = i + 1;
        return new ms();
    }

    private ms ms(long j) {
        ms msVar = this.f4789ms;
        ms msVar2 = null;
        while (msVar != null && msVar.xr > j) {
            msVar2 = msVar;
            msVar = msVar.ah;
        }
        return (msVar == null || msVar2 == null || msVar == msVar2 || j - msVar.xr >= msVar2.xr - j) ? msVar2 : msVar;
    }

    private static class ms {
        ms ah;
        ms d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        long f4790ms;
        long xr;

        private ms() {
        }
    }
}
