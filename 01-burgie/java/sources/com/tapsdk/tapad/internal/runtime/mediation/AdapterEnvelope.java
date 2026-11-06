package com.tapsdk.tapad.internal.runtime.mediation;

import com.tapsdk.tapad.a;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterEnvelope {
    public static final int FIXED_LENGTH = 56;
    public static final int MAX_ID_FIELD_BYTES = 4096;
    public static final int MAX_PAYLOAD_BYTES = 1048576;
    public static final int MAX_TRACE_FRAMES = 100000;
    public static final int SCHEMA_VERSION = 1;
    public static final int TRACE_SCHEMA_VERSION = 1;
    private final int adFormat;
    private final String adHandle;
    private final String adapterId;
    private final long attemptId;
    private final int instanceId;
    private final int messageKind;
    private final long monotonicTimeMs;
    private final int opcode;
    private final byte[] payload;
    private final String placementId;
    private final String requestId;
    private final long sequenceNo;
    private final int surfaceId;
    private static final byte[] ENVELOPE_MAGIC = {68, 82, 65, 68};
    private static final byte[] TRACE_MAGIC = {68, 82, 65, 84};

    public enum WireError {
        INVALID_MAGIC,
        UNSUPPORTED_SCHEMA_VERSION,
        UNKNOWN_MESSAGE_KIND,
        UNKNOWN_OPCODE,
        UNKNOWN_AD_FORMAT,
        NON_ZERO_RESERVED_BYTE,
        FIELD_TOO_LONG,
        PAYLOAD_TOO_LONG,
        INVALID_UTF8,
        LENGTH_OVERFLOW,
        TRUNCATED,
        TRAILING_BYTES,
        TOO_MANY_TRACE_FRAMES
    }

    public AdapterEnvelope(int i, int i2, int i3, long j, long j2, long j3, int i4, int i5, String str, String str2, String str3, String str4, byte[] bArr) {
        this.messageKind = i;
        this.opcode = i2;
        this.adFormat = i3;
        this.sequenceNo = j;
        this.monotonicTimeMs = j2;
        this.attemptId = j3;
        this.instanceId = i4;
        this.surfaceId = i5;
        this.requestId = (String) Objects.requireNonNull(str, "requestId");
        this.adapterId = (String) Objects.requireNonNull(str2, "adapterId");
        this.placementId = (String) Objects.requireNonNull(str3, "placementId");
        this.adHandle = (String) Objects.requireNonNull(str4, "adHandle");
        this.payload = Arrays.copyOf((byte[]) Objects.requireNonNull(bArr, "payload"), bArr.length);
    }

    public static AdapterEnvelope decode(byte[] bArr) throws WireException {
        if (bArr == null || bArr.length < 56) {
            throw new WireException(WireError.TRUNCATED, "envelope header is truncated");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        requireMagic(byteBufferOrder, ENVELOPE_MAGIC);
        int unsignedShort = readUnsignedShort(byteBufferOrder);
        if (unsignedShort != 1) {
            throw new WireException(WireError.UNSUPPORTED_SCHEMA_VERSION, b.a("schema_version=", unsignedShort));
        }
        int i = byteBufferOrder.get() & UByte.MAX_VALUE;
        if ((byteBufferOrder.get() & UByte.MAX_VALUE) != 0) {
            throw new WireException(WireError.NON_ZERO_RESERVED_BYTE, "reserved byte must be zero");
        }
        int unsignedShort2 = readUnsignedShort(byteBufferOrder);
        validateMessageKindAndOpcode(i, unsignedShort2);
        int unsignedShort3 = readUnsignedShort(byteBufferOrder);
        validateAdFormat(unsignedShort3);
        long j = byteBufferOrder.getLong();
        long j2 = byteBufferOrder.getLong();
        long j3 = byteBufferOrder.getLong();
        int i2 = byteBufferOrder.getInt();
        int i3 = byteBufferOrder.getInt();
        int unsignedShort4 = readUnsignedShort(byteBufferOrder);
        int unsignedShort5 = readUnsignedShort(byteBufferOrder);
        int unsignedShort6 = readUnsignedShort(byteBufferOrder);
        int unsignedShort7 = readUnsignedShort(byteBufferOrder);
        long j4 = ((long) byteBufferOrder.getInt()) & 4294967295L;
        validateIdLength(Constants.Bidding.REQUEST_ID, unsignedShort4);
        validateIdLength("adapter_id", unsignedShort5);
        validateIdLength("placement_id", unsignedShort6);
        validateIdLength("ad_handle", unsignedShort7);
        if (j4 > 1048576) {
            throw new WireException(WireError.PAYLOAD_TOO_LONG, "payload length=" + j4);
        }
        int i4 = (int) j4;
        long j5 = ((long) unsignedShort4) + ((long) unsignedShort5) + ((long) unsignedShort6) + ((long) unsignedShort7) + ((long) i4);
        if (j5 > byteBufferOrder.remaining()) {
            throw new WireException(WireError.TRUNCATED, "envelope body is truncated");
        }
        if (j5 < byteBufferOrder.remaining()) {
            throw new WireException(WireError.TRAILING_BYTES, "trailing bytes=" + (((long) byteBufferOrder.remaining()) - j5));
        }
        String utf8 = readUtf8(byteBufferOrder, Constants.Bidding.REQUEST_ID, unsignedShort4);
        String utf9 = readUtf8(byteBufferOrder, "adapter_id", unsignedShort5);
        String utf10 = readUtf8(byteBufferOrder, "placement_id", unsignedShort6);
        String utf11 = readUtf8(byteBufferOrder, "ad_handle", unsignedShort7);
        byte[] bArr2 = new byte[i4];
        byteBufferOrder.get(bArr2);
        return new AdapterEnvelope(i, unsignedShort2, unsignedShort3, j, j2, j3, i2, i3, utf8, utf9, utf10, utf11, bArr2);
    }

    public static List<AdapterEnvelope> decodeTrace(byte[] bArr) throws WireException {
        if (bArr == null || bArr.length < 12) {
            throw new WireException(WireError.TRUNCATED, "trace header is truncated");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        requireMagic(byteBufferOrder, TRACE_MAGIC);
        int unsignedShort = readUnsignedShort(byteBufferOrder);
        if (unsignedShort != 1) {
            throw new WireException(WireError.UNSUPPORTED_SCHEMA_VERSION, b.a("trace schema_version=", unsignedShort));
        }
        if (readUnsignedShort(byteBufferOrder) != 0) {
            throw new WireException(WireError.NON_ZERO_RESERVED_BYTE, "trace reserved field must be zero");
        }
        long j = ((long) byteBufferOrder.getInt()) & 4294967295L;
        if (j > 100000) {
            throw new WireException(WireError.TOO_MANY_TRACE_FRAMES, "frame count=" + j);
        }
        int i = (int) j;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            if (byteBufferOrder.remaining() < 4) {
                throw new WireException(WireError.TRUNCATED, "trace frame length is truncated");
            }
            long j2 = ((long) byteBufferOrder.getInt()) & 4294967295L;
            if (j2 > byteBufferOrder.remaining()) {
                throw new WireException(WireError.TRUNCATED, "trace frame is truncated");
            }
            byte[] bArr2 = new byte[(int) j2];
            byteBufferOrder.get(bArr2);
            arrayList.add(decode(bArr2));
        }
        if (byteBufferOrder.hasRemaining()) {
            throw new WireException(WireError.TRAILING_BYTES, "trace trailing bytes=" + byteBufferOrder.remaining());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static byte[] encodeIdField(String str, String str2) throws WireException {
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        validateIdLength(str, bytes.length);
        return bytes;
    }

    public static byte[] encodeTrace(List<AdapterEnvelope> list) throws WireException {
        Objects.requireNonNull(list, "frames");
        if (list.size() > 100000) {
            throw new WireException(WireError.TOO_MANY_TRACE_FRAMES, "frame count=" + list.size());
        }
        ArrayList arrayList = new ArrayList(list.size());
        long length = 12;
        Iterator<AdapterEnvelope> it = list.iterator();
        while (it.hasNext()) {
            byte[] bArrEncode = ((AdapterEnvelope) Objects.requireNonNull(it.next(), "trace frame")).encode();
            arrayList.add(bArrEncode);
            length += ((long) bArrEncode.length) + 4;
            if (length > 2147483647L) {
                throw new WireException(WireError.LENGTH_OVERFLOW, "encoded trace is too large");
            }
        }
        ByteBuffer byteBufferLittleEndian = littleEndian((int) length);
        byteBufferLittleEndian.put(TRACE_MAGIC);
        putUnsignedShort(byteBufferLittleEndian, 1);
        int i = 0;
        putUnsignedShort(byteBufferLittleEndian, 0);
        byteBufferLittleEndian.putInt(list.size());
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            byte[] bArr = (byte[]) obj;
            byteBufferLittleEndian.putInt(bArr.length);
            byteBufferLittleEndian.put(bArr);
        }
        return byteBufferLittleEndian.array();
    }

    private static ByteBuffer littleEndian(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void putUnsignedShort(ByteBuffer byteBuffer, int i) throws WireException {
        if (i < 0 || i > 65535) {
            throw new WireException(WireError.LENGTH_OVERFLOW, b.a("u16 value=", i));
        }
        byteBuffer.putShort((short) i);
    }

    private static int readUnsignedShort(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    private static String readUtf8(ByteBuffer byteBuffer, String str, int i) throws WireException {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        try {
            CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr)).toString();
        } catch (CharacterCodingException e) {
            throw new WireException(WireError.INVALID_UTF8, a.a(str, " is not UTF-8"), e);
        }
    }

    private static void requireMagic(ByteBuffer byteBuffer, byte[] bArr) throws WireException {
        for (byte b : bArr) {
            if (!byteBuffer.hasRemaining() || byteBuffer.get() != b) {
                throw new WireException(WireError.INVALID_MAGIC, "invalid wire magic");
            }
        }
    }

    private static void validateAdFormat(int i) throws WireException {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
            throw new WireException(WireError.UNKNOWN_AD_FORMAT, b.a("ad format=", i));
        }
    }

    private static void validateIdLength(String str, int i) throws WireException {
        if (i > 4096) {
            throw new WireException(WireError.FIELD_TOO_LONG, str + " length=" + i);
        }
    }

    private static void validateMessageKindAndOpcode(int i, int i2) throws WireException {
        if (i == 1) {
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 9) {
                return;
            }
        } else {
            if (i != 2) {
                throw new WireException(WireError.UNKNOWN_MESSAGE_KIND, b.a("message kind=", i));
            }
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10 || i2 == 11 || i2 == 12 || i2 == 13 || i2 == 14 || i2 == 15 || i2 == 16 || i2 == 17) {
                return;
            }
        }
        throw new WireException(WireError.UNKNOWN_OPCODE, "kind=" + i + ", opcode=" + i2);
    }

    public byte[] encode() throws WireException {
        validateMessageKindAndOpcode(this.messageKind, this.opcode);
        validateAdFormat(this.adFormat);
        byte[] bArrEncodeIdField = encodeIdField(Constants.Bidding.REQUEST_ID, this.requestId);
        byte[] bArrEncodeIdField2 = encodeIdField("adapter_id", this.adapterId);
        byte[] bArrEncodeIdField3 = encodeIdField("placement_id", this.placementId);
        byte[] bArrEncodeIdField4 = encodeIdField("ad_handle", this.adHandle);
        byte[] bArr = this.payload;
        if (bArr.length > 1048576) {
            throw new WireException(WireError.PAYLOAD_TOO_LONG, "payload length=" + this.payload.length);
        }
        long length = ((long) bArrEncodeIdField.length) + 56 + ((long) bArrEncodeIdField2.length) + ((long) bArrEncodeIdField3.length) + ((long) bArrEncodeIdField4.length) + ((long) bArr.length);
        if (length > 2147483647L) {
            throw new WireException(WireError.LENGTH_OVERFLOW, "encoded envelope is too large");
        }
        ByteBuffer byteBufferLittleEndian = littleEndian((int) length);
        byteBufferLittleEndian.put(ENVELOPE_MAGIC);
        putUnsignedShort(byteBufferLittleEndian, 1);
        byteBufferLittleEndian.put((byte) this.messageKind);
        byteBufferLittleEndian.put((byte) 0);
        putUnsignedShort(byteBufferLittleEndian, this.opcode);
        putUnsignedShort(byteBufferLittleEndian, this.adFormat);
        byteBufferLittleEndian.putLong(this.sequenceNo);
        byteBufferLittleEndian.putLong(this.monotonicTimeMs);
        byteBufferLittleEndian.putLong(this.attemptId);
        byteBufferLittleEndian.putInt(this.instanceId);
        byteBufferLittleEndian.putInt(this.surfaceId);
        putUnsignedShort(byteBufferLittleEndian, bArrEncodeIdField.length);
        putUnsignedShort(byteBufferLittleEndian, bArrEncodeIdField2.length);
        putUnsignedShort(byteBufferLittleEndian, bArrEncodeIdField3.length);
        putUnsignedShort(byteBufferLittleEndian, bArrEncodeIdField4.length);
        byteBufferLittleEndian.putInt(this.payload.length);
        byteBufferLittleEndian.put(bArrEncodeIdField);
        byteBufferLittleEndian.put(bArrEncodeIdField2);
        byteBufferLittleEndian.put(bArrEncodeIdField3);
        byteBufferLittleEndian.put(bArrEncodeIdField4);
        byteBufferLittleEndian.put(this.payload);
        return byteBufferLittleEndian.array();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdapterEnvelope)) {
            return false;
        }
        AdapterEnvelope adapterEnvelope = (AdapterEnvelope) obj;
        return this.messageKind == adapterEnvelope.messageKind && this.opcode == adapterEnvelope.opcode && this.adFormat == adapterEnvelope.adFormat && this.sequenceNo == adapterEnvelope.sequenceNo && this.monotonicTimeMs == adapterEnvelope.monotonicTimeMs && this.attemptId == adapterEnvelope.attemptId && this.instanceId == adapterEnvelope.instanceId && this.surfaceId == adapterEnvelope.surfaceId && this.requestId.equals(adapterEnvelope.requestId) && this.adapterId.equals(adapterEnvelope.adapterId) && this.placementId.equals(adapterEnvelope.placementId) && this.adHandle.equals(adapterEnvelope.adHandle) && Arrays.equals(this.payload, adapterEnvelope.payload);
    }

    public int getAdFormat() {
        return this.adFormat;
    }

    public String getAdHandle() {
        return this.adHandle;
    }

    public String getAdapterId() {
        return this.adapterId;
    }

    public long getAttemptId() {
        return this.attemptId;
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public int getMessageKind() {
        return this.messageKind;
    }

    public long getMonotonicTimeMs() {
        return this.monotonicTimeMs;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public byte[] getPayload() {
        byte[] bArr = this.payload;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getSequenceNo() {
        return this.sequenceNo;
    }

    public int getSurfaceId() {
        return this.surfaceId;
    }

    public int hashCode() {
        return Arrays.hashCode(this.payload) + (Objects.hash(Integer.valueOf(this.messageKind), Integer.valueOf(this.opcode), Integer.valueOf(this.adFormat), Long.valueOf(this.sequenceNo), Long.valueOf(this.monotonicTimeMs), Long.valueOf(this.attemptId), Integer.valueOf(this.instanceId), Integer.valueOf(this.surfaceId), this.requestId, this.adapterId, this.placementId, this.adHandle) * 31);
    }

    public static final class WireException extends Exception {
        private final WireError error;

        public WireException(WireError wireError, String str) {
            super(str);
            this.error = wireError;
        }

        public WireError getError() {
            return this.error;
        }

        public WireException(WireError wireError, String str, Throwable th) {
            super(str, th);
            this.error = wireError;
        }
    }
}
