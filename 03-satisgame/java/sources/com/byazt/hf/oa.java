package com.byazt.hf;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface oa {
    public static final oa n = new oa() { // from class: com.byazt.hf.oa.1
        @Override // com.byazt.hf.oa
        public boolean n(int i, List<s> list) {
            return true;
        }

        @Override // com.byazt.hf.oa
        public boolean n(int i, List<s> list, boolean z) {
            return true;
        }

        @Override // com.byazt.hf.oa
        public boolean n(int i, com.byazt.wa.l lVar, int i2, boolean z) throws IOException {
            lVar.fs(i2);
            return true;
        }
    };

    boolean n(int i, com.byazt.wa.l lVar, int i2, boolean z) throws IOException;

    boolean n(int i, List<s> list);

    boolean n(int i, List<s> list, boolean z);
}
