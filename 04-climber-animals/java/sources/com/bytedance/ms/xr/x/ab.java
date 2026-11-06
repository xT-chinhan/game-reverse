package com.bytedance.ms.xr.x;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final ms f589ms = new xr();

    private static class ms {
        public long ms(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private ms() {
        }
    }

    private static class xr extends ms {
        private xr() {
            super();
        }

        @Override // com.bytedance.ms.xr.x.ab.ms
        public long ms(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long ms(ActivityManager.MemoryInfo memoryInfo) {
        return f589ms.ms(memoryInfo);
    }
}
