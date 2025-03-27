public class Pessoa{
        protected String nome;
        protected int idade;
        protected String identificador;
    
        public Pessoa(String nome, int idade, String identificador){
            this.nome = nome;
            this.idade = idade;
            this.identificador = identificador;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        public int getIdade(){
            return this.idade;
        }
    
        public String getIdentificador(){
            return this.identificador;
        }
    
        public void setNome(String nome){
            this.nome = nome;
        }
    
        public void setIdade(int idade){
            this.idade = idade;
        }
    
        public void setIdentificador(String identificador){
            this.identificador = identificador;
        }

    
}




