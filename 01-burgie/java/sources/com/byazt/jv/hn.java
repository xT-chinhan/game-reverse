package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 20})
public final class hn implements Closeable, Flushable {
    public final com.byazt.gr.x hw;
    public final com.byazt.gr.uc pr;

    public void update(gz gzVar, gz gzVar2) {
        com.byazt.gr.x.pr prVarPr;
        hw hwVar = new hw(gzVar2);
        try {
            prVarPr = ((pr) gzVar.aj()).pr.pr();
            if (prVarPr != null) {
                try {
                    hwVar.pr(prVarPr);
                    prVarPr.hw();
                } catch (IOException e) {
                    pr(prVarPr);
                }
            }
        } catch (IOException e2) {
            prVarPr = null;
        }
    }

    private void pr(com.byazt.gr.x.pr prVar) {
        if (prVar != null) {
            try {
                prVar.hn();
            } catch (IOException e) {
            }
        }
    }

    public void delete() throws IOException {
        this.hw.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.hw.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.hw.close();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 506})
    private static final class hw {
        public final lb aj;
        public final String c;
        public final int fw;
        public final String hn;
        public final long k;
        public final rc uc;
        public final yb vk;
        public final long w;
        public final lb x;
        public final String zo;
        public static final String pr = com.byazt.lp.c.hw().hn() + "-Sent-Millis";
        public static final String hw = com.byazt.lp.c.hw().hn() + "-Received-Millis";

        public hw(gz gzVar) {
            this.hn = gzVar.hw().pr().toString();
            this.x = com.byazt.osx.c.hw(gzVar);
            this.c = gzVar.hw().hw();
            this.uc = gzVar.hn();
            this.fw = gzVar.x();
            this.zo = gzVar.uc();
            this.aj = gzVar.zo();
            this.vk = gzVar.fw();
            this.w = gzVar.g();
            this.k = gzVar.ho();
        }

        public void pr(com.byazt.gr.x.pr prVar) throws IOException {
            com.byazt.du.x xVarPr = com.byazt.du.k.pr(prVar.pr(0));
            xVarPr.hw(this.hn).aj(10);
            xVarPr.hw(this.c).aj(10);
            xVarPr.k(this.x.pr()).aj(10);
            int iPr = this.x.pr();
            for (int i = 0; i < iPr; i++) {
                xVarPr.hw(this.x.pr(i)).hw(": ").hw(this.x.hw(i)).aj(10);
            }
            xVarPr.hw(new com.byazt.osx.w(this.uc, this.fw, this.zo).toString()).aj(10);
            xVarPr.k(this.aj.pr() + 2).aj(10);
            int iPr2 = this.aj.pr();
            for (int i2 = 0; i2 < iPr2; i2++) {
                xVarPr.hw(this.aj.pr(i2)).hw(": ").hw(this.aj.hw(i2)).aj(10);
            }
            xVarPr.hw(pr).hw(": ").k(this.w).aj(10);
            xVarPr.hw(hw).hw(": ").k(this.k).aj(10);
            if (pr()) {
                xVarPr.aj(10);
                xVarPr.hw(this.vk.hw().pr()).aj(10);
                pr(xVarPr, this.vk.hn());
                pr(xVarPr, this.vk.x());
                xVarPr.hw(this.vk.pr().pr()).aj(10);
            }
            xVarPr.close();
        }

        private boolean pr() {
            return this.hn.startsWith("https://");
        }

        private void pr(com.byazt.du.x xVar, List<Certificate> list) throws IOException {
            try {
                xVar.k(list.size()).aj(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    xVar.hw(com.byazt.du.uc.pr(list.get(i).getEncoded()).hw()).aj(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 116})
    private static class pr extends nl {
        public final String hn;
        public final com.byazt.du.c hw;
        public final com.byazt.gr.x.hn pr;
        public final String x;

        @Override // com.byazt.jv.nl
        public cz pr() {
            String str = this.hn;
            if (str != null) {
                return cz.pr(str);
            }
            return null;
        }

        @Override // com.byazt.jv.nl
        public long hw() {
            try {
                String str = this.x;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException e) {
                return -1L;
            }
        }

        @Override // com.byazt.jv.nl
        public com.byazt.du.c hn() {
            return this.hw;
        }
    }
}
