package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.Defcon;

/* JADX INFO: loaded from: classes3.dex */
public class ReportPolicy {
    public static final int BATCH_AT_LAUNCH = 1;
    static final int BATCH_AT_TERMINATE = 2;
    public static final int BATCH_BY_INTERVAL = 6;
    public static final int DAILY = 4;
    static final int IMMEDIATE = 3;
    public static final int QUASI_REALTIME_POLICY = 11;
    public static final int REALTIME = 0;
    public static final int SMART_POLICY = 8;
    public static final int WIFIONLY = 5;

    public static boolean isValid(int i) {
        if (i != 8 && i != 11) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static class ReportStrategy {
        public boolean shouldSendMessage(boolean z) {
            return true;
        }

        public boolean isValid() {
            return true;
        }
    }

    public static class ReportQuasiRealtime extends ReportStrategy {
        private long mReportInterval;
        private static long DEFAULT_REPORT_INTERVAL = IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS;
        private static long MIN_REPORT_INTERVAL = 3000;
        private static long MAX_REPORT_INTERVAL = 90000;

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return true;
        }

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public void setReportInterval(long j) {
            if (j >= MIN_REPORT_INTERVAL && j <= MAX_REPORT_INTERVAL) {
                this.mReportInterval = j;
            } else {
                this.mReportInterval = DEFAULT_REPORT_INTERVAL;
            }
        }
    }

    public static class ReportRealtime extends ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return true;
        }
    }

    public static class ReportAtLaunch extends ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return z;
        }
    }

    public static class ReportByInterval extends ReportStrategy {
        private long mReportInterval;
        private StatTracer mTracer;
        private static long MIN_REPORT_INTERVAL = 90000;
        private static long MAX_REPORT_INTERVAL = 86400000;

        public ReportByInterval(StatTracer statTracer, long j) {
            this.mTracer = statTracer;
            setReportInterval(j);
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            if (z || System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.mReportInterval) {
                return true;
            }
            return false;
        }

        public void setReportInterval(long j) {
            if (j >= MIN_REPORT_INTERVAL && j <= MAX_REPORT_INTERVAL) {
                this.mReportInterval = j;
            } else {
                this.mReportInterval = MIN_REPORT_INTERVAL;
            }
        }

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public static boolean isValidValue(int i) {
            if (i < MIN_REPORT_INTERVAL) {
                return false;
            }
            return true;
        }
    }

    public static class ReportDaily extends ReportStrategy {
        private long HOURS_DAY = 86400000;
        private StatTracer mTracer;

        public ReportDaily(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            if (System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.HOURS_DAY) {
                return true;
            }
            return false;
        }
    }

    public static class ReportWifiOnly extends ReportStrategy {
        private Context mContext;

        public ReportWifiOnly(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            return DeviceConfig.isWiFiAvailable(this.mContext);
        }
    }

    public static class DefconPolicy extends ReportStrategy {
        private Defcon defcon;
        private StatTracer tracer;

        public DefconPolicy(StatTracer statTracer, Defcon defcon) {
            this.tracer = statTracer;
            this.defcon = defcon;
        }

        public boolean shouldSendMessageByInstant() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - UMEnvelopeBuild.getLastInstantBuildTime(UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval()) {
                return true;
            }
            return false;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval()) {
                return true;
            }
            return false;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            return this.defcon.isOpen();
        }
    }

    public static class LatentPolicy extends ReportStrategy {
        private long latency;
        private long start;

        public LatentPolicy(int i) {
            this.start = 0L;
            this.latency = i;
            this.start = System.currentTimeMillis();
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            if (System.currentTimeMillis() - this.start >= this.latency) {
                return true;
            }
            return false;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            return System.currentTimeMillis() - this.start < this.latency;
        }
    }

    public static class SmartPolicy extends ReportStrategy {
        private final long ReportInterval = 10800000;
        private StatTracer mTracer;

        public SmartPolicy(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            if (System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= 10800000) {
                return true;
            }
            return false;
        }
    }

    public static class DebugPolicy extends ReportStrategy {
        private final long ReportInterval = IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS;
        private StatTracer mTracer;

        public DebugPolicy(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z) {
            if (System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS) {
                return true;
            }
            return false;
        }
    }
}
