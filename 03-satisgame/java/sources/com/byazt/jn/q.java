package com.byazt.jn;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1490, 5})
public class q implements Result {
    public String n;

    @Override // com.bykv.vk.openvk.api.proto.Result
    public int code() {
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public boolean isSuccess() {
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public ValueSet values() {
        return null;
    }

    public q(String str) {
        this.n = str;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public String message() {
        return this.n;
    }
}
