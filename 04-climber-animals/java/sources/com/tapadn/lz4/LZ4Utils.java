package com.tapadn.lz4;

/* JADX INFO: loaded from: classes3.dex */
enum LZ4Utils {
    ;

    private static final int MAX_INPUT_SIZE = 2113929216;

    static class Match {
        int len;
        int ref;
        int start;

        Match() {
        }

        int end() {
            return this.start + this.len;
        }

        void fix(int i) {
            this.start += i;
            this.ref += i;
            this.len -= i;
        }
    }

    static void copyTo(Match match, Match match2) {
        match2.len = match.len;
        match2.start = match.start;
        match2.ref = match.ref;
    }

    static int hash(int i) {
        return (i * (-1640531535)) >>> 20;
    }

    static int hash64k(int i) {
        return (i * (-1640531535)) >>> 19;
    }

    static int hashHC(int i) {
        return (i * (-1640531535)) >>> 17;
    }

    static int maxCompressedLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("length must be >= 0, got " + i);
        }
        if (i < MAX_INPUT_SIZE) {
            return i + (i / 255) + 16;
        }
        throw new IllegalArgumentException("length must be < 2113929216");
    }
}
