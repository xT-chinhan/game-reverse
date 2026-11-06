package com.byazt.wb;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 426, 5})
public final class uc extends pr {
    public static final uc hn = new uc(7500100, "执行成功");
    public static final uc x = new uc(7500101, "入参不符合预期");
    public static final uc c = new uc(7500102, "请求scheme信息(deeplink)网络报错");
    public static final uc uc = new uc(7500103, "返回scheme信息不完整");
    public static final uc fw = new uc(7500104, "scheme deeplink打开失败");
    public static final uc zo = new uc(7500105, "scheme deeplink打开被拒绝");
    public static final uc aj = new uc(7500106, "请求open sdk信息(path, userName)网络报错");
    public static final uc vk = new uc(7500107, "返回open sdk信息不完整");
    public static final uc w = new uc(7500108, "open sdk未注册或API不兼容");
    public static final uc k = new uc(7500109, "open sdk打开失败");

    private uc(int i, String str) {
        this.pr = i;
        this.hw = str;
    }
}
