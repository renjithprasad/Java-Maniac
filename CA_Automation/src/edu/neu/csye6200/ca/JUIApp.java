package edu.neu.csye6200.ca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static edu.neu.csye6200.ca.Constants.*;

/**
 * @author Renjith
 */

abstract class JUIApp implements ActionListener {
    JFrame frame = null;
    private CanvasListener mIListener;
    JTextField inputField = new JTextField(20);
    CAGenerationSet caGenerationSet = CAGenerationSet.getInstance();
    static int number = 20;

    JUIApp(CanvasListener controller) {
        mIListener = controller;
        initGUI();

    }

    private void initGUI() {
        frame = new JFrame();
        frame.setTitle(CA_TITLE);
        //frame.setSize(400, 300);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.add(getMainPanel(), BorderLayout.NORTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JPanel getMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        JButton btn0 = new JButton(CA_START);
        btn0.addActionListener(this);
        mainPanel.add(btn0);

        JButton btn1 = new JButton(CA_STOP);
        btn1.addActionListener(this);
        mainPanel.add(btn1);

        JLabel label = new JLabel("Number: ");
        mainPanel.add(label);

        
        inputField.addActionListener(this);
        mainPanel.add(inputField);

        final DefaultComboBoxModel<String> Rulebox = new DefaultComboBoxModel<>();
        for (String rule :
                CA_RULES) {
            Rulebox.addElement(rule);
        }

        final JComboBox<String> totalRules = new JComboBox<>(Rulebox);
        ItemListener itemListener = itemEvent -> {
            int state = itemEvent.getStateChange();
            if (ItemEvent.SELECTED == state) {
                mIListener.updateRule((String) itemEvent.getItem());
            }
        };
        totalRules.addItemListener(itemListener);
        mainPanel.add(totalRules);

        return mainPanel;
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
    	int counter = 0;
        System.out.println("Action Event received " + arg0);
        switch (arg0.getActionCommand()) {
            case CA_START:
                caGenerationSet.resetCells();
                if (!((inputField.getText()) == null)) {
                	counter = (Integer.parseInt(inputField.getText()));
                } else {
                	counter =50;
                }
                while (counter != 0) {
                    caGenerationSet.applyRulesForNextGeneration();
                    --counter;
                }
                mIListener.start(caGenerationSet.getCaGenerationArrayList());
                break;
            case CA_STOP:
                mIListener.stop();
                break;
            default:
                number = Integer.parseInt(arg0.getActionCommand());
                break;
        }
    }

}
