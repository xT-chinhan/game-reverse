package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ay extends ax {
    public static final String b = "logout";
    private static final String[] c = {"#", "#", "V", "D", "I", "W", "E", "A"};

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    String a() {
        return b;
    }

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    protected void a(int i, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory iXAdContainerFactoryC = aa.a().c();
            if (iXAdContainerFactoryC != null) {
                iXAdContainerFactoryC.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + c[i] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}
