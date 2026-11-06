package com.byazt.sw;

import com.byazt.gx.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, 96, 13})
public class w implements Closeable {
    public final Map<String, s> l = new HashMap();
    public final FileInputStream n;
    public s[] q;
    public n qg;
    public qg[] s;

    public static boolean n(File file) {
        try {
            x.n(new w(file));
            return true;
        } catch (IOException unused) {
            x.n((Closeable) null);
            return false;
        } catch (Throwable th) {
            x.n((Closeable) null);
            throw th;
        }
    }

    private w(File file) throws IOException {
        this.qg = null;
        this.s = null;
        this.q = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.n = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.qg = new n(channel);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.qg.tj);
        byteBufferAllocate.order(this.qg.n[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.qg.w);
        this.s = new qg[this.qg.cp];
        for (int i = 0; i < this.s.length; i++) {
            qg(channel, byteBufferAllocate, "failed to read phdr.");
            this.s[i] = new qg(byteBufferAllocate, this.qg.n[4]);
        }
        channel.position(this.qg.x);
        byteBufferAllocate.limit(this.qg.d);
        this.q = new s[this.qg.oa];
        for (int i2 = 0; i2 < this.q.length; i2++) {
            qg(channel, byteBufferAllocate, "failed to read shdr.");
            this.q[i2] = new s(byteBufferAllocate, this.qg.n[4]);
        }
        if (this.qg.sz > 0) {
            ByteBuffer byteBufferN = n(this.q[this.qg.sz]);
            for (s sVar : this.q) {
                byteBufferN.position(sVar.n);
                sVar.cp = n(byteBufferN);
                this.l.put(sVar.cp, sVar);
            }
        }
    }

    private static String n(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName("ASCII"));
    }

    private ByteBuffer n(s sVar) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) sVar.w);
        this.n.getChannel().position(sVar.l);
        qg(this.n.getChannel(), byteBufferAllocate, "failed to read section: " + sVar.cp);
        return byteBufferAllocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i = fileChannel.read(byteBuffer);
        if (i != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i + " bytes were read.");
        }
        byteBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(int i, int i2, int i3, String str) throws IOException {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n.close();
        this.l.clear();
        this.s = null;
        this.q = null;
    }

    @com.byazt.cp.n(n = {0, 1, 96, 108})
    private static class n {
        public final short cp;
        public final short d;
        public final int fs;
        public final long l;
        public final byte[] n;
        public final short oa;
        public final int q;
        public final short qg;
        public final short rv;
        public final short s;
        public final short sz;
        public final short tj;
        public final long w;
        public final long x;

        private n(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.n = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                w.qg(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                w.qg(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                w.qg(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
                this.qg = byteBufferAllocate.getShort();
                this.s = byteBufferAllocate.getShort();
                int i = byteBufferAllocate.getInt();
                this.q = i;
                w.qg(i, 1, 1, "bad elf version: " + i);
                byte b = bArr[4];
                if (b == 1) {
                    this.l = byteBufferAllocate.getInt();
                    this.w = byteBufferAllocate.getInt();
                    this.x = byteBufferAllocate.getInt();
                } else if (b == 2) {
                    this.l = byteBufferAllocate.getLong();
                    this.w = byteBufferAllocate.getLong();
                    this.x = byteBufferAllocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.fs = byteBufferAllocate.getInt();
                this.rv = byteBufferAllocate.getShort();
                this.tj = byteBufferAllocate.getShort();
                this.cp = byteBufferAllocate.getShort();
                this.d = byteBufferAllocate.getShort();
                this.oa = byteBufferAllocate.getShort();
                this.sz = byteBufferAllocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 96, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    private static class qg {
        public final long fs;
        public final long l;
        public final int n;
        public final long q;
        public final int qg;
        public final long s;
        public final long w;
        public final long x;

        private qg(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.n = byteBuffer.getInt();
                this.s = byteBuffer.getInt();
                this.q = byteBuffer.getInt();
                this.l = byteBuffer.getInt();
                this.w = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.qg = byteBuffer.getInt();
                this.fs = byteBuffer.getInt();
                return;
            }
            if (i == 2) {
                this.n = byteBuffer.getInt();
                this.qg = byteBuffer.getInt();
                this.s = byteBuffer.getLong();
                this.q = byteBuffer.getLong();
                this.l = byteBuffer.getLong();
                this.w = byteBuffer.getLong();
                this.x = byteBuffer.getLong();
                this.fs = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 96, MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME})
    private static class s {
        public String cp;
        public final int fs;
        public final long l;
        public final int n;
        public final long q;
        public final int qg;
        public final long rv;
        public final long s;
        public final long tj;
        public final long w;
        public final int x;

        private s(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.n = byteBuffer.getInt();
                this.qg = byteBuffer.getInt();
                this.s = byteBuffer.getInt();
                this.q = byteBuffer.getInt();
                this.l = byteBuffer.getInt();
                this.w = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.fs = byteBuffer.getInt();
                this.rv = byteBuffer.getInt();
                this.tj = byteBuffer.getInt();
            } else if (i == 2) {
                this.n = byteBuffer.getInt();
                this.qg = byteBuffer.getInt();
                this.s = byteBuffer.getLong();
                this.q = byteBuffer.getLong();
                this.l = byteBuffer.getLong();
                this.w = byteBuffer.getLong();
                this.x = byteBuffer.getInt();
                this.fs = byteBuffer.getInt();
                this.rv = byteBuffer.getLong();
                this.tj = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.cp = null;
        }
    }
}
