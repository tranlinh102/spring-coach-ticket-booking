package com.coachticketbooking.common.id;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.UUID;

public class UuidUtils {
    private static final SecureRandom random = new SecureRandom();

    private UuidUtils() {}

    public static UUID randomV7() {
        byte[] bytes = new byte[16];

        // 1️⃣ Timestamp 60 bit = 6 byte (milliseconds * 10⁴ để lấy microseconds)
        long time = Instant.now().toEpochMilli() * 10000;
        bytes[0] = (byte) ((time >>> 40) & 0xFF);
        bytes[1] = (byte) ((time >>> 32) & 0xFF);
        bytes[2] = (byte) ((time >>> 24) & 0xFF);
        bytes[3] = (byte) ((time >>> 16) & 0xFF);
        bytes[4] = (byte) ((time >>> 8) & 0xFF);
        bytes[5] = (byte) (time & 0xFF);

        // 2️⃣ 4 bit version + 12 bit random
        byte[] rnd = new byte[10];
        random.nextBytes(rnd);

        bytes[6] = (byte) ((0x70) | ((rnd[0] >> 4) & 0x0F)); // version = 7
        bytes[7] = rnd[1];

        // 3️⃣ 2 bit variant (RFC 4122) + 62 bit random
        bytes[8] = (byte) ((rnd[2] & 0x3F) | 0x80);
        System.arraycopy(rnd, 3, bytes, 9, 7);

        // 4️⃣ Kết hợp thành UUID
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long high = bb.getLong();
        long low = bb.getLong();

        return new UUID(high, low);
    }
}
