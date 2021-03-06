/*
 * Copyright (C) 2007-2014 Dylan Bumford, Lucas Champollion, Maribel Romero
 * and Joshua Tauberer
 * 
 * This file is part of The Lambda Calculator.
 * 
 * The Lambda Calculator is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * The Lambda Calculator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with The Lambda Calculator.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

/*
 * WelcomeWindow.java
 *
 * Created on May 31, 2007, 1:47 PM
 */

package lambdacalc.gui;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;

/**
 *
 * @author  champoll
 */
public class WelcomeWindow extends javax.swing.JFrame {
    
    private static WelcomeWindow singleton=null;

    public static WelcomeWindow getSingleton() {
        return singleton;
    }    
    
    
    /** Creates new form WelcomeWindow. Private so that showWindow is used instead. */
    private WelcomeWindow() {
        TrainingWindow.prepareWindow();
        ScratchPadWindow.prepareWindow();
        // we don't prepare the TeacherToolWindow because it's not
        // likely to be used often and because its startup is conditioned on
        // the user answering positively to a JFileChooser
        
        initComponents();

        jLabelAuthors.setText(lambdacalc.Main.AUTHORS_AND_YEAR);
        jLabelAffiliation.setText(lambdacalc.Main.AFFILIATION);
        jLabelWebsite.setText(lambdacalc.Main.WEBSITE);

        if (lambdacalc.Main.GOD_MODE) {
            jLabelVersion.setText("version " + lambdacalc.Main.VERSION
                    + " (teacher edition)");
        } else {
            jLabelVersion.setText("version " + lambdacalc.Main.VERSION 
                    + " (student edition)");
        }
    }
    
    public static void prepareWindow() {
       if (singleton == null) {
            singleton = new WelcomeWindow();
       }
    }
        
    public static void showWindow() {
        
        prepareWindow();
        singleton.show();
    }
    
    public static void exit() {
        disposeWindow();
        
        // In some cases, the program doesn't exit properly. 
        // This system call is not essential. It can be commented out
        // if necessary.
        System.exit(0);
    }
    
    static void disposeWindow() {
        if (singleton != null)
            singleton.dispose();
            
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMenu = new javax.swing.JMenu();
        menuItemExercise = new javax.swing.JMenuItem();
        menuItemScratchPad = new javax.swing.JMenuItem();
        menuItemTeacherTool = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        btnExercise = new javax.swing.JButton();
        btnScratchPad = new javax.swing.JButton();
        btnTeacherTool = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelAuthors = new javax.swing.JLabel();
        jLabelAffiliation = new javax.swing.JLabel();
        jLabelWebsite = new javax.swing.JLabel();
        jLabelVersion = new javax.swing.JLabel();

        jMenuMenu.setMnemonic('m');
        jMenuMenu.setText("Menu");
        jMenuMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMenuActionPerformed(evt);
            }
        });

        menuItemExercise.setMnemonic('e');
        menuItemExercise.setText("Work on an Exercise");
        menuItemExercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExerciseActionPerformed(evt);
            }
        });
        jMenuMenu.add(menuItemExercise);

        menuItemScratchPad.setMnemonic('s');
        menuItemScratchPad.setText("Use the Scratch Pad");
        menuItemScratchPad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemScratchPadActionPerformed(evt);
            }
        });
        jMenuMenu.add(menuItemScratchPad);

        menuItemTeacherTool.setMnemonic('t');
        menuItemTeacherTool.setText("Use the Teacher Tool");
        menuItemTeacherTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTeacherToolActionPerformed(evt);
            }
        });
        jMenuMenu.add(menuItemTeacherTool);

        menuItemExit.setMnemonic('x');
        menuItemExit.setText("Exit Program");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenuMenu.add(menuItemExit);

        jMenuBar1.add(jMenuMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lambda Calculator");

        btnExercise.setText("Use the Interactive Exercise Solver");
        btnExercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExerciseActionPerformed(evt);
            }
        });

        btnScratchPad.setText("Use the Scratch Pad");
        btnScratchPad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScratchPadActionPerformed(evt);
            }
        });

        btnTeacherTool.setText("Use the Teacher Tool");
        btnTeacherTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherToolActionPerformed(evt);
            }
        });

        btnExit.setText("Exit Program");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to the Lambda Calculator");

        jLabelAuthors.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabelAuthors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAuthors.setText("[authors and year]");

        jLabelAffiliation.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabelAffiliation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAffiliation.setText("[affiliation]");

        jLabelWebsite.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabelWebsite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWebsite.setText("[website]");

        jLabelVersion.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabelVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVersion.setText("[version]");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelAuthors, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelWebsite, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .add(btnScratchPad, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .add(btnTeacherTool, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .add(btnExercise, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .add(jLabelVersion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnExit)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelAffiliation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(jLabelAuthors)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelAffiliation)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelWebsite)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelVersion)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnExercise, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnScratchPad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnTeacherTool, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(btnExit)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        TrainingWindow.exit();
        ScratchPadWindow.exit();
        TeacherToolWindow.exit();
        
        exit();
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        btnExit.doClick();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemScratchPadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemScratchPadActionPerformed
        btnScratchPad.doClick();
    }//GEN-LAST:event_menuItemScratchPadActionPerformed

    private void menuItemExerciseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExerciseActionPerformed
        btnExercise.doClick();
    }//GEN-LAST:event_menuItemExerciseActionPerformed

    private void btnTeacherToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherToolActionPerformed
        TeacherToolWindow.showWindow();
    }//GEN-LAST:event_btnTeacherToolActionPerformed

    private void btnScratchPadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScratchPadActionPerformed
        ScratchPadWindow.showWindow();
    }//GEN-LAST:event_btnScratchPadActionPerformed

    private void menuItemTeacherToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTeacherToolActionPerformed
        btnTeacherTool.doClick();
    }//GEN-LAST:event_menuItemTeacherToolActionPerformed

    private void jMenuMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMenuActionPerformed
    }//GEN-LAST:event_jMenuMenuActionPerformed

    private void btnExerciseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExerciseActionPerformed
        TrainingWindow.showWindow();
    }//GEN-LAST:event_btnExerciseActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeWindow().setVisible(true);
            }
        });
    }
    
    public Object clone() throws CloneNotSupportedException {
	throw new CloneNotSupportedException();
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExercise;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnScratchPad;
    private javax.swing.JButton btnTeacherTool;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAffiliation;
    private javax.swing.JLabel jLabelAuthors;
    private javax.swing.JLabel jLabelVersion;
    private javax.swing.JLabel jLabelWebsite;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuMenu;
    private javax.swing.JMenuItem menuItemExercise;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemScratchPad;
    private javax.swing.JMenuItem menuItemTeacherTool;
    // End of variables declaration//GEN-END:variables
    
}
