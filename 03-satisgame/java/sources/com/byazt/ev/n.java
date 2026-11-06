package com.byazt.ev;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 19})
public class n {
    public static final Logger w = Logger.getLogger(n.class.getName());
    public C0172n l;
    public final byte[] n;
    public final l q;
    public final fs qg;
    public final x s;

    public n(byte[] bArr, fs fsVar) {
        l lVar = new l(new ByteArrayInputStream(bArr));
        this.q = lVar;
        this.s = new x(new rv(lVar));
        this.n = bArr;
        this.qg = fsVar;
    }

    public void n() throws IOException {
        s(2);
        int i = this.s.readInt();
        d.n(this.s);
        cp();
        for (int i2 = 0; i2 < i; i2++) {
            qg();
        }
    }

    private void qg() throws IOException {
        qg(512);
        this.s.readInt();
        this.s.skipBytes(256);
        this.s.n();
        this.s.n();
        this.s.n();
        this.s.n();
        if (this.l.qg == 288 && this.s.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        d.n(this.s);
        d.n(this.s);
        cp();
        boolean z = true;
        while (z) {
            short s = this.l.n;
            if (s == 514) {
                q();
            } else if (s != 515) {
                z = false;
            } else {
                s();
            }
        }
    }

    private void s() throws IOException {
        qg(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT);
        int i = this.s.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.s.readInt();
            this.s.skipBytes(256);
        }
        while (cp().n == 513) {
            q();
        }
    }

    private void q() throws IOException {
        l();
        short s = cp().n;
        while (s == 514) {
            l();
            s = cp().n;
        }
        while (s == 513) {
            w();
            if (this.q.n() < this.l.l) {
                w.warning("Unknown data detected. Skipping: " + (this.l.l - this.q.n()) + " byte(s)");
                this.q.skip(this.l.l - this.q.n());
            }
            s = cp().n;
        }
    }

    private void l() throws IOException {
        qg(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE);
        this.s.readUnsignedByte();
        this.s.skipBytes(3);
        this.s.skipBytes(this.s.readInt() * 4);
    }

    private void w() throws IOException {
        qg(513);
        this.s.readUnsignedByte();
        this.s.readByte();
        this.s.skipBytes(2);
        int i = this.s.readInt();
        int i2 = this.s.readInt();
        tj();
        int i3 = (this.l.q + i2) - (i * 4);
        if (i3 != this.q.n()) {
            w.warning("Invalid data detected. Skipping: " + (i3 - this.q.n()) + " byte(s)");
            this.s.skipBytes(i3 - this.q.n());
        }
        int[] iArrN = this.s.n(i);
        HashSet hashSet = new HashSet();
        for (int i4 : iArrN) {
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                x();
                hashSet.add(Integer.valueOf(i4));
            }
        }
    }

    private void x() throws IOException {
        if (this.s.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.s.readShort();
        this.s.readInt();
        if ((s & 1) == 0) {
            rv();
        } else {
            fs();
        }
    }

    private void fs() throws IOException {
        int iN = cp.n(this.s);
        cp.n(this.n, this.s.readInt(), iN, this.qg);
        int i = this.s.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int iN2 = cp.n(this.s);
            cp.n(this.n, this.s.readInt(), iN2, this.qg);
            rv();
        }
    }

    private void rv() throws IOException {
        this.s.n((short) 8);
        this.s.n((byte) 0);
        byte b = this.s.readByte();
        int iN = cp.n(this.s);
        int i = this.s.readInt();
        if (b == 1) {
            cp.n(this.n, i, iN, this.qg);
        }
        if (b == 2) {
            cp.n(this.n, i, iN, this.qg);
        }
    }

    private void tj() throws IOException {
        int i = this.s.readInt();
        int i2 = 28;
        if (i < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.s.readShort();
        this.s.readShort();
        this.s.readByte();
        this.s.readByte();
        this.s.readByte();
        this.s.readByte();
        this.s.readByte();
        this.s.readByte();
        this.s.readUnsignedShort();
        this.s.readByte();
        this.s.readByte();
        this.s.readByte();
        this.s.skipBytes(1);
        this.s.readShort();
        this.s.readShort();
        this.s.readShort();
        this.s.skipBytes(2);
        if (i >= 32) {
            this.s.readByte();
            this.s.readByte();
            this.s.readShort();
            i2 = 32;
        }
        if (i >= 36) {
            this.s.readShort();
            this.s.readShort();
            i2 = 36;
        }
        if (i >= 48) {
            n(4).toCharArray();
            n(8).toCharArray();
            i2 = 48;
        }
        if (i >= 52) {
            this.s.readByte();
            this.s.readByte();
            this.s.skipBytes(2);
            i2 = 52;
        }
        if (i >= 56) {
            this.s.skipBytes(4);
            i2 = 56;
        }
        int i3 = i - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.s.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                w.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                w.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i), bigInteger));
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            this.s.skipBytes(i4);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v6 short, still in use, count: 1, list:
          (r3v6 short) from 0x0014: CAST (char) (r3v6 short)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:148)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:101)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:117)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    private java.lang.String n(int r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 16
            r0.<init>(r1)
        L7:
            int r1 = r3 + (-1)
            if (r3 == 0) goto L1a
            com.byazt.ev.x r3 = r2.s
            byte r3 = r3.readByte()
            short r3 = (short) r3
            if (r3 == 0) goto L1a
            char r3 = (char) r3
            r0.append(r3)
            r3 = r1
            goto L7
        L1a:
            com.byazt.ev.x r3 = r2.s
            r3.skipBytes(r1)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.ev.n.n(int):java.lang.String");
    }

    private C0172n cp() throws IOException {
        C0172n c0172nN = C0172n.n(this.s, this.q);
        this.l = c0172nN;
        return c0172nN;
    }

    private void qg(int i) {
        if (this.l.n != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.l.n)));
        }
    }

    private void s(int i) throws IOException {
        cp();
        qg(i);
    }

    /* JADX INFO: renamed from: com.byazt.ev.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0172n {
        public final int l;
        public final short n;
        public final int q;
        public final int qg;
        public final int s;

        public C0172n(short s, int i, int i2, int i3) {
            this.n = s;
            this.qg = i;
            this.s = i2;
            this.q = i3;
            this.l = i3 + i2;
        }

        public static C0172n n(x xVar, l lVar) throws IOException {
            int iN = lVar.n();
            try {
                return new C0172n(xVar.readShort(), xVar.readShort(), xVar.readInt(), iN);
            } catch (EOFException unused) {
                return new C0172n((short) -1, 0, 0, lVar.n());
            }
        }
    }
}
