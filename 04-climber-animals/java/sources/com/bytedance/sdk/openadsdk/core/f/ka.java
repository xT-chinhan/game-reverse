package com.bytedance.sdk.openadsdk.core.f;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.sdk.openadsdk.ao.xr.ah.d {
    public ka(ValueSet valueSet) {
        super(valueSet);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public com.bytedance.sdk.openadsdk.ao.xr.ah.ah x() {
        Object objObjectValue = this.xr.objectValue(262102, Object.class);
        if (objObjectValue instanceof ValueSet) {
            return new com.bytedance.sdk.openadsdk.ao.xr.ah.ah((ValueSet) objObjectValue);
        }
        if (objObjectValue instanceof SparseArray) {
            return new com.bytedance.sdk.openadsdk.ao.xr.ah.ah(com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) objObjectValue).xr());
        }
        return null;
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bykv.ms.ms.ms.ms.xr f2498ms = com.bykv.ms.ms.ms.ms.xr.ms();

        public ms ms(boolean z) {
            this.f2498ms.ms(262101, z);
            return this;
        }

        public ms ms(com.bytedance.sdk.openadsdk.ao.xr.ah.ah ahVar) {
            this.f2498ms.ms(262102, ahVar);
            return this;
        }

        public ms xr(boolean z) {
            this.f2498ms.ms(262103, z);
            return this;
        }

        public ms ah(boolean z) {
            this.f2498ms.ms(262104, z);
            return this;
        }

        public ms ms(String str) {
            this.f2498ms.ms(262105, str);
            return this;
        }

        public ms d(boolean z) {
            this.f2498ms.ms(262106, z);
            return this;
        }

        public ms xr(String str) {
            this.f2498ms.ms(262107, str);
            return this;
        }

        public ms ka(boolean z) {
            this.f2498ms.ms(262108, z);
            return this;
        }

        public ms ah(String str) {
            this.f2498ms.ms(262109, str);
            return this;
        }

        public ms c(boolean z) {
            this.f2498ms.ms(262110, z);
            return this;
        }

        public ms d(String str) {
            this.f2498ms.ms(262112, str);
            return this;
        }

        public ms ab(boolean z) {
            this.f2498ms.ms(262111, z);
            return this;
        }

        public ka ms() {
            return new ka(this.f2498ms.xr());
        }
    }
}
