package com.byazt.qvu;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 781, 26})
public class qg {
    public boolean n = false;
    public int qg = -1;
    public String s = null;
    public ValueSet q = null;

    private qg() {
    }

    public static final qg n() {
        return new qg();
    }

    public qg n(boolean z) {
        this.n = z;
        return this;
    }

    public qg n(int i) {
        this.qg = i;
        return this;
    }

    public qg n(String str) {
        this.s = str;
        return this;
    }

    public qg n(ValueSet valueSet) {
        this.q = valueSet;
        return this;
    }

    public Result qg() {
        boolean z = this.n;
        int i = this.qg;
        String str = this.s;
        ValueSet valueSetQg = this.q;
        if (valueSetQg == null) {
            valueSetQg = s.n().qg();
        }
        return new n(z, i, str, valueSetQg);
    }

    @com.byazt.cp.n(n = {0, 1, 781, 48})
    private static final class n implements Result {
        public final boolean n;
        public final ValueSet q;
        public final int qg;
        public final String s;

        private n(boolean z, int i, String str, ValueSet valueSet) {
            this.n = z;
            this.qg = i;
            this.s = str;
            this.q = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.n;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.qg;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.s;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.q;
        }
    }
}
