package com.taptap.sdk.update.download;

import android.os.SystemClock;
import com.taptap.sdk.update.download.core.Util;

/* JADX INFO: loaded from: classes3.dex */
public class SpeedCalculator {
    long allIncreaseBytes;
    long beginTimestamp;
    long bytesPerSecond;
    long endTimestamp;
    long increaseBytes;
    long timestamp;

    public synchronized void reset() {
        this.timestamp = 0L;
        this.increaseBytes = 0L;
        this.bytesPerSecond = 0L;
        this.beginTimestamp = 0L;
        this.endTimestamp = 0L;
        this.allIncreaseBytes = 0L;
    }

    long nowMillis() {
        return SystemClock.uptimeMillis();
    }

    public synchronized void downloading(long increaseBytes) {
        if (this.timestamp == 0) {
            long jNowMillis = nowMillis();
            this.timestamp = jNowMillis;
            this.beginTimestamp = jNowMillis;
        }
        this.increaseBytes += increaseBytes;
        this.allIncreaseBytes += increaseBytes;
    }

    public synchronized void flush() {
        long nowMillis = nowMillis();
        long sinceNowIncreaseBytes = this.increaseBytes;
        long durationMillis = Math.max(1L, nowMillis - this.timestamp);
        this.increaseBytes = 0L;
        this.timestamp = nowMillis;
        this.bytesPerSecond = (long) ((sinceNowIncreaseBytes / durationMillis) * 1000.0f);
    }

    public long getInstantBytesPerSecondAndFlush() {
        flush();
        return this.bytesPerSecond;
    }

    public synchronized long getBytesPerSecondAndFlush() {
        long interval = nowMillis() - this.timestamp;
        if (interval < 1000) {
            long j = this.bytesPerSecond;
            if (j != 0) {
                return j;
            }
        }
        if (this.bytesPerSecond == 0 && interval < 500) {
            return 0L;
        }
        return getInstantBytesPerSecondAndFlush();
    }

    public synchronized long getBytesPerSecondFromBegin() {
        long sinceNowIncreaseBytes;
        long durationMillis;
        long endTimestamp = this.endTimestamp;
        if (endTimestamp == 0) {
            endTimestamp = nowMillis();
        }
        sinceNowIncreaseBytes = this.allIncreaseBytes;
        durationMillis = Math.max(1L, endTimestamp - this.beginTimestamp);
        return (long) ((sinceNowIncreaseBytes / durationMillis) * 1000.0f);
    }

    public synchronized void endTask() {
        this.endTimestamp = nowMillis();
    }

    public String instantSpeed() {
        return getSpeedWithSIAndFlush();
    }

    public String speed() {
        return humanReadableSpeed(getBytesPerSecondAndFlush(), true);
    }

    public String lastSpeed() {
        return humanReadableSpeed(this.bytesPerSecond, true);
    }

    public synchronized long getInstantSpeedDurationMillis() {
        return nowMillis() - this.timestamp;
    }

    public String getSpeedWithBinaryAndFlush() {
        return humanReadableSpeed(getInstantBytesPerSecondAndFlush(), false);
    }

    public String getSpeedWithSIAndFlush() {
        return humanReadableSpeed(getInstantBytesPerSecondAndFlush(), true);
    }

    public String averageSpeed() {
        return speedFromBegin();
    }

    public String speedFromBegin() {
        return humanReadableSpeed(getBytesPerSecondFromBegin(), true);
    }

    private static String humanReadableSpeed(long bytes, boolean si) {
        return Util.humanReadableBytes(bytes, si) + "/s";
    }
}
