package com.byazt.zr;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.af.w;
import com.byazt.hg.of;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface x {
    boolean a_(of ofVar);

    int c();

    String fw();

    long hn();

    void hn(w wVar);

    int hw();

    int hw(of ofVar);

    int pr(Context context, long j);

    int pr(Context context, w wVar, Map<String, Object> map);

    int pr(Context context, of ofVar, Map<String, Object> map);

    int pr(w wVar, hn hnVar, String str, Map<String, Object> map);

    int pr(com.byazt.mh.hw hwVar, boolean z);

    int pr(String str);

    void pr();

    void pr(com.byazt.igw.x xVar);

    void pr(String str, of ofVar, long j);

    void pr(String str, boolean z);

    void pr(Function<SparseArray<Object>, Object> function);

    boolean pr(String str, int i);

    boolean uc();

    void x();

    JSONObject zo();
}
