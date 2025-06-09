package modelo;

public class Modelo {
    private String texto;
    private int veces;
    private String textoRepetido;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }
    
    public String getTextoRepetido() {
        return textoRepetido;
    }

    public void setTextoRepetido(String textoRepetido) {
        this.textoRepetido = textoRepetido;
    }
    
    public String generarTextoRepetido() {
        String generarTexto = "";
        
        for (int i = 0; i < veces; i++) {
            generarTexto += texto;
        }
        
        this.setTextoRepetido(generarTexto);
        return this.getTextoRepetido();
    }
    

}
