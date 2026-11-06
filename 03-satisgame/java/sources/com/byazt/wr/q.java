package com.byazt.wr;

import com.google.android.gms.common.util.GmsVersion;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2283, 5})
public final class q extends n {
    public static final q s = new q(GmsVersion.VERSION_QUESO, "执行成功");
    public static final q q = new q(7500001, "入参不符合预期");
    public static final q l = new q(7500008, "直播插件没有初始化成功");
    public static final q w = new q(7500009, "直播插件通信bridge未设置");
    public static final q x = new q(7500011, "直播插件通信bridge未设置");

    private q(int i, String str) {
        this.n = i;
        this.qg = str;
    }
}
