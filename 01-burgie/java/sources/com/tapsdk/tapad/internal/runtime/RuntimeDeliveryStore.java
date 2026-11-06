package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.AtomicFile;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class RuntimeDeliveryStore {
    private static final String ASSIGNMENT_CORRUPT_MARKER = "__dirichlet_assignment_ledger_corrupt_v1__";
    private static final String ASSIGNMENT_EVENT_HASH = "306d9f00";
    private static final String ASSIGNMENT_EVENT_PREFIX = "asg_v1_";
    static final String ASSIGNMENT_KEY = "assignment_deliveries_v1";
    private static final String ASSIGNMENT_LOCK = ".sirius-assignment.lock";
    static final String ASSIGNMENT_NAMESPACE = "dirichlet_sirius_experiment";
    private static final int ASSIGNMENT_SCHEMA_VERSION = 1;
    private static final String ASSIGNMENT_STATE = "sirius-assignment.json";
    private static final int ASSIGNMENT_WRITE_MERGED = 2;
    private static final String LOCK = ".mediation.lock";
    private static final int MAX_ASSIGNMENT_DELIVERIES = 256;
    private static final int MAX_ASSIGNMENT_STATE_BYTES = 262144;
    private static final int MAX_STATE_BYTES = 262144;
    static final int NOT_HANDLED = Integer.MIN_VALUE;
    private static final Object PROCESS_LOCK = new Object();
    private static final int SCHEMA_VERSION = 1;
    private static final String STATE = "mediation.json";
    private static final String TAG = "RuntimeDeliveryStore";

    public static final class AssignmentEntry {
        final JSONObject event;
        final String eventId;
        final long eventTimeMs;
        final long sequence;
        final String status;

        public AssignmentEntry(JSONObject jSONObject) throws IOException {
            String strRequiredString = RuntimeDeliveryStore.requiredString(jSONObject, "event_id");
            this.eventId = strRequiredString;
            if (!RuntimeDeliveryStore.isAssignmentEventId(strRequiredString)) {
                throw new IOException("invalid assignment event id");
            }
            long jRequiredLong = RuntimeDeliveryStore.requiredLong(jSONObject, "event_time_ms");
            this.eventTimeMs = jRequiredLong;
            if (jRequiredLong <= 0) {
                throw new IOException("invalid assignment event time");
            }
            String strRequiredString2 = RuntimeDeliveryStore.requiredString(jSONObject, NotificationCompat.CATEGORY_STATUS);
            this.status = strRequiredString2;
            if (!"ready".equals(strRequiredString2) && !"in_flight".equals(strRequiredString2) && !"delivered".equals(strRequiredString2)) {
                throw new IOException("invalid assignment delivery status");
            }
            long jRequiredLong2 = RuntimeDeliveryStore.requiredLong(jSONObject, "sequence");
            this.sequence = jRequiredLong2;
            if (jRequiredLong2 < 0) {
                throw new IOException("invalid assignment sequence");
            }
            Object objOpt = jSONObject.opt(NotificationCompat.CATEGORY_EVENT);
            if (!(objOpt instanceof JSONObject)) {
                throw new IOException("missing assignment event");
            }
            JSONObject jSONObject2 = new JSONObject(objOpt.toString());
            this.event = jSONObject2;
            RuntimeDeliveryStore.validateEvent(jSONObject2, strRequiredString, jRequiredLong);
        }

        public JSONObject toJson() {
            return new JSONObject().put("event_id", this.eventId).put("event_time_ms", this.eventTimeMs).put(NotificationCompat.CATEGORY_STATUS, this.status).put("sequence", this.sequence).put(NotificationCompat.CATEGORY_EVENT, new JSONObject(this.event.toString()));
        }
    }

    public interface LockedOperation<T> {
        T run(File file);
    }

    private RuntimeDeliveryStore() {
    }

    private static Context applicationContext(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static File canonical(File file) {
        return file.getCanonicalFile();
    }

    public static void clearForTests(Context context) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext == null) {
            return;
        }
        try {
            withLock(contextApplicationContext, new LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$$ExternalSyntheticLambda4
                @Override // com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore.LockedOperation
                public final Object run(File file) {
                    return RuntimeDeliveryStore.lambda$clearForTests$2(file);
                }
            });
        } catch (Throwable th) {
        }
    }

    private static int copyString(String str, byte[] bArr) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bArr != null && bArr.length > 0) {
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, bArr.length));
        }
        return bytes.length;
    }

    private static String decodeUtf8(byte[] bArr) {
        CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr)).toString();
    }

    private static int deliveryStatusRank(String str) {
        if ("delivered".equals(str)) {
            return 3;
        }
        return "in_flight".equals(str) ? 2 : 1;
    }

    public static int handleAssignmentStorage(Context context, int i, String str, byte[] bArr) {
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("namespace", "");
            String strOptString2 = jSONObject.optString("key", "");
            boolean z = ASSIGNMENT_NAMESPACE.equals(strOptString) && ASSIGNMENT_KEY.equals(strOptString2);
            boolean z2 = i == 4 && ASSIGNMENT_NAMESPACE.equals(strOptString) && strOptString2.isEmpty();
            boolean z3 = i == 3 && ASSIGNMENT_NAMESPACE.equals(strOptString) && isAssignmentEventId(strOptString2);
            if (!z && !z2 && !z3) {
                return Integer.MIN_VALUE;
            }
            if (z3) {
                return removeAssignmentDelivery(context, strOptString2) ? 1 : -1;
            }
            switch (i) {
                case 0:
                    return readAssignmentLedger(context) == null ? 0 : 1;
                case 1:
                    String assignmentLedger = readAssignmentLedger(context);
                    if (assignmentLedger == null) {
                        return -1;
                    }
                    return copyString(assignmentLedger, bArr);
                case 2:
                    Object objOpt = jSONObject.opt(Constants.VALUE_FIELD);
                    if ("string".equals(jSONObject.optString("type", "string")) && (objOpt instanceof String)) {
                        return writeAssignmentLedgerResult(context, (String) objOpt);
                    }
                    return -1;
                case 3:
                case 4:
                    return removeAssignmentLedger(context) ? 1 : -1;
                default:
                    return -1;
            }
        } catch (Throwable th) {
            return Integer.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAssignmentEventId(String str) {
        return str != null && str.startsWith(ASSIGNMENT_EVENT_PREFIX) && str.getBytes(StandardCharsets.UTF_8).length <= 128;
    }

    private static boolean isPositiveInteger(String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        try {
            return Long.parseLong(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean jsonSimilar(Object obj, Object obj2) {
        Object obj3;
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null || obj == (obj3 = JSONObject.NULL) || obj2 == obj3) {
            return false;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!jSONObject2.has(next) || !jsonSimilar(jSONObject.opt(next), jSONObject2.opt(next))) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            return ((obj instanceof Number) && (obj2 instanceof Number)) ? obj.toString().equals(obj2.toString()) : obj.equals(obj2);
        }
        JSONArray jSONArray = (JSONArray) obj;
        JSONArray jSONArray2 = (JSONArray) obj2;
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!jsonSimilar(jSONArray.opt(i), jSONArray2.opt(i))) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ Object lambda$clearForTests$2(File file) {
        new AtomicFile(new File(file, STATE)).delete();
        return null;
    }

    static /* synthetic */ JSONObject lambda$read$0(File file) throws IOException {
        JSONObject jSONObjectOptJSONObject;
        try {
            FileInputStream fileInputStreamOpenRead = new AtomicFile(new File(file, STATE)).openRead();
            try {
                byte[] bounded = readBounded(fileInputStreamOpenRead);
                if (fileInputStreamOpenRead != null) {
                    fileInputStreamOpenRead.close();
                }
                JSONObject jSONObject = new JSONObject(new String(bounded, StandardCharsets.UTF_8));
                if (jSONObject.optInt("schema_version", 0) == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("runtime_delivery")) != null) {
                    return new JSONObject(jSONObjectOptJSONObject.toString());
                }
                return null;
            } catch (Throwable th) {
                if (fileInputStreamOpenRead != null) {
                    try {
                        fileInputStreamOpenRead.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    static /* synthetic */ Boolean lambda$removeAssignmentDelivery$6(String str, File file) throws IOException {
        String assignmentLedgerFile = readAssignmentLedgerFile(file);
        if (assignmentLedgerFile == null) {
            return Boolean.TRUE;
        }
        AssignmentLedger assignmentLedger = new AssignmentLedger(assignmentLedgerFile);
        boolean z = assignmentLedger.entries.remove(str) != null;
        if (!z && !assignmentLedger.hasRevision) {
            return Boolean.TRUE;
        }
        if (z && !assignmentLedger.hasRevision) {
            assignmentLedger.hasRevision = true;
            assignmentLedger.revision = 1L;
        } else if (assignmentLedger.hasRevision) {
            long j = assignmentLedger.revision;
            long j2 = LongCompanionObject.MAX_VALUE;
            if (j != LongCompanionObject.MAX_VALUE) {
                j2 = j + 1;
            }
            assignmentLedger.revision = j2;
        }
        byte[] bytes = assignmentLedger.encode().getBytes(StandardCharsets.UTF_8);
        return (bytes.length <= 0 || bytes.length > 262144) ? Boolean.FALSE : Boolean.valueOf(writeAtomic(new AtomicFile(stateFile(file, ASSIGNMENT_STATE)), bytes));
    }

    static /* synthetic */ Boolean lambda$removeAssignmentLedger$5(File file) {
        new AtomicFile(stateFile(file, ASSIGNMENT_STATE)).delete();
        return Boolean.TRUE;
    }

    static /* synthetic */ Integer lambda$writeAssignmentLedgerResult$4(AssignmentLedger assignmentLedger, File file) throws IOException {
        AssignmentLedger assignmentLedger2;
        AtomicFile atomicFile = new AtomicFile(stateFile(file, ASSIGNMENT_STATE));
        String assignmentLedgerFile = readAssignmentLedgerFile(file);
        AssignmentLedger assignmentLedger3 = new AssignmentLedger();
        if (assignmentLedgerFile != null) {
            assignmentLedger2 = new AssignmentLedger(assignmentLedgerFile);
            assignmentLedger3.addAll(assignmentLedger2);
        } else {
            assignmentLedger2 = null;
        }
        int i = 1;
        boolean z = assignmentLedger.hasWriteMetadata && assignmentLedger2 != null && assignmentLedger2.hasRevision && assignmentLedger2.revision > assignmentLedger.baseRevision;
        for (AssignmentEntry assignmentEntry : assignmentLedger.entries.values()) {
            if (!z || assignmentLedger3.entries.containsKey(assignmentEntry.eventId) || assignmentLedger.newEventIds.contains(assignmentEntry.eventId)) {
                assignmentLedger3.add(assignmentEntry);
            }
        }
        boolean z2 = assignmentLedger.hasWriteMetadata;
        if (z2 || (assignmentLedger2 != null && assignmentLedger2.hasRevision)) {
            assignmentLedger3.hasRevision = true;
            long j = 1;
            if (assignmentLedger2 != null) {
                long j2 = assignmentLedger2.revision;
                j = j2 == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : 1 + j2;
            }
            assignmentLedger3.revision = j;
        }
        byte[] bytes = assignmentLedger3.encode().getBytes(StandardCharsets.UTF_8);
        if (bytes.length <= 0 || bytes.length > 262144) {
            return -1;
        }
        if (!writeAtomic(atomicFile, bytes)) {
            i = -1;
        } else if (z2) {
            i = 2;
        }
        return Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AssignmentEntry mergeEntries(AssignmentEntry assignmentEntry, AssignmentEntry assignmentEntry2) throws IOException {
        if (assignmentEntry.eventTimeMs != assignmentEntry2.eventTimeMs || !jsonSimilar(assignmentEntry.event, assignmentEntry2.event)) {
            throw new IOException("conflicting assignment event id");
        }
        int iDeliveryStatusRank = deliveryStatusRank(assignmentEntry.status);
        int iDeliveryStatusRank2 = deliveryStatusRank(assignmentEntry2.status);
        return (iDeliveryStatusRank2 <= iDeliveryStatusRank && (iDeliveryStatusRank2 < iDeliveryStatusRank || assignmentEntry2.sequence <= assignmentEntry.sequence)) ? assignmentEntry : assignmentEntry2;
    }

    public static JSONObject read(Context context) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext == null) {
            return null;
        }
        try {
            return (JSONObject) withLock(contextApplicationContext, new LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$$ExternalSyntheticLambda6
                @Override // com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore.LockedOperation
                public final Object run(File file) {
                    return RuntimeDeliveryStore.lambda$read$0(file);
                }
            });
        } catch (Throwable th) {
            return null;
        }
    }

    public static String readAssignmentLedger(Context context) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext == null) {
            return null;
        }
        try {
            return (String) withLock(contextApplicationContext, ASSIGNMENT_LOCK, new LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$$ExternalSyntheticLambda1
                @Override // com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore.LockedOperation
                public final Object run(File file) {
                    return RuntimeDeliveryStore.readAssignmentLedgerFile(file);
                }
            });
        } catch (Throwable th) {
            return ASSIGNMENT_CORRUPT_MARKER;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readAssignmentLedgerFile(File file) throws IOException {
        try {
            FileInputStream fileInputStreamOpenRead = new AtomicFile(stateFile(file, ASSIGNMENT_STATE)).openRead();
            try {
                byte[] bounded = readBounded(fileInputStreamOpenRead, 262144);
                if (fileInputStreamOpenRead != null) {
                    fileInputStreamOpenRead.close();
                }
                return decodeUtf8(bounded);
            } catch (Throwable th) {
                if (fileInputStreamOpenRead != null) {
                    try {
                        fileInputStreamOpenRead.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private static byte[] readBounded(FileInputStream fileInputStream) {
        return readBounded(fileInputStream, 262144);
    }

    private static boolean removeAssignmentDelivery(Context context, final String str) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext != null && isAssignmentEventId(str)) {
            try {
                return ((Boolean) withLock(contextApplicationContext, ASSIGNMENT_LOCK, new LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$$ExternalSyntheticLambda5
                    @Override // com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore.LockedOperation
                    public final Object run(File file) {
                        return RuntimeDeliveryStore.lambda$removeAssignmentDelivery$6(str, file);
                    }
                })).booleanValue();
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static boolean removeAssignmentLedger(Context context) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext == null) {
            return false;
        }
        try {
            return ((Boolean) withLock(contextApplicationContext, ASSIGNMENT_LOCK, new LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$$ExternalSyntheticLambda3
                @Override // com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore.LockedOperation
                public final Object run(File file) {
                    return RuntimeDeliveryStore.lambda$removeAssignmentLedger$5(file);
                }
            })).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long requiredLong(JSONObject jSONObject, String str) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if ((objOpt instanceof Integer) || (objOpt instanceof Long)) {
            return ((Number) objOpt).longValue();
        }
        throw new IOException(c.a("missing integer field: ", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String requiredString(JSONObject jSONObject, String str) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        throw new IOException(c.a("missing string field: ", str));
    }

    private static File stateFile(File file, String str) throws IOException {
        File fileCanonical = canonical(new File(file, str));
        if (file.equals(fileCanonical.getParentFile())) {
            return fileCanonical;
        }
        throw new IOException("runtime delivery state escaped root");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateEvent(JSONObject jSONObject, String str, long j) throws IOException {
        if (!ASSIGNMENT_EVENT_HASH.equals(requiredString(jSONObject, "event_hash")) || !str.equals(requiredString(jSONObject, "delivery_token"))) {
            throw new IOException("invalid assignment event envelope");
        }
        Object objOpt = jSONObject.opt("fields");
        if (!(objOpt instanceof JSONObject)) {
            throw new IOException("missing assignment event fields");
        }
        JSONObject jSONObject2 = (JSONObject) objOpt;
        if (!str.equals(requiredString(jSONObject2, "event_id")) || !str.equals(requiredString(jSONObject2, "assignment_id")) || j != requiredLong(jSONObject2, "event_time_ms")) {
            throw new IOException("invalid assignment event identity");
        }
        String strRequiredString = requiredString(jSONObject2, "assignment_unit");
        String strRequiredString2 = requiredString(jSONObject2, "assignment_key");
        if (strRequiredString2.trim().isEmpty() || !("adn_did".equals(strRequiredString) || com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID.equals(strRequiredString))) {
            throw new IOException("invalid assignment unit");
        }
        if (com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID.equals(strRequiredString)) {
            if (!strRequiredString2.trim().equals(requiredString(jSONObject2, com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID).trim())) {
                throw new IOException("invalid request assignment identity");
            }
        } else if (!strRequiredString2.trim().equals(requiredString(jSONObject2, "adn_did").trim())) {
            throw new IOException("invalid ADN assignment identity");
        }
        if (requiredString(jSONObject2, "experiment_id").isEmpty() || requiredString(jSONObject2, "vid").isEmpty() || requiredString(jSONObject2, "feature_key").isEmpty() || requiredString(jSONObject2, "feature_keys").isEmpty() || !isPositiveInteger(requiredString(jSONObject2, "media_id"))) {
            throw new IOException("invalid assignment event metadata");
        }
        String strRequiredString3 = requiredString(jSONObject2, "product");
        String strRequiredString4 = requiredString(jSONObject2, Common.Predefined.SUB_OS_TYPE);
        if ((!"adn".equals(strRequiredString3) && !"mediation".equals(strRequiredString3)) || ((!"android".equals(strRequiredString4) && !"ios".equals(strRequiredString4)) || !"client_countly".equals(requiredString(jSONObject2, "event_source")))) {
            throw new IOException("invalid assignment event source");
        }
    }

    private static <T> T withLock(Context context, LockedOperation<T> lockedOperation) {
        return (T) withLock(context, LOCK, lockedOperation);
    }

    public static boolean write(Context context, JSONObject jSONObject) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext != null && jSONObject != null) {
            try {
                final byte[] bytes = new JSONObject().put("schema_version", 1).put("runtime_delivery", new JSONObject(jSONObject.toString())).toString().getBytes(StandardCharsets.UTF_8);
                if (bytes.length > 0 && bytes.length <= 262144) {
                    return ((Boolean) withLock(contextApplicationContext, new LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$$ExternalSyntheticLambda0
                        @Override // com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore.LockedOperation
                        public final Object run(File file) {
                            return Boolean.valueOf(RuntimeDeliveryStore.writeAtomic(new AtomicFile(new File(file, RuntimeDeliveryStore.STATE)), bytes));
                        }
                    })).booleanValue();
                }
                return false;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static boolean writeAssignmentLedger(Context context, String str) {
        return writeAssignmentLedgerResult(context, str) > 0;
    }

    public static int writeAssignmentLedgerResult(Context context, String str) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext != null && str != null) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (bytes.length > 0 && bytes.length <= 262144) {
                try {
                    final AssignmentLedger assignmentLedger = new AssignmentLedger(str);
                    return ((Integer) withLock(contextApplicationContext, ASSIGNMENT_LOCK, new LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$$ExternalSyntheticLambda2
                        @Override // com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore.LockedOperation
                        public final Object run(File file) {
                            return RuntimeDeliveryStore.lambda$writeAssignmentLedgerResult$4(assignmentLedger, file);
                        }
                    })).intValue();
                } catch (Throwable th) {
                }
            }
        }
        return -1;
    }

    private static boolean writeAtomic(AtomicFile atomicFile, byte[] bArr) {
        FileOutputStream fileOutputStreamStartWrite;
        try {
            fileOutputStreamStartWrite = atomicFile.startWrite();
            try {
                fileOutputStreamStartWrite.write(bArr);
                fileOutputStreamStartWrite.getFD().sync();
                atomicFile.finishWrite(fileOutputStreamStartWrite);
                return true;
            } catch (IOException e) {
                if (fileOutputStreamStartWrite == null) {
                    return false;
                }
                atomicFile.failWrite(fileOutputStreamStartWrite);
                return false;
            }
        } catch (IOException e2) {
            fileOutputStreamStartWrite = null;
        }
    }

    private static byte[] readBounded(FileInputStream fileInputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = fileInputStream.read(bArr);
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            if (byteArrayOutputStream.size() + i2 > i) {
                throw new IOException("runtime delivery state is too large");
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    private static <T> T withLock(Context context, String str, LockedOperation<T> lockedOperation) {
        T tRun;
        synchronized (PROCESS_LOCK) {
            File fileCanonical = canonical(context.getFilesDir());
            File fileCanonical2 = canonical(new File(fileCanonical, TapAdConfig.AggregationChannel.DIRICHLET));
            File fileCanonical3 = canonical(new File(fileCanonical2, "runtime-delivery"));
            if (!fileCanonical.equals(fileCanonical2.getParentFile()) || !fileCanonical2.equals(fileCanonical3.getParentFile())) {
                throw new IOException("runtime delivery path escaped app-private root");
            }
            if (!fileCanonical3.isDirectory() && !fileCanonical3.mkdirs()) {
                throw new IOException("cannot create runtime delivery root");
            }
            File fileCanonical4 = canonical(new File(fileCanonical3, str));
            if (!fileCanonical3.equals(fileCanonical4.getParentFile())) {
                throw new IOException("runtime delivery lock escaped root");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileCanonical4, "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    FileLock fileLockLock = channel.lock();
                    try {
                        tRun = lockedOperation.run(fileCanonical3);
                        if (fileLockLock != null) {
                            fileLockLock.close();
                        }
                        channel.close();
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
        return tRun;
    }

    public static final class AssignmentLedger {
        long baseRevision;
        boolean hasRevision;
        boolean hasWriteMetadata;
        long revision;
        final LinkedHashMap<String, AssignmentEntry> entries = new LinkedHashMap<>();
        final List<String> newEventIds = new ArrayList();

        public AssignmentLedger() {
        }

        static /* synthetic */ int lambda$encode$0(AssignmentEntry assignmentEntry, AssignmentEntry assignmentEntry2) {
            int iCompare = Long.compare(assignmentEntry.sequence, assignmentEntry2.sequence);
            return iCompare != 0 ? iCompare : assignmentEntry.eventId.compareTo(assignmentEntry2.eventId);
        }

        public void add(AssignmentEntry assignmentEntry) throws IOException {
            AssignmentEntry assignmentEntry2 = this.entries.get(assignmentEntry.eventId);
            LinkedHashMap<String, AssignmentEntry> linkedHashMap = this.entries;
            String str = assignmentEntry.eventId;
            if (assignmentEntry2 != null) {
                assignmentEntry = RuntimeDeliveryStore.mergeEntries(assignmentEntry2, assignmentEntry);
            }
            linkedHashMap.put(str, assignmentEntry);
        }

        public void addAll(AssignmentLedger assignmentLedger) throws IOException {
            Iterator<AssignmentEntry> it = assignmentLedger.entries.values().iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }

        public String encode() throws JSONException, IOException {
            if (this.entries.size() > 256) {
                throw new IOException("assignment ledger has too many entries");
            }
            ArrayList arrayList = new ArrayList(this.entries.values());
            Collections.sort(arrayList, new Comparator() { // from class: com.tapsdk.tapad.internal.runtime.RuntimeDeliveryStore$AssignmentLedger$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return RuntimeDeliveryStore.AssignmentLedger.lambda$encode$0((RuntimeDeliveryStore.AssignmentEntry) obj, (RuntimeDeliveryStore.AssignmentEntry) obj2);
                }
            });
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((AssignmentEntry) obj).toJson());
            }
            JSONObject jSONObjectPut = new JSONObject().put("version", 1);
            if (this.hasRevision || this.revision > 0) {
                jSONObjectPut.put("revision", this.revision);
            }
            jSONObjectPut.put("deliveries", jSONArray);
            return jSONObjectPut.toString();
        }

        public AssignmentLedger(String str) throws IOException {
            JSONObject jSONObject = new JSONObject(str);
            if (RuntimeDeliveryStore.requiredLong(jSONObject, "version") == 1) {
                Object objOpt = jSONObject.opt("deliveries");
                if (objOpt instanceof JSONArray) {
                    if (jSONObject.has("revision")) {
                        long jRequiredLong = RuntimeDeliveryStore.requiredLong(jSONObject, "revision");
                        this.revision = jRequiredLong;
                        if (jRequiredLong >= 0) {
                            this.hasRevision = true;
                        } else {
                            throw new IOException("invalid assignment revision");
                        }
                    }
                    if (jSONObject.has("base_revision")) {
                        long jRequiredLong2 = RuntimeDeliveryStore.requiredLong(jSONObject, "base_revision");
                        this.baseRevision = jRequiredLong2;
                        if (jRequiredLong2 >= 0) {
                            this.hasWriteMetadata = true;
                        } else {
                            throw new IOException("invalid assignment base revision");
                        }
                    }
                    if (jSONObject.has("new_event_ids")) {
                        Object objOpt2 = jSONObject.opt("new_event_ids");
                        if (objOpt2 instanceof JSONArray) {
                            this.hasWriteMetadata = true;
                            JSONArray jSONArray = (JSONArray) objOpt2;
                            if (jSONArray.length() <= 256) {
                                HashSet hashSet = new HashSet();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    Object objOpt3 = jSONArray.opt(i);
                                    if (objOpt3 instanceof String) {
                                        String str2 = (String) objOpt3;
                                        if (RuntimeDeliveryStore.isAssignmentEventId(str2) && hashSet.add(str2)) {
                                            this.newEventIds.add(str2);
                                        }
                                    }
                                    throw new IOException("invalid assignment new event id");
                                }
                            }
                            throw new IOException("too many assignment new event ids");
                        }
                        throw new IOException("invalid assignment new event ids");
                    }
                    JSONArray jSONArray2 = (JSONArray) objOpt;
                    if (jSONArray2.length() <= 256) {
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            Object objOpt4 = jSONArray2.opt(i2);
                            if (objOpt4 instanceof JSONObject) {
                                add(new AssignmentEntry((JSONObject) objOpt4));
                            } else {
                                throw new IOException("invalid assignment ledger entry");
                            }
                        }
                        Iterator<String> it = this.newEventIds.iterator();
                        while (it.hasNext()) {
                            if (!this.entries.containsKey(it.next())) {
                                throw new IOException("new assignment event is not in ledger");
                            }
                        }
                        return;
                    }
                    throw new IOException("assignment ledger has too many entries");
                }
                throw new IOException("missing assignment deliveries");
            }
            throw new IOException("unsupported assignment ledger version");
        }
    }
}
