import java.util.ArrayList;
import java.util.List;


    public class Sobrevivente extends Pessoa{
        private List<String> Habilidades;
        private String Status;
        public static final List<String> HABILIDADES_POSSIVEIS = List.of(
            "Engenharia",
            "Medicina",
            "Combate",
            "Exploração",
            "Culinária",
            "Diplomacia",
            "Hackeamento",
            "Furtividade"
        );
    
        public static final List<String> STATUS_POSSIVEIS = List.of(
            "Ativo",
            "Doente",
            "Ferido",
            "Morto"
    
        );
    
        public Sobrevivente(String nome, int idade, String identificador, String status, List<String> habilidades){
            super(nome, idade, identificador);
            this.Habilidades = new ArrayList<>();
            this.Status = status;
        }

        public List<String> getHabilidades(){
            return Habilidades;
        }

        public String getStatus(){
            return Status;
        }

        public void setStatusSobrevivente(String status){
            if(!STATUS_POSSIVEIS.contains(status)){
                System.out.println("Status inválido. Escolha entre: " + String.join(", ", STATUS_POSSIVEIS));
                return;
            }
            this.Status = status;
            System.out.println("Status adicionado com sucesso");
        }

        
    
        public String addHabilidade(String habilidade){
            if(!HABILIDADES_POSSIVEIS.contains(habilidade)){
                return "Habilidade inválida.";
                
            }
    
            else if (Habilidades.size() >= 3){
                return "O sobrevivente já possui 3 habilidades.";
            }
    
            else if(Habilidades.contains(habilidade)){
                return "Este sobrevivente já possui esta habilidade.";
            }
    
            Habilidades.add(habilidade);
            return "Habilidade adicionada com sucesso"; 
    
        }
    
        public String removeHabilidade(String habilidade){
            if(!Habilidades.contains(habilidade)){
                return "Este sobrevivente não possui esta habilidade.";
            }
            Habilidades.remove(habilidade);
            return "Habilidade removida com sucesso";
        }
    
        public String addStatus(String status){
            if(!STATUS_POSSIVEIS.contains(status)){
                return "Status inválido.";
                
            }
            else if(Status.contains(status)){
                return "Este sobrevivente já possui este status.";
            }
            this.Status = status;
            return "Status adicionado com sucesso";
    
        }
    

}
