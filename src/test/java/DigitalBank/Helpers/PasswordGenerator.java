package DigitalBank.Helpers;

import java.security.SecureRandom;

public class PasswordGenerator
{
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuwxyz";
    private static final String NUMERIC = "0123456789";

    private static SecureRandom random = new SecureRandom();
    private static final char[] dic = (UPPER_CASE + LOWER_CASE + NUMERIC).toCharArray();

    public static String generatePassword(int len)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++)
        {
            builder.append(dic[random.nextInt(dic.length)]);
        }

        return builder.toString();
    }
}
