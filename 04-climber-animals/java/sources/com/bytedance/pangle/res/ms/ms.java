package com.bytedance.pangle.res.ms;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static final Logger c = Logger.getLogger(ms.class.getName());
    private final ab ah;
    private final ka d;
    private C0225ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final byte[] f678ms;
    private final x xr;

    public ms(byte[] bArr, x xVar) {
        ka kaVar = new ka(new ByteArrayInputStream(bArr));
        this.d = kaVar;
        this.ah = new ab(new ny(kaVar));
        this.f678ms = bArr;
        this.xr = xVar;
    }

    public void ms() throws IOException {
        ah(2);
        int i = this.ah.readInt();
        sl.ms(this.ah);
        hi();
        for (int i2 = 0; i2 < i; i2++) {
            xr();
        }
    }

    private void xr() throws IOException {
        xr(512);
        this.ah.readInt();
        this.ah.skipBytes(256);
        this.ah.ms();
        this.ah.ms();
        this.ah.ms();
        this.ah.ms();
        if (this.ka.xr == 288 && this.ah.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        sl.ms(this.ah);
        sl.ms(this.ah);
        hi();
        boolean z = true;
        while (z) {
            short s = this.ka.f679ms;
            if (s == 514) {
                d();
            } else if (s != 515) {
                z = false;
            } else {
                ah();
            }
        }
    }

    private void ah() throws IOException {
        xr(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT);
        int i = this.ah.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.ah.readInt();
            this.ah.skipBytes(256);
        }
        while (hi().f679ms == 513) {
            d();
        }
    }

    private void d() throws IOException {
        ka();
        short s = hi().f679ms;
        while (s == 514) {
            ka();
            s = hi().f679ms;
        }
        while (s == 513) {
            c();
            if (this.d.ms() < this.ka.ka) {
                c.warning("Unknown data detected. Skipping: " + (this.ka.ka - this.d.ms()) + " byte(s)");
                this.d.skip(this.ka.ka - this.d.ms());
            }
            s = hi().f679ms;
        }
    }

    private void ka() throws IOException {
        xr(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE);
        this.ah.readUnsignedByte();
        this.ah.skipBytes(3);
        this.ah.skipBytes(this.ah.readInt() * 4);
    }

    private void c() throws IOException {
        xr(513);
        this.ah.readUnsignedByte();
        this.ah.readByte();
        this.ah.skipBytes(2);
        int i = this.ah.readInt();
        int i2 = this.ah.readInt();
        ch();
        int i3 = (this.ka.d + i2) - (i * 4);
        if (i3 != this.d.ms()) {
            c.warning("Invalid data detected. Skipping: " + (i3 - this.d.ms()) + " byte(s)");
            this.ah.skipBytes(i3 - this.d.ms());
        }
        int[] iArrMs = this.ah.ms(i);
        HashSet hashSet = new HashSet();
        for (int i4 : iArrMs) {
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                ab();
                hashSet.add(Integer.valueOf(i4));
            }
        }
    }

    private void ab() throws IOException {
        if (this.ah.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.ah.readShort();
        this.ah.readInt();
        if ((s & 1) == 0) {
            ny();
        } else {
            x();
        }
    }

    private void x() throws IOException {
        int iMs = hi.ms(this.ah);
        hi.ms(this.f678ms, this.ah.readInt(), iMs, this.xr);
        int i = this.ah.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int iMs2 = hi.ms(this.ah);
            hi.ms(this.f678ms, this.ah.readInt(), iMs2, this.xr);
            ny();
        }
    }

    private void ny() throws IOException {
        this.ah.ms((short) 8);
        this.ah.ms((byte) 0);
        byte b = this.ah.readByte();
        int iMs = hi.ms(this.ah);
        int i = this.ah.readInt();
        if (b == 1) {
            hi.ms(this.f678ms, i, iMs, this.xr);
        }
        if (b == 2) {
            hi.ms(this.f678ms, i, iMs, this.xr);
        }
    }

    private void ch() throws IOException {
        int i = this.ah.readInt();
        int i2 = 28;
        if (i < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.ah.readShort();
        this.ah.readShort();
        this.ah.readByte();
        this.ah.readByte();
        this.ah.readByte();
        this.ah.readByte();
        this.ah.readByte();
        this.ah.readByte();
        this.ah.readUnsignedShort();
        this.ah.readByte();
        this.ah.readByte();
        this.ah.readByte();
        this.ah.skipBytes(1);
        this.ah.readShort();
        this.ah.readShort();
        this.ah.readShort();
        this.ah.skipBytes(2);
        if (i >= 32) {
            this.ah.readByte();
            this.ah.readByte();
            this.ah.readShort();
            i2 = 32;
        }
        if (i >= 36) {
            this.ah.readShort();
            this.ah.readShort();
            i2 = 36;
        }
        if (i >= 48) {
            ms(4).toCharArray();
            ms(8).toCharArray();
            i2 = 48;
        }
        if (i >= 52) {
            this.ah.readByte();
            this.ah.readByte();
            this.ah.skipBytes(2);
            i2 = 52;
        }
        if (i >= 56) {
            this.ah.skipBytes(4);
            i2 = 56;
        }
        int i3 = i - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.ah.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                c.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                c.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i), bigInteger));
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            this.ah.skipBytes(i4);
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
    private java.lang.String ms(int r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 16
            r0.<init>(r1)
        L7:
            int r1 = r3 + (-1)
            if (r3 == 0) goto L1a
            com.bytedance.pangle.res.ms.ab r3 = r2.ah
            byte r3 = r3.readByte()
            short r3 = (short) r3
            if (r3 == 0) goto L1a
            char r3 = (char) r3
            r0.append(r3)
            r3 = r1
            goto L7
        L1a:
            com.bytedance.pangle.res.ms.ab r3 = r2.ah
            r3.skipBytes(r1)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.ms.ms.ms(int):java.lang.String");
    }

    private C0225ms hi() throws IOException {
        C0225ms c0225msMs = C0225ms.ms(this.ah, this.d);
        this.ka = c0225msMs;
        return c0225msMs;
    }

    private void xr(int i) {
        if (this.ka.f679ms != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.ka.f679ms)));
        }
    }

    private void ah(int i) throws IOException {
        hi();
        xr(i);
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.res.ms.ms$ms, reason: collision with other inner class name */
    public static class C0225ms {
        public final int ah;
        public final int d;
        public final int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final short f679ms;
        public final int xr;

        public C0225ms(short s, int i, int i2, int i3) {
            this.f679ms = s;
            this.xr = i;
            this.ah = i2;
            this.d = i3;
            this.ka = i3 + i2;
        }

        public static C0225ms ms(ab abVar, ka kaVar) throws IOException {
            int iMs = kaVar.ms();
            try {
                return new C0225ms(abVar.readShort(), abVar.readShort(), abVar.readInt(), iMs);
            } catch (EOFException unused) {
                return new C0225ms((short) -1, 0, 0, kaVar.ms());
            }
        }
    }
}
