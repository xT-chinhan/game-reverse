package com.byazt.nv;

import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes2.dex */
public interface pr {
    void hn(long j, long j2, String str, String str2);

    void hw(long j, long j2, String str, String str2);

    void pr();

    void pr(long j, long j2, String str, String str2);

    void pr(long j, String str, String str2);

    void pr(String str, String str2);

    /* JADX INFO: renamed from: com.byazt.nv.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 734, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static final class C0146pr {
        public static pr pr(final com.byazt.rkl.hn hnVar) {
            return new pr() { // from class: com.byazt.nv.pr.pr.1
                @Override // com.byazt.nv.pr
                public void pr() {
                    com.byazt.rkl.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr();
                    }
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, long j2, String str, String str2) {
                    com.byazt.rkl.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.nv.pr
                public void hw(long j, long j2, String str, String str2) {
                    com.byazt.rkl.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.hw(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.nv.pr
                public void hn(long j, long j2, String str, String str2) {
                    com.byazt.rkl.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.hn(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, String str, String str2) {
                    com.byazt.rkl.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr(j, str, str2);
                    }
                }

                @Override // com.byazt.nv.pr
                public void pr(String str, String str2) {
                    com.byazt.rkl.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr(str, str2);
                    }
                }
            };
        }
    }
}
