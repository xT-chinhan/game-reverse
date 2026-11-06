package com.byazt.wf;

import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 62})
public class fw {
    public static final pr pr;

    @com.byazt.vzx.pr(pr = {0, 1, 201, 766})
    private static class pr {
        private pr() {
        }

        public long pr(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 201, 984})
    private static class hw extends pr {
        private hw() {
            super();
        }

        @Override // com.byazt.wf.fw.pr
        public long pr(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            pr = new hw();
        } else {
            pr = new pr();
        }
    }

    public static long pr(ActivityManager.MemoryInfo memoryInfo) {
        return pr.pr(memoryInfo);
    }
}
