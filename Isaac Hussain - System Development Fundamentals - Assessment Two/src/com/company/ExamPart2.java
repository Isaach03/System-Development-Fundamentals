package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExamPart2 extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel question1 = new JLabel("4) How many degrees celsius is the boiling point of water?");
    JTextField answer1 = new JTextField();
    JLabel question2 = new JLabel("5) How many sides does a decagon have?");
    JTextField answer2 = new JTextField();
    JButton submit = new JButton("Submit");
    static int score = ExamPart1.getScore();
    static int student1Score = ExamPart1.getStudent1Score();
    static int student2Score = ExamPart1.getStudent2Score();
    static ArrayList<String> loggedIn = ExamPart1.getLoggedIn();

    ExamPart2()
    {
        setVisible(true);
        addActionEvent();
        answer1.setFont(new Font("Serif", Font.PLAIN, 100));
        answer2.setFont(new Font("Serif", Font.PLAIN, 100));
        setSize(500,700);
        addComponentsToContainer();
        setLayoutManager();
    }

    //Returns student 1's score.
    public static int getStudent1Score() {
        return student1Score;
    }

    //Returns student 2's score.
    public static int getStudent2Score() {
        return student2Score;
    }

    //Returns list of logged in students so there can be correct assignments
    //of scores.
    public static ArrayList<String> getLoggedIn() {
        return loggedIn;
    }

    //Using one of Java Swing's layouts to place elements in one column.
    public void setLayoutManager() {
        container.setLayout(new BoxLayout(container, 1));
    }

    //Adds each swing component to the window.
    public void addComponentsToContainer() {
        container.add(question1);
        container.add(answer1);
        container.add(question2);
        container.add(answer2);
        container.add(submit);
    }

    //Making the interactive parts of the program, i.e. buttons,
    //text fields and dropdown boxes such that when you interact
    //with them, they do something.
    public void addActionEvent() {
        answer1.addActionListener(this);
        answer2.addActionListener(this);
        submit.addActionListener(this);
    }

    //When submit is clicked, scores are totalled and assigned to the given
    //student.
    public void actionPerformed(ActionEvent e) {
        score = 0;
        if (e.getSource() == submit) {

            if (answer1.getText().equalsIgnoreCase("100")) {
                score += 1;
            }

            if (answer2.getText().equalsIgnoreCase("10")) {
                score += 1;
            }

            int exam2Score = score;

            if ((loggedIn.contains("student1") && !loggedIn.contains("student2")) || (loggedIn.contains("student2") && !loggedIn.contains("student1"))) {
                student1Score = student1Score + exam2Score;
                score = 0;
            }

            if (loggedIn.contains("student2") && loggedIn.contains("student1")) {
                student2Score = ExamPart1.getStudent2Score() + exam2Score;
            }

            setVisible(false);

        }
    }

}
