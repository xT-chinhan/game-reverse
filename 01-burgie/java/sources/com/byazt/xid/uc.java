package com.byazt.xid;

import com.byazt.gs.fw;
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
@com.byazt.vzx.pr(pr = {0, 1, 582, 5})
public class uc implements Closeable {
    public final Map<String, hn> c = new HashMap();
    public hw[] hn;
    public pr hw;
    public final FileInputStream pr;
    public hn[] x;

    public static boolean pr(File file) {
        try {
            fw.pr(new uc(file));
            return true;
        } catch (IOException e) {
            fw.pr((Closeable) null);
            return false;
        } catch (Throwable th) {
            fw.pr((Closeable) null);
            throw th;
        }
    }

    private uc(File file) throws IOException {
        this.hw = null;
        this.hn = null;
        this.x = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.pr = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.hw = new pr(channel);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.hw.vk);
        byteBufferAllocate.order(this.hw.pr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.hw.uc);
        this.hn = new hw[this.hw.w];
        for (int i = 0; i < this.hn.length; i++) {
            hw(channel, byteBufferAllocate, "failed to read phdr.");
            this.hn[i] = new hw(byteBufferAllocate, this.hw.pr[4]);
        }
        channel.position(this.hw.fw);
        byteBufferAllocate.limit(this.hw.k);
        this.x = new hn[this.hw.m];
        for (int i2 = 0; i2 < this.x.length; i2++) {
            hw(channel, byteBufferAllocate, "failed to read shdr.");
            this.x[i2] = new hn(byteBufferAllocate, this.hw.pr[4]);
        }
        if (this.hw.g > 0) {
            ByteBuffer byteBufferPr = pr(this.x[this.hw.g]);
            for (hn hnVar : this.x) {
                byteBufferPr.position(hnVar.pr);
                hnVar.w = pr(byteBufferPr);
                this.c.put(hnVar.w, hnVar);
            }
        }
    }

    private static String pr(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName("ASCII"));
    }

    private ByteBuffer pr(hn hnVar) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) hnVar.uc);
        this.pr.getChannel().position(hnVar.c);
        hw(this.pr.getChannel(), byteBufferAllocate, "failed to read section: " + hnVar.w);
        return byteBufferAllocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i = fileChannel.read(byteBuffer);
        if (i != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i + " bytes were read.");
        }
        byteBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(int i, int i2, int i3, String str) throws IOException {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pr.close();
        this.c.clear();
        this.hn = null;
        this.x = null;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 582, 129})
    private static class pr {
        public final short aj;
        public final long c;
        public final long fw;
        public final short g;
        public final short hn;
        public final short hw;
        public final short k;
        public final short m;
        public final byte[] pr;
        public final long uc;
        public final short vk;
        public final short w;
        public final int x;
        public final int zo;

        private pr(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.pr = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                uc.hw(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                uc.hw(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                uc.hw(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
                this.hw = byteBufferAllocate.getShort();
                this.hn = byteBufferAllocate.getShort();
                int i = byteBufferAllocate.getInt();
                this.x = i;
                uc.hw(i, 1, 1, "bad elf version: " + i);
                switch (bArr[4]) {
                    case 1:
                        this.c = byteBufferAllocate.getInt();
                        this.uc = byteBufferAllocate.getInt();
                        this.fw = byteBufferAllocate.getInt();
                        break;
                    case 2:
                        this.c = byteBufferAllocate.getLong();
                        this.uc = byteBufferAllocate.getLong();
                        this.fw = byteBufferAllocate.getLong();
                        break;
                    default:
                        throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.zo = byteBufferAllocate.getInt();
                this.aj = byteBufferAllocate.getShort();
                this.vk = byteBufferAllocate.getShort();
                this.w = byteBufferAllocate.getShort();
                this.k = byteBufferAllocate.getShort();
                this.m = byteBufferAllocate.getShort();
                this.g = byteBufferAllocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 582, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED})
    private static class hw {
        public final long c;
        public final long fw;
        public final long hn;
        public final int hw;
        public final int pr;
        public final long uc;
        public final long x;
        public final long zo;

        private hw(ByteBuffer byteBuffer, int i) throws IOException {
            switch (i) {
                case 1:
                    this.pr = byteBuffer.getInt();
                    this.hn = byteBuffer.getInt();
                    this.x = byteBuffer.getInt();
                    this.c = byteBuffer.getInt();
                    this.uc = byteBuffer.getInt();
                    this.fw = byteBuffer.getInt();
                    this.hw = byteBuffer.getInt();
                    this.zo = byteBuffer.getInt();
                    return;
                case 2:
                    this.pr = byteBuffer.getInt();
                    this.hw = byteBuffer.getInt();
                    this.hn = byteBuffer.getLong();
                    this.x = byteBuffer.getLong();
                    this.c = byteBuffer.getLong();
                    this.uc = byteBuffer.getLong();
                    this.fw = byteBuffer.getLong();
                    this.zo = byteBuffer.getLong();
                    return;
                default:
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 582, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE})
    private static class hn {
        public final long aj;
        public final long c;
        public final int fw;
        public final long hn;
        public final int hw;
        public final int pr;
        public final long uc;
        public final long vk;
        public String w;
        public final long x;
        public final int zo;

        private hn(ByteBuffer byteBuffer, int i) throws IOException {
            switch (i) {
                case 1:
                    this.pr = byteBuffer.getInt();
                    this.hw = byteBuffer.getInt();
                    this.hn = byteBuffer.getInt();
                    this.x = byteBuffer.getInt();
                    this.c = byteBuffer.getInt();
                    this.uc = byteBuffer.getInt();
                    this.fw = byteBuffer.getInt();
                    this.zo = byteBuffer.getInt();
                    this.aj = byteBuffer.getInt();
                    this.vk = byteBuffer.getInt();
                    break;
                case 2:
                    this.pr = byteBuffer.getInt();
                    this.hw = byteBuffer.getInt();
                    this.hn = byteBuffer.getLong();
                    this.x = byteBuffer.getLong();
                    this.c = byteBuffer.getLong();
                    this.uc = byteBuffer.getLong();
                    this.fw = byteBuffer.getInt();
                    this.zo = byteBuffer.getInt();
                    this.aj = byteBuffer.getLong();
                    this.vk = byteBuffer.getLong();
                    break;
                default:
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.w = null;
        }
    }
}
