package com.tapsdk.tapad.internal.runtime.download;

import com.byazt.fi.BaseConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidDownloadRequest {
    private final int apkVerifyType;
    private final int connectTimeout;
    private final long expectedSize;
    private final String fileName;
    private final Map<String, List<String>> headers;
    private final int maxRetries;
    private final String md5;
    private final int readTimeout;
    private final boolean resumable;
    private final String targetDirectory;
    private final List<Long> urlExpiryEpochSeconds;
    private final List<String> urls;

    public static class Builder {
        private String fileName;
        private Map<String, List<String>> headers;
        private int maxRetries;
        private String md5;
        private String targetDirectory;
        private final List<String> urls = new ArrayList();
        private final List<Long> urlExpiryEpochSeconds = new ArrayList();
        private long expectedSize = -1;
        private int apkVerifyType = -1;
        private boolean resumable = true;
        private int connectTimeout = 15000;
        private int readTimeout = BaseConstants.Time.MINUTE;

        public Builder apkVerifyType(int i) {
            this.apkVerifyType = i;
            return this;
        }

        public AndroidDownloadRequest build() {
            if (this.urls.isEmpty()) {
                throw new IllegalArgumentException("At least one URL is required");
            }
            String str = this.targetDirectory;
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("Target directory is required");
            }
            int i = this.connectTimeout;
            if (i <= 0) {
                i = 15000;
            }
            this.connectTimeout = i;
            int i2 = this.readTimeout;
            if (i2 <= 0) {
                i2 = BaseConstants.Time.MINUTE;
            }
            this.readTimeout = i2;
            this.maxRetries = Math.max(0, Math.min(this.maxRetries, 3));
            return new AndroidDownloadRequest(this);
        }

        public Builder connectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        public Builder expectedSize(long j) {
            this.expectedSize = j;
            return this;
        }

        public Builder fileName(String str) {
            this.fileName = str;
            return this;
        }

        public Builder header(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            List<String> arrayList = this.headers.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.headers.put(str, arrayList);
            }
            arrayList.add(str2);
            return this;
        }

        public Builder headers(Map<String, List<String>> map) {
            this.headers = map;
            return this;
        }

        public Builder maxRetries(int i) {
            this.maxRetries = i;
            return this;
        }

        public Builder md5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        public Builder resumable(boolean z) {
            this.resumable = z;
            return this;
        }

        public Builder targetDirectory(String str) {
            this.targetDirectory = str;
            return this;
        }

        public Builder url(String str) {
            return url(str, LongCompanionObject.MAX_VALUE);
        }

        public Builder url(String str, long j) {
            if (str != null && !str.isEmpty()) {
                this.urls.add(str);
                this.urlExpiryEpochSeconds.add(Long.valueOf(j));
            }
            return this;
        }
    }

    private static Map<String, List<String>> copyHeaders(Map<String, List<String>> map) {
        if (map == null || map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                map2.put(entry.getKey(), Collections.unmodifiableList(new ArrayList(entry.getValue())));
            }
        }
        return Collections.unmodifiableMap(map2);
    }

    public int getApkVerifyType() {
        return this.apkVerifyType;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public long getExpectedSize() {
        return this.expectedSize;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public int getMaxRetries() {
        return this.maxRetries;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPrimaryUrl() {
        if (this.urls.isEmpty()) {
            return null;
        }
        return this.urls.get(0);
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getTargetDirectory() {
        return this.targetDirectory;
    }

    public String getUrl(int i) {
        if (i < 0 || i >= this.urls.size()) {
            return null;
        }
        return this.urls.get(i);
    }

    public int getUrlCount() {
        return this.urls.size();
    }

    public long getUrlExpiryEpochSeconds(int i) {
        return (i < 0 || i >= this.urlExpiryEpochSeconds.size()) ? LongCompanionObject.MAX_VALUE : this.urlExpiryEpochSeconds.get(i).longValue();
    }

    public boolean isResumable() {
        return this.resumable;
    }

    public boolean isUrlValidAt(int i, long j) {
        return getUrlExpiryEpochSeconds(i) > j;
    }

    private AndroidDownloadRequest(Builder builder) {
        this.urls = new ArrayList(builder.urls);
        this.urlExpiryEpochSeconds = new ArrayList(builder.urlExpiryEpochSeconds);
        this.fileName = builder.fileName;
        this.targetDirectory = builder.targetDirectory;
        this.md5 = builder.md5;
        this.expectedSize = builder.expectedSize;
        this.apkVerifyType = builder.apkVerifyType;
        this.resumable = builder.resumable;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.maxRetries = builder.maxRetries;
        this.headers = copyHeaders(builder.headers);
    }
}
