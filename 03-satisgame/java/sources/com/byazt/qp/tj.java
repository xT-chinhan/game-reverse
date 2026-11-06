package com.byazt.qp;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface tj {
    void n(int i, String str, Throwable th);

    void n(d dVar, int i, Object obj, Object obj2);

    void n(d dVar, int i, String str, Throwable th);

    void n(d dVar, Object obj, Object obj2, boolean z, JSONObject jSONObject, Throwable th);

    default void n(com.byazt.sym.qg qgVar) {
    }

    default void n(com.byazt.sym.s sVar) {
    }

    void n(String str, Object obj, int i);

    void n(String str, Object obj, int i, int i2);

    void n(String str, Object obj, Object obj2, int i, int i2);

    void n(String str, Throwable th);

    void qg(String str, Object obj, int i);

    void qg(String str, Object obj, Object obj2, int i, int i2);
}
