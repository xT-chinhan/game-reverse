package com.byazt.xz;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 774, 13})
public class w implements s {
    @Override // com.byazt.xz.s
    public List<qg> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new qg("update") { // from class: com.byazt.xz.w.1
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.rv(sVar, str, nVar);
            }
        });
        arrayList.add(new qg("updateState") { // from class: com.byazt.xz.w.2
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.tj(sVar, str, nVar);
            }
        });
        arrayList.add(new qg("emit") { // from class: com.byazt.xz.w.3
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.qg(sVar, str, nVar);
            }
        });
        arrayList.add(new qg("startAnimate") { // from class: com.byazt.xz.w.4
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.w(sVar, str, nVar);
            }
        });
        arrayList.add(new qg("startTimer") { // from class: com.byazt.xz.w.5
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.x(sVar, str, nVar);
            }
        });
        arrayList.add(new qg("stopTimer") { // from class: com.byazt.xz.w.6
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.fs(sVar, str, nVar);
            }
        });
        arrayList.add(new qg("pauseTimer") { // from class: com.byazt.xz.w.7
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.s(sVar, str, nVar);
            }
        });
        arrayList.add(new qg("resumeTimer") { // from class: com.byazt.xz.w.8
            @Override // com.byazt.xz.qg
            public com.byazt.ss.n n(com.byazt.ih.s sVar, String str, x.n nVar) {
                return new com.byazt.ss.q(sVar, str, nVar);
            }
        });
        return arrayList;
    }
}
