package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes3.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;

    @Nullable
    Segment head;
    long size;

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.1
            @Override // java.io.OutputStream
            public void write(int b) {
                Buffer.this.writeByte((int) ((byte) b));
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int offset, int byteCount) {
                Buffer.this.write(data, offset, byteCount);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSource
    public void require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size > 0) {
                    return Buffer.this.readByte() & UByte.MAX_VALUE;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int offset, int byteCount) {
                return Buffer.this.read(sink, offset, byteCount);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public final Buffer copyTo(OutputStream out) throws IOException {
        return copyTo(out, 0L, this.size);
    }

    public final Buffer copyTo(OutputStream out, long offset, long byteCount) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, offset, byteCount);
        if (byteCount == 0) {
            return this;
        }
        Segment s = this.head;
        while (offset >= s.limit - s.pos) {
            offset -= (long) (s.limit - s.pos);
            s = s.next;
        }
        while (byteCount > 0) {
            int pos = (int) (((long) s.pos) + offset);
            int toCopy = (int) Math.min(s.limit - pos, byteCount);
            out.write(s.data, pos, toCopy);
            byteCount -= (long) toCopy;
            offset = 0;
            s = s.next;
        }
        return this;
    }

    public final Buffer copyTo(Buffer out, long offset, long byteCount) {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, offset, byteCount);
        if (byteCount == 0) {
            return this;
        }
        out.size += byteCount;
        Segment s = this.head;
        while (offset >= s.limit - s.pos) {
            offset -= (long) (s.limit - s.pos);
            s = s.next;
        }
        while (byteCount > 0) {
            Segment copy = s.sharedCopy();
            copy.pos = (int) (((long) copy.pos) + offset);
            copy.limit = Math.min(copy.pos + ((int) byteCount), copy.limit);
            Segment segment = out.head;
            if (segment == null) {
                copy.prev = copy;
                copy.next = copy;
                out.head = copy;
            } else {
                segment.prev.push(copy);
            }
            byteCount -= (long) (copy.limit - copy.pos);
            offset = 0;
            s = s.next;
        }
        return this;
    }

    public final Buffer writeTo(OutputStream out) throws IOException {
        return writeTo(out, this.size);
    }

    public final Buffer writeTo(OutputStream out, long byteCount) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0L, byteCount);
        Segment s = this.head;
        while (byteCount > 0) {
            int toCopy = (int) Math.min(byteCount, s.limit - s.pos);
            out.write(s.data, s.pos, toCopy);
            s.pos += toCopy;
            this.size -= (long) toCopy;
            byteCount -= (long) toCopy;
            if (s.pos == s.limit) {
                Segment toRecycle = s;
                Segment segmentPop = toRecycle.pop();
                s = segmentPop;
                this.head = segmentPop;
                SegmentPool.recycle(toRecycle);
            }
        }
        return this;
    }

    public final Buffer readFrom(InputStream in) throws IOException {
        readFrom(in, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream in, long byteCount) throws IOException {
        if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        }
        readFrom(in, byteCount, false);
        return this;
    }

    private void readFrom(InputStream in, long byteCount, boolean forever) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (byteCount > 0 || forever) {
                Segment tail = writableSegment(1);
                int maxToCopy = (int) Math.min(byteCount, 8192 - tail.limit);
                int bytesRead = in.read(tail.data, tail.limit, maxToCopy);
                if (bytesRead == -1) {
                    if (!forever) {
                        throw new EOFException();
                    }
                    return;
                } else {
                    tail.limit += bytesRead;
                    this.size += (long) bytesRead;
                    byteCount -= (long) bytesRead;
                }
            } else {
                return;
            }
        }
    }

    public final long completeSegmentByteCount() {
        long result = this.size;
        if (result == 0) {
            return 0L;
        }
        Segment tail = this.head.prev;
        if (tail.limit < 8192 && tail.owner) {
            return result - ((long) (tail.limit - tail.pos));
        }
        return result;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        byte[] data = segment.data;
        int pos2 = pos + 1;
        byte b = data[pos];
        this.size--;
        if (pos2 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos2;
        }
        return b;
    }

    public final byte getByte(long pos) {
        Util.checkOffsetAndCount(this.size, pos, 1L);
        long j = this.size;
        if (j - pos > pos) {
            Segment s = this.head;
            while (true) {
                int segmentByteCount = s.limit - s.pos;
                if (pos < segmentByteCount) {
                    return s.data[s.pos + ((int) pos)];
                }
                pos -= (long) segmentByteCount;
                s = s.next;
            }
        } else {
            long pos2 = pos - j;
            Segment s2 = this.head.prev;
            while (true) {
                pos2 += (long) (s2.limit - s2.pos);
                if (pos2 >= 0) {
                    return s2.data[s2.pos + ((int) pos2)];
                }
                s2 = s2.prev;
            }
        }
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (this.size < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 2) {
            int s = ((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE);
            return (short) s;
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int s2 = ((data[pos] & 255) << 8) | (data[pos2] & 255);
        this.size -= 2;
        if (pos3 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos3;
        }
        return (short) s2;
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (this.size < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 4) {
            return ((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16) | ((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        int pos3 = pos2 + 1;
        int i = ((data[pos] & 255) << 24) | ((data[pos2] & 255) << 16);
        int pos4 = pos3 + 1;
        int i2 = i | ((data[pos3] & 255) << 8);
        int pos5 = pos4 + 1;
        int i3 = i2 | (data[pos4] & 255);
        this.size -= 4;
        if (pos5 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos5;
        }
        return i3;
    }

    @Override // okio.BufferedSource
    public long readLong() {
        if (this.size < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int pos = segment.pos;
        int limit = segment.limit;
        if (limit - pos < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (((long) readInt()) & 4294967295L);
        }
        byte[] data = segment.data;
        int pos2 = pos + 1;
        long j = (((long) data[pos]) & 255) << 56;
        int pos3 = pos2 + 1;
        int pos4 = pos3 + 1;
        long j2 = j | ((((long) data[pos2]) & 255) << 48) | ((((long) data[pos3]) & 255) << 40);
        int pos5 = pos4 + 1;
        int pos6 = pos5 + 1;
        long j3 = j2 | ((((long) data[pos4]) & 255) << 32) | ((((long) data[pos5]) & 255) << 24);
        int pos7 = pos6 + 1;
        long j4 = j3 | ((((long) data[pos6]) & 255) << 16);
        int pos8 = pos7 + 1;
        long j5 = j4 | ((((long) data[pos7]) & 255) << 8);
        int pos9 = pos8 + 1;
        long v = j5 | (((long) data[pos8]) & 255);
        this.size -= 8;
        if (pos9 == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = pos9;
        }
        return v;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        byte b;
        boolean done;
        boolean done2;
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        long value = 0;
        int seen = 0;
        boolean negative = false;
        boolean done3 = false;
        long overflowZone = -922337203685477580L;
        long overflowDigit = -7;
        loop0: while (true) {
            Segment segment = this.head;
            byte[] data = segment.data;
            int pos = segment.pos;
            int limit = segment.limit;
            while (true) {
                if (pos >= limit) {
                    overflowZone = overflowZone;
                    break;
                }
                b = data[pos];
                if (b < 48 || b > 57) {
                    done = done3;
                    overflowZone = overflowZone;
                    if (b == 45 && seen == 0) {
                        negative = true;
                        overflowDigit--;
                    } else {
                        if (seen == 0) {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b));
                        }
                        done3 = true;
                        break;
                    }
                } else {
                    int digit = 48 - b;
                    if (value < overflowZone) {
                        done2 = done3;
                        break loop0;
                    }
                    if (value == overflowZone) {
                        done2 = done3;
                        if (digit < overflowDigit) {
                            break loop0;
                        }
                    } else {
                        done2 = done3;
                    }
                    value = (value * 10) + ((long) digit);
                    done = done2;
                }
                pos++;
                seen++;
                overflowZone = overflowZone;
                done3 = done;
                data = data;
            }
            if (pos == limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = pos;
            }
            if (done3 || this.head == null) {
                this.size -= (long) seen;
                return negative ? value : -value;
            }
            overflowZone = overflowZone;
        }
        Buffer buffer = new Buffer().writeDecimalLong(value).writeByte((int) b);
        if (!negative) {
            buffer.readByte();
        }
        throw new NumberFormatException("Number too large: " + buffer.readUtf8());
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        int digit;
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        long value = 0;
        int seen = 0;
        boolean done = false;
        do {
            Segment segment = this.head;
            byte[] data = segment.data;
            int pos = segment.pos;
            int limit = segment.limit;
            while (pos < limit) {
                byte b = data[pos];
                if (b >= 48 && b <= 57) {
                    digit = b - 48;
                } else if (b >= 97 && b <= 102) {
                    digit = (b - 97) + 10;
                } else if (b >= 65 && b <= 70) {
                    digit = (b - 65) + 10;
                } else {
                    if (seen == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                    done = true;
                    break;
                }
                if (((-1152921504606846976L) & value) != 0) {
                    Buffer buffer = new Buffer().writeHexadecimalUnsignedLong(value).writeByte((int) b);
                    throw new NumberFormatException("Number too large: " + buffer.readUtf8());
                }
                value = (value << 4) | ((long) digit);
                pos++;
                seen++;
            }
            if (pos == limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = pos;
            }
            if (done) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) seen;
        return value;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long byteCount) throws EOFException {
        return new ByteString(readByteArray(byteCount));
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        int index = selectPrefix(options, false);
        if (index == -1) {
            return -1;
        }
        int selectedSize = options.byteStrings[index].size();
        try {
            skip(selectedSize);
            return index;
        } catch (EOFException e) {
            throw new AssertionError();
        }
    }

    int selectPrefix(Options options, boolean selectTruncated) {
        int i;
        int triePos;
        Segment head = this.head;
        int triePos2 = -2;
        if (head == null) {
            if (!selectTruncated) {
                return options.indexOf(ByteString.EMPTY);
            }
            return -2;
        }
        Segment s = head;
        byte[] data = head.data;
        int pos = head.pos;
        int limit = head.limit;
        int[] trie = options.trie;
        int scanOrSelect = 0;
        int prefixIndex = -1;
        loop0: while (true) {
            int triePos3 = scanOrSelect + 1;
            int scanOrSelect2 = trie[scanOrSelect];
            int triePos4 = triePos3 + 1;
            int possiblePrefixIndex = trie[triePos3];
            if (possiblePrefixIndex != -1) {
                prefixIndex = possiblePrefixIndex;
            }
            if (s == null) {
                break;
            }
            if (scanOrSelect2 < 0) {
                int scanByteCount = scanOrSelect2 * (-1);
                int trieLimit = triePos4 + scanByteCount;
                while (true) {
                    int pos2 = pos + 1;
                    int b = data[pos] & 255;
                    int triePos5 = triePos4 + 1;
                    if (b != trie[triePos4]) {
                        return prefixIndex;
                    }
                    boolean scanComplete = triePos5 == trieLimit;
                    if (pos2 != limit) {
                        i = -2;
                    } else {
                        s = s.next;
                        pos2 = s.pos;
                        data = s.data;
                        limit = s.limit;
                        if (s != head) {
                            i = -2;
                        } else {
                            if (!scanComplete) {
                                break loop0;
                            }
                            i = -2;
                            s = null;
                        }
                    }
                    if (!scanComplete) {
                        triePos4 = triePos5;
                        pos = pos2;
                    } else {
                        pos = pos2;
                        triePos = trie[triePos5];
                        break;
                    }
                }
            } else {
                i = triePos2;
                int pos3 = pos + 1;
                int b2 = data[pos] & 255;
                int selectLimit = triePos4 + scanOrSelect2;
                while (triePos4 != selectLimit) {
                    if (b2 == trie[triePos4]) {
                        int nextStep = trie[triePos4 + scanOrSelect2];
                        if (pos3 == limit) {
                            s = s.next;
                            int pos4 = s.pos;
                            data = s.data;
                            limit = s.limit;
                            if (s == head) {
                                s = null;
                                pos = pos4;
                                triePos = nextStep;
                            } else {
                                pos = pos4;
                                triePos = nextStep;
                            }
                        } else {
                            pos = pos3;
                            triePos = nextStep;
                        }
                    } else {
                        triePos4++;
                    }
                }
                return prefixIndex;
            }
            if (triePos >= 0) {
                return triePos;
            }
            scanOrSelect = -triePos;
            triePos2 = i;
        }
        if (selectTruncated) {
            return -2;
        }
        return prefixIndex;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer sink, long byteCount) throws EOFException {
        long j = this.size;
        if (j < byteCount) {
            sink.write(this, j);
            throw new EOFException();
        }
        sink.write(this, byteCount);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long byteCount = this.size;
        if (byteCount > 0) {
            sink.write(this, byteCount);
        }
        return byteCount;
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, Util.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public String readString(long byteCount, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, byteCount);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (byteCount > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + byteCount);
        }
        if (byteCount == 0) {
            return "";
        }
        Segment s = this.head;
        if (((long) s.pos) + byteCount > s.limit) {
            return new String(readByteArray(byteCount), charset);
        }
        String result = new String(s.data, s.pos, (int) byteCount, charset);
        s.pos = (int) (((long) s.pos) + byteCount);
        this.size -= byteCount;
        if (s.pos == s.limit) {
            this.head = s.pop();
            SegmentPool.recycle(s);
        }
        return result;
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long newline = indexOf((byte) 10);
        if (newline == -1) {
            long j = this.size;
            if (j != 0) {
                return readUtf8(j);
            }
            return null;
        }
        return readUtf8Line(newline);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException("limit < 0: " + limit);
        }
        long scanLength = LongCompanionObject.MAX_VALUE;
        if (limit != LongCompanionObject.MAX_VALUE) {
            scanLength = limit + 1;
        }
        long newline = indexOf((byte) 10, 0L, scanLength);
        if (newline != -1) {
            return readUtf8Line(newline);
        }
        if (scanLength < size() && getByte(scanLength - 1) == 13 && getByte(scanLength) == 10) {
            return readUtf8Line(scanLength);
        }
        Buffer data = new Buffer();
        copyTo(data, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), limit) + " content=" + data.readByteString().hex() + Typography.ellipsis);
    }

    String readUtf8Line(long newline) throws EOFException {
        if (newline > 0 && getByte(newline - 1) == 13) {
            String result = readUtf8(newline - 1);
            skip(2L);
            return result;
        }
        String result2 = readUtf8(newline);
        skip(1L);
        return result2;
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int codePoint;
        int byteCount;
        int min;
        if (this.size == 0) {
            throw new EOFException();
        }
        int b0 = getByte(0L);
        if ((b0 & 128) == 0) {
            codePoint = b0 & WorkQueueKt.MASK;
            byteCount = 1;
            min = 0;
        } else {
            int codePoint2 = b0 & 224;
            if (codePoint2 == 192) {
                codePoint = b0 & 31;
                byteCount = 2;
                min = 128;
            } else {
                int codePoint3 = b0 & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA;
                if (codePoint3 == 224) {
                    codePoint = b0 & 15;
                    byteCount = 3;
                    min = 2048;
                } else {
                    int codePoint4 = b0 & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT;
                    if (codePoint4 == 240) {
                        codePoint = b0 & 7;
                        byteCount = 4;
                        min = 65536;
                    } else {
                        skip(1L);
                        return REPLACEMENT_CHARACTER;
                    }
                }
            }
        }
        if (this.size < byteCount) {
            throw new EOFException("size < " + byteCount + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b0) + ")");
        }
        for (int i = 1; i < byteCount; i++) {
            byte b = getByte(i);
            if ((b & 192) == 128) {
                codePoint = (codePoint << 6) | (b & 63);
            } else {
                skip(i);
                return REPLACEMENT_CHARACTER;
            }
        }
        skip(byteCount);
        if (codePoint > 1114111) {
            return REPLACEMENT_CHARACTER;
        }
        return ((codePoint < 55296 || codePoint > 57343) && codePoint >= min) ? codePoint : REPLACEMENT_CHARACTER;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long byteCount) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, byteCount);
        if (byteCount > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + byteCount);
        }
        byte[] result = new byte[(int) byteCount];
        readFully(result);
        return result;
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink) {
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        int offset = 0;
        while (offset < sink.length) {
            int read = read(sink, offset, sink.length - offset);
            if (read == -1) {
                throw new EOFException();
            }
            offset += read;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink, int offset, int byteCount) {
        Util.checkOffsetAndCount(sink.length, offset, byteCount);
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(byteCount, s.limit - s.pos);
        System.arraycopy(s.data, s.pos, sink, offset, toCopy);
        s.pos += toCopy;
        this.size -= (long) toCopy;
        if (s.pos == s.limit) {
            this.head = s.pop();
            SegmentPool.recycle(s);
        }
        return toCopy;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(sink.remaining(), s.limit - s.pos);
        sink.put(s.data, s.pos, toCopy);
        s.pos += toCopy;
        this.size -= (long) toCopy;
        if (s.pos == s.limit) {
            this.head = s.pop();
            SegmentPool.recycle(s);
        }
        return toCopy;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public void skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int toSkip = (int) Math.min(byteCount, segment.limit - this.head.pos);
            this.size -= (long) toSkip;
            byteCount -= (long) toSkip;
            this.head.pos += toSkip;
            if (this.head.pos == this.head.limit) {
                Segment toRecycle = this.head;
                this.head = toRecycle.pop();
                SegmentPool.recycle(toRecycle);
            }
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string) {
        return writeUtf8(string, 0, string.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string, int beginIndex, int endIndex) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (beginIndex < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + beginIndex);
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + endIndex + " < " + beginIndex);
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + endIndex + " > " + string.length());
        }
        int i = beginIndex;
        while (i < endIndex) {
            int c = string.charAt(i);
            if (c < 128) {
                Segment tail = writableSegment(1);
                byte[] data = tail.data;
                int segmentOffset = tail.limit - i;
                int runLimit = Math.min(endIndex, 8192 - segmentOffset);
                int i2 = i + 1;
                data[i + segmentOffset] = (byte) c;
                while (i2 < runLimit) {
                    int c2 = string.charAt(i2);
                    if (c2 >= 128) {
                        break;
                    }
                    data[i2 + segmentOffset] = (byte) c2;
                    i2++;
                }
                int runSize = (i2 + segmentOffset) - tail.limit;
                tail.limit += runSize;
                this.size += (long) runSize;
                i = i2;
            } else if (c < 2048) {
                writeByte((c >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                writeByte(128 | (c & 63));
                i++;
            } else if (c < 55296 || c > 57343) {
                writeByte((c >> 12) | 224);
                writeByte(((c >> 6) & 63) | 128);
                writeByte(128 | (c & 63));
                i++;
            } else {
                int low = i + 1 < endIndex ? string.charAt(i + 1) : 0;
                if (c > 56319 || low < 56320 || low > 57343) {
                    writeByte(63);
                    i++;
                } else {
                    int codePoint = ((((-55297) & c) << 10) | ((-56321) & low)) + 65536;
                    writeByte((codePoint >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                    writeByte(((codePoint >> 12) & 63) | 128);
                    writeByte(((codePoint >> 6) & 63) | 128);
                    writeByte(128 | (codePoint & 63));
                    i += 2;
                }
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
        } else if (codePoint < 2048) {
            writeByte((codePoint >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            writeByte(128 | (codePoint & 63));
        } else if (codePoint < 65536) {
            if (codePoint >= 55296 && codePoint <= 57343) {
                writeByte(63);
            } else {
                writeByte((codePoint >> 12) | 224);
                writeByte(((codePoint >> 6) & 63) | 128);
                writeByte(128 | (codePoint & 63));
            }
        } else if (codePoint <= 1114111) {
            writeByte((codePoint >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            writeByte(((codePoint >> 12) & 63) | 128);
            writeByte(((codePoint >> 6) & 63) | 128);
            writeByte(128 | (codePoint & 63));
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(codePoint));
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, Charset charset) {
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, int beginIndex, int endIndex, Charset charset) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (beginIndex < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + beginIndex);
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + endIndex + " < " + beginIndex);
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + endIndex + " > " + string.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(Util.UTF_8)) {
            return writeUtf8(string, beginIndex, endIndex);
        }
        byte[] data = string.substring(beginIndex, endIndex).getBytes(charset);
        return write(data, 0, data.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source, int offset, int byteCount) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Util.checkOffsetAndCount(source.length, offset, byteCount);
        int limit = offset + byteCount;
        while (offset < limit) {
            Segment tail = writableSegment(1);
            int toCopy = Math.min(limit - offset, 8192 - tail.limit);
            System.arraycopy(source, offset, tail.data, tail.limit, toCopy);
            offset += toCopy;
            tail.limit += toCopy;
        }
        this.size += (long) byteCount;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        int byteCount = source.remaining();
        int remaining = byteCount;
        while (remaining > 0) {
            Segment tail = writableSegment(1);
            int toCopy = Math.min(remaining, 8192 - tail.limit);
            source.get(tail.data, tail.limit, toCopy);
            remaining -= toCopy;
            tail.limit += toCopy;
        }
        this.size += (long) byteCount;
        return byteCount;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long totalBytesRead = 0;
        while (true) {
            long readCount = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (readCount != -1) {
                totalBytesRead += readCount;
            } else {
                return totalBytesRead;
            }
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long byteCount) throws IOException {
        while (byteCount > 0) {
            long read = source.read(this, byteCount);
            if (read == -1) {
                throw new EOFException();
            }
            byteCount -= read;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int b) {
        Segment tail = writableSegment(1);
        byte[] bArr = tail.data;
        int i = tail.limit;
        tail.limit = i + 1;
        bArr[i] = (byte) b;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int s) {
        Segment tail = writableSegment(2);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((s >>> 8) & 255);
        data[limit2] = (byte) (s & 255);
        tail.limit = limit2 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int s) {
        return writeShort((int) Util.reverseBytesShort((short) s));
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment tail = writableSegment(4);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((i >>> 24) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((i >>> 16) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((i >>> 8) & 255);
        data[limit4] = (byte) (i & 255);
        tail.limit = limit4 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long v) {
        Segment tail = writableSegment(8);
        byte[] data = tail.data;
        int limit = tail.limit;
        int limit2 = limit + 1;
        data[limit] = (byte) ((v >>> 56) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((v >>> 48) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((v >>> 40) & 255);
        int limit5 = limit4 + 1;
        data[limit4] = (byte) ((v >>> 32) & 255);
        int limit6 = limit5 + 1;
        data[limit5] = (byte) ((v >>> 24) & 255);
        int limit7 = limit6 + 1;
        data[limit6] = (byte) ((v >>> 16) & 255);
        int limit8 = limit7 + 1;
        data[limit7] = (byte) ((v >>> 8) & 255);
        data[limit8] = (byte) (v & 255);
        tail.limit = limit8 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long v) {
        return writeLong(Util.reverseBytesLong(v));
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long v) {
        int width;
        if (v == 0) {
            return writeByte(48);
        }
        boolean negative = false;
        if (v < 0) {
            v = -v;
            if (v < 0) {
                return writeUtf8("-9223372036854775808");
            }
            negative = true;
        }
        if (v < 100000000) {
            if (v < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                if (v < 100) {
                    width = v < 10 ? 1 : 2;
                } else {
                    width = v < 1000 ? 3 : 4;
                }
            } else if (v < C.MICROS_PER_SECOND) {
                width = v < 100000 ? 5 : 6;
            } else {
                width = v < 10000000 ? 7 : 8;
            }
        } else if (v < 1000000000000L) {
            if (v < 10000000000L) {
                width = v < C.NANOS_PER_SECOND ? 9 : 10;
            } else {
                width = v < 100000000000L ? 11 : 12;
            }
        } else if (v < 1000000000000000L) {
            if (v < 10000000000000L) {
                width = 13;
            } else {
                width = v < 100000000000000L ? 14 : 15;
            }
        } else if (v < 100000000000000000L) {
            width = v < 10000000000000000L ? 16 : 17;
        } else {
            width = v < 1000000000000000000L ? 18 : 19;
        }
        if (negative) {
            width++;
        }
        Segment tail = writableSegment(width);
        byte[] data = tail.data;
        int pos = tail.limit + width;
        while (v != 0) {
            int digit = (int) (v % 10);
            pos--;
            data[pos] = DIGITS[digit];
            v /= 10;
        }
        if (negative) {
            data[pos - 1] = 45;
        }
        tail.limit += width;
        this.size += (long) width;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long v) {
        if (v == 0) {
            return writeByte(48);
        }
        int width = (Long.numberOfTrailingZeros(Long.highestOneBit(v)) / 4) + 1;
        Segment tail = writableSegment(width);
        byte[] data = tail.data;
        int start = tail.limit;
        for (int pos = (tail.limit + width) - 1; pos >= start; pos--) {
            data[pos] = DIGITS[(int) (15 & v)];
            v >>>= 4;
        }
        tail.limit += width;
        this.size += (long) width;
        return this;
    }

    Segment writableSegment(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            this.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        Segment tail = segment.prev;
        if (tail.limit + minimumCapacity > 8192 || !tail.owner) {
            return tail.push(SegmentPool.take());
        }
        return tail;
    }

    @Override // okio.Sink
    public void write(Buffer source, long byteCount) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(source.size, 0L, byteCount);
        while (byteCount > 0) {
            if (byteCount < source.head.limit - source.head.pos) {
                Segment segment = this.head;
                Segment tail = segment != null ? segment.prev : null;
                if (tail != null && tail.owner) {
                    if ((((long) tail.limit) + byteCount) - ((long) (tail.shared ? 0 : tail.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        source.head.writeTo(tail, (int) byteCount);
                        source.size -= byteCount;
                        this.size += byteCount;
                        return;
                    }
                }
                source.head = source.head.split((int) byteCount);
            }
            Segment tail2 = source.head;
            long movedByteCount = tail2.limit - tail2.pos;
            source.head = tail2.pop();
            Segment segment2 = this.head;
            if (segment2 == null) {
                this.head = tail2;
                tail2.prev = tail2;
                tail2.next = tail2;
            } else {
                segment2.prev.push(tail2).compact();
            }
            source.size -= movedByteCount;
            this.size += movedByteCount;
            byteCount -= movedByteCount;
        }
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        }
        long j = this.size;
        if (j == 0) {
            return -1L;
        }
        if (byteCount > j) {
            byteCount = this.size;
        }
        sink.write(this, byteCount);
        return byteCount;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long fromIndex) {
        return indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0049  */
    /* JADX WARN: Code duplicated, block: B:29:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x006b A[LOOP:2: B:28:0x005e->B:33:0x006b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x0064 A[SYNTHETIC] */
    @Override // okio.BufferedSource
    public long indexOf(byte b, long fromIndex, long toIndex) {
        Segment s;
        long offset;
        byte[] data;
        int limit;
        int pos;
        if (fromIndex < 0 || toIndex < fromIndex) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(fromIndex), Long.valueOf(toIndex)));
        }
        long j = this.size;
        if (toIndex > j) {
            toIndex = this.size;
        }
        if (fromIndex == toIndex || (s = this.head) == null) {
            return -1L;
        }
        if (j - fromIndex < fromIndex) {
            offset = this.size;
            while (offset > fromIndex) {
                s = s.prev;
                offset -= (long) (s.limit - s.pos);
            }
        } else {
            offset = 0;
            while (true) {
                long nextOffset = ((long) (s.limit - s.pos)) + offset;
                if (nextOffset >= fromIndex) {
                    break;
                }
                s = s.next;
                offset = nextOffset;
            }
            while (offset < toIndex) {
                data = s.data;
                limit = (int) Math.min(s.limit, (((long) s.pos) + toIndex) - offset);
                for (pos = (int) ((((long) s.pos) + fromIndex) - offset); pos < limit; pos++) {
                    if (data[pos] == b) {
                        return ((long) (pos - s.pos)) + offset;
                    }
                }
                offset += (long) (s.limit - s.pos);
                fromIndex = offset;
                s = s.next;
            }
            return -1L;
        }
        while (offset < toIndex) {
            data = s.data;
            limit = (int) Math.min(s.limit, (((long) s.pos) + toIndex) - offset);
            while (pos < limit) {
                if (data[pos] == b) {
                    return ((long) (pos - s.pos)) + offset;
                }
            }
            offset += (long) (s.limit - s.pos);
            fromIndex = offset;
            s = s.next;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes) throws IOException {
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes, long fromIndex) throws IOException {
        long offset;
        int pos;
        Segment s;
        if (bytes.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        if (fromIndex < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment s2 = this.head;
        if (s2 == null) {
            return -1L;
        }
        if (this.size - fromIndex < fromIndex) {
            offset = this.size;
            while (offset > fromIndex) {
                s2 = s2.prev;
                offset -= (long) (s2.limit - s2.pos);
            }
        } else {
            offset = 0;
            while (true) {
                long nextOffset = ((long) (s2.limit - s2.pos)) + offset;
                if (nextOffset >= fromIndex) {
                    break;
                }
                s2 = s2.next;
                offset = nextOffset;
            }
        }
        byte b0 = bytes.getByte(0);
        int bytesSize = bytes.size();
        long resultLimit = 1 + (this.size - ((long) bytesSize));
        long fromIndex2 = fromIndex;
        Segment s3 = s2;
        long offset2 = offset;
        while (offset2 < resultLimit) {
            byte[] data = s3.data;
            int segmentLimit = (int) Math.min(s3.limit, (((long) s3.pos) + resultLimit) - offset2);
            int pos2 = (int) ((((long) s3.pos) + fromIndex2) - offset2);
            while (pos2 < segmentLimit) {
                if (data[pos2] == b0) {
                    int segmentLimit2 = pos2 + 1;
                    pos = pos2;
                    s = s3;
                    if (rangeEquals(s3, segmentLimit2, bytes, 1, bytesSize)) {
                        return ((long) (pos - s.pos)) + offset2;
                    }
                } else {
                    pos = pos2;
                    s = s3;
                }
                pos2 = pos + 1;
                s3 = s;
                segmentLimit = segmentLimit;
                data = data;
            }
            Segment s4 = s3;
            offset2 += (long) (s4.limit - s4.pos);
            fromIndex2 = offset2;
            s3 = s4.next;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        long offset;
        Buffer buffer = this;
        if (fromIndex < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment s = buffer.head;
        if (s == null) {
            return -1L;
        }
        if (buffer.size - fromIndex < fromIndex) {
            offset = buffer.size;
            while (offset > fromIndex) {
                s = s.prev;
                offset -= (long) (s.limit - s.pos);
            }
        } else {
            offset = 0;
            while (true) {
                long nextOffset = ((long) (s.limit - s.pos)) + offset;
                if (nextOffset >= fromIndex) {
                    break;
                }
                s = s.next;
                offset = nextOffset;
            }
        }
        int i = 0;
        if (targetBytes.size() == 2) {
            int b0 = targetBytes.getByte(0);
            int b1 = targetBytes.getByte(1);
            long offset2 = offset;
            long fromIndex2 = fromIndex;
            while (offset2 < buffer.size) {
                byte[] data = s.data;
                int limit = s.limit;
                for (int pos = (int) ((((long) s.pos) + fromIndex2) - offset2); pos < limit; pos++) {
                    int b = data[pos];
                    if (b == b0 || b == b1) {
                        return ((long) (pos - s.pos)) + offset2;
                    }
                }
                int pos2 = s.limit;
                offset2 += (long) (pos2 - s.pos);
                fromIndex2 = offset2;
                s = s.next;
            }
            return -1L;
        }
        byte[] targetByteArray = targetBytes.internalArray();
        long offset3 = offset;
        long fromIndex3 = fromIndex;
        while (offset3 < buffer.size) {
            byte[] data2 = s.data;
            int pos3 = (int) ((((long) s.pos) + fromIndex3) - offset3);
            int limit2 = s.limit;
            while (pos3 < limit2) {
                byte b2 = data2[pos3];
                int length = targetByteArray.length;
                while (i < length) {
                    byte t = targetByteArray[i];
                    if (b2 == t) {
                        return ((long) (pos3 - s.pos)) + offset3;
                    }
                    i++;
                }
                pos3++;
                i = 0;
            }
            offset3 += (long) (s.limit - s.pos);
            fromIndex3 = offset3;
            s = s.next;
            buffer = this;
            i = 0;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes) {
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || this.size - offset < byteCount || bytes.size() - bytesOffset < byteCount) {
            return false;
        }
        for (int i = 0; i < byteCount; i++) {
            if (getByte(((long) i) + offset) != bytes.getByte(bytesOffset + i)) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeEquals(Segment segment, int segmentPos, ByteString bytes, int bytesOffset, int bytesLimit) {
        int segmentLimit = segment.limit;
        byte[] data = segment.data;
        for (int i = bytesOffset; i < bytesLimit; i++) {
            if (segmentPos == segmentLimit) {
                segment = segment.next;
                data = segment.data;
                segmentPos = segment.pos;
                segmentLimit = segment.limit;
            }
            if (data[segmentPos] != bytes.getByte(i)) {
                return false;
            }
            segmentPos++;
        }
        return true;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.add(Integer.valueOf(this.head.limit - this.head.pos));
        for (Segment s = this.head.next; s != this.head; s = s.next) {
            result.add(Integer.valueOf(s.limit - s.pos));
        }
        return result;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            Segment segment = this.head;
            if (segment != null) {
                messageDigest.update(segment.data, this.head.pos, this.head.limit - this.head.pos);
                for (Segment s = this.head.next; s != this.head; s = s.next) {
                    messageDigest.update(s.data, s.pos, s.limit - s.pos);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final ByteString hmacSha1(ByteString key) {
        return hmac(TapHttpUtil.HMAC_SHA1, key);
    }

    public final ByteString hmacSha256(ByteString key) {
        return hmac(TapHttpUtil.HMAC_SHA256, key);
    }

    public final ByteString hmacSha512(ByteString key) {
        return hmac("HmacSHA512", key);
    }

    private ByteString hmac(String algorithm, ByteString key) {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            Segment segment = this.head;
            if (segment != null) {
                mac.update(segment.data, this.head.pos, this.head.limit - this.head.pos);
                for (Segment s = this.head.next; s != this.head; s = s.next) {
                    mac.update(s.data, s.pos, s.limit - s.pos);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Buffer)) {
            return false;
        }
        Buffer that = (Buffer) o;
        long j = this.size;
        if (j != that.size) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        Segment sa = this.head;
        Segment sb = that.head;
        int posA = sa.pos;
        int posB = sb.pos;
        long pos = 0;
        while (pos < this.size) {
            long count = Math.min(sa.limit - posA, sb.limit - posB);
            int i = 0;
            while (i < count) {
                int posA2 = posA + 1;
                int posB2 = posB + 1;
                if (sa.data[posA] != sb.data[posB]) {
                    return false;
                }
                i++;
                posA = posA2;
                posB = posB2;
            }
            int i2 = sa.limit;
            if (posA == i2) {
                sa = sa.next;
                posA = sa.pos;
            }
            if (posB == sb.limit) {
                sb = sb.next;
                posB = sb.pos;
            }
            pos += count;
        }
        return true;
    }

    public int hashCode() {
        Segment s = this.head;
        if (s == null) {
            return 0;
        }
        int result = 1;
        do {
            int limit = s.limit;
            for (int pos = s.pos; pos < limit; pos++) {
                result = (result * 31) + s.data[pos];
            }
            s = s.next;
        } while (s != this.head);
        return result;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Buffer clone() {
        Buffer result = new Buffer();
        if (this.size == 0) {
            return result;
        }
        Segment segmentSharedCopy = this.head.sharedCopy();
        result.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment s = this.head.next; s != this.head; s = s.next) {
            result.head.prev.push(s.sharedCopy());
        }
        result.size = this.size;
        return result;
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return snapshot((int) j);
    }

    public final ByteString snapshot(int byteCount) {
        return byteCount == 0 ? ByteString.EMPTY : new SegmentedByteString(this, byteCount);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        public final int next() {
            if (this.offset == this.buffer.size) {
                throw new IllegalStateException();
            }
            long j = this.offset;
            return j == -1 ? seek(0L) : seek(j + ((long) (this.end - this.start)));
        }

        public final int seek(long offset) {
            Segment next;
            long nextOffset;
            if (offset < -1 || offset > this.buffer.size) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(offset), Long.valueOf(this.buffer.size)));
            }
            if (offset == -1 || offset == this.buffer.size) {
                this.segment = null;
                this.offset = offset;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long min = 0;
            long max = this.buffer.size;
            Segment head = this.buffer.head;
            Segment tail = this.buffer.head;
            Segment segment = this.segment;
            if (segment != null) {
                long segmentOffset = this.offset - ((long) (this.start - segment.pos));
                if (segmentOffset > offset) {
                    max = segmentOffset;
                    tail = this.segment;
                } else {
                    min = segmentOffset;
                    head = this.segment;
                }
            }
            if (max - offset > offset - min) {
                next = head;
                nextOffset = min;
                while (offset >= ((long) (next.limit - next.pos)) + nextOffset) {
                    nextOffset += (long) (next.limit - next.pos);
                    next = next.next;
                }
            } else {
                next = tail;
                nextOffset = max;
                while (nextOffset > offset) {
                    next = next.prev;
                    nextOffset -= (long) (next.limit - next.pos);
                }
            }
            if (this.readWrite && next.shared) {
                Segment unsharedNext = next.unsharedCopy();
                if (this.buffer.head == next) {
                    this.buffer.head = unsharedNext;
                }
                next = next.push(unsharedNext);
                next.prev.pop();
            }
            this.segment = next;
            this.offset = offset;
            this.data = next.data;
            this.start = next.pos + ((int) (offset - nextOffset));
            int i = next.limit;
            this.end = i;
            return i - this.start;
        }

        public final long resizeBuffer(long newSize) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long oldSize = buffer.size;
            if (newSize <= oldSize) {
                if (newSize < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + newSize);
                }
                long bytesToSubtract = oldSize - newSize;
                while (bytesToSubtract > 0) {
                    Segment tail = this.buffer.head.prev;
                    int tailSize = tail.limit - tail.pos;
                    if (tailSize <= bytesToSubtract) {
                        this.buffer.head = tail.pop();
                        SegmentPool.recycle(tail);
                        bytesToSubtract -= (long) tailSize;
                    } else {
                        tail.limit = (int) (((long) tail.limit) - bytesToSubtract);
                        break;
                    }
                }
                this.segment = null;
                this.offset = newSize;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (newSize > oldSize) {
                boolean needsToSeek = true;
                long bytesToAdd = newSize - oldSize;
                while (bytesToAdd > 0) {
                    Segment tail2 = this.buffer.writableSegment(1);
                    int segmentBytesToAdd = (int) Math.min(bytesToAdd, 8192 - tail2.limit);
                    tail2.limit += segmentBytesToAdd;
                    bytesToAdd -= (long) segmentBytesToAdd;
                    if (needsToSeek) {
                        this.segment = tail2;
                        this.offset = oldSize;
                        this.data = tail2.data;
                        this.start = tail2.limit - segmentBytesToAdd;
                        this.end = tail2.limit;
                        needsToSeek = false;
                    }
                }
            }
            this.buffer.size = newSize;
            return oldSize;
        }

        public final long expandBuffer(int minByteCount) {
            if (minByteCount <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + minByteCount);
            }
            if (minByteCount > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + minByteCount);
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long oldSize = buffer.size;
            Segment tail = this.buffer.writableSegment(minByteCount);
            int result = 8192 - tail.limit;
            tail.limit = 8192;
            this.buffer.size = ((long) result) + oldSize;
            this.segment = tail;
            this.offset = oldSize;
            this.data = tail.data;
            this.start = 8192 - result;
            this.end = 8192;
            return result;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }
}
