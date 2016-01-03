package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 */
public class prob5_8_ {
    public static void main(String[] args) {
        int width = 16;
        int height = 6;
        byte[] screen = new byte[width / 8 * height];

        for (int i = 0; i < width / 8 * height; i++) {
            screen[i] = 0x0;
        }

        drawHorizontalLine(screen, width, 3, 8, 3);

        for (int i = 0; i < width / 8 * height; i++) {
            System.out.print(toBinaryString(screen[i]));
            System.out.print(" ");
            if (i % (width / 8) == 1) {
                System.out.println();
            }
        }
    }

    public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        int byteNum = width / 8;

        if (x1 < 0 || x2 < 0) {
            return;
        }

        if (x1 > width || x2 > width) {
            return;
        }

        if (y < 0 || y > screen.length / byteNum) {
            return;
        }

        int heightIndex = byteNum * (y - 1) - 1;

        int startIndex = x1 / 8;
        int startOffset = x1 % 8;

        if (startOffset != 0) {
            startIndex++;
            screen[startIndex + heightIndex] |= 0xFF >>> (startOffset - 1);
        } else {
            screen[startIndex + heightIndex] |= 1;
        }
        startIndex++;

        int endIndex = x2 / 8;
        int endOffset = x2 % 8;

        if (endOffset != 0) {
            screen[endIndex + heightIndex + 1] |= 0xFF << (8 - endOffset);
        }

        for (int i = startIndex; i <= endIndex; i++) {
            screen[i + heightIndex] = (byte) 0xFF;
        }
    }

    public static String toBinaryString(byte b) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            if ((b & 1) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            b >>= 1;
        }

        return sb.reverse().toString();
    }
}
