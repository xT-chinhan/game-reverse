package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.Util;
import com.umeng.analytics.pro.cc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 36})
public final class ny extends iu {
    public final com.byazt.du.uc aj;
    public final List<hw> k;
    public long m = -1;
    public final cz vk;
    public final cz w;
    public static final cz pr = cz.pr("multipart/mixed");
    public static final cz hw = cz.pr("multipart/alternative");
    public static final cz hn = cz.pr("multipart/digest");
    public static final cz x = cz.pr("multipart/parallel");
    public static final cz c = cz.pr("multipart/form-data");
    public static final byte[] uc = {58, 32};
    public static final byte[] fw = {cc.k, 10};
    public static final byte[] zo = {45, 45};

    public ny(com.byazt.du.uc ucVar, cz czVar, List<hw> list) {
        this.aj = ucVar;
        this.vk = czVar;
        this.w = cz.pr(czVar + "; boundary=" + ucVar.pr());
        this.k = com.byazt.xx.hn.pr(list);
    }

    @Override // com.byazt.jv.iu
    public cz pr() {
        return this.w;
    }

    @Override // com.byazt.jv.iu
    public long hw() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long jPr = pr((com.byazt.du.x) null, true);
        this.m = jPr;
        return jPr;
    }

    @Override // com.byazt.jv.iu
    public void pr(com.byazt.du.x xVar) throws IOException {
        pr(xVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long pr(com.byazt.du.x xVar, boolean z) throws IOException {
        com.byazt.du.hn hnVar;
        if (!z) {
            hnVar = 0;
        } else {
            xVar = new com.byazt.du.hn();
            hnVar = xVar;
        }
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            hw hwVar = this.k.get(i);
            lb lbVar = hwVar.pr;
            iu iuVar = hwVar.hw;
            xVar.hn(zo);
            xVar.hw(this.aj);
            xVar.hn(fw);
            if (lbVar != null) {
                int iPr = lbVar.pr();
                for (int i2 = 0; i2 < iPr; i2++) {
                    xVar.hw(lbVar.pr(i2)).hn(uc).hw(lbVar.hw(i2)).hn(fw);
                }
            }
            cz czVarPr = iuVar.pr();
            if (czVarPr != null) {
                xVar.hw("Content-Type: ").hw(czVarPr.toString()).hn(fw);
            }
            long jHw = iuVar.hw();
            if (jHw != -1) {
                xVar.hw("Content-Length: ").k(jHw).hn(fw);
            } else if (z) {
                hnVar.lb();
                return -1L;
            }
            byte[] bArr = fw;
            xVar.hn(bArr);
            if (z) {
                j += jHw;
            } else {
                iuVar.pr(xVar);
            }
            xVar.hn(bArr);
        }
        byte[] bArr2 = zo;
        xVar.hn(bArr2);
        xVar.hw(this.aj);
        xVar.hn(bArr2);
        xVar.hn(fw);
        if (z) {
            long jHw2 = j + hnVar.hw();
            hnVar.lb();
            return jHw2;
        }
        return j;
    }

    public static StringBuilder pr(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\n':
                    sb.append("%0A");
                    break;
                case '\r':
                    sb.append("%0D");
                    break;
                case '\"':
                    sb.append("%22");
                    break;
                default:
                    sb.append(cCharAt);
                    break;
            }
        }
        sb.append('\"');
        return sb;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 499})
    public static final class hw {
        public final iu hw;
        public final lb pr;

        public static hw pr(lb lbVar, iu iuVar) {
            if (iuVar == null) {
                throw new NullPointerException("body == null");
            }
            if (lbVar != null && lbVar.pr("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (lbVar != null && lbVar.pr(Util.CONTENT_LENGTH) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new hw(lbVar, iuVar);
        }

        public static hw pr(String str, String str2, iu iuVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            ny.pr(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                ny.pr(sb, str2);
            }
            return pr(lb.pr(Util.CONTENT_DISPOSITION, sb.toString()), iuVar);
        }

        private hw(lb lbVar, iu iuVar) {
            this.pr = lbVar;
            this.hw = iuVar;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 795})
    public static final class pr {
        public final List<hw> hn;
        public cz hw;
        public final com.byazt.du.uc pr;

        public pr() {
            this(UUID.randomUUID().toString());
        }

        public pr(String str) {
            this.hw = ny.pr;
            this.hn = new ArrayList();
            this.pr = com.byazt.du.uc.pr(str);
        }

        public pr pr(cz czVar) {
            if (czVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!czVar.pr().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(czVar)));
            }
            this.hw = czVar;
            return this;
        }

        public pr pr(String str, String str2, iu iuVar) {
            return pr(hw.pr(str, str2, iuVar));
        }

        public pr pr(hw hwVar) {
            if (hwVar == null) {
                throw new NullPointerException("part == null");
            }
            this.hn.add(hwVar);
            return this;
        }

        public ny pr() {
            if (this.hn.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new ny(this.pr, this.hw, this.hn);
        }
    }
}
