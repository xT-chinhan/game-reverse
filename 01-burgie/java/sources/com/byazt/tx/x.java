package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 121})
public class x {
    public static com.byazt.eqw.hw pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return pr(jsonReader, ucVar, true);
    }

    public static com.byazt.eqw.hw pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, boolean z) throws IOException {
        return new com.byazt.eqw.hw(pr(jsonReader, z ? com.byazt.ptr.vk.pr() : 1.0f, ucVar, k.pr));
    }

    public static com.byazt.eqw.x hw(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return new com.byazt.eqw.x(pr(jsonReader, ucVar, lb.pr));
    }

    public static com.byazt.eqw.uc hn(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return new com.byazt.eqw.uc(cz.pr(jsonReader, ucVar, com.byazt.ptr.vk.pr(), ve.pr, true));
    }

    public static com.byazt.eqw.fw x(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return new com.byazt.eqw.fw(pr(jsonReader, ucVar, n.pr));
    }

    public static com.byazt.eqw.zo c(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return new com.byazt.eqw.zo(pr(jsonReader, com.byazt.ptr.vk.pr(), ucVar, e.pr));
    }

    public static com.byazt.eqw.vk uc(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return new com.byazt.eqw.vk(pr(jsonReader, com.byazt.ptr.vk.pr(), ucVar, aj.pr));
    }

    public static com.byazt.eqw.pr fw(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return new com.byazt.eqw.pr(pr(jsonReader, ucVar, fw.pr));
    }

    public static com.byazt.eqw.hn pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, int i) throws IOException {
        return new com.byazt.eqw.hn(pr(jsonReader, ucVar, new ho(i)));
    }

    private static <T> List<com.byazt.cz.pr<T>> pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, qn<T> qnVar) throws IOException {
        return cz.pr(jsonReader, ucVar, 1.0f, qnVar, false);
    }

    private static <T> List<com.byazt.cz.pr<T>> pr(JsonReader jsonReader, float f, com.byazt.dx.uc ucVar, qn<T> qnVar) throws IOException {
        return cz.pr(jsonReader, ucVar, f, qnVar, false);
    }
}
