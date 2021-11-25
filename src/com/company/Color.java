package com.company;

public class Color {
    // Constants
    private static final int colorOffset = 8;
    public static final Color BLACK = new Color();
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);

    // Main
    public static void main(String[] args) {
        ColorVisualizer colorVisualizer = new ColorVisualizer(WHITE);
        colorVisualizer = new ColorVisualizer(RED.complementaryColor());
        colorVisualizer = new ColorVisualizer(BLUE.mixColor(GREEN));
    }

    // Attributes
    private int rgb;

    // Constructors
    public Color() {

    }

    public Color(int rgb) {
        this.rgb = rgb;
    }

    public Color(int red, int green, int blue) {
        red = checkValues(red) << (colorOffset * 2);
        green = checkValues(green) << colorOffset;
        blue = checkValues(blue);

        rgb = red | green | blue;
    }

    public Color(String hexStr) {
        rgb = Integer.parseInt(hexStr.substring(1), 16);
    }

    // Methods
    private int checkValues(int value) {

        if (value > 255 || value < 0) {
            System.err.println("Value not in range of numbers");
            value = Math.max(0, Math.min(255, value));
        }

        return value;
    }

    @Override
    public String toString() {
        return getHex();
    }

    public Color complementaryColor() {
        return new Color(~rgb & 16777215);
    }

    public Color mixColor(Color color) {
        int r = (getRed() + color.getRed()) / 2;
        int g = (getGreen() + color.getGreen()) / 2;
        int b = (getBlue() + color.getBlue()) / 2;

        return new Color(r, g, b);
    }

    // Getter
    public int getRgb() {
        return rgb;
    }

    public int getRed() {
        return getColor(colorOffset * 2);
    }

    public int getGreen() {
        return getColor(colorOffset);
    }

    public int getBlue() {
        return getColor(0);
    }

    private int getColor(int offset) {
        return (rgb >> offset) & 255;
    }

    public String getHex() {
        String hexStr = Integer.toHexString(rgb);
        return "#" + "000000".substring(hexStr.length()) + hexStr.toUpperCase();
    }
}
