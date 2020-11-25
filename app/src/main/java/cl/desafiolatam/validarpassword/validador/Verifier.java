package cl.desafiolatam.validarpassword.validador;

import android.graphics.Color;

public enum Verifier {
    WEAK("Weak", Color.parseColor("#FE2E2E")),
    MEDIUM("Medium", Color.parseColor("#FFFF00")),
    STRONG("Strong", Color.parseColor("#40FF00")),
    VERY_STRONG("Very Strong", Color.parseColor("#088A08"));

    public String  mensaje;
    public int color;
    public static int LARGO_MIN = 5;

    private static int puntos = 0;
    private static boolean largo = false;
    private static boolean mayusculas = false;
    private static boolean numeros = false;

    Verifier(String mensaje, int color) {
        this.mensaje = mensaje;
        this.color = color;
    }

    public static Verifier evaluarPassword(String password) {

        largo = validaLargo(password);
        mayusculas = validaMayusculas(password);
        numeros = validarNumeros(password);
        puntos = calcularPuntos(largo, mayusculas, numeros);


        switch (puntos) {
            case 0:
                return WEAK;
            case 1:
                return MEDIUM;
            case 2:
                return STRONG;
            case 3:
                return VERY_STRONG;
        }
        return WEAK;
    }

    private static int calcularPuntos(boolean largo, boolean mayusculas, boolean numeros) {
        int totalPuntos = 0;

        if (largo == true &&  mayusculas == false) {
            totalPuntos = 1;
        }

        if (largo == true && mayusculas == true) {
            totalPuntos = 2;
        }

        if (largo == true && mayusculas == true && numeros == true) {
            totalPuntos = 3;
        }

        return totalPuntos;
    }

    private static boolean validaLargo(String password) {
        boolean tieneLargo = false;
        if (password.length() > LARGO_MIN) {
            tieneLargo = true;
        }
        return tieneLargo;
    }

    private static boolean validaMayusculas(String password) {
        boolean tieneMayusculas = false;
        for (int i = 0; i < password.length(); i++) {
            char letra = password.charAt(i);
            if (!tieneMayusculas && Character.isUpperCase(letra)) {
                tieneMayusculas = true;
            }
        }
        return tieneMayusculas;
    }

    private static boolean validarNumeros(String password) {
        boolean tieneNumeros = false;
        for (int i = 0; i < password.length(); i++) {
            char letra = password.charAt(i);
            if (!tieneNumeros && Character.isDigit(letra)) {
                tieneNumeros = true;
            }
        }
        return tieneNumeros;
    }
}
