package com.zhytnik.converter.example;

/**
 * @author Alexey Zhytnik
 * @since 04-Sep-16
 */
class Logger {

    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int CYAN = 3;
    public static final int YELLOW = 4;

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_YELLOW = "\u001B[32m";

    public static void log(String s) {
        System.out.println(s);
    }

    public static void log(Object obj, int color) {
        log(obj.toString(), color);
    }

    public static void log(String s, int color) {
        switch (color) {
            case RED:
                red(s);
                return;
            case BLUE:
                blue(s);
                return;
            case CYAN:
                cyan(s);
                return;
            case YELLOW:
                yellow(s);
                return;
            default:
                System.out.println(s);
        }
    }

    private static void red(String s) {
        System.out.println(ANSI_RED + s + ANSI_RESET);
    }

    private static void blue(String s) {
        System.out.println(ANSI_BLUE + s + ANSI_RESET);
    }

    private static void cyan(String s) {
        System.out.println(ANSI_CYAN + s + ANSI_RESET);
    }

    private static void yellow(String s) {
        System.out.println(ANSI_YELLOW + s + ANSI_RESET);
    }

    public static void printDelimiter() {
        System.out.println(ANSI_WHITE + "- - - - - - - - - - - - - - - - - - - - - - - - -" + ANSI_RESET);
    }
}
