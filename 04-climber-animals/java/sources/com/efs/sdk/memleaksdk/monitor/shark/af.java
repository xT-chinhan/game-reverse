package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class af extends ae {
    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public String d() {
        return "reason_physical_memory";
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public boolean b() {
        ah.b bVar = ah.g;
        float deviceMemoryThreshold = a().getDeviceMemoryThreshold();
        if (bVar.d < deviceMemoryThreshold) {
            g.c("UMonitor.PSS", String.format(Locale.US, "device memory threshold: %f, rate: %f", Float.valueOf(deviceMemoryThreshold), Float.valueOf(bVar.d)));
        } else if (bVar.d < 0.1f) {
            g.c("UMonitor.PSS", "mem info rate < 10%");
        } else if (bVar.d < 0.15f) {
            g.b("UMonitor.PSS", "mem info rate < 15%");
        } else if (bVar.d < 0.2f) {
            g.b("UMonitor.PSS", "mem info rate < 20%");
        } else if (bVar.d < 0.3f) {
            g.b("UMonitor.PSS", "mem info rate < 30%");
        }
        return false;
    }
}
