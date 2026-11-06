package com.tapsdk.tapad.internal.ionia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class IoniaInstalledApps {
    static final int COMMAND = 29;
    static final int MAX_BYTES = 2097152;
    static final int VERSION = 1;

    public static final class App {
        public final long firstInstallTimeMs;
        public final String installSource;
        public final String label;
        public final long lastUpdateTimeMs;
        public final String packageName;
        public final String signatureSha1;
        public final boolean systemApp;
        public final int targetSdk;
        public final long versionCode;
        public final String versionName;

        private App(Codec.Reader reader) {
            this.packageName = reader.readStr();
            this.versionName = reader.readStr();
            this.versionCode = reader.readU64();
            this.firstInstallTimeMs = reader.readU64();
            this.lastUpdateTimeMs = reader.readU64();
            this.signatureSha1 = reader.readStr();
            this.installSource = reader.readStr();
            this.label = reader.readStr();
            int u32 = reader.readU32();
            if (u32 != 0 && u32 != 1) {
                throw new Codec.CodecException("system flag");
            }
            this.systemApp = u32 == 1;
            this.targetSdk = reader.readU32();
        }
    }

    public interface Callback {
        void onResult(Result result);
    }

    public static final class Result {
        public final List<App> apps;
        public final Status status;

        private Result(Status status, List<App> list) {
            this.status = status;
            this.apps = Collections.unmodifiableList(new ArrayList(list));
        }
    }

    public enum Status {
        OK,
        DENIED,
        UNAVAILABLE,
        UNSUPPORTED
    }

    private IoniaInstalledApps() {
    }

    public static Result decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return empty(Status.UNSUPPORTED);
        }
        if (bArr.length > 2097164) {
            return empty(Status.UNAVAILABLE);
        }
        try {
            Codec.Reader reader = new Codec.Reader(bArr);
            int u32 = reader.readU32();
            byte[] bytes = reader.readBytes();
            if (reader.remaining() != 0) {
                return empty(Status.UNAVAILABLE);
            }
            Codec.Reader reader2 = new Codec.Reader(bytes);
            if (reader2.readU32() != 1) {
                return empty(Status.UNSUPPORTED);
            }
            if (u32 != 0) {
                if (reader2.remaining() != 0) {
                    return empty(Status.UNAVAILABLE);
                }
                return empty(u32 == 1 ? Status.DENIED : Status.UNAVAILABLE);
            }
            int u33 = reader2.readU32();
            if (u33 >= 0 && u33 <= 800) {
                ArrayList arrayList = new ArrayList(u33);
                int i = 0;
                while (true) {
                    if (i >= u33) {
                        break;
                    }
                    arrayList.add(new App(reader2));
                    i++;
                }
                return reader2.remaining() != 0 ? empty(Status.UNAVAILABLE) : new Result(Status.OK, arrayList);
            }
            return empty(Status.UNAVAILABLE);
        } catch (RuntimeException e) {
            return empty(Status.UNAVAILABLE);
        }
    }

    public static Result empty(Status status) {
        return new Result(status, Collections.EMPTY_LIST);
    }
}
