package lab05;

public class ApostaSemSeguro extends Aposta {
    public ApostaSemSeguro(String apostador, int valor, String previsao) {
        
        super(apostador, valor, previsao);
        if (apostador.equals(null) || apostador.equals("")) {
            
            throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
        }
        
        if (valor <= 0) {
            
            throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
        }
        
        if (apostador.equals("  ")) {
            
            throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
        }
        
        if (previsao.equals("   ")) {
            
            throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
        }
        
        if (previsao.equals("") || previsao.equals(null)) {
            
            throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
        }
        
        if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
            
            throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
        }
    }
    
    @Override
    public String toString() {
        
        return apostador + " - R$" + valor + " - " + previsao;
    }
}