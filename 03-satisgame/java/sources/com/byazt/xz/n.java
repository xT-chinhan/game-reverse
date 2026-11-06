package com.byazt.xz;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 774, 19})
public class n implements rv {
    @Override // com.byazt.xz.rv
    public List<fs> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fs("slide") { // from class: com.byazt.xz.n.1
            @Override // com.byazt.xz.fs
            public com.byazt.et.qg n(Context context) {
                return new com.byazt.et.l(context);
            }
        });
        arrayList.add(new fs("tap") { // from class: com.byazt.xz.n.2
            @Override // com.byazt.xz.fs
            public com.byazt.et.qg n(Context context) {
                return new com.byazt.et.w(context);
            }
        });
        arrayList.add(new fs("timer") { // from class: com.byazt.xz.n.3
            @Override // com.byazt.xz.fs
            public com.byazt.et.qg n(Context context) {
                return new com.byazt.et.x(context);
            }
        });
        arrayList.add(new fs("touchStart") { // from class: com.byazt.xz.n.4
            @Override // com.byazt.xz.fs
            public com.byazt.et.qg n(Context context) {
                return new com.byazt.et.cp(context);
            }
        });
        arrayList.add(new fs("touchEnd") { // from class: com.byazt.xz.n.5
            @Override // com.byazt.xz.fs
            public com.byazt.et.qg n(Context context) {
                return new com.byazt.et.tj(context);
            }
        });
        arrayList.add(new fs("animateState") { // from class: com.byazt.xz.n.6
            @Override // com.byazt.xz.fs
            public com.byazt.et.qg n(Context context) {
                return new com.byazt.et.n(context);
            }
        });
        arrayList.add(new fs("timerState") { // from class: com.byazt.xz.n.7
            @Override // com.byazt.xz.fs
            public com.byazt.et.qg n(Context context) {
                return new com.byazt.et.rv(context);
            }
        });
        return arrayList;
    }
}
