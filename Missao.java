import java.util.ArrayList;
import java.util.List;
import java.util.*;



public class Missao {
    private String nome_missao;
    private String objetivo;
    private String local;
    private String status;
    private List<String> sobreviventes;
    private List<Recurso> recursosColetados;
    protected List<Missao> missao = new ArrayList<Missao>();

    public static final List<String> STATUS_POSSIVEIS_MISSAO = List.of(
        "Em andamento",
        "Sucesso",
        "Fracasso"
    );

    public Missao(String nome_missao, String objetivo, String local){
        this.nome_missao = nome_missao;
        this.objetivo = objetivo;
        this.local = local;
        this.status = "Em andamento";
        this.sobreviventes = new ArrayList<>();
        this.recursosColetados = new ArrayList<>();
    }

    public String getNomeMissao() {
        return nome_missao;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getLocal() {
        return local;
    }

    public String getStatus() {
        return status;
    }


    public List<String> getSobreviventes() {
        return sobreviventes;
    }

    public List<Recurso> getRecursosColetados() {
        return recursosColetados;
    }

    public void setStatus(String status) {
        if (!STATUS_POSSIVEIS_MISSAO.contains(status)) {
            System.out.println("Status inválido. Escolha entre: " + String.join(", ", STATUS_POSSIVEIS_MISSAO));
            return;
        }
        this.status = status;
    }
    


    public void cadastrarMissao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome da Missão: ");
        nome_missao = scanner.nextLine();
        System.out.println("Objetivo: ");
        objetivo = scanner.nextLine();
        System.out.println("Local: ");
        local = scanner.nextLine();
        scanner.close();
        System.out.println("Missão cadastrada com sucesso.");
        missao.add(this);
    
    }

    public void adicionarsobreviventes(String identificador) {
        if (sobreviventes.size() >= 5) {
            System.out.println("O limite de 5 sobreviventes por missão foi atingido.");
            return;
        }
        if (!sobreviventes.contains(identificador)) {
            sobreviventes.add(identificador);
        } else {
            System.out.println("O sobrevivente já está nesta missão.");
        }
    }
    

}