/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.csculminating.gui;

import java.awt.BorderLayout;

/**
 *
 * @author caden
 */
public class SimPage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SimPage.class.getName());

    /**
     * Creates new form SimPage
     */
    public SimPage() {
        initComponents();
        
        double[][][] testData = {{
        { // Index 0: Time values
            0.000, 0.016, 0.032, 0.048, 0.064, 0.080, 0.096, 0.112, 0.128, 0.144,
            0.160, 0.176, 0.192, 0.208, 0.224, 0.240, 0.256, 0.272, 0.288, 0.304,
            0.320, 0.336, 0.352, 0.368, 0.384, 0.400, 0.416, 0.432, 0.448, 0.464,
            0.480, 0.496, 0.512, 0.528, 0.544, 0.560, 0.576, 0.592, 0.608, 0.624,
            0.640, 0.656, 0.672, 0.688, 0.704, 0.720, 0.736, 0.752, 0.768, 0.784,
            0.800, 0.816, 0.832, 0.848, 0.864, 0.880, 0.896, 0.912, 0.928, 0.944,
            0.960, 0.976
        },
        { // Index 1: Position 1 (Cart 1, moving right)
            50.0, 53.20128, 56.40512, 59.61152, 62.82048, 66.032, 69.24608, 72.46272, 75.68192, 78.90368,
            82.128, 85.35488, 88.58432, 91.81632, 95.05088, 98.288, 101.52768, 104.76992, 108.01472, 111.26208,
            114.512, 117.76448, 121.01952, 124.27712, 127.53728, 130.8, 134.06528, 137.33312, 140.60352, 143.87648,
            147.152, 150.43008, 153.71072, 156.99392, 160.27968, 163.568, 166.85888, 170.15232, 173.44832, 176.74688,
            180.048, 183.35168, 186.65792, 189.96672, 193.27808, 196.592, 199.90848, 203.22752, 206.54912, 209.87328,
            213.2, 216.52928, 219.86112, 223.19552, 226.53248, 229.872, 233.21408, 236.55872, 239.90592, 243.25568,
            246.608, 249.96288, 253.32032, 256.68032, 260.04288, 263.408, 266.77568, 270.14592, 273.51872, 276.89408,
            280.272, 283.65248, 287.03552, 290.42112, 293.80928, 297.2, 300.59328, 303.98912, 307.38752, 310.78848,
            314.192, 317.59808, 321.00672, 324.41792, 327.83168, 331.248, 334.66688, 338.08832, 341.51232, 344.93888,
            348.368, 351.79968, 355.23392, 358.67072, 362.11008, 365.552, 368.99648, 372.44352, 375.89312, 379.34528,
            382.8, 386.25728, 389.71712, 393.17952, 396.64448, 400.112, 403.58208, 407.05472, 410.52992, 414.00768,
            417.488, 420.97088, 424.45632, 427.94432, 431.43488, 434.928, 438.42368, 441.92192, 445.42272, 448.92608,
            452.432, 455.94048, 459.45152, 462.96512, 466.48128, 470.0, 473.52128, 477.04512, 480.57152, 484.10048,
            487.632, 491.16608, 494.70272, 498.24192, 501.78368, 505.328, 508.87488, 512.42432, 515.97632, 519.53088,
            523.088, 526.64768, 530.20992, 533.77472, 537.34208, 540.912, 544.48448, 548.05952, 551.63712, 555.21728,
            558.8, 562.38528, 565.97312, 569.56352, 573.15648, 576.752, 580.35008, 583.95072, 587.55392, 591.15968,
            594.768, 598.37888, 601.99232, 605.60832, 609.22688, 612.848, 616.47168, 620.09792, 623.72672, 627.35808,
            630.992, 634.62848, 638.26752, 641.90912, 645.55328, 649.2, 652.84928, 656.50112, 660.15552, 663.81248,
            667.472, 671.13408, 674.79872, 678.46592, 682.13568, 685.808, 689.48288, 693.16032, 696.84032, 700.52288,
            704.208, 707.89568, 711.58592, 715.27872, 718.97408, 722.672, 726.37248, 730.07552, 733.78112, 737.48928,
            741.2, 744.91328, 748.62912, 752.34752, 756.06848, 759.792, 763.51808, 767.24672, 770.97792, 774.71168,
            778.448, 782.18688, 785.92832, 789.67232, 793.41888, 797.168, 800.91968, 804.67392, 808.43072, 812.19008,
            815.952, 819.71648, 823.48352, 827.25312, 831.02528, 834.8, 838.57728, 842.35712, 846.13952, 849.92448,
            853.712, 857.50208, 861.29472, 865.08992, 868.88768, 872.688, 876.49088, 880.29632, 884.10432, 887.91488,
            891.728, 895.54368, 899.36192, 903.18272, 907.00608, 910.832, 914.66048, 918.49152, 922.32512, 926.16128,
            930.0
        },
        { // Index 2: filler (unused or velocity)
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        { // Index 3: filler (unused or velocity)
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        { // Index 4: Position 2 (Cart 2, moving left)
            200.0, 196.79872, 193.60128, 190.40768, 187.21792, 184.032, 180.84992, 177.67168, 174.49728, 171.32672,
            168.16, 164.99712, 161.83808, 158.68288, 155.53152, 152.384, 149.24032, 146.10048, 142.96448, 139.83232,
            136.704, 133.57952, 130.45888, 127.34208, 124.22912, 121.12, 118.01472, 114.91328, 111.81568, 108.72192,
            105.632, 102.546, 99.46384, 96.38552, 93.31104, 90.2404, 87.1736, 84.11064, 81.05152, 77.99624,
            74.9448, 71.8972, 68.85344, 65.81352, 62.77744, 59.7452, 56.7168, 53.69224, 50.67152, 47.65464,
            44.6416, 41.6324, 38.62704, 35.62552, 32.62784, 29.634, 26.644, 23.65784, 20.67552, 17.69704,
            14.7224, 11.7516, 8.78464, 5.82152, 2.86224, -0.0932, -3.0458, -5.99552, -8.9424, -11.8864,
            -14.82752, -17.7658, -20.7012, -23.63376, -26.56348, -29.49032, -32.41432, -35.33544, -38.25372, -41.16912,
            -44.08168, -46.99136, -49.8982, -52.8022, -55.70336, -58.60168, -61.49716, -64.38984, -67.27968, -70.16672,
            -73.05092, -75.93232, -78.81088, -81.68664, -84.5596, -87.42976, -90.29712, -93.16168, -96.02344, -98.8824,
            -101.73856, -104.59192, -107.44248, -110.29024, -113.1352, -115.97736, -118.81672, -121.65328, -124.48704, -127.31792,
            -130.14592, -132.97112, -135.79352, -138.61312, -141.42992, -144.24392, -147.05512, -149.86352, -152.66912, -155.47192,
            -158.27192, -161.06912, -163.86352, -166.65512, -169.44392, -172.22992, -175.01312, -177.79352, -180.57112, -183.34592,
            -186.11792, -188.88712, -191.65352, -194.41712, -197.17792, -199.93592, -202.69112, -205.44352, -208.19312, -210.93992,
            -213.68392, -216.42512, -219.16352, -221.89912, -224.63192, -227.36192, -230.08912, -232.81352, -235.53512, -238.25392,
            -240.96992, -243.68312, -246.39352, -249.10112, -251.80592, -254.50792, -257.20712, -259.90352, -262.59712, -265.28792,
            -267.97592, -270.66112, -273.34352, -276.02312, -278.69992, -281.37392, -284.04512, -286.71352, -289.37912, -292.04192,
            -294.70192, -297.35912, -300.01352, -302.66512, -305.31392, -307.95992, -310.60312, -313.24352, -315.88112, -318.51592,
            -321.14792, -323.77712, -326.40352, -329.02712, -331.64792, -334.26592, -336.88112, -339.49352, -342.10312, -344.70992,
            -347.31392, -349.91512, -352.51352, -355.10912, -357.70192, -360.29192, -362.87912, -365.46352, -368.04512, -370.62392,
            -373.19992, -375.77312, -378.34352, -380.91112, -383.47592, -386.03792, -388.59712, -391.15352, -393.70712, -396.25792,
            -398.80592, -401.35112, -403.89352, -406.43312, -408.96992, -411.50392, -414.03512, -416.56352, -419.08912, -421.61192,
            -424.13192, -426.64912, -429.16352, -431.67512, -434.18392, -436.68992, -439.19312, -441.69352, -444.19112, -446.68592,
            -449.17792, -451.66712, -454.15352, -456.63712, -459.11792, -461.59592, -464.07112, -466.54352, -469.01312, -471.47992,
            -473.94392, -476.40512, -478.86352, -481.31912, -483.77192, -486.22192, -488.66912, -491.11352, -493.55512, -495.99392,
            -498.42992, -500.86312, -503.29352, -505.72112, -508.14592, -510.56792, -512.98712, -515.40352, -517.81712, -520.22792,
            -522.63592, -525.04112, -527.44352, -529.84312, -532.23992, -534.63392, -537.02512, -539.41352, -541.79912, -544.18192,
            -546.56192, -548.93912, -551.31352, -553.68512, -556.05392, -558.41992, -560.78312, -563.14352, -565.50112, -567.85592,
            -570.20792, -572.55712, -574.90352, -577.24712, -579.58792, -581.92592, -584.26112, -586.59352, -588.92312, -591.24992,
            -593.57392, -595.89512, -598.21352, -600.52912, -602.84192, -605.15192, -607.45912, -609.76352, -612.06512, -614.36392,
            -616.65992, -618.95312, -621.24352, -623.53112, -625.81592, -628.09792, -630.37712, -632.65352, -634.92712, -637.19792,
            -639.46592, -641.73112, -643.99352, -646.25312, -648.50992, -650.76392, -653.01512, -655.26352, -657.50912, -659.75192,
            -661.99192, -664.22912, -666.46352, -668.69512, -670.92392, -673.14992, -675.37312, -677.59352, -679.81112, -682.02592,
            -684.23792, -686.44712, -688.65352, -690.85712, -693.05792, -695.25592, -697.45112, -699.64352, -701.83312, -704.01992,
            -706.20392, -708.38512, -710.56352, -712.73912, -714.91192, -717.08192, -719.24912, -721.41352, -723.57512, -725.73392,
            -727.88992, -730.04312, -732.19352, -734.34112, -736.48592, -738.62792, -740.76712, -742.90352, -745.03712, -747.16792,
            -749.29592, -751.42112, -753.54352, -755.66312, -757.77992, -759.89392, -762.00512, -764.11352, -766.21912, -768.32192,
            -770.42192, -772.51912, -774.61352, -776.70512, -778.79392, -780.87992, -782.96312, -785.04352, -787.12112, -789.19592,
            -791.26792, -793.33712, -795.40352, -797.46712, -799.52792, -801.58592, -803.64112, -805.69352, -807.74312, -809.78992,
            -811.83392, -813.87512, -815.91352, -817.94912, -819.98192, -822.01192, -824.03912, -826.06352, -828.08512, -830.10392,
            -832.11992, -834.13312, -836.14352, -838.15112, -840.15592, -842.15792, -844.15712, -846.15352, -848.14712, -850.13792,
            -852.12592, -854.11112, -856.09352, -858.07312, -860.04992, -862.02392, -863.99512, -865.96352, -867.92912, -869.89192,
            -871.85192, -873.80912, -875.76352, -877.71512, -879.66392, -881.60992, -883.55312, -885.49352, -887.43112, -889.36592,
            -891.29792, -893.22712, -895.15352, -897.07712, -899.0
        }
    }};
        
        Cart cart1 = new Cart(1, -1, 150);
        Cart cart2 = new Cart(1, 1, 60);
        
        SimulationPanel idea = new SimulationPanel(testData, "pe", false, cart1, cart2, tempSim);
        tempSim.add(idea, BorderLayout.CENTER);
        idea.startSimulation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        CloseButtonBorder = new javax.swing.JPanel();
        TitleScreen1 = new javax.swing.JLabel();
        tempSim = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(620, 700));
        setMinimumSize(new java.awt.Dimension(620, 700));
        setPreferredSize(new java.awt.Dimension(620, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeButton.setBackground(new java.awt.Color(204, 204, 204));
        closeButton.setText("Close");
        closeButton.setBorder(null);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 610, 580, 30));

        CloseButtonBorder.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(CloseButtonBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 608, 584, 34));

        TitleScreen1.setBackground(new java.awt.Color(153, 153, 153));
        TitleScreen1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 96)); // NOI18N
        TitleScreen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleScreen1.setText("Simulation");
        TitleScreen1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(TitleScreen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 600, -1));

        tempSim.setBackground(new java.awt.Color(204, 204, 204));
        tempSim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        javax.swing.GroupLayout tempSimLayout = new javax.swing.GroupLayout(tempSim);
        tempSim.setLayout(tempSimLayout);
        tempSimLayout.setHorizontalGroup(
            tempSimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        tempSimLayout.setVerticalGroup(
            tempSimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        getContentPane().add(tempSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 230, 580, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed

        GUI.changeOpenS();
        setVisible(false);

    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SimPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CloseButtonBorder;
    private javax.swing.JLabel TitleScreen1;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel tempSim;
    // End of variables declaration//GEN-END:variables
}
