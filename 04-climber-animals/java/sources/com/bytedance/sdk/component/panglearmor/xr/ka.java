package com.bytedance.sdk.component.panglearmor.xr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ka f1321ms;
    private boolean xr = false;
    private long ah = 180000;
    private long d = 43200000;
    private long ka = 3;
    private long c = 30;
    private long ab = 15;

    private ka() {
    }

    public static ka ms() {
        if (f1321ms == null) {
            synchronized (ka.class) {
                if (f1321ms == null) {
                    f1321ms = new ka();
                }
            }
        }
        return f1321ms;
    }

    public synchronized void ms(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.xr = jSONObject.optBoolean("sensorenable", false);
                this.ah = jSONObject.optLong("interval", 180000L);
                this.d = jSONObject.optLong("expireduation", 43200000L);
                this.ka = jSONObject.optLong("showinterval", 3L);
                this.c = jSONObject.optLong("azimuth_unit", 30L);
                this.ab = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }

    public boolean xr() {
        return this.xr;
    }

    public long ah() {
        return this.d;
    }

    public long d() {
        return this.ah;
    }

    public long ka() {
        return this.ka;
    }

    public long c() {
        return this.c;
    }

    public long ab() {
        return this.ab;
    }
}
