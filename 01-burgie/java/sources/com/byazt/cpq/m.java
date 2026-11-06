package com.byazt.cpq;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface m {
    public static final m pr = new m() { // from class: com.byazt.cpq.m.1
        @Override // com.byazt.cpq.m
        public boolean pr(int i, List<hn> list) {
            return true;
        }

        @Override // com.byazt.cpq.m
        public boolean pr(int i, List<hn> list, boolean z) {
            return true;
        }

        @Override // com.byazt.cpq.m
        public boolean pr(int i, com.byazt.du.c cVar, int i2, boolean z) throws IOException {
            cVar.zo(i2);
            return true;
        }
    };

    boolean pr(int i, com.byazt.du.c cVar, int i2, boolean z) throws IOException;

    boolean pr(int i, List<hn> list);

    boolean pr(int i, List<hn> list, boolean z);
}
