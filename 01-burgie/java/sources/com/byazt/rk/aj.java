package com.byazt.rk;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1536, 61})
public class aj {
    public float hw;
    public float pr;

    public aj(float f, float f2) {
        this.pr = f;
        this.hw = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aj ajVar = (aj) obj;
        if (Float.compare(ajVar.pr, this.pr) == 0 && Float.compare(ajVar.hw, this.hw) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.pr), Float.valueOf(this.hw)});
    }
}
