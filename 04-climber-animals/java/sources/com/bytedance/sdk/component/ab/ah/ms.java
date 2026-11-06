package com.bytedance.sdk.component.ab.ah;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.ab.ms, com.bytedance.sdk.component.ab.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.sdk.component.d.ms.ms f744ms;
    private final boolean xr = false;

    public ms(com.bytedance.sdk.component.d.ms.ms msVar) {
        this.f744ms = msVar;
    }

    @Override // com.bytedance.sdk.component.ab.ms
    public Map<String, Object> ms(File file) {
        if (file.getName().endsWith(".prop")) {
            return new xr(this.f744ms, this.xr).ms(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            return new xr(this.f744ms, this.xr).ms(file2);
        }
        if (file.getName().endsWith("xml")) {
            if (ka.ms()) {
                return new ka(this.f744ms, this.xr).ms(file);
            }
            return new c(this.f744ms, this.xr).ms(file);
        }
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.sdk.component.ab.xr
    public void ms(Map<String, Object> map, File file) throws Throwable {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new xr(this.f744ms, this.xr).ms(map, file);
    }
}
