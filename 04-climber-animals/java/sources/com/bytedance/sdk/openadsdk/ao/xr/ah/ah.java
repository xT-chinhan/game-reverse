package com.bytedance.sdk.openadsdk.ao.xr.ah;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final ValueSet f1693ms;

    public ah(ValueSet valueSet) {
        this.f1693ms = valueSet == null ? com.bykv.ms.ms.ms.ms.xr.f12ms : valueSet;
    }

    public double ms() {
        return this.f1693ms.doubleValue(262001);
    }

    public double xr() {
        return this.f1693ms.doubleValue(262002);
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bykv.ms.ms.ms.ms.xr f1694ms = com.bykv.ms.ms.ms.ms.xr.ms();

        public ms ms(double d) {
            this.f1694ms.ms(262001, d);
            return this;
        }

        public ms xr(double d) {
            this.f1694ms.ms(262002, d);
            return this;
        }

        public ah ms() {
            return new ah(this.f1694ms.xr());
        }
    }
}
