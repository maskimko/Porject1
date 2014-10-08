/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.applet1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author maskimko
 */
public class SomePanel extends JPanel implements ActionListener {

    public static final String SOMEACTION = "doSomething";
    private JTextArea textArea;
    
    public SomePanel(){
        super(new BorderLayout());
        textArea = new JTextArea("Some initial text.\n");
        textArea.setPreferredSize(new Dimension(300, 400));
        JButton button = new JButton("The only button");
        button.setActionCommand(SOMEACTION);
        button.addActionListener(this);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(button);
        
        add(textArea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(SOMEACTION)) {
            textArea.append("The only button has been pressed!\n");
        }
    }
    
    public static void createAndShowGui(){
        JFrame frame = new JFrame("First my applet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SomePanel sp = new SomePanel();
        sp.setOpaque(true);
        frame.setContentPane(sp);
        frame.pack();
        frame.setVisible(true);
    }
    
}
