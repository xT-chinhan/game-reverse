package com.byazt.op;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.gct.pk;
import com.byazt.llp.cp;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface q {
    boolean a_(pk pkVar);

    JSONObject fs();

    int l();

    int n(Context context, long j);

    int n(Context context, pk pkVar, Map<String, Object> map);

    int n(Context context, cp cpVar, Map<String, Object> map);

    int n(cp cpVar, s sVar, String str, Map<String, Object> map);

    int n(com.byazt.wc.qg qgVar, boolean z);

    int n(String str);

    void n();

    void n(com.byazt.hnb.q qVar);

    void n(String str, pk pkVar, long j);

    void n(String str, boolean z);

    void n(Function<SparseArray<Object>, Object> function);

    boolean n(String str, int i);

    void q();

    int qg();

    int qg(pk pkVar);

    long s();

    void s(cp cpVar);

    boolean w();

    String x();
}
