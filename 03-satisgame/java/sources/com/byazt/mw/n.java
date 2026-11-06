package com.byazt.mw;

import android.util.SparseArray;
import com.byazt.fvm.w;
import com.byazt.gct.pk;
import com.byazt.gct.wv;
import com.byazt.gct.y;
import com.byazt.qk.oa;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface n {

    public interface l {
        void n(int i, String str);

        void n(com.byazt.mw.qg.q qVar);
    }

    /* JADX INFO: renamed from: com.byazt.mw.n$n, reason: collision with other inner class name */
    public interface InterfaceC0251n {
        void n(boolean z, long j, long j2);
    }

    public interface q {
        void n(int i, String str);

        void n(com.byazt.mw.qg.s sVar);
    }

    public interface qg {
        void n(int i, String str, com.byazt.gct.qg qgVar);

        void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar);
    }

    public interface s<T> {
        void n(int i, String str);

        void n(T t);
    }

    com.byazt.gct.q n(pk pkVar, String str);

    com.byazt.px.n n(int i);

    String n(com.byazt.zq.qg qgVar);

    String n(com.byazt.zq.qg qgVar, boolean z, int i);

    void n(wv wvVar, String str, String str2, s sVar, int i, long j);

    void n(com.byazt.oj.qg qgVar, List<w> list);

    void n(com.byazt.zq.qg qgVar, y yVar, int i, qg qgVar2);

    void n(String str);

    void n(String str, String str2, InterfaceC0251n interfaceC0251n);

    void n(Map<String, Object> map, Function<SparseArray<Object>, Object> function);

    void n(Function<SparseArray<Object>, Object> function);

    void n(JSONObject jSONObject, com.byazt.fxc.qg qgVar);

    void n(JSONObject jSONObject, l lVar);

    void n(JSONObject jSONObject, q qVar);

    void n(JSONObject jSONObject, s<oa> sVar);

    void qg(com.byazt.zq.qg qgVar, y yVar, int i, qg qgVar2);

    void s(com.byazt.zq.qg qgVar, y yVar, int i, qg qgVar2);
}
