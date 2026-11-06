package com.byazt.px;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.du.a;
import com.byazt.du.k;
import com.byazt.du.lb;
import com.byazt.du.qa;
import com.byazt.iaw.fw;
import com.byazt.jv.b;
import com.byazt.jv.fo;
import com.byazt.jv.gz;
import com.byazt.jv.nl;
import com.byazt.osx.aj;
import com.byazt.osx.w;
import com.byazt.osx.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import com.taptap.sdk.update.download.core.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 894, 37})
public final class pr implements com.byazt.osx.hn {
    public final com.byazt.du.c hn;
    public final fw hw;
    public final fo pr;
    public final com.byazt.du.x x;
    public int c = 0;
    public long uc = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    public pr(fo foVar, fw fwVar, com.byazt.du.c cVar, com.byazt.du.x xVar) {
        this.pr = foVar;
        this.hw = fwVar;
        this.hn = cVar;
        this.x = xVar;
    }

    @Override // com.byazt.osx.hn
    public lb pr(b bVar, long j) {
        if ("chunked".equalsIgnoreCase(bVar.pr(Util.TRANSFER_ENCODING))) {
            return c();
        }
        if (j != -1) {
            return pr(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.byazt.osx.hn
    public void hn() {
        com.byazt.iaw.hn hnVarHw = this.hw.hw();
        if (hnVarHw != null) {
            hnVarHw.hw();
        }
    }

    @Override // com.byazt.osx.hn
    public void pr(b bVar) throws IOException {
        pr(bVar.hn(), aj.pr(bVar, this.hw.hw().pr().hw().type()));
    }

    @Override // com.byazt.osx.hn
    public nl pr(gz gzVar) throws IOException {
        String strHw = gzVar.hw("Content-Type");
        if (!com.byazt.osx.c.hn(gzVar)) {
            return new zo(strHw, 0L, k.pr(hw(0L)));
        }
        if ("chunked".equalsIgnoreCase(gzVar.hw(Util.TRANSFER_ENCODING))) {
            return new zo(strHw, -1L, k.pr(pr(gzVar.hw().pr())));
        }
        long jPr = com.byazt.osx.c.pr(gzVar);
        if (jPr != -1) {
            return new zo(strHw, jPr, k.pr(hw(jPr)));
        }
        return new zo(strHw, -1L, k.pr(uc()));
    }

    @Override // com.byazt.osx.hn
    public void pr() throws IOException {
        this.x.flush();
    }

    @Override // com.byazt.osx.hn
    public void hw() throws IOException {
        this.x.flush();
    }

    public void pr(com.byazt.jv.lb lbVar, String str) throws IOException {
        if (this.c != 0) {
            throw new IllegalStateException("state: " + this.c);
        }
        this.x.hw(str).hw("\r\n");
        int iPr = lbVar.pr();
        for (int i = 0; i < iPr; i++) {
            this.x.hw(lbVar.pr(i)).hw(": ").hw(lbVar.hw(i)).hw("\r\n");
        }
        this.x.hw("\r\n");
        this.c = 1;
    }

    @Override // com.byazt.osx.hn
    public gz.pr pr(boolean z) throws IOException {
        int i = this.c;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.c);
        }
        try {
            w wVarPr = w.pr(fw());
            gz.pr prVarPr = new gz.pr().pr(wVarPr.pr).pr(wVarPr.hw).pr(wVarPr.hn).pr(x());
            if (z && wVarPr.hw == 100) {
                return null;
            }
            this.c = 4;
            return prVarPr;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.hw);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private String fw() throws IOException {
        String strC = this.hn.c(this.uc);
        this.uc -= (long) strC.length();
        return strC;
    }

    public com.byazt.jv.lb x() throws IOException {
        com.byazt.jv.lb.pr prVar = new com.byazt.jv.lb.pr();
        while (true) {
            String strFw = fw();
            if (strFw.length() != 0) {
                com.byazt.xx.pr.pr.pr(prVar, strFw);
            } else {
                return prVar.pr();
            }
        }
    }

    public lb c() {
        if (this.c != 1) {
            throw new IllegalStateException("state: " + this.c);
        }
        this.c = 2;
        return new hw();
    }

    public lb pr(long j) {
        if (this.c != 1) {
            throw new IllegalStateException("state: " + this.c);
        }
        this.c = 2;
        return new x(j);
    }

    public qa hw(long j) throws IOException {
        if (this.c != 4) {
            throw new IllegalStateException("state: " + this.c);
        }
        this.c = 5;
        return new c(j);
    }

    public qa pr(com.byazt.jv.qa qaVar) throws IOException {
        if (this.c != 4) {
            throw new IllegalStateException("state: " + this.c);
        }
        this.c = 5;
        return new hn(qaVar);
    }

    public qa uc() throws IOException {
        if (this.c != 4) {
            throw new IllegalStateException("state: " + this.c);
        }
        fw fwVar = this.hw;
        if (fwVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.c = 5;
        fwVar.x();
        return new uc();
    }

    public void pr(com.byazt.du.aj ajVar) {
        a aVarPr = ajVar.pr();
        ajVar.pr(a.hn);
        aVarPr.uc();
        aVarPr.c();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 894, 100})
    private final class x implements lb {
        public boolean hn;
        public final com.byazt.du.aj hw;
        public long x;

        public x(long j) {
            this.hw = new com.byazt.du.aj(pr.this.x.pr());
            this.x = j;
        }

        @Override // com.byazt.du.lb
        public a pr() {
            return this.hw;
        }

        @Override // com.byazt.du.lb
        public void a_(com.byazt.du.hn hnVar, long j) throws IOException {
            if (this.hn) {
                throw new IllegalStateException("closed");
            }
            com.byazt.xx.hn.pr(hnVar.hw(), 0L, j);
            if (j > this.x) {
                throw new ProtocolException("expected " + this.x + " bytes but received " + j);
            }
            pr.this.x.a_(hnVar, j);
            this.x -= j;
        }

        @Override // com.byazt.du.lb, java.io.Flushable
        public void flush() throws IOException {
            if (this.hn) {
                return;
            }
            pr.this.x.flush();
        }

        @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.hn) {
                return;
            }
            this.hn = true;
            if (this.x > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            pr.this.pr(this.hw);
            pr.this.c = 3;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 894, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private final class hw implements lb {
        public boolean hn;
        public final com.byazt.du.aj hw;

        public hw() {
            this.hw = new com.byazt.du.aj(pr.this.x.pr());
        }

        @Override // com.byazt.du.lb
        public a pr() {
            return this.hw;
        }

        @Override // com.byazt.du.lb
        public void a_(com.byazt.du.hn hnVar, long j) throws IOException {
            if (this.hn) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            pr.this.x.w(j);
            pr.this.x.hw("\r\n");
            pr.this.x.a_(hnVar, j);
            pr.this.x.hw("\r\n");
        }

        @Override // com.byazt.du.lb, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.hn) {
                return;
            }
            pr.this.x.flush();
        }

        @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.hn) {
                return;
            }
            this.hn = true;
            pr.this.x.hw("0\r\n\r\n");
            pr.this.pr(this.hw);
            pr.this.c = 3;
        }
    }

    /* JADX INFO: renamed from: com.byazt.px.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 894, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private abstract class AbstractC0167pr implements qa {
        public long hn;
        public boolean hw;
        public final com.byazt.du.aj pr;

        private AbstractC0167pr() {
            this.pr = new com.byazt.du.aj(pr.this.hn.pr());
            this.hn = 0L;
        }

        @Override // com.byazt.du.qa
        public a pr() {
            return this.pr;
        }

        @Override // com.byazt.du.qa
        public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
            try {
                long jPr = pr.this.hn.pr(hnVar, j);
                if (jPr > 0) {
                    this.hn += jPr;
                }
                return jPr;
            } catch (IOException e) {
                pr(false, e);
                throw e;
            }
        }

        public final void pr(boolean z, IOException iOException) throws IOException {
            if (pr.this.c == 6) {
                return;
            }
            if (pr.this.c != 5) {
                throw new IllegalStateException("state: " + pr.this.c);
            }
            pr.this.pr(this.pr);
            pr.this.c = 6;
            if (pr.this.hw != null) {
                pr.this.hw.pr(!z, pr.this, this.hn, iOException);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 894, 103})
    private class c extends AbstractC0167pr {
        public long uc;

        public c(long j) throws IOException {
            super();
            this.uc = j;
            if (j == 0) {
                pr(true, (IOException) null);
            }
        }

        @Override // com.byazt.px.pr.AbstractC0167pr, com.byazt.du.qa
        public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hw) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.uc;
            if (j2 == 0) {
                return -1L;
            }
            long jPr = super.pr(hnVar, Math.min(j2, j));
            if (jPr == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                pr(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.uc - jPr;
            this.uc = j3;
            if (j3 == 0) {
                pr(true, (IOException) null);
            }
            return jPr;
        }

        @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.hw) {
                return;
            }
            if (this.uc != 0 && !com.byazt.xx.hn.pr(this, 100, TimeUnit.MILLISECONDS)) {
                pr(false, (IOException) null);
            }
            this.hw = true;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 894, MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END})
    private class hn extends AbstractC0167pr {
        public long fw;
        public final com.byazt.jv.qa uc;
        public boolean zo;

        public hn(com.byazt.jv.qa qaVar) {
            super();
            this.fw = -1L;
            this.zo = true;
            this.uc = qaVar;
        }

        @Override // com.byazt.px.pr.AbstractC0167pr, com.byazt.du.qa
        public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hw) {
                throw new IllegalStateException("closed");
            }
            if (!this.zo) {
                return -1L;
            }
            long j2 = this.fw;
            if (j2 == 0 || j2 == -1) {
                hw();
                if (!this.zo) {
                    return -1L;
                }
            }
            long jPr = super.pr(hnVar, Math.min(j, this.fw));
            if (jPr == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                pr(false, (IOException) protocolException);
                throw protocolException;
            }
            this.fw -= jPr;
            return jPr;
        }

        private void hw() throws IOException {
            if (this.fw != -1) {
                pr.this.hn.nt();
            }
            try {
                this.fw = pr.this.hn.m();
                String strTrim = pr.this.hn.nt().trim();
                if (this.fw < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.fw + strTrim + "\"");
                }
                if (this.fw == 0) {
                    this.zo = false;
                    com.byazt.osx.c.pr(pr.this.pr.uc(), this.uc, pr.this.x());
                    pr(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.hw) {
                return;
            }
            if (this.zo && !com.byazt.xx.hn.pr(this, 100, TimeUnit.MILLISECONDS)) {
                pr(false, (IOException) null);
            }
            this.hw = true;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 894, 982})
    private class uc extends AbstractC0167pr {
        public boolean uc;

        public uc() {
            super();
        }

        @Override // com.byazt.px.pr.AbstractC0167pr, com.byazt.du.qa
        public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hw) {
                throw new IllegalStateException("closed");
            }
            if (this.uc) {
                return -1L;
            }
            long jPr = super.pr(hnVar, j);
            if (jPr == -1) {
                this.uc = true;
                pr(true, (IOException) null);
                return -1L;
            }
            return jPr;
        }

        @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.hw) {
                return;
            }
            if (!this.uc) {
                pr(false, (IOException) null);
            }
            this.hw = true;
        }
    }
}
