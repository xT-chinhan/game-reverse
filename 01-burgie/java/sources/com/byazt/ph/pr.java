package com.byazt.ph;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 37})
public class pr {
    public static final Logger uc = Logger.getLogger(pr.class.getName());
    public C0163pr c;
    public final fw hn;
    public final zo hw;
    public final byte[] pr;
    public final c x;

    public pr(byte[] bArr, zo zoVar) {
        c cVar = new c(new ByteArrayInputStream(bArr));
        this.x = cVar;
        this.hn = new fw(new aj(cVar));
        this.pr = bArr;
        this.hw = zoVar;
    }

    public void pr() throws IOException {
        hn(2);
        int i = this.hn.readInt();
        k.pr(this.hn);
        w();
        for (int i2 = 0; i2 < i; i2++) {
            hw();
        }
    }

    private void hw() throws IOException {
        hw(512);
        this.hn.readInt();
        this.hn.skipBytes(256);
        this.hn.pr();
        this.hn.pr();
        this.hn.pr();
        this.hn.pr();
        if (this.c.hw == 288 && this.hn.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        k.pr(this.hn);
        k.pr(this.hn);
        w();
        boolean z = true;
        while (z) {
            switch (this.c.pr) {
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE /* 514 */:
                    x();
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT /* 515 */:
                    hn();
                    break;
                default:
                    z = false;
                    break;
            }
        }
    }

    private void hn() throws IOException {
        hw(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT);
        int i = this.hn.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.hn.readInt();
            this.hn.skipBytes(256);
        }
        while (w().pr == 513) {
            x();
        }
    }

    private void x() throws IOException {
        c();
        short s = w().pr;
        while (s == 514) {
            c();
            s = w().pr;
        }
        while (s == 513) {
            uc();
            if (this.x.pr() < this.c.c) {
                uc.warning("Unknown data detected. Skipping: " + (this.c.c - this.x.pr()) + " byte(s)");
                this.x.skip(this.c.c - this.x.pr());
            }
            s = w().pr;
        }
    }

    private void c() throws IOException {
        hw(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE);
        this.hn.readUnsignedByte();
        this.hn.skipBytes(3);
        this.hn.skipBytes(this.hn.readInt() * 4);
    }

    private void uc() throws IOException {
        hw(513);
        this.hn.readUnsignedByte();
        this.hn.readByte();
        this.hn.skipBytes(2);
        int i = this.hn.readInt();
        int i2 = this.hn.readInt();
        vk();
        int i3 = (this.c.x + i2) - (i * 4);
        if (i3 != this.x.pr()) {
            uc.warning("Invalid data detected. Skipping: " + (i3 - this.x.pr()) + " byte(s)");
            this.hn.skipBytes(i3 - this.x.pr());
        }
        int[] iArrPr = this.hn.pr(i);
        HashSet hashSet = new HashSet();
        for (int i4 : iArrPr) {
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                fw();
                hashSet.add(Integer.valueOf(i4));
            }
        }
    }

    private void fw() throws IOException {
        if (this.hn.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.hn.readShort();
        this.hn.readInt();
        if ((s & 1) == 0) {
            aj();
        } else {
            zo();
        }
    }

    private void zo() throws IOException {
        int iPr = w.pr(this.hn);
        w.pr(this.pr, this.hn.readInt(), iPr, this.hw);
        int i = this.hn.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int iPr2 = w.pr(this.hn);
            w.pr(this.pr, this.hn.readInt(), iPr2, this.hw);
            aj();
        }
    }

    private void aj() throws IOException {
        this.hn.pr((short) 8);
        this.hn.pr((byte) 0);
        byte b = this.hn.readByte();
        int iPr = w.pr(this.hn);
        int i = this.hn.readInt();
        if (b == 1) {
            w.pr(this.pr, i, iPr, this.hw);
        }
        if (b == 2) {
            w.pr(this.pr, i, iPr, this.hw);
        }
    }

    private void vk() throws IOException {
        int i = this.hn.readInt();
        int i2 = 28;
        if (i < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.hn.readShort();
        this.hn.readShort();
        this.hn.readByte();
        this.hn.readByte();
        this.hn.readByte();
        this.hn.readByte();
        this.hn.readByte();
        this.hn.readByte();
        this.hn.readUnsignedShort();
        this.hn.readByte();
        this.hn.readByte();
        this.hn.readByte();
        this.hn.skipBytes(1);
        this.hn.readShort();
        this.hn.readShort();
        this.hn.readShort();
        this.hn.skipBytes(2);
        if (i >= 32) {
            this.hn.readByte();
            this.hn.readByte();
            this.hn.readShort();
            i2 = 32;
        }
        if (i >= 36) {
            this.hn.readShort();
            this.hn.readShort();
            i2 = 36;
        }
        if (i >= 48) {
            pr(4).toCharArray();
            pr(8).toCharArray();
            i2 = 48;
        }
        if (i >= 52) {
            this.hn.readByte();
            this.hn.readByte();
            this.hn.skipBytes(2);
            i2 = 52;
        }
        if (i >= 56) {
            this.hn.skipBytes(4);
            i2 = 56;
        }
        int i3 = i - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.hn.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                uc.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                uc.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i), bigInteger));
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            this.hn.skipBytes(i4);
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
    private java.lang.String pr(int r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 16
            r0.<init>(r1)
        L7:
            int r1 = r3 + (-1)
            if (r3 == 0) goto L1a
            com.byazt.ph.fw r3 = r2.hn
            byte r3 = r3.readByte()
            short r3 = (short) r3
            if (r3 == 0) goto L1a
            char r3 = (char) r3
            r0.append(r3)
            r3 = r1
            goto L7
        L1a:
            com.byazt.ph.fw r3 = r2.hn
            r3.skipBytes(r1)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.ph.pr.pr(int):java.lang.String");
    }

    private C0163pr w() throws IOException {
        C0163pr c0163prPr = C0163pr.pr(this.hn, this.x);
        this.c = c0163prPr;
        return c0163prPr;
    }

    private void hw(int i) {
        if (this.c.pr != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.c.pr)));
        }
    }

    private void hn(int i) throws IOException {
        w();
        hw(i);
    }

    /* JADX INFO: renamed from: com.byazt.ph.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0163pr {
        public final int c;
        public final int hn;
        public final int hw;
        public final short pr;
        public final int x;

        public C0163pr(short s, int i, int i2, int i3) {
            this.pr = s;
            this.hw = i;
            this.hn = i2;
            this.x = i3;
            this.c = i3 + i2;
        }

        public static C0163pr pr(fw fwVar, c cVar) throws IOException {
            int iPr = cVar.pr();
            try {
                return new C0163pr(fwVar.readShort(), fwVar.readShort(), fwVar.readInt(), iPr);
            } catch (EOFException e) {
                return new C0163pr((short) -1, 0, 0, cVar.pr());
            }
        }
    }
}
