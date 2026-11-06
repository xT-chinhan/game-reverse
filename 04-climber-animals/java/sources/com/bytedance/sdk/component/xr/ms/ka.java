package com.bytedance.sdk.component.xr.ms;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ka extends ub {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    List<String> f1598ms;
    List<String> xr;

    ka(List<String> list, List<String> list2) {
        this.f1598ms = list;
        this.xr = list2;
    }

    public static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final List<String> f1599ms = new ArrayList();
        private final List<String> xr = new ArrayList();

        public ms ms(String str, String str2) {
            this.f1599ms.add(str);
            this.xr.add(str2);
            return this;
        }

        public ka ms() {
            return new ka(this.f1599ms, this.xr);
        }
    }
}
