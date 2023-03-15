package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ExamResults extends JFrame {

    Container container = getContentPane();
    JLabel results = new JLabel("Results");
    JTable resultsTable = new JTable(12, 2);
    static ArrayList<String> loggedIn = ExamPart2.getLoggedIn();
    static int student1Score = ExamPart2.getStudent1Score();
    static int student2Score = ExamPart2.getStudent2Score();

    ExamResults() throws IOException {
        setVisible(true);
        setSize(500,245);
        addComponentsToContainer();
        setLayoutManager();
        fillTable();
    }

    //Using one of Java Swing's layouts to place elements in one column.
    public void setLayoutManager() {
        container.setLayout(new BoxLayout(container, 1));
    }

    //Adds each swing component to the window.
    public void addComponentsToContainer() {
        container.add(results);
        container.add(resultsTable);
    }

    //Fills the table with results and headers.
    public void fillTable() throws IOException {
        resultsTable.setValueAt("Student Username", 0, 0);
        resultsTable.setValueAt("Student score out of 5", 0, 1);

        if (loggedIn.size() == 1 || loggedIn.size() == 2) {
            resultsTable.setValueAt(loggedIn.get(0), 1, 0);
            resultsTable.setValueAt(student1Score, 1, 1);
        }

        if(loggedIn.size() == 2) {
            resultsTable.setValueAt(loggedIn.get(1), 2, 0);
            resultsTable.setValueAt(student2Score, 2, 1);

            examFinished();
        }
    }

    //Writes completion message to txt file
    public void examFinished() throws IOException {
        //Change path name here
        String file_name = "C:\\Users\\HussainI1\\exam_finished.txt";

        WriteFile data = new WriteFile(file_name,true);
        data.writeToFile("Exam process finished");

        System.out.println("Text File Written To");

    }
}
