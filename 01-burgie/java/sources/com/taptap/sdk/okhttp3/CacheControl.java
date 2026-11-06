package com.taptap.sdk.okhttp3;

import com.taptap.sdk.okhttp3.internal.http.HttpHeaders;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheControl {

    @Nullable
    String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    private CacheControl(boolean noCache, boolean noStore, int maxAgeSeconds, int sMaxAgeSeconds, boolean isPrivate, boolean isPublic, boolean mustRevalidate, int maxStaleSeconds, int minFreshSeconds, boolean onlyIfCached, boolean noTransform, boolean immutable, @Nullable String headerValue) {
        this.noCache = noCache;
        this.noStore = noStore;
        this.maxAgeSeconds = maxAgeSeconds;
        this.sMaxAgeSeconds = sMaxAgeSeconds;
        this.isPrivate = isPrivate;
        this.isPublic = isPublic;
        this.mustRevalidate = mustRevalidate;
        this.maxStaleSeconds = maxStaleSeconds;
        this.minFreshSeconds = minFreshSeconds;
        this.onlyIfCached = onlyIfCached;
        this.noTransform = noTransform;
        this.immutable = immutable;
        this.headerValue = headerValue;
    }

    CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
        this.immutable = builder.immutable;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean immutable() {
        return this.immutable;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00be  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:45:0x0105  */
    /* JADX WARN: Code duplicated, block: B:47:0x010d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0115  */
    /* JADX WARN: Code duplicated, block: B:50:0x011d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0125  */
    /* JADX WARN: Code duplicated, block: B:53:0x012d  */
    /* JADX WARN: Code duplicated, block: B:54:0x013a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0142  */
    /* JADX WARN: Code duplicated, block: B:57:0x014c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0154  */
    /* JADX WARN: Code duplicated, block: B:60:0x015b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0163  */
    /* JADX WARN: Code duplicated, block: B:63:0x016a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0172  */
    /* JADX WARN: Code duplicated, block: B:66:0x017a  */
    public static CacheControl parse(Headers headers) {
        int maxAgeSeconds;
        int pos;
        String parameter;
        int pos2;
        boolean noStore = false;
        int maxAgeSeconds2 = -1;
        int sMaxAgeSeconds = -1;
        boolean isPrivate = false;
        boolean isPublic = false;
        boolean mustRevalidate = false;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean onlyIfCached = false;
        boolean noTransform = false;
        boolean immutable = false;
        boolean canUseHeaderValue = true;
        String headerValue = null;
        int i = 0;
        boolean noCache = false;
        int size = headers.size();
        while (i < size) {
            int size2 = size;
            String name = headers.name(i);
            boolean immutable2 = immutable;
            String value = headers.value(i);
            if (name.equalsIgnoreCase("Cache-Control")) {
                if (headerValue != null) {
                    canUseHeaderValue = false;
                } else {
                    headerValue = value;
                }
            } else {
                if (name.equalsIgnoreCase("Pragma")) {
                    canUseHeaderValue = false;
                }
                immutable = immutable2;
                i++;
                size = size2;
            }
            int pos3 = 0;
            while (true) {
                String name2 = name;
                if (pos3 < value.length()) {
                    int tokenStart = pos3;
                    boolean noStore2 = noStore;
                    int pos4 = HttpHeaders.skipUntil(value, pos3, "=,;");
                    String directive = value.substring(tokenStart, pos4).trim();
                    int tokenStart2 = value.length();
                    if (pos4 == tokenStart2) {
                        maxAgeSeconds = maxAgeSeconds2;
                    } else {
                        maxAgeSeconds = maxAgeSeconds2;
                        if (value.charAt(pos4) != ',' && value.charAt(pos4) != ';') {
                            int pos5 = HttpHeaders.skipWhitespace(value, pos4 + 1);
                            if (pos5 < value.length() && value.charAt(pos5) == '\"') {
                                int pos6 = pos5 + 1;
                                int pos7 = HttpHeaders.skipUntil(value, pos6, "\"");
                                parameter = value.substring(pos6, pos7);
                                pos = pos7 + 1;
                            } else {
                                pos = HttpHeaders.skipUntil(value, pos5, ",;");
                                parameter = value.substring(pos5, pos).trim();
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(directive)) {
                            pos2 = pos;
                            noCache = true;
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("no-store".equalsIgnoreCase(directive)) {
                            pos2 = pos;
                            noStore = true;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else {
                            pos2 = pos;
                            if ("max-age".equalsIgnoreCase(directive)) {
                                maxAgeSeconds2 = HttpHeaders.parseSeconds(parameter, -1);
                                noStore = noStore2;
                            } else if ("s-maxage".equalsIgnoreCase(directive)) {
                                sMaxAgeSeconds = HttpHeaders.parseSeconds(parameter, -1);
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("private".equalsIgnoreCase(directive)) {
                                isPrivate = true;
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("public".equalsIgnoreCase(directive)) {
                                isPublic = true;
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("must-revalidate".equalsIgnoreCase(directive)) {
                                mustRevalidate = true;
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("max-stale".equalsIgnoreCase(directive)) {
                                maxStaleSeconds = HttpHeaders.parseSeconds(parameter, Integer.MAX_VALUE);
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("min-fresh".equalsIgnoreCase(directive)) {
                                minFreshSeconds = HttpHeaders.parseSeconds(parameter, -1);
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("only-if-cached".equalsIgnoreCase(directive)) {
                                onlyIfCached = true;
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("no-transform".equalsIgnoreCase(directive)) {
                                noTransform = true;
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else if ("immutable".equalsIgnoreCase(directive)) {
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            } else {
                                immutable2 = true;
                                noStore = noStore2;
                                maxAgeSeconds2 = maxAgeSeconds;
                            }
                        }
                        name = name2;
                        pos3 = pos2;
                    }
                    pos = pos4 + 1;
                    parameter = null;
                    if ("no-cache".equalsIgnoreCase(directive)) {
                        pos2 = pos;
                        noCache = true;
                        noStore = noStore2;
                        maxAgeSeconds2 = maxAgeSeconds;
                    } else if ("no-store".equalsIgnoreCase(directive)) {
                        pos2 = pos;
                        noStore = true;
                        maxAgeSeconds2 = maxAgeSeconds;
                    } else {
                        pos2 = pos;
                        if ("max-age".equalsIgnoreCase(directive)) {
                            maxAgeSeconds2 = HttpHeaders.parseSeconds(parameter, -1);
                            noStore = noStore2;
                        } else if ("s-maxage".equalsIgnoreCase(directive)) {
                            sMaxAgeSeconds = HttpHeaders.parseSeconds(parameter, -1);
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("private".equalsIgnoreCase(directive)) {
                            isPrivate = true;
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("public".equalsIgnoreCase(directive)) {
                            isPublic = true;
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("must-revalidate".equalsIgnoreCase(directive)) {
                            mustRevalidate = true;
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("max-stale".equalsIgnoreCase(directive)) {
                            maxStaleSeconds = HttpHeaders.parseSeconds(parameter, Integer.MAX_VALUE);
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("min-fresh".equalsIgnoreCase(directive)) {
                            minFreshSeconds = HttpHeaders.parseSeconds(parameter, -1);
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("only-if-cached".equalsIgnoreCase(directive)) {
                            onlyIfCached = true;
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("no-transform".equalsIgnoreCase(directive)) {
                            noTransform = true;
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else if ("immutable".equalsIgnoreCase(directive)) {
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        } else {
                            immutable2 = true;
                            noStore = noStore2;
                            maxAgeSeconds2 = maxAgeSeconds;
                        }
                    }
                    name = name2;
                    pos3 = pos2;
                }
            }
            immutable = immutable2;
            i++;
            size = size2;
        }
        boolean immutable3 = immutable;
        if (!canUseHeaderValue) {
            headerValue = null;
        }
        return new CacheControl(noCache, noStore, maxAgeSeconds2, sMaxAgeSeconds, isPrivate, isPublic, mustRevalidate, maxStaleSeconds, minFreshSeconds, onlyIfCached, noTransform, immutable3, headerValue);
    }

    public String toString() {
        String result = this.headerValue;
        if (result != null) {
            return result;
        }
        String strHeaderValue = headerValue();
        this.headerValue = strHeaderValue;
        return strHeaderValue;
    }

    private String headerValue() {
        StringBuilder result = new StringBuilder();
        if (this.noCache) {
            result.append("no-cache, ");
        }
        if (this.noStore) {
            result.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            result.append("max-age=").append(this.maxAgeSeconds).append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            result.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
        }
        if (this.isPrivate) {
            result.append("private, ");
        }
        if (this.isPublic) {
            result.append("public, ");
        }
        if (this.mustRevalidate) {
            result.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            result.append("max-stale=").append(this.maxStaleSeconds).append(", ");
        }
        if (this.minFreshSeconds != -1) {
            result.append("min-fresh=").append(this.minFreshSeconds).append(", ");
        }
        if (this.onlyIfCached) {
            result.append("only-if-cached, ");
        }
        if (this.noTransform) {
            result.append("no-transform, ");
        }
        if (this.immutable) {
            result.append("immutable, ");
        }
        if (result.length() == 0) {
            return "";
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

    public static final class Builder {
        boolean immutable;
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder maxAge(int maxAge, TimeUnit timeUnit) {
            int i;
            if (maxAge < 0) {
                throw new IllegalArgumentException("maxAge < 0: " + maxAge);
            }
            long maxAgeSecondsLong = timeUnit.toSeconds(maxAge);
            if (maxAgeSecondsLong > 2147483647L) {
                i = Integer.MAX_VALUE;
            } else {
                i = (int) maxAgeSecondsLong;
            }
            this.maxAgeSeconds = i;
            return this;
        }

        public Builder maxStale(int maxStale, TimeUnit timeUnit) {
            int i;
            if (maxStale < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + maxStale);
            }
            long maxStaleSecondsLong = timeUnit.toSeconds(maxStale);
            if (maxStaleSecondsLong > 2147483647L) {
                i = Integer.MAX_VALUE;
            } else {
                i = (int) maxStaleSecondsLong;
            }
            this.maxStaleSeconds = i;
            return this;
        }

        public Builder minFresh(int minFresh, TimeUnit timeUnit) {
            int i;
            if (minFresh < 0) {
                throw new IllegalArgumentException("minFresh < 0: " + minFresh);
            }
            long minFreshSecondsLong = timeUnit.toSeconds(minFresh);
            if (minFreshSecondsLong > 2147483647L) {
                i = Integer.MAX_VALUE;
            } else {
                i = (int) minFreshSecondsLong;
            }
            this.minFreshSeconds = i;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder immutable() {
            this.immutable = true;
            return this;
        }

        public CacheControl build() {
            return new CacheControl(this);
        }
    }
}
