package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x extends ms {
    private Map<Integer, Boolean> hi;

    public x(Context context) {
        super(context);
        this.hi = new HashMap();
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ah.ms
    public boolean ms(Object... objArr) {
        int i = this.ka != null ? Integer.parseInt(this.ka.get("interval")) : -1;
        if (((Integer) objArr[0]).intValue() < i) {
            return true;
        }
        Boolean bool = this.hi.get(Integer.valueOf(i));
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        this.hi.put(Integer.valueOf(i), Boolean.TRUE);
        this.f360ms.ms(this.xr, this.c, this.ah.xr());
        return true;
    }
}
