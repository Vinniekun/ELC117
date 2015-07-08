package GuildGUI;

public class Personagem {
    private String jogador;
    private String personagem;
    private String nivel;
    private String raca;
    private String profissao;
    private String nivelprof;
    private String dungeon;
    private String pvp;
    private String classe;
    private String[] horas;

    public Personagem() {
        horas = new String[7];
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel =  nivel;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }
    
    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNivelprof() {
        return nivelprof;
    }

    public void setNivelprof(String nivelprof) {
        this.nivelprof = nivelprof;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDungeon() {
        return dungeon;
    }

    public void setDungeon(String dungeon) {
        this.dungeon = dungeon;
    }

    public String getPvp() {
        return pvp;
    }

    public void setPvp(String pvp) {
        this.pvp = pvp;
    }

    public String getHoras(int index) {
        return horas[index];
    }

    public void setHoras(String horas, int index) {
        this.horas[index] = horas;
    }
    
    
    
}
