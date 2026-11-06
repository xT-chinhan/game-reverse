package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends YogaNodeJNIBase {
    protected void finalize() throws Throwable {
        try {
            zb();
        } finally {
            super.finalize();
        }
    }

    public void zb() {
        if (this.f441ms != 0) {
            long j = this.f441ms;
            this.f441ms = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
