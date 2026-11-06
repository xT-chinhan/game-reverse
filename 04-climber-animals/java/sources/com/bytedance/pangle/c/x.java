package com.bytedance.pangle.c;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x implements Closeable {
    private xr[] ah;
    private ah[] d;
    private final Map<String, ah> ka = new HashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final FileInputStream f625ms;
    private ms xr;

    public static boolean ms(File file) {
        try {
            com.bytedance.pangle.util.ab.ms(new x(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.ab.ms((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.ab.ms((Closeable) null);
            throw th;
        }
    }

    private x(File file) throws IOException {
        this.xr = null;
        this.ah = null;
        this.d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f625ms = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.xr = new ms(channel);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.xr.ch);
        byteBufferAllocate.order(this.xr.f627ms[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.xr.c);
        this.ah = new xr[this.xr.hi];
        for (int i = 0; i < this.ah.length; i++) {
            xr(channel, byteBufferAllocate, "failed to read phdr.");
            this.ah[i] = new xr(byteBufferAllocate, this.xr.f627ms[4]);
        }
        channel.position(this.xr.ab);
        byteBufferAllocate.limit(this.xr.sl);
        this.d = new ah[this.xr.zb];
        for (int i2 = 0; i2 < this.d.length; i2++) {
            xr(channel, byteBufferAllocate, "failed to read shdr.");
            this.d[i2] = new ah(byteBufferAllocate, this.xr.f627ms[4]);
        }
        if (this.xr.u > 0) {
            ByteBuffer byteBufferMs = ms(this.d[this.xr.u]);
            for (ah ahVar : this.d) {
                byteBufferMs.position(ahVar.f626ms);
                ahVar.hi = ms(byteBufferMs);
                this.ka.put(ahVar.hi, ahVar);
            }
        }
    }

    private static String ms(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName("ASCII"));
    }

    private ByteBuffer ms(ah ahVar) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) ahVar.c);
        this.f625ms.getChannel().position(ahVar.ka);
        xr(this.f625ms.getChannel(), byteBufferAllocate, "failed to read section: " + ahVar.hi);
        return byteBufferAllocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i = fileChannel.read(byteBuffer);
        if (i != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i + " bytes were read.");
        }
        byteBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(int i, int i2, int i3, String str) throws IOException {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f625ms.close();
        this.ka.clear();
        this.ah = null;
        this.d = null;
    }

    private static class ms {
        public final long ab;
        public final short ah;
        public final long c;
        public final short ch;
        public final int d;
        public final short hi;
        public final long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final byte[] f627ms;
        public final short ny;
        public final short sl;
        public final short u;
        public final int x;
        public final short xr;
        public final short zb;

        private ms(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.f627ms = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                x.xr(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                x.xr(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                x.xr(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
                this.xr = byteBufferAllocate.getShort();
                this.ah = byteBufferAllocate.getShort();
                int i = byteBufferAllocate.getInt();
                this.d = i;
                x.xr(i, 1, 1, "bad elf version: " + i);
                byte b = bArr[4];
                if (b == 1) {
                    this.ka = byteBufferAllocate.getInt();
                    this.c = byteBufferAllocate.getInt();
                    this.ab = byteBufferAllocate.getInt();
                } else if (b == 2) {
                    this.ka = byteBufferAllocate.getLong();
                    this.c = byteBufferAllocate.getLong();
                    this.ab = byteBufferAllocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.x = byteBufferAllocate.getInt();
                this.ny = byteBufferAllocate.getShort();
                this.ch = byteBufferAllocate.getShort();
                this.hi = byteBufferAllocate.getShort();
                this.sl = byteBufferAllocate.getShort();
                this.zb = byteBufferAllocate.getShort();
                this.u = byteBufferAllocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    private static class xr {
        public final long ab;
        public final long ah;
        public final long c;
        public final long d;
        public final long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final int f628ms;
        public final long x;
        public final int xr;

        private xr(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.f628ms = byteBuffer.getInt();
                this.ah = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.ka = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.ab = byteBuffer.getInt();
                this.xr = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                return;
            }
            if (i == 2) {
                this.f628ms = byteBuffer.getInt();
                this.xr = byteBuffer.getInt();
                this.ah = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.ka = byteBuffer.getLong();
                this.c = byteBuffer.getLong();
                this.ab = byteBuffer.getLong();
                this.x = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
        }
    }

    private static class ah {
        public final int ab;
        public final long ah;
        public final long c;
        public final long ch;
        public final long d;
        public String hi;
        public final long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final int f626ms;
        public final long ny;
        public final int x;
        public final int xr;

        private ah(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.f626ms = byteBuffer.getInt();
                this.xr = byteBuffer.getInt();
                this.ah = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.ka = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.ab = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.ny = byteBuffer.getInt();
                this.ch = byteBuffer.getInt();
            } else if (i == 2) {
                this.f626ms = byteBuffer.getInt();
                this.xr = byteBuffer.getInt();
                this.ah = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.ka = byteBuffer.getLong();
                this.c = byteBuffer.getLong();
                this.ab = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.ny = byteBuffer.getLong();
                this.ch = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.hi = null;
        }
    }
}
