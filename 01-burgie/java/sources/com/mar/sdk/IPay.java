package com.mar.sdk;

/* JADX INFO: loaded from: classes2.dex */
public interface IPay extends IPlugin {
    public static final int PLUGIN_TYPE = 2;

    boolean needQueryResult();

    void pay(PayParams payParams);
}
