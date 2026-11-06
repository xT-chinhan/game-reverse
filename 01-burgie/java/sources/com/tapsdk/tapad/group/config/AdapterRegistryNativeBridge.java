package com.tapsdk.tapad.group.config;

import com.tapsdk.tapad.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
final class AdapterRegistryNativeBridge {
    static final int CAP_ALL = 63;
    static final int CAP_BANNER = 8;
    static final int CAP_FEED_EXPRESS = 32;
    static final int CAP_FEED_NATIVE = 16;
    static final int CAP_INTERSTITIAL = 2;
    static final int CAP_REWARD = 1;
    static final int CAP_SPLASH = 4;
    static final int COMMAND_DROP = 3;
    private static final int COMMAND_HEADER_BYTES = 24;
    static final int COMMAND_INITIALIZE = 1;
    static final int COMMAND_PUBLISH = 2;
    static final int COMMAND_QUARANTINE = 5;
    private static final int COMMAND_RECORD_BYTES = 16;
    static final int COMMAND_SKIP = 4;
    static final int FACT_ADAPTER_PRESENT = 2;
    static final int FACT_CONFIGURED = 1;
    static final int FACT_ENTRY_POINT_PRESENT = 8;
    private static final int FACT_HEADER_BYTES = 16;
    static final int FACT_PARTNER_VERSION_ADVISORY = 32;
    static final int FACT_PLATFORM_SUPPORTED = 16;
    private static final int FACT_RECORD_HEADER_BYTES = 24;
    static final int FACT_SDK_PRESENT = 4;
    static final int KNOWN_FACTS = 63;
    private static final int MAX_COMMAND_BYTES = 152;
    private static final int MAX_ENTRIES = 8;
    private static final int MAX_FACT_BYTES = 4096;
    private static final int MAX_VERSION_BYTES = 64;
    private static final AtomicInteger NEXT_GENERATION = new AtomicInteger(1);
    static final int REASON_DUPLICATE_RESULT = 11;
    static final int REASON_INIT_FAILED = 10;
    static final int REASON_INVALID_CAPABILITY = 9;
    static final int REASON_INVALID_EVENT = 12;
    static final int REASON_NONE = 0;
    static final int REASON_NOT_CONFIGURED = 2;
    static final int REASON_PARTNER_VERSION_MISMATCH = 7;
    static final int REASON_PLATFORM_INCOMPATIBLE = 8;
    static final int REASON_SESSION_REPLACED = 13;
    static final int REASON_UNSUPPORTED_NETWORK = 1;
    static final int REQUIRED_FACTS = 31;
    static final int STATE_FAILED = 5;
    static final int STATE_INITIALIZING = 2;
    static final int STATE_QUARANTINED = 6;
    static final int STATE_READY = 3;
    static final int STATE_RELEASED = 7;
    static final int STATE_UNAVAILABLE = 4;
    private static final int VERSION = 1;
    static final int VERSION_ANY = 0;
    static final int VERSION_EXACT = 1;
    static final int VERSION_MAJOR = 4;
    static final int VERSION_MAJOR_MINOR = 3;
    static final int VERSION_MAJOR_MINOR_PATCH = 2;

    public static final class Command {
        final int capabilityMask;
        final int command;
        final int lifecycleToken;
        final int networkId;
        final int reason;
        final int state;

        public Command(int i, int i2, int i3, int i4, int i5, int i6) {
            this.command = i;
            this.reason = i2;
            this.networkId = i3;
            this.state = i4;
            this.lifecycleToken = i5;
            this.capabilityMask = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isCanonical() {
            int i;
            int i2;
            int i3;
            int i4 = this.networkId;
            if (i4 >= 0 && i4 <= 5 && this.lifecycleToken > 0) {
                int i5 = this.capabilityMask;
                boolean z = i5 != 0 && (i5 & (-64)) == 0;
                int i6 = this.command;
                boolean z2 = i6 == 5 && this.reason == 9;
                if (!z && !z2) {
                    return false;
                }
                switch (i6) {
                    case 1:
                        if (this.state == 2 && ((i = this.reason) == 0 || i == 7)) {
                            return true;
                        }
                        break;
                    case 2:
                        return this.state == 3 && this.reason == 0;
                    case 3:
                        int i7 = this.state;
                        return (i7 == 5 && this.reason == 10) || (i7 == 7 && this.reason == 13);
                    case 4:
                        return this.state == 4 && (i2 = this.reason) >= 2 && i2 <= 8;
                    case 5:
                        return this.state == 6 && ((i3 = this.reason) == 1 || i3 == 9 || i3 == 11 || i3 == 12);
                    default:
                        return false;
                }
            }
            return false;
        }

        public boolean hasPartnerVersionAdvisory() {
            return this.command == 1 && this.reason == 7;
        }
    }

    public static final class CommandBatch {
        final List<Command> commands;
        final int failedCount;
        final int generation;
        final int readyCount;
        final boolean terminal;
        final int unavailableCount;

        public CommandBatch(int i, boolean z, int i2, int i3, int i4, List<Command> list) {
            this.generation = i;
            this.terminal = z;
            this.readyCount = i2;
            this.failedCount = i3;
            this.unavailableCount = i4;
            this.commands = list;
        }
    }

    public static final class Fact {
        final String actualPartnerVersion;
        final String adapterVersion;
        final int adapterVersionRule;
        final int capabilityMask;
        final String mediationVersion;
        final int networkId;
        final int partnerVersionRule;
        final String pinnedPartnerVersion;
        final int platformFacts;

        public Fact(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4) {
            this.networkId = i;
            this.platformFacts = i2;
            this.adapterVersionRule = i3;
            this.partnerVersionRule = i4;
            this.capabilityMask = i5;
            this.adapterVersion = str;
            this.mediationVersion = str2;
            this.pinnedPartnerVersion = str3;
            this.actualPartnerVersion = str4;
        }
    }

    public static final class Session {
        private boolean closed;
        private final int generation;
        final CommandBatch initialCommands;
        private final long sessionId;

        public Session(long j, int i, CommandBatch commandBatch) {
            this.sessionId = j;
            this.generation = i;
            this.initialCommands = commandBatch;
        }

        public synchronized void abort() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            AdapterRegistryNativeBridge.abortNativeQuietly(this.sessionId);
        }

        public synchronized CommandBatch apply(int i, boolean z) {
            CommandBatch commandBatchDecodeCommands;
            if (this.closed || i <= 0) {
                throw new RegistryException(-9505);
            }
            byte[] bArr = new byte[152];
            try {
                int iNativeResult = AdapterRegistryNativeBridge.nativeResult(this.sessionId, i, z, bArr);
                if (iNativeResult <= 0) {
                    this.closed = true;
                    throw new RegistryException(iNativeResult);
                }
                try {
                    commandBatchDecodeCommands = AdapterRegistryNativeBridge.decodeCommands(bArr, iNativeResult, this.generation);
                    if (commandBatchDecodeCommands.commands.size() != 1) {
                        throw new RegistryException(-9504);
                    }
                } catch (RegistryException e) {
                    this.closed = true;
                    AdapterRegistryNativeBridge.abortNativeQuietly(this.sessionId);
                    throw e;
                }
            } catch (Throwable th) {
                this.closed = true;
                AdapterRegistryNativeBridge.abortNativeQuietly(this.sessionId);
                throw new RegistryException(-9502, th);
            }
            return commandBatchDecodeCommands;
        }

        public synchronized CommandBatch close() {
            byte[] bArr;
            int iNativeClose;
            if (this.closed) {
                throw new RegistryException(-9505);
            }
            this.closed = true;
            bArr = new byte[152];
            try {
                iNativeClose = AdapterRegistryNativeBridge.nativeClose(this.sessionId, bArr);
                if (iNativeClose <= 0) {
                    throw new RegistryException(iNativeClose);
                }
            } catch (Throwable th) {
                AdapterRegistryNativeBridge.abortNativeQuietly(this.sessionId);
                throw new RegistryException(-9502, th);
            }
            return AdapterRegistryNativeBridge.decodeCommands(bArr, iNativeClose, this.generation);
        }
    }

    private AdapterRegistryNativeBridge() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void abortNativeQuietly(long j) {
        if (j <= 0) {
            return;
        }
        try {
            nativeAbort(j);
        } catch (Throwable th) {
        }
    }

    public static Session begin(List<Fact> list) throws RegistryException {
        int iNextGeneration = nextGeneration();
        int size = list == null ? 0 : list.size();
        byte[] bArr = new byte[152];
        try {
            long jNativeBegin = nativeBegin(encodeFacts(iNextGeneration, list), bArr);
            if (jNativeBegin <= 0) {
                throw new RegistryException((int) jNativeBegin);
            }
            try {
                CommandBatch commandBatchDecodeCommands = decodeCommands(bArr, 0, iNextGeneration);
                if (commandBatchDecodeCommands.commands.size() == size) {
                    return new Session(jNativeBegin, iNextGeneration, commandBatchDecodeCommands);
                }
                throw new RegistryException(-9504);
            } catch (RegistryException e) {
                abortNativeQuietly(jNativeBegin);
                throw e;
            }
        } catch (Throwable th) {
            throw new RegistryException(-9502, th);
        }
    }

    public static CommandBatch decodeCommands(byte[] bArr, int i, int i2) throws RegistryException {
        int i3;
        if (bArr == null || bArr.length < 24) {
            throw new RegistryException(-9504);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferOrder.get() != 68 || byteBufferOrder.get() != 82 || byteBufferOrder.get() != 71 || byteBufferOrder.get() != 67 || unsigned(byteBufferOrder.getShort()) != 1) {
            throw new RegistryException(-9504);
        }
        int iUnsigned = unsigned(byteBufferOrder.getShort());
        int i4 = byteBufferOrder.getInt();
        int iUnsigned2 = unsigned(byteBufferOrder.getShort());
        int iUnsigned3 = unsigned(byteBufferOrder.getShort());
        int iUnsigned4 = unsigned(byteBufferOrder.getShort());
        int iUnsigned5 = unsigned(byteBufferOrder.getShort());
        int i5 = byteBufferOrder.getInt();
        int i6 = (iUnsigned * 16) + 24;
        if (iUnsigned > 8 || i4 != i2 || (!(iUnsigned2 == 0 || iUnsigned2 == 1) || i5 != 0 || i6 > bArr.length || ((i > 0 && i != i6) || iUnsigned3 > 8 || iUnsigned4 > 8 || iUnsigned5 > 8 || ((long) iUnsigned3) + ((long) iUnsigned4) + ((long) iUnsigned5) > 8))) {
            throw new RegistryException(-9504);
        }
        ArrayList arrayList = new ArrayList(iUnsigned);
        int i7 = -1;
        int i8 = 0;
        while (i8 < iUnsigned) {
            Command command = new Command(unsigned(byteBufferOrder.getShort()), unsigned(byteBufferOrder.getShort()), unsigned(byteBufferOrder.getShort()), unsigned(byteBufferOrder.getShort()), byteBufferOrder.getInt(), byteBufferOrder.getInt());
            if (!command.isCanonical() || (i3 = command.networkId) <= i7) {
                throw new RegistryException(-9504);
            }
            arrayList.add(command);
            i8++;
            i7 = i3;
        }
        return new CommandBatch(i4, iUnsigned2 == 1, iUnsigned3, iUnsigned4, iUnsigned5, Collections.unmodifiableList(arrayList));
    }

    public static byte[] encodeFacts(int i, List<Fact> list) throws RegistryException {
        int i2;
        int i3;
        int i4;
        ArrayList arrayList = list == null ? new ArrayList() : new ArrayList(list);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            if (((Fact) obj) == null) {
                throw new RegistryException(-9501);
            }
        }
        Collections.sort(arrayList, new Comparator<Fact>() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryNativeBridge.1
            @Override // java.util.Comparator
            public int compare(Fact fact, Fact fact2) {
                return Integer.compare(fact.networkId, fact2.networkId);
            }
        });
        if (arrayList.size() > 8) {
            throw new RegistryException(-9501);
        }
        int length = 16;
        int i6 = -1;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj2 = arrayList.get(i7);
            i7++;
            Fact fact = (Fact) obj2;
            if (fact == null || (i2 = fact.networkId) <= i6 || i2 < 0 || i2 > 5 || (fact.platformFacts & (-64)) != 0 || (i3 = fact.adapterVersionRule) < 0 || i3 > 4 || (i4 = fact.partnerVersionRule) < 0 || i4 > 4) {
                throw new RegistryException(-9501);
            }
            byte[][] bArr = {utf8(fact.adapterVersion), utf8(fact.mediationVersion), utf8(fact.pinnedPartnerVersion), utf8(fact.actualPartnerVersion)};
            arrayList2.add(bArr);
            length += 24;
            for (int i8 = 0; i8 < 4; i8++) {
                byte[] bArr2 = bArr[i8];
                if (bArr2.length > 64) {
                    throw new RegistryException(-9501);
                }
                length += bArr2.length;
            }
            i6 = i2;
        }
        if (length > 4096) {
            throw new RegistryException(-9501);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(length).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put((byte) 68).put((byte) 82).put((byte) 71).put((byte) 70);
        byteBufferOrder.putShort((short) 1);
        byteBufferOrder.putShort((short) arrayList.size());
        byteBufferOrder.putInt(i);
        byteBufferOrder.putInt(0);
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            Fact fact2 = (Fact) arrayList.get(i9);
            byte[][] bArr3 = (byte[][]) arrayList2.get(i9);
            byteBufferOrder.putShort((short) fact2.networkId);
            byteBufferOrder.putShort((short) fact2.platformFacts);
            byteBufferOrder.putShort((short) fact2.adapterVersionRule);
            byteBufferOrder.putShort((short) fact2.partnerVersionRule);
            byteBufferOrder.putInt(fact2.capabilityMask);
            for (byte[] bArr4 : bArr3) {
                byteBufferOrder.putShort((short) bArr4.length);
            }
            byteBufferOrder.putInt(0);
            for (byte[] bArr5 : bArr3) {
                byteBufferOrder.put(bArr5);
            }
        }
        return byteBufferOrder.array();
    }

    private static native boolean nativeAbort(long j);

    private static native long nativeBegin(byte[] bArr, byte[] bArr2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeClose(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeResult(long j, int i, boolean z, byte[] bArr);

    private static int nextGeneration() {
        while (true) {
            AtomicInteger atomicInteger = NEXT_GENERATION;
            int i = atomicInteger.get();
            if (atomicInteger.compareAndSet(i, (i >= 65535 || i <= 0) ? 1 : i + 1) && i > 0 && i <= 65535) {
                return i;
            }
        }
    }

    private static int unsigned(short s) {
        return s & UShort.MAX_VALUE;
    }

    private static byte[] utf8(String str) {
        if (str == null) {
            str = "";
        }
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static final class RegistryException extends Exception {
        final int status;

        public RegistryException(int i) {
            super(b.a("AdapterRegistry status=", i));
            this.status = i;
        }

        public RegistryException(int i, Throwable th) {
            super(b.a("AdapterRegistry status=", i), th);
            this.status = i;
        }
    }
}
