package com.byazt.sd;

import android.util.SparseArray;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.hg.u;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface fo {

    public interface c {
        void pr(int i, String str);

        void pr(rc.x xVar);
    }

    public interface hn<T> {
        void pr(int i, String str);

        void pr(T t);
    }

    public interface hw {
        void pr(int i, String str, com.byazt.hg.hw hwVar);

        void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar);
    }

    public interface pr {
        void pr(boolean z, long j, long j2);
    }

    public interface x {
        void pr(int i, String str);

        void pr(rc.hn hnVar);
    }

    void hn(com.byazt.qe.hw hwVar, i iVar, int i, hw hwVar2);

    void hw(com.byazt.qe.hw hwVar, i iVar, int i, hw hwVar2);

    com.byazt.hfm.pr pr(int i);

    com.byazt.hg.x pr(of ofVar, String str);

    String pr(com.byazt.qe.hw hwVar);

    String pr(com.byazt.qe.hw hwVar, boolean z, int i);

    void pr(com.byazt.dw.hw hwVar, List<com.byazt.mr.uc> list);

    void pr(u uVar, String str, String str2, hn hnVar, int i, long j);

    void pr(com.byazt.qe.hw hwVar, i iVar, int i, hw hwVar2);

    void pr(String str);

    void pr(String str, String str2, pr prVar);

    void pr(Map<String, Object> map, Function<SparseArray<Object>, Object> function);

    void pr(Function<SparseArray<Object>, Object> function);

    void pr(JSONObject jSONObject, c cVar);

    void pr(JSONObject jSONObject, hn<com.byazt.hcx.m> hnVar);

    void pr(JSONObject jSONObject, x xVar);

    void pr(JSONObject jSONObject, com.byazt.xe.hw hwVar);
}
