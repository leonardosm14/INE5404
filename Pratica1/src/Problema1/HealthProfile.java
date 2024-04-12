package Problema1;
import java.time.LocalDate;

public class HealthProfile {

    private String nome;
    private String sobrenome;
    private String sexo;
    private Integer dia_nascimento;
    private Integer mes_nascimento;
    private Integer ano_nascimento;
    private Float altura;
    private Float peso;
    
    // Construtor da Classe
    public HealthProfile(String nome, String sobrenome, String sexo, Integer dia_nascimento, Integer mes_nascimento,
                         Integer ano_nascimento, Float altura, Float peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dia_nascimento = dia_nascimento;
        this.mes_nascimento = mes_nascimento;
        this.ano_nascimento = ano_nascimento;
        this.altura = altura;
        this.peso = peso;
    }
    
    // Set e Get nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Set e Get sobrenome
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    // Set e Get sexo
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    // Set e Get dia_nascimento
    public Integer getDia_nascimento() {
        return dia_nascimento;
    }
    public void setDia_nascimento(Integer dia_nascimento) {
        this.dia_nascimento = dia_nascimento;
    }
    
    // Set e Get mes_nascimento
    
    public Integer getMes_nascimento() {
        return mes_nascimento;
    }

 
    public void setMes_nascimento(Integer mes_nascimento) {
        this.mes_nascimento = mes_nascimento;
    }
    
    
    // Set e Get ano_nascimento
    public Integer getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(Integer ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    // Set e Get altura
    public Float getAltura() {
        return altura;
    }
    public void setAltura(Float altura) {
        this.altura = altura;
    }

    // Set e Get peso
    public Float getPeso() {
        return peso;
    }
    public void setPeso(Float peso) {
        this.peso = peso;
    }
    
    
    // Calcula Idade
    public Integer calculaIdade() {
    
        Integer idade;
        Integer controlador = 0;

        LocalDate data_atual = LocalDate.now();
    
        //verificar 

        Integer dia_atual = data_atual.getDayOfMonth();	
        Integer mes_atual = data_atual.getMonthValue(); 	
        Integer ano_atual = data_atual.getYear();

        if (ano_atual > ano_nascimento && 
           (mes_atual < mes_nascimento || 
           (mes_atual == mes_nascimento &&
            dia_atual < dia_nascimento)))

            controlador = 1;
        
        idade = ano_atual - ano_nascimento - controlador;

        return idade;
    
    }
    
    public Float[] intervaloFrequenciaAlvo() {
        Integer idade = calculaIdade();

        Integer frequenciaCardiacaMaxima = 220 - idade;
        Float freqMinima = 0.50f * frequenciaCardiacaMaxima;
        Float freqMaxima = 0.85f * frequenciaCardiacaMaxima;
        
        Float[] frequenciaCardiacaAlvo = {freqMinima, freqMaxima};

        return frequenciaCardiacaAlvo;
    }
    
    public Float calculaIMC() {
        
        if (altura == 0) {
            throw new ArithmeticException("Altura deve ser maior que 0.");
        }

        Float IMC = peso / (altura * altura);

        return IMC;
        
    }

}