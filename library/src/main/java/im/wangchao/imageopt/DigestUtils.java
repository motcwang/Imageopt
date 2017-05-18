package im.wangchao.imageopt;

import java.security.MessageDigest;

/**
 * <p>Description  : Digest.</p>
 * <p/>
 * <p>Author       : wangchao.</p>
 * <p>Date         : 15/12/16.</p>
 * <p>Time         : 下午3:27.</p>
 */
/*package*/ class DigestUtils {
    /**
     * 摘要码
     */
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int BUFFER_SIZE = 4096;

    private DigestUtils() {
        throw new AssertionError();
    }

    /**
     * encode String
     */
    public static String md5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new String(encodeHex(messageDigest.digest()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * byte[] to hexadecimal char[]
     */
    private static char[] encodeHex(final byte[] data) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return out;
    }
}
