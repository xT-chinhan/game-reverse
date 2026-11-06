package com.byazt.qe;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1180, 20})
public class hn {
    public PluginValueSet pr;

    public hn(SparseArray<Object> sparseArray) {
        this.pr = com.byazt.ij.pr.pr(sparseArray).hw();
    }

    public double pr() {
        return this.pr.doubleValue(262001);
    }

    public double hw() {
        return this.pr.doubleValue(262002);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1180, 116})
    public static class pr {
        public final com.byazt.xi.hw pr = com.byazt.xi.hw.pr();

        public pr pr(double d) {
            this.pr.pr(262001, Double.valueOf(d));
            return this;
        }

        public pr hw(double d) {
            this.pr.pr(262002, Double.valueOf(d));
            return this;
        }

        public hn pr() {
            return new hn(this.pr.hw());
        }
    }
}
