import java.util.ArrayList;
import java.util.List;

public class Vault {
    private List<Recurso> recursos = new ArrayList<>();
    private List<Sobrevivente> sobreviventes = new ArrayList<>();
    private List<Missao> missoes = new ArrayList<>();

    public void cadastrarSobrevivente(String nome, int idade, String identificador, String status) {
        sobreviventes.add(new Sobrevivente(nome, idade, identificador, status, new ArrayList<>()));
        System.out.println("Sobrevivente cadastrado.");
    }

    public Sobrevivente getSobrevivente(String identificador) {
        for (Sobrevivente s : sobreviventes) {
            if (s.getIdentificador().equals(identificador)) {
                return s;
            }
        }
        return null;
    }


    private Recurso getNomeRecurso(String nome) {
        for (Recurso recurso : recursos) {
            if (recurso.getNomeRecurso().contains(nome)) {
                return recurso;
            }
        }
        return null;
    }

    public void addRecurso(String nome, int quantidade, String unidade) {
        Recurso recurso = getNomeRecurso(nome);
    
        if (recurso == null) {
            recursos.add(new Recurso(nome, quantidade, unidade));
            System.out.println("Recurso adicionado ao Vault.");
        } else if (!unidade.equals("único")) {
            recurso.adicionarQuantidade(quantidade);
            System.out.println("Quantidade atualizada.");
        } else {
            System.out.println("Recurso único já existe no Vault.");
        }
    }
    
    
    
    public boolean consumirRecurso(String nome, int quantidade) {
        Recurso recurso = getNomeRecurso(nome);
        if (recurso != null) {
            if (recurso.getQuantidade() >= quantidade) {
                recurso.setQuantidade(recurso.getQuantidade() - quantidade);
                System.out.println("Recurso consumido.");
                return true;
            } else {
                System.out.println("Quantidade insuficiente.");
                return false;
            }
        }
        System.out.println("Recurso não encontrado.");
        return false;
    }
    public void atualizarMissao(String nomeMissao, String novoStatus) {
        for (Missao m : missoes) {
            if (m.getNomeMissao().equalsIgnoreCase(nomeMissao)) {
                m.setStatus(novoStatus);
                System.out.println("Status da missão atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Missão não encontrada.");
    }

    public void adicionarSobreviventeAM(String nomeMissao, String identificador) {
        for (Missao m : missoes) {
            if (m.getNomeMissao().equalsIgnoreCase(nomeMissao)) {
                Sobrevivente s = getSobrevivente(identificador);
                if (s != null) {
                    if (s.getStatus().contains("Ativo") || s.getStatus().contains("Ferido")) {
                        m.adicionarsobreviventes(identificador);
                        System.out.println("Sobrevivente adicionado com sucesso na missão " + nomeMissao + ".");
                    } else {
                        System.out.println("Sobrevivente com o identificador " + identificador + " não está ativo.");
                    }
                } else {
                    System.out.println("Sobrevivente com o identificador " + identificador + " não encontrado.");
                }
                return;
            }
        }
        System.out.println("Missão com o nome " + nomeMissao + " não encontrada.");
    }

    public void mostrarRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("Nenhum recurso disponível no Vault.");
            return;
        }
    
        System.out.println("Recursos disponíveis no Vault:");
        for (Recurso recurso : recursos) {
            System.out.println("Recurso: " + recurso.getNomeRecurso() + " | Quantidade: " + recurso.getQuantidade() + " " + recurso.getUnidade());
        }
    }

    public void mostrarsobreviventesM(String nomeMissao) {
        for (Missao missao : missoes) {
            if (missao.getNomeMissao().equalsIgnoreCase(nomeMissao)) {
                List<String> sobreviventes = missao.getSobreviventes();
                if (sobreviventes.isEmpty()) {
                    System.out.println("Nenhum sobrevivente está cadastrado na missão " + nomeMissao + ".");
                } else {
                    System.out.println("Sobreviventes cadastrados na missão " + nomeMissao + ":");
                    for (String identificador : sobreviventes) {
                        System.out.println("- " + identificador);
                    }
                }
                return;
            }
        }
        System.out.println("Missão com o nome " + nomeMissao + " não encontrada.");
    }

    public void listasobreviventes() {
        if (sobreviventes.isEmpty()) {
            System.out.println("Nenhum sobrevivente cadastrado.");
        } else {
            for (Sobrevivente s : sobreviventes) {
                System.out.println("Nome: " + s.getNome() + " | Idade: " + s.getIdade() + " | Identificador: " + s.getIdentificador() + " | Status:" + s.getStatus() + " | Habilidades: " + s.getHabilidades());
            }
        }
    }

    public void atualizarStatusSobrevivente(String nomeStatus, String identificador) {
        for (Sobrevivente sobrevivente : sobreviventes) {
            if (identificador.equalsIgnoreCase(sobrevivente.getIdentificador())) {
                sobrevivente.setStatusSobrevivente(nomeStatus);
                System.out.println("Status atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Sobrevivente com o identificador " + identificador + " não encontrado.");
    }
    

    

    public void mostrarMissoes() {
        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão cadastrada.");
        } else {
            for (Missao m : missoes) {
                System.out.println("Missão: " + m.getNomeMissao() + " | Status: " + m.getStatus());
            }
        }
    }

    public void cadastrarMissao(String nome_missao, String objetivo, String local) {
        Missao novaMissao = new Missao(nome_missao, objetivo, local);
        missoes.add(novaMissao);
        System.out.println("Missão cadastrada com sucesso.");
    }
}