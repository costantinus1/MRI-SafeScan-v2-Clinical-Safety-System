package clinic.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import clinic.db.DatabaseManager;

public class MriSafetyScreener extends JFrame {

    private JTextField patientIdInput, patientInitialsInput;
    private JCheckBox cbPacemaker, cbAllergies, cbRenal;
    private JLabel safetyStatusFooter;
    private JButton btnExecute;

    public MriSafetyScreener() {
        // --- 1. WINDOW ARCHITECTURE ---
        setTitle("MRI SafeScan v2.0 — Clinical Safety System");
        setSize(520, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // CUSTOM COLOR PALETTE
        Color forestGreen = new Color(69, 89, 40); 
        Color khakiText = new Color(185, 195, 120); 

        // --- 2. BRANDING HEADER (NORTH) ---
        JPanel brandingHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        brandingHeader.setBackground(forestGreen);
        brandingHeader.setPreferredSize(new Dimension(500, 110));

        JLabel logoLabel = new JLabel();
        try {
            
            ImageIcon icon = new ImageIcon("src/hospital_logo.jpg");
            if (icon.getIconWidth() > 0) {
                Image scaled = icon.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
                logoLabel.setIcon(new ImageIcon(scaled));
            }
        } catch (Exception e) {
            logoLabel.setText("[ HOSPITAL LOGO ]");
            logoLabel.setForeground(khakiText);
        }

        brandingHeader.add(logoLabel);
        add(brandingHeader, BorderLayout.NORTH);

        // 3 CLINICAL INTERFACE (CENTER) 
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(forestGreen);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input: Patient ID
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblId = new JLabel("Patient ID (Pseudonymized):");
        lblId.setForeground(khakiText);
        lblId.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mainPanel.add(lblId, gbc);

        patientIdInput = new JTextField(15);
        gbc.gridy = 1;
        mainPanel.add(patientIdInput, gbc);

        // Input: Initials
        gbc.gridy = 2;
        JLabel lblInit = new JLabel("Patient Initials:");
        lblInit.setForeground(khakiText);
        lblInit.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mainPanel.add(lblInit, gbc);

        patientInitialsInput = new JTextField(15);
        gbc.gridy = 3;
        mainPanel.add(patientInitialsInput, gbc);

        // Section Title
        JLabel mainTitle = new JLabel("MRI  SAFETY  SCREENING", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Monospaced", Font.BOLD, 22));
        mainTitle.setForeground(khakiText);
        gbc.gridy = 4; gbc.insets = new Insets(30, 0, 15, 0);
        mainPanel.add(mainTitle, gbc);

        // Safety Checkboxes
        cbPacemaker = new JCheckBox("Positive for Pacemaker / Metal Implant");
        cbPacemaker.setForeground(new Color(255, 180, 180)); // Warning Red/Pink
        cbPacemaker.setOpaque(false);
        gbc.gridy = 5; gbc.insets = new Insets(5, 0, 5, 0);
        mainPanel.add(cbPacemaker, gbc);

        cbAllergies = new JCheckBox("History of Severe Allergies");
        cbAllergies.setForeground(khakiText);
        cbAllergies.setOpaque(false);
        gbc.gridy = 6;
        mainPanel.add(cbAllergies, gbc);

        cbRenal = new JCheckBox("History of Renal Failure");
        cbRenal.setForeground(khakiText);
        cbRenal.setOpaque(false);
        gbc.gridy = 7;
        mainPanel.add(cbRenal, gbc);

        // Primary Action
        btnExecute = new JButton("EXECUTE SAFETY CHECK");
        btnExecute.setBackground(khakiText);
        btnExecute.setOpaque(true);
        btnExecute.setBorderPainted(false);
        btnExecute.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridy = 8; gbc.insets = new Insets(30, 0, 20, 0);
        mainPanel.add(btnExecute, gbc);

        // Dynamic Status Indicator
        safetyStatusFooter = new JLabel("SYSTEM READY", SwingConstants.CENTER);
        safetyStatusFooter.setForeground(khakiText);
        safetyStatusFooter.setFont(new Font("Monospaced", Font.BOLD, 18));
        safetyStatusFooter.setBorder(new LineBorder(khakiText, 1));
        safetyStatusFooter.setPreferredSize(new Dimension(300, 60));
        gbc.gridy = 9;
        mainPanel.add(safetyStatusFooter, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // 4. OPERATIONS 
        btnExecute.addActionListener(e -> runSafetyLogic());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void runSafetyLogic() {
        String patientId = patientIdInput.getText().trim();
        if (patientId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ERROR: ID REQUIRED");
            return;
        }

        String status;
        if (cbPacemaker.isSelected()) {
            status = "RED: ABORT";
            safetyStatusFooter.setText("STATUS: RED - ABORT");
            safetyStatusFooter.setForeground(Color.RED);
        } else if (cbAllergies.isSelected() || cbRenal.isSelected()) {
            status = "YELLOW: CONSULT";
            safetyStatusFooter.setText("STATUS: YELLOW - CONSULT");
            safetyStatusFooter.setForeground(Color.YELLOW);
        } else {
            status = "GREEN: SUCCESS";
            safetyStatusFooter.setText("STATUS: GREEN - SAFE");
            safetyStatusFooter.setForeground(new Color(185, 195, 120));
        }

        // Save result to Safety sceening history
        DatabaseManager.saveResult(patientId, status);
    }
}