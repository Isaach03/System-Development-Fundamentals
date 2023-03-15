package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExamPart1 extends JFrame implements ActionListener
{
    Container container = getContentPane();
    JLabel question1 = new JLabel("1) What is the capital of Greece?");
    JTextField answer1 = new JTextField();
    JLabel question2 = new JLabel("2) Who invented the light bulb?");
    String[] comboBox1 = { "","Isaac Newton", "Jason Walker", "Bill Nye", "Thomas Edison", "Hippocrates" };
    JComboBox answer2 = new JComboBox(comboBox1);
    JLabel question3 = new JLabel("3) Who said 'I think, therefore I am'?");
    String[] comboBox2 = { "","Lao Tzu", "Aristotle", "Rene Descartes", "Friedrich Nietzsche", "Gautama Buddha"};
    JComboBox answer3 = new JComboBox(comboBox2);
    JButton submit = new JButton("Submit");
    static int score = 0;
    static int student1Score = 0;
    static int student2Score = 0;
    static ArrayList<String> loggedIn = LoginFrame.getLoggedIn();

    ExamPart1()
    {
        setVisible(true);
        addActionEvent();
        answer1.setFont(new Font("Serif", Font.PLAIN, 100));
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

    //Using one of Java Swing's layouts to place elements in one column.
    public void setLayoutManager() {
        container.setLayout(new BoxLayout(container, 1));
    }

    //Returns list of logged in students so there can be correct assignments
    //of scores.
    public static ArrayList<String> getLoggedIn() {
        return loggedIn;
    }

    //Returns score for the current object.
    public static int getScore() {
        return score;
    }

    //Adds each swing component to the window.
    public void addComponentsToContainer() {
        container.add(question1);
        container.add(answer1);
        container.add(question2);
        container.add(answer2);
        container.add(question3);
        container.add(answer3);
        container.add(submit);
    }

    //Making the interactive parts of the program, i.e. buttons,
    //text fields and dropdown boxes such that when you interact
    //with them, they do something.
    public void addActionEvent() {
        answer1.addActionListener(this);
        answer2.addActionListener(this);
        answer3.addActionListener(this);
        submit.addActionListener(this);
    }

    //When submit is clicked, scores are totalled and assigned to the given
    //student.
    @Override
    public void actionPerformed(ActionEvent e) {
        score = 0;
        if (e.getSource() == submit) {

            if (answer1.getText().equalsIgnoreCase("Athens")) {
                score += 1;
            }

            if (answer2.getSelectedItem() == "Thomas Edison") {
                score += 1;
            }

            if (answer3.getSelectedItem() == "Rene Descartes") {
                score += 1;
            }

            int exam1Score = score;

            if ((loggedIn.contains("student1") && !loggedIn.contains("student2")) || (loggedIn.contains("student2") && !loggedIn.contains("student1"))) {
                student1Score = exam1Score;
            }

            if (loggedIn.contains("student2") && loggedIn.contains("student1")) {
                student2Score = exam1Score;
            }

            new ExamPart2();
            setVisible(false);

        }
    }




}

