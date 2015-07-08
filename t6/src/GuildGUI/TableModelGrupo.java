package GuildGUI;


import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

class TableModelGrupo extends AbstractTableModel {
    
    private ArrayList<Grupo> grupo;
    
    private static final String[] columnNames = {"Numero","Grupo"};
    
    public TableModelGrupo() {
        grupo = new ArrayList<Grupo>();
    }
    
    public void remove(int index) {
	fireTableRowsDeleted(index, index);
        grupo.remove(index);
    }
    
    public Grupo select(int index) {
        return grupo.get(index);
    }
    
    public void add(Grupo g) {
        fireTableRowsInserted(grupo.size()-1, grupo.size()-1);
        grupo.add(g);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return grupo.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return rowIndex+1;
            case 1: return "Grupo formado";
        }
        return null;
    }
}

