package com.tapsdk.tapad.group;

import com.tapsdk.tapad.b;
import com.tapsdk.tapad.group.ads.DirichletAd;
import com.tapsdk.tapad.group.ads.MediationShowAdmissionBridge;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.runtime.mediation.AdapterEnvelope;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
final class SchedulerMechanicalAdapterExecutor {
    static final int CLAIM_EXECUTE = 1;
    static final int CLAIM_REPLAY = 2;
    private static final int COMMAND_PAYLOAD_BYTES = 24;
    private static final int SETTLEMENT_PAYLOAD_BYTES = 52;
    private static final int TERMINAL_PAYLOAD_BYTES = 24;
    private final CandidateHandles candidates;
    private final long requestId;
    private final TerminalActions terminalActions;
    private boolean terminalDelivered;
    private boolean valid;
    private final Map<Long, Route> routes = new LinkedHashMap();
    private final TransferredCandidates transferredCandidates = new TransferredCandidates();

    public static final class CandidateHandles {
        private static final int HEADER_BYTES = 32;
        private static final int MAX_CANDIDATES = 1024;
        private static final int MAX_INGRESS_BYTES = 1056000;
        private int nextHandle;
        private int registered;
        private final long requestId;
        private final Map<String, DirichletAd> byHandle = new LinkedHashMap();
        private final IdentityHashMap<DirichletAd, String> byCandidate = new IdentityHashMap<>();

        public CandidateHandles(long j) {
            this.requestId = j;
        }

        public CandidateSummary close() {
            CandidateSummary candidateSummary = new CandidateSummary(this.registered, this.byHandle.size());
            ArrayList arrayList = new ArrayList(this.byHandle.values());
            this.byHandle.clear();
            this.byCandidate.clear();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                DirichletAd dirichletAd = (DirichletAd) obj;
                if (dirichletAd != null) {
                    dirichletAd.destroy();
                }
            }
            return candidateSummary;
        }

        public DirichletAd get(String str) {
            if (str == null) {
                return null;
            }
            return this.byHandle.get(str);
        }

        public byte[] register(int i, List<DirichletAd> list, byte[] bArr) {
            long length = 0;
            if (this.requestId != 0 && i > 0 && list != null && !list.isEmpty() && list.size() + this.registered <= 1024) {
                if (bArr == null) {
                    bArr = new byte[0];
                }
                if (bArr.length > MAX_INGRESS_BYTES) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(list.size());
                IdentityHashMap identityHashMap = new IdentityHashMap();
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        long length2 = 32 + length + ((long) bArr.length);
                        if (length2 > 1056000 || length2 > 2147483647L) {
                            break;
                            break;
                        }
                        ByteBuffer byteBufferOrder = ByteBuffer.allocate((int) length2).order(ByteOrder.LITTLE_ENDIAN);
                        byteBufferOrder.put((byte) 68).put((byte) 82).put((byte) 67).put((byte) 73);
                        byteBufferOrder.putShort((short) 1);
                        byteBufferOrder.putShort((short) (bArr.length == 0 ? 0 : 1));
                        byteBufferOrder.putLong(this.requestId);
                        byteBufferOrder.putInt(i);
                        byteBufferOrder.putShort((short) arrayList.size());
                        byteBufferOrder.putShort((short) 0);
                        byteBufferOrder.putInt((int) length);
                        byteBufferOrder.putInt(bArr.length);
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            String str = (String) arrayList.get(i3);
                            DirichletAd dirichletAd = list.get(i3);
                            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                            byteBufferOrder.putShort((short) bytes.length);
                            byteBufferOrder.putShort((short) 0);
                            byteBufferOrder.put(bytes);
                            this.byHandle.put(str, dirichletAd);
                            this.byCandidate.put(dirichletAd, str);
                        }
                        byteBufferOrder.put(bArr);
                        this.nextHandle = arrayList.size() + this.nextHandle;
                        this.registered = arrayList.size() + this.registered;
                        return byteBufferOrder.array();
                    }
                    DirichletAd dirichletAd2 = list.get(i2);
                    if (dirichletAd2 == null || this.byCandidate.containsKey(dirichletAd2) || identityHashMap.put(dirichletAd2, Boolean.TRUE) != null) {
                        return null;
                    }
                    String str2 = String.format(Locale.US, "candidate-%016x-%04x", Long.valueOf(this.requestId), Integer.valueOf(this.nextHandle + i2));
                    byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
                    arrayList.add(str2);
                    length += ((long) bytes2.length) + 4;
                    i2++;
                }
            }
            return null;
        }

        public void remove(String str, DirichletAd dirichletAd) {
            if (str == null || this.byHandle.get(str) != dirichletAd) {
                throw new IllegalStateException("candidate handle changed");
            }
            this.byHandle.remove(str);
            this.byCandidate.remove(dirichletAd);
        }
    }

    public static final class CandidateSummary {
        final int live;
        final int registered;

        public CandidateSummary(int i, int i2) {
            this.registered = i;
            this.live = i2;
        }
    }

    public static final class Command {
        final long deadlineMs;
        final AdapterEnvelope frame;
        final long routeKey;
        final Settlement settlement;

        public Command(AdapterEnvelope adapterEnvelope, long j, long j2, Settlement settlement) {
            this.frame = adapterEnvelope;
            this.routeKey = j;
            this.deadlineMs = j2;
            this.settlement = settlement;
        }
    }

    public static final class DecodedBatch {
        final List<Command> commands;
        final Boolean terminalFilled;

        public DecodedBatch(List<Command> list, Boolean bool) {
            this.commands = list;
            this.terminalFilled = bool;
        }
    }

    public interface Route {
        void cancel(long j);

        void load(long j, long j2);

        int routeKey();
    }

    public static final class Settlement {
        final long adjustedPrice;
        final long clearingPrice;
        final int counterpartyProvider;
        final long originalPrice;
        final long selectionRank;
        final boolean win;

        public Settlement(boolean z, long j, long j2, long j3, long j4, int i) {
            this.win = z;
            this.selectionRank = j;
            this.adjustedPrice = j2;
            this.originalPrice = j3;
            this.clearingPrice = j4;
            this.counterpartyProvider = i;
        }
    }

    public interface TerminalActions {
        void complete(boolean z, List<DirichletAd> list);

        void fail(String str);
    }

    public static final class TransferredCandidates {
        private final List<DirichletAd> candidates = new ArrayList();

        public void add(DirichletAd dirichletAd) {
            if (dirichletAd != null) {
                this.candidates.add(dirichletAd);
            }
        }

        public void close() {
            SchedulerMechanicalAdapterExecutor.destroyCandidates(this.candidates);
            this.candidates.clear();
        }

        public List<DirichletAd> take() {
            List<DirichletAd> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.candidates));
            this.candidates.clear();
            return listUnmodifiableList;
        }
    }

    public SchedulerMechanicalAdapterExecutor(long j, List<? extends Route> list, TerminalActions terminalActions) {
        this.valid = true;
        this.requestId = j;
        this.terminalActions = terminalActions;
        this.candidates = new CandidateHandles(j);
        if (j == 0 || list == null || list.isEmpty() || list.size() > 256 || terminalActions == null) {
            this.valid = false;
            return;
        }
        for (Route route : list) {
            if (route == null || route.routeKey() <= 0 || this.routes.put(Long.valueOf(route.routeKey()), route) != null) {
                this.valid = false;
                this.routes.clear();
                return;
            }
        }
    }

    private static void applySettlement(DirichletAd dirichletAd, Settlement settlement) {
        if (!MediationRuntimeCoreBridge.updateFillWin(dirichletAd.getTrackId(), settlement.win, settlement.selectionRank, settlement.adjustedPrice, settlement.clearingPrice)) {
            throw new IllegalStateException("shared Rust rejected candidate settlement");
        }
        dirichletAd.applySchedulerSettlement(settlement.win, settlement.adjustedPrice, settlement.originalPrice, settlement.clearingPrice, settlement.counterpartyProvider);
    }

    private static DecodedBatch decode(byte[] bArr) {
        try {
            List<AdapterEnvelope> listDecodeTrace = AdapterEnvelope.decodeTrace(bArr);
            ArrayList arrayList = new ArrayList(listDecodeTrace.size());
            Boolean boolValueOf = null;
            for (AdapterEnvelope adapterEnvelope : listDecodeTrace) {
                int opcode = adapterEnvelope.getOpcode();
                byte[] payload = adapterEnvelope.getPayload();
                if (opcode == 9) {
                    if (payload.length != 24) {
                        return null;
                    }
                    boolValueOf = Boolean.valueOf(readU16(payload, 6) == 1);
                    arrayList.add(new Command(adapterEnvelope, 0L, 0L, null));
                } else if (opcode == 6 || opcode == 7) {
                    if (payload.length != 52) {
                        return null;
                    }
                    arrayList.add(new Command(adapterEnvelope, readU32(payload, 8), 0L, new Settlement(opcode == 6, readU32(payload, 16), readI64(payload, 20), readI64(payload, 28), readI64(payload, 36), readU16(payload, 44))));
                } else {
                    if ((opcode != 2 && opcode != 3 && opcode != 8 && opcode != 5) || payload.length != 24) {
                        return null;
                    }
                    arrayList.add(new Command(adapterEnvelope, readU32(payload, 8), readI64(payload, 16), null));
                }
            }
            return new DecodedBatch(arrayList, boolValueOf);
        } catch (Throwable th) {
            return null;
        }
    }

    private void deliverTerminal(Boolean bool) {
        if (bool == null || this.terminalDelivered) {
            return;
        }
        this.terminalDelivered = true;
        List<DirichletAd> listTake = this.transferredCandidates.take();
        boolean zBooleanValue = false;
        try {
            this.terminalActions.complete(bool.booleanValue(), listTake);
            zBooleanValue = bool.booleanValue();
        } catch (Throwable th) {
        }
        if (zBooleanValue) {
            return;
        }
        destroyCandidates(listTake);
    }

    public static String describeFailure(String str, Throwable th) {
        if (th == null) {
            return str;
        }
        String simpleName = th.getClass().getSimpleName();
        String message = th.getMessage();
        String str2 = (message == null || message.trim().isEmpty()) ? str + ":" + simpleName : str + ":" + simpleName + ":" + message.trim();
        return str2.length() <= 256 ? str2 : str2.substring(0, 256);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyCandidates(List<DirichletAd> list) {
        for (DirichletAd dirichletAd : list) {
            if (dirichletAd != null) {
                dirichletAd.destroy();
            }
        }
    }

    private void invalidate(String str) {
        boolean z = this.terminalDelivered;
        this.valid = false;
        if (z) {
            return;
        }
        this.terminalDelivered = true;
        try {
            TerminalActions terminalActions = this.terminalActions;
            if (str == null || str.isEmpty()) {
                str = "scheduler_failed";
            }
            terminalActions.fail(str);
        } catch (Throwable th) {
        }
    }

    private static long readI64(byte[] bArr, int i) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong(i);
    }

    private static int readU16(byte[] bArr, int i) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(i) & UShort.MAX_VALUE;
    }

    private static long readU32(byte[] bArr, int i) {
        return ((long) ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt(i)) & 4294967295L;
    }

    private Route route(long j) {
        Route route = this.routes.get(Long.valueOf(j));
        if (route != null) {
            return route;
        }
        throw new IllegalStateException("missing scheduler route");
    }

    private boolean settle(byte[] bArr, int i, boolean z) {
        try {
            return SchedulerNativeBridge.settleExecution(this.requestId, bArr, i, z);
        } catch (Throwable th) {
            return false;
        }
    }

    public CandidateSummary closeCandidates() {
        CandidateSummary candidateSummaryClose = this.candidates.close();
        this.transferredCandidates.close();
        return candidateSummaryClose;
    }

    public boolean execute(byte[] bArr) {
        int i;
        Settlement settlement;
        if (!this.valid) {
            return false;
        }
        DecodedBatch decodedBatchDecode = decode(bArr);
        if (decodedBatchDecode == null) {
            invalidate("decode_failed");
            return false;
        }
        if (decodedBatchDecode.commands.isEmpty()) {
            return true;
        }
        try {
            int iClaimExecution = SchedulerNativeBridge.claimExecution(this.requestId, bArr);
            if (iClaimExecution != 1 && iClaimExecution != 2) {
                invalidate(b.a("claim_rejected:", iClaimExecution));
                return false;
            }
            if (iClaimExecution == 2) {
                deliverTerminal(decodedBatchDecode.terminalFilled);
                return this.valid;
            }
            try {
                i = 0;
                for (Command command : decodedBatchDecode.commands) {
                    try {
                        AdapterEnvelope adapterEnvelope = command.frame;
                        int opcode = adapterEnvelope.getOpcode();
                        if (opcode != 9) {
                            if (opcode == 2) {
                                route(command.routeKey).load(adapterEnvelope.getAttemptId(), command.deadlineMs);
                            } else if (opcode == 3) {
                                route(command.routeKey).cancel(adapterEnvelope.getAttemptId());
                            } else if (opcode == 6 || opcode == 7) {
                                DirichletAd dirichletAd = this.candidates.get(adapterEnvelope.getAdHandle());
                                if (dirichletAd == null || (settlement = command.settlement) == null) {
                                    throw new IllegalStateException("missing scheduler candidate");
                                }
                                applySettlement(dirichletAd, settlement);
                            } else if (opcode == 8) {
                                DirichletAd dirichletAd2 = this.candidates.get(adapterEnvelope.getAdHandle());
                                if (dirichletAd2 == null) {
                                    throw new IllegalStateException("missing transfer candidate");
                                }
                                long jStageTransfer = MediationShowAdmissionBridge.stageTransfer(this.requestId, bArr, adapterEnvelope.getSequenceNo(), adapterEnvelope.getAdFormat());
                                if (jStageTransfer == 0) {
                                    throw new IllegalStateException("show lease stage failed");
                                }
                                MediationShowAdmissionBridge.bindTransferred(dirichletAd2, jStageTransfer, adapterEnvelope.getAdFormat());
                                this.candidates.remove(adapterEnvelope.getAdHandle(), dirichletAd2);
                                this.transferredCandidates.add(dirichletAd2);
                            } else {
                                if (opcode != 5) {
                                    throw new IllegalStateException("unknown scheduler command");
                                }
                                DirichletAd dirichletAd3 = this.candidates.get(adapterEnvelope.getAdHandle());
                                if (dirichletAd3 == null) {
                                    throw new IllegalStateException("missing destroy candidate");
                                }
                                dirichletAd3.destroy();
                                this.candidates.remove(adapterEnvelope.getAdHandle(), dirichletAd3);
                            }
                        }
                        i++;
                    } catch (Throwable th) {
                        th = th;
                        settle(bArr, i, false);
                        invalidate(describeFailure("command_failed", th));
                        return false;
                    }
                }
                if (settle(bArr, i, true)) {
                    deliverTerminal(decodedBatchDecode.terminalFilled);
                    return true;
                }
                invalidate("settlement_rejected");
                return false;
            } catch (Throwable th2) {
                th = th2;
                i = 0;
            }
        } catch (Throwable th3) {
            invalidate(describeFailure("claim_failed", th3));
            return false;
        }
    }

    public void fail(String str) {
        invalidate(str);
    }

    public boolean isValid() {
        return this.valid;
    }

    public byte[] registerCandidates(int i, List<DirichletAd> list, byte[] bArr) {
        if (this.valid) {
            return this.candidates.register(i, list, bArr);
        }
        return null;
    }
}
