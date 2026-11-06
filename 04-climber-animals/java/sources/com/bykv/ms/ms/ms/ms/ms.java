package com.bykv.ms.ms.ms.ms;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f10ms = false;
    private int xr = -1;
    private String ah = null;
    private ValueSet d = null;

    private ms() {
    }

    public static final ms ms() {
        return new ms();
    }

    public ms ms(boolean z) {
        this.f10ms = z;
        return this;
    }

    public ms ms(int i) {
        this.xr = i;
        return this;
    }

    public ms ms(String str) {
        this.ah = str;
        return this;
    }

    public ms ms(ValueSet valueSet) {
        this.d = valueSet;
        return this;
    }

    public Result xr() {
        boolean z = this.f10ms;
        int i = this.xr;
        String str = this.ah;
        ValueSet valueSetXr = this.d;
        if (valueSetXr == null) {
            valueSetXr = xr.ms().xr();
        }
        return new C0172ms(z, i, str, valueSetXr);
    }

    /* JADX INFO: renamed from: com.bykv.ms.ms.ms.ms.ms$ms, reason: collision with other inner class name */
    private static final class C0172ms implements Result {
        private final String ah;
        private final ValueSet d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final boolean f11ms;
        private final int xr;

        private C0172ms(boolean z, int i, String str, ValueSet valueSet) {
            this.f11ms = z;
            this.xr = i;
            this.ah = str;
            this.d = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f11ms;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.xr;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.ah;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.d;
        }
    }
}
