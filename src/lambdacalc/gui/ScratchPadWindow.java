/*
 * TeacherToolWindow.java
 *
 * Created on May 29th, 2007
 */

package lambdacalc.gui;

import java.io.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import lambdacalc.exercises.*;
import lambdacalc.logic.*;

/**
 *
 * @author  champoll 
 * @author tauberer
 */
public class ScratchPadWindow extends javax.swing.JFrame {
    private static ScratchPadWindow singleton=null;

    static ScratchPadWindow getSingleton() {
        return singleton;
    }    
    
    // states set by the radio buttons
    private static final boolean LAMBDA_CONVERSION = true;
    private static final boolean TYPE_SIMPLIFICATION = false;
    
    private boolean selection = LAMBDA_CONVERSION;
    
    private boolean userMod = false; // whether user is trying to modify a problem he's currently working on
    
    private Exercise ex=null; // contract: this must be null whenever a problem has been solved
    private Exercise previousEx; // whenever a problem is solved it is written in here
    
    private String currentProblemString = "";
    
    public static void prepareWindow() {
       if (singleton == null) {
            singleton = new ScratchPadWindow();
       }
       singleton.resetGUI();
    }
        
    public static void showWindow() {
        
        prepareWindow();
        singleton.show();
    }
    
    static void exit() {
        disposeWindow();
    }
    
    static void disposeWindow() {
        if (singleton != null) {
            singleton.dispose();
        }
    }
    
    /** Creates new form ScratchPadWindow. Private so that showWindow is used instead. */
    private ScratchPadWindow() {
        initComponents();
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        txtUserAnswer = new lambdacalc.gui.LambdaEnabledTextField();
        jButtonCheckAnswer = new javax.swing.JButton();
        jScrollPaneFeedback = new javax.swing.JScrollPane();
        txtFeedback = new javax.swing.JTextArea();
        jButtonEnterProblem = new javax.swing.JButton();
        jPanelButtons = new javax.swing.JPanel();
        jButtonCloseWindow = new javax.swing.JButton();
        jButtonDoAgain = new javax.swing.JButton();
        jButtonDoAnotherProblem = new javax.swing.JButton();
        jPanelRadioButtons = new javax.swing.JPanel();
        jRadioButtonType = new javax.swing.JRadioButton();
        jRadioButtonLambda = new javax.swing.JRadioButton();
        jPanelEnterYourOwnProblem = new javax.swing.JPanel();
        txtEnterYourOwnProblem = new lambdacalc.gui.LambdaEnabledTextField();
        jButtonTransfer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemClose = new javax.swing.JMenuItem();

        fileChooser.setApproveButtonText("Open Directory");
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Lambda Teacher Tool");
        txtUserAnswer.setFont(new java.awt.Font("Serif", 0, 18));
        txtUserAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserAnswerActionPerformed(evt);
                txtUserAnswerActionPerformed1(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(txtUserAnswer, gridBagConstraints);

        jButtonCheckAnswer.setText("Check Answer");
        jButtonCheckAnswer.setMaximumSize(new java.awt.Dimension(120, 25));
        jButtonCheckAnswer.setMinimumSize(new java.awt.Dimension(120, 25));
        jButtonCheckAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCheckAnswer(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jButtonCheckAnswer, gridBagConstraints);

        jScrollPaneFeedback.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jScrollPaneFeedback.setBorder(javax.swing.BorderFactory.createTitledBorder("Feedback"));
        txtFeedback.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtFeedback.setColumns(20);
        txtFeedback.setEditable(false);
        txtFeedback.setFont(new java.awt.Font("SansSerif", 0, 12));
        txtFeedback.setLineWrap(true);
        txtFeedback.setRows(5);
        txtFeedback.setWrapStyleWord(true);
        txtFeedback.setBorder(null);
        jScrollPaneFeedback.setViewportView(txtFeedback);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jScrollPaneFeedback, gridBagConstraints);

        jButtonEnterProblem.setText("Enter Problem");
        jButtonEnterProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnterProblemActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        getContentPane().add(jButtonEnterProblem, gridBagConstraints);

        jButtonCloseWindow.setText("Close Window");
        jButtonCloseWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseWindowActionPerformed(evt);
            }
        });

        jButtonDoAgain.setText("Do Problem Again");
        jButtonDoAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoAgainActionPerformed(evt);
            }
        });

        jButtonDoAnotherProblem.setText("Do Another Problem");
        jButtonDoAnotherProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoAnotherProblemActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelButtonsLayout = new org.jdesktop.layout.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .add(jButtonDoAgain)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonDoAnotherProblem)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 101, Short.MAX_VALUE)
                .add(jButtonCloseWindow)
                .addContainerGap())
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonDoAgain)
                    .add(jButtonDoAnotherProblem)
                    .add(jButtonCloseWindow))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jPanelButtons, gridBagConstraints);

        jPanelRadioButtons.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(jRadioButtonType);
        jRadioButtonType.setText("Type Identification");
        jRadioButtonType.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonType.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTypeActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelRadioButtons.add(jRadioButtonType, gridBagConstraints);

        buttonGroup1.add(jRadioButtonLambda);
        jRadioButtonLambda.setSelected(true);
        jRadioButtonLambda.setText("Lambda Conversion");
        jRadioButtonLambda.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButtonLambda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonLambda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLambdaActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelRadioButtons.add(jRadioButtonLambda, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        getContentPane().add(jPanelRadioButtons, gridBagConstraints);

        jPanelEnterYourOwnProblem.setLayout(new java.awt.GridBagLayout());

        txtEnterYourOwnProblem.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Your Own Problem"));
        txtEnterYourOwnProblem.setFont(new java.awt.Font("Serif", 0, 18));
        txtEnterYourOwnProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnterYourOwnProblemActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanelEnterYourOwnProblem.add(txtEnterYourOwnProblem, gridBagConstraints);

        jButtonTransfer.setText("Paste below");
        jButtonTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransferActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelEnterYourOwnProblem.add(jButtonTransfer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 5);
        getContentPane().add(jPanelEnterYourOwnProblem, gridBagConstraints);

        menuFile.setMnemonic('F');
        menuFile.setText("File");
        menuItemClose.setMnemonic('c');
        menuItemClose.setText("Close Window");
        menuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCloseActionPerformed(evt);
            }
        });

        menuFile.add(menuItemClose);

        jMenuBar1.add(menuFile);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransferActionPerformed
        txtUserAnswer.setText(txtEnterYourOwnProblem.getText());
        txtUserAnswer.requestFocusInWindow();
    }//GEN-LAST:event_jButtonTransferActionPerformed

    private void jButtonEnterProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnterProblemActionPerformed
        
        Exercise enteredEx;
        
        switchOff(txtUserAnswer);
        
        IdentifierTyper it;
        Exercise currentMainWindowEx=null;
        
        if (TrainingWindow.getSingleton() != null) {
            currentMainWindowEx = 
                    TrainingWindow.getSingleton().getCurrentExercise();
        }
        if (currentMainWindowEx != null && currentMainWindowEx instanceof HasIdentifierTyper) {
            it = ((HasIdentifierTyper) currentMainWindowEx).getIdentifierTyper();
        } else {
            it = IdentifierTyper.createDefault();
        }

        // options for parsing lambda expressions
        ExpressionParser.ParseOptions exprParseOpts = new ExpressionParser.ParseOptions();
        exprParseOpts.ASCII = false; // LambdaEnabledTextBox will already do the conversion
        exprParseOpts.singleLetterIdentifiers = true; // Pa means P(a) 
        // TODO maybe singleLetterIdentifiers option should be parametrized
        // and/or dependent on whatever the state of the main window is?
        exprParseOpts.typer = it;
        
        String line = txtEnterYourOwnProblem.getText().trim();
            if (!line.equals(txtEnterYourOwnProblem.getText())) {
                txtEnterYourOwnProblem.setText(line);
            }
        
        try {
            if (this.selection==LAMBDA_CONVERSION) {
                enteredEx= new LambdaConversionExercise(line, exprParseOpts, 1, it);
                if (enteredEx == null) {
                  
                    throw new SyntaxException("Warning: TypeExercise constructor returned null",
                            txtUserAnswer.getText().length());
                    
                }
                
                // we don't want to bug people in the ScratchPad application
                ((LambdaConversionExercise) enteredEx).setNotSoFast(false);
                
            } else if (this.selection==TYPE_SIMPLIFICATION) {
                enteredEx= new TypeExercise(line, exprParseOpts, 1, it);
                if (enteredEx == null) {
                    
                    throw new SyntaxException("Warning: TypeExercise constructor returned null",
                            txtUserAnswer.getText().length());                   
                }
            } else {
                throw new RuntimeException("Scratch pad is in an illegal state");
            }
            
            // successfully entered a problem
            this.currentProblemString = line;
            previousEx=ex;
            ex=enteredEx;
            tellGUIProblemEntered();
            
        } catch (SyntaxException s) {

            jButtonCheckAnswer.setEnabled(false);
            //if (this.ex!=null) { // user is trying to modify a problem on the fly
            if (false) { // user is trying to modify a problem on the fly
                undoOnTheFlyModification();
                displayFeedback("I could not understand your modification of the current problem: " + s.getMessage()
                +"\nI reverted your modification. If you would like to scratch the current problem " +
                        "and start a new one, click on Do Another Problem.");                
            } else { // user is trying to enter a problem at the beginning or after clicking "Do another problem"

                displayFeedback(s.getMessage());
                txtEnterYourOwnProblem.requestFocusInWindow();
                if (s.getPosition() >= 0 && s.getPosition() <= txtUserAnswer.getText().length())
                    txtEnterYourOwnProblem.setCaretPosition(s.getPosition());
            }
        } catch (TypeEvaluationException t) {
            jButtonCheckAnswer.setEnabled(false);
//            if (this.ex!=null) { // user is trying to modify a problem on the fly
            if (false) { // user is trying to modify a problem on the fly
                undoOnTheFlyModification();
                displayFeedback("I could not understand your modification of the current problem: " + t.getMessage()
                +"\nI reverted your modification. If you would like to scratch the current problem " +
                        "and start a new one, click on Do Another Problem.");
            } else {
                
                displayFeedback(t.getMessage());
                txtEnterYourOwnProblem.requestFocusInWindow();
            }
        }

    }//GEN-LAST:event_jButtonEnterProblemActionPerformed

    private void undoOnTheFlyModification() {
        txtEnterYourOwnProblem.setText(this.currentProblemString);
        //tellGUIProblemEntered();
    }
    
    private void jButtonDoAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoAgainActionPerformed
        ex.reset();
        txtEnterYourOwnProblem.setText(this.currentProblemString);
        displayFeedback("");
        tellGUIProblemEntered();
    }//GEN-LAST:event_jButtonDoAgainActionPerformed

    private void jButtonDoAnotherProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoAnotherProblemActionPerformed
        resetGUI();
        this.ex = null;
    }//GEN-LAST:event_jButtonDoAnotherProblemActionPerformed

    private void jButtonCloseWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseWindowActionPerformed
        menuItemClose.doClick();
    }//GEN-LAST:event_jButtonCloseWindowActionPerformed

    private void jRadioButtonTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTypeActionPerformed
        radioButtonSwitch(TYPE_SIMPLIFICATION);
    }//GEN-LAST:event_jRadioButtonTypeActionPerformed

    private void jRadioButtonLambdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLambdaActionPerformed
        radioButtonSwitch(LAMBDA_CONVERSION);
    }//GEN-LAST:event_jRadioButtonLambdaActionPerformed

    private void radioButtonSwitch(boolean userChoice) {
        selection = userChoice;
        jButtonDoAnotherProblem.doClick();
    }
    
    private void txtUserAnswerActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAnswerActionPerformed1
        jButtonCheckAnswer.doClick();
    }//GEN-LAST:event_txtUserAnswerActionPerformed1

      
    private void txtEnterYourOwnProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnterYourOwnProblemActionPerformed
        jButtonEnterProblem.doClick();
    }//GEN-LAST:event_txtEnterYourOwnProblemActionPerformed

    private void switchOn(javax.swing.JTextField j) {
        j.setEnabled(true);
        j.setEditable(true);
        //j.setBackground(javax.swing.UIManager.getColor("TextField.activeBackground"));
    }
    
    private void switchOff(javax.swing.JTextField j) {
        j.setEnabled(false);
        j.setEditable(false);
        //if (j.getText().equals("")) {
        //    j.setBackground(javax.swing.UIManager.getColor("TextField.inactiveBackground"));
        //}
    }
    
    // before user has entered anything -- waiting for a problem
    private void resetGUI() {
        displayFeedback("Entering resetGUI");
        switchOn(txtEnterYourOwnProblem);
        jButtonEnterProblem.setEnabled(true);
        jButtonCheckAnswer.setEnabled(false);
        txtUserAnswer.setText("");
        switchOff(txtUserAnswer);
        setRadioButtonsEnabled(true);
        jButtonDoAnotherProblem.setEnabled(false);
        txtFeedback.setText("");
        jButtonDoAgain.setEnabled(false);
        
        txtEnterYourOwnProblem.requestFocusInWindow();
    }
    
    // after user has entered a problem and clicked "Enter problem" or hit Return
    private void tellGUIProblemEntered() {

        switchOn(txtEnterYourOwnProblem); // switch off if you don't want to allow users
        // to allow entering a problem while they're working on another one
        
        jButtonEnterProblem.setEnabled(true);
        jButtonCheckAnswer.setEnabled(true);
        txtUserAnswer.setText("");
        setRadioButtonsEnabled(true);
        jButtonDoAnotherProblem.setEnabled(true);
        jButtonDoAgain.setEnabled(true);
        switchOn(txtUserAnswer);
        
        if (selection==LAMBDA_CONVERSION) {
            displayFeedback("I got your problem. Now enter a lambda expression into the highlighted text field.");
        } else { // selection==TYPE+SIMPLIFICATION
            displayFeedback("I got your problem. Now enter a type into the highlighted text field.");
        }
        
        txtUserAnswer.requestFocusInWindow();
    }
    
    // when problem is solved
    private void tellGUIProblemSolved() {
        txtEnterYourOwnProblem.setEnabled(true);
        jButtonEnterProblem.setEnabled(true);
        switchOff(txtUserAnswer);
        jButtonCheckAnswer.setEnabled(false);
        setRadioButtonsEnabled(true);
        jButtonDoAnotherProblem.setEnabled(true);
        jButtonDoAgain.setEnabled(true);
    }

    
    private void displayFeedback(String msg) {
        txtFeedback.setText(msg);
    }
    
    private void setRadioButtonsEnabled(boolean b) {
        jRadioButtonLambda.setEnabled(b);
        jRadioButtonType.setEnabled(b);
    }
    
    private void onCheckAnswer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCheckAnswer
        try {
            String string = txtUserAnswer.getText().trim();
            if (!string.equals(txtUserAnswer.getText())) {
                txtUserAnswer.setText(string);
            }
            
            if (ex == null) {
                // TODO exception handling
            }
            AnswerStatus status = ex.checkAnswer(string);
            displayFeedback(status.getMessage());
            if (status.isCorrect()) {
                if (status.endsExercise()) {
                    tellGUIProblemSolved();
                    
                    previousEx=ex;
                    ex=null;
                } else { // "Correct! Now simplify..."
                    txtEnterYourOwnProblem.setText(ex.getLastAnswer());
                }
            }
        } catch (SyntaxException s) {
            displayFeedback(s.getMessage());
            if (s.getPosition() >= 0 && s.getPosition() <= txtUserAnswer.getText().length())
                txtUserAnswer.setCaretPosition(s.getPosition());
        }
        txtUserAnswer.requestFocusInWindow();
    }//GEN-LAST:event_onCheckAnswer

    
    private void txtUserAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAnswerActionPerformed
        onCheckAnswer(evt);
    }//GEN-LAST:event_txtUserAnswerActionPerformed

    private void menuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCloseActionPerformed
        this.hide();
    }//GEN-LAST:event_menuItemCloseActionPerformed
    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScratchPadWindow().setVisible(true);
            }
        });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButtonCheckAnswer;
    private javax.swing.JButton jButtonCloseWindow;
    private javax.swing.JButton jButtonDoAgain;
    private javax.swing.JButton jButtonDoAnotherProblem;
    private javax.swing.JButton jButtonEnterProblem;
    private javax.swing.JButton jButtonTransfer;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelEnterYourOwnProblem;
    private javax.swing.JPanel jPanelRadioButtons;
    private javax.swing.JRadioButton jRadioButtonLambda;
    private javax.swing.JRadioButton jRadioButtonType;
    private javax.swing.JScrollPane jScrollPaneFeedback;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemClose;
    private lambdacalc.gui.LambdaEnabledTextField txtEnterYourOwnProblem;
    private javax.swing.JTextArea txtFeedback;
    private lambdacalc.gui.LambdaEnabledTextField txtUserAnswer;
    // End of variables declaration//GEN-END:variables
    
    
}
