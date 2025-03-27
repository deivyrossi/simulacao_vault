public class Recurso {
    private String nome;
    private int quantidade;
    private String unidade;

    public Recurso(String nome, int quantidade, String unidade) {
        this.nome = nome;
        this.quantidade = unidade.equals("único") ? 1 : quantidade;
        this.unidade = unidade;
    }

    public String getNomeRecurso() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setNomeRecurso(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void adicionarQuantidade(int quantidade) {
        if (!unidade.equals("único")) {
            this.quantidade += quantidade;
        }
    }

    public boolean consumirRecurso(int quantidadeConsumir) {
        if (unidade.equals("único")) {
            System.out.println("Este recurso é único e não pode ser consumido parcialmente.");
            return false;
        } else if (quantidade >= quantidadeConsumir) {
            quantidade -= quantidadeConsumir;
            return true;
        }
        return false;
    }
}
