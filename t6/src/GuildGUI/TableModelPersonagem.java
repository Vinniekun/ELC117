package GuildGUI;


import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

class TableModelPersonagem extends AbstractTableModel {

    // Lista de disciplinas
    private ArrayList<Personagem> hero;

    // Array com os nomes das colunas da tabela
    private static final String[] columnNames = {"Jogador", "Personagem","Classe", "Nível", "Raça", "Diciplina","NívelProf","Dungeon","PvP","Dom","Seg","Ter","Qua","Qui","Sex","Sab"};
    
    
    // Construtor default
    public TableModelPersonagem() {
        hero = new ArrayList<Personagem>();
    }

    // Metodo chamado pela GUI para remover um elemento
    public void remove(int index) {
	fireTableRowsDeleted(index, index);
        hero.remove(index);
    }

    // Metodo chamado pela GUI para selecionar um elemento
    public Personagem select(int index) {
        return hero.get(index);
    }

    // Metodo chamado pela GUI para inserir um elemento
    public void add(Personagem d) {
        fireTableRowsInserted(hero.size()-1, hero.size()-1);
        hero.add(d);
    }

    // Metodo chamado pela GUI para alterar um elemento
    public void update(int index, Personagem d) {
        hero.set(index, d);
        fireTableRowsUpdated(index, index);
    }

    @Override
    public int getColumnCount() {
        // COMPLETE-ME: retorne o numero de colunas que a tabela devera conter
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return hero.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return hero.get(rowIndex).getJogador();
            case 1: return hero.get(rowIndex).getPersonagem();
            case 2: return hero.get(rowIndex).getClasse();
            case 3: return hero.get(rowIndex).getNivel();
            case 4: return hero.get(rowIndex).getRaca();
            case 5: return hero.get(rowIndex).getProfissao();
            case 6: return hero.get(rowIndex).getNivelprof();
            case 7: return hero.get(rowIndex).getDungeon();
            case 8: return hero.get(rowIndex).getPvp();
            case 9: return hero.get(rowIndex).getHoras(0);
            case 10: return hero.get(rowIndex).getHoras(1);
            case 11: return hero.get(rowIndex).getHoras(2);
            case 12: return hero.get(rowIndex).getHoras(3);
            case 13: return hero.get(rowIndex).getHoras(4);
            case 14: return hero.get(rowIndex).getHoras(5);
            case 15: return hero.get(rowIndex).getHoras(6);
        }
        return null;
    }

    public String randomJogador(){
        Random rand = new Random();
        String[] escolha = {"Vinicius","Otavio","Pedro","Patrick","Eduardo","Duda","Rafael","Cassiano","Felipe","Andrea","Pitthan","Lucas",
        "João","Fernando","João","Victor","Thome","Iago","Bruna","Paula","Uriel","Jair","Jaime","Thomas","Julio","Gabriel","Gilmar","Greyci",
        "Kelly","Marcos","Junior","Estefano","Cassales","jvlima","Sonia","Susane","Mauricio","Lucca","Rodrigo"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomPersonagem(){
        Random rand = new Random();
        String[] escolha = {"Hausen","Lord Elbert","Lord Uther","Helman","Fargus","Desmond","Zephiel","Roon","Akira","Ryu",
        "Tricia","Ignus","Valefor","Miyu","Vinnie","BolaDeFogo","Naruto69XXX420BLAZE","Death","Sonia","Nergal","Cloud","Hector",
        "Chaves","Chapolin","OmAtAdOr","se7e","Teixeira","Cruel","Nar0tt0","Rumi","Qwen","Quina","zidane","Sasuke7777","Wrist",
        "Valkyrie","Odin","Freya","Doritos","Fandangos","CCrlz","Yuun","Vinao","Iop","Rangerdomau","Soubom","javanes","Rudra",
        "Dante","Igor","Valentine","Florzinha","Taric","Ashe","Poppy","Yuggernaut","io","Tryndamere","Fruki","Xin","Zero","Zer0"
        ,"Eclesia","Pokemaniaco","jin","killua","Coiso","Fanta","Dores","Nadibaru","Mario","Moises","Klha","Legolas2001","legas"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomNivel(){
        Random rand = new Random();
        String[] escolha = {"1-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70", "71-80"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomClasse(){
        Random rand = new Random();
        String[] escolha = {"Warrior", "Guardian", "Revenat", "Ranger", "Thief", "Enginner", "Elementalist", "Necromancer", "Mesmer"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomProfissao(){
        Random rand = new Random();
        String[] escolha = {"Armorsmith", "Artificer", "Chef", "Huntsman", "Jeweler", "Leatherworker", "Tailor", "Weaponsmith"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomNivelprof(){
        Random rand = new Random();
        String[] escolha = {"1-100", "100-199", "200-299", "300-399", "400-449", "450"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomDungeon(){
        Random rand = new Random();
        String[] escolha = {"Aggro Control", "Crowd Control", "Burst", "Condition" , "Healing", "Blast Finisher", "Damage Per Second"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomPvp(){
        Random rand = new Random();
        String[] escolha = {"Bunker", "Roamer", "Capturer", "Scout", "Control"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomHora(){
        Random rand = new Random();
        String[] escolha = {"Manhã","Tarde","Noite","Madrugada"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
    public String randomRaca(){
        Random rand = new Random();
        String[] escolha = {"Human", "Asura", "Norn", "Charr", "Sylvari"};
        int valor = rand.nextInt(escolha.length);
        String nome = escolha[valor];
        return nome;
    }
    
}

