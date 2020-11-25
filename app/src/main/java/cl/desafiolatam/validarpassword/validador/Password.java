package cl.desafiolatam.validarpassword.validador;

import android.graphics.Color;
import cl.desafiolatam.validarpassword.R;

public enum Password {
    WEAK("Weak", Color.parseColor("#FE2E2E")),
    MEDIUM("Medium", Color.parseColor("#FFFF00")),
    STRONG("Strong", Color.parseColor("#40FF00")),
    VERY_STRONG("Very Strong", Color.parseColor("#088A08"));

    public String  mensaje;
    public int color;
    public static int LARGO_MIN = 5;

    Password(String mensaje, int color) {
        this.mensaje = mensaje;
        this.color = color;
    }

    public static Password calcular(String password) {
        int puntos = 0;
        boolean mayusculas = false;
        boolean numeros = false;

        //Longitud mínima de al menos 5 caracteres --> 1 punto
        if (password.length() > LARGO_MIN) {
            puntos++;
        }

        //Contiene letras mayúsculas --> Se suma otro punto (2)
        for (int i = 0; i < password.length(); i++) {
            char letra = password.charAt(i);
            if (!mayusculas && Character.isUpperCase(letra)) {
                mayusculas = true;
                puntos++;
            }
            //Contiene al menos un caracter numérico --> Se suma otro punto (3)
            if (!numeros && Character.isDigit(letra)) {
                numeros = true;
                puntos++;
            }
        }

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
}
