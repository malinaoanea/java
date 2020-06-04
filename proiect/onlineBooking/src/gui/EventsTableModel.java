package gui;

import database.Data;
import event.Event;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EventsTableModel extends AbstractTableModel {
    private String[] columnNames = {"id", "event name"};
    private Object[][] data;

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public EventsTableModel(Data data) {
        this.data = this.getEvent(data);
    }

    private Object[][] getEvent(Data data) {
        ArrayList<Event> events = data.getEvents();
        int n_events = events.size();

        Object[][] objects = new Object[n_events][2];
        int i = 0;
        for (Event event:events) {
            objects[i][0] = event.getId();
            objects[i][1] = event.getName();
            i+=1;
        }

        return objects;
    }
}
