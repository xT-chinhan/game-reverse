package com.bytedance.ms.xr.x;

import android.os.Debug;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final ms f596ms = new C0218xr();

    private static class ms {
        public int ah(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int ms(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int xr(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private ms() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ms.xr.x.xr$xr, reason: collision with other inner class name */
    private static class C0218xr extends ms {
        private C0218xr() {
            super();
        }

        @Override // com.bytedance.ms.xr.x.xr.ms
        public int ms(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.bytedance.ms.xr.x.xr.ms
        public int xr(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.bytedance.ms.xr.x.xr.ms
        public int ah(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int ms(Debug.MemoryInfo memoryInfo) {
        return f596ms.ms(memoryInfo);
    }

    public static int xr(Debug.MemoryInfo memoryInfo) {
        return f596ms.xr(memoryInfo);
    }

    public static int ah(Debug.MemoryInfo memoryInfo) {
        return f596ms.ah(memoryInfo);
    }
}
