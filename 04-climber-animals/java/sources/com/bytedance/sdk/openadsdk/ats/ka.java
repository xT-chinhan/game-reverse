package com.bytedance.sdk.openadsdk.ats;

import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@ATS(single = true, value = {"system_info"})
public class ka implements com.bytedance.sdk.component.d.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static HashMap<String, ms> f1829ms = new HashMap<>();
    private com.bytedance.sdk.component.d.ah xr = new com.bytedance.sdk.openadsdk.ats.ms.ah();

    private Pair<ms, Boolean> ka(String str) {
        ms msVar = f1829ms.get(str);
        if (msVar == null) {
            ms msVar2 = new ms();
            f1829ms.put(str, msVar2);
            return new Pair<>(msVar2, Boolean.TRUE);
        }
        return new Pair<>(msVar, Boolean.FALSE);
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(1)
    public String ms(String str) {
        Pair<ms, Boolean> pairKa = ka(str);
        if (((Boolean) pairKa.second).booleanValue()) {
            ((ms) pairKa.first).f1830ms = this.xr.ms(str);
        }
        return ((ms) pairKa.first).f1830ms;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(2)
    public int xr(String str) {
        Pair<ms, Boolean> pairKa = ka(str);
        if (((Boolean) pairKa.second).booleanValue()) {
            ((ms) pairKa.first).xr = this.xr.xr(str);
        }
        return ((ms) pairKa.first).xr;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(3)
    public long ah(String str) {
        Pair<ms, Boolean> pairKa = ka(str);
        if (((Boolean) pairKa.second).booleanValue()) {
            ((ms) pairKa.first).ah = this.xr.ah(str);
        }
        return ((ms) pairKa.first).ah;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(4)
    public boolean d(String str) {
        Pair<ms, Boolean> pairKa = ka(str);
        if (((Boolean) pairKa.second).booleanValue()) {
            ((ms) pairKa.first).d = this.xr.d(str);
        }
        return ((ms) pairKa.first).d;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(5)
    public void ms(String str, String str2) {
        this.xr.ms(str, str2);
    }

    private static final class ms {
        long ah;
        boolean d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f1830ms;
        int xr;

        private ms() {
        }
    }
}
