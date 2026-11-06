package com.bytedance.sdk.openadsdk.mediation.bridge;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class MediationResultBuilder {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3969ms = false;
    private int xr = -1;
    private String ah = null;
    private ValueSet d = null;

    private MediationResultBuilder() {
    }

    public static final MediationResultBuilder create() {
        return new MediationResultBuilder();
    }

    public MediationResultBuilder setSuccess(boolean z) {
        this.f3969ms = z;
        return this;
    }

    public MediationResultBuilder setCode(int i) {
        this.xr = i;
        return this;
    }

    public MediationResultBuilder setMessage(String str) {
        this.ah = str;
        return this;
    }

    public MediationResultBuilder setValues(ValueSet valueSet) {
        this.d = valueSet;
        return this;
    }

    public Result build() {
        boolean z = this.f3969ms;
        int i = this.xr;
        String str = this.ah;
        ValueSet valueSetBuild = this.d;
        if (valueSetBuild == null) {
            valueSetBuild = MediationValueSetBuilder.create().build();
        }
        return new ResultImpl(z, i, str, valueSetBuild);
    }

    private static final class ResultImpl implements Result {
        private final String ah;
        private final ValueSet d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final boolean f3970ms;
        private final int xr;

        private ResultImpl(boolean z, int i, String str, ValueSet valueSet) {
            this.f3970ms = z;
            this.xr = i;
            this.ah = str;
            this.d = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f3970ms;
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
