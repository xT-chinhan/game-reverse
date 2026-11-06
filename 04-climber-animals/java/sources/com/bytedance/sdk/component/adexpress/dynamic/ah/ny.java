package com.bytedance.sdk.component.adexpress.dynamic.ah;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public float f766ms;
    public float xr;

    public ny(float f, float f2) {
        this.f766ms = f;
        this.xr = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ny nyVar = (ny) obj;
            if (Float.compare(nyVar.f766ms, this.f766ms) == 0 && Float.compare(nyVar.xr, this.xr) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f766ms), Float.valueOf(this.xr)});
    }
}
