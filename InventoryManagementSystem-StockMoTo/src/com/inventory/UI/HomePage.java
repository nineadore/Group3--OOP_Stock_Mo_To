package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class HomePage extends JPanel {

    private JLabel welcomeLabel;
    private static final Dimension PANEL_SIZE = new Dimension(700, 400);

    public HomePage(String username) {
        initComponents();
        loadUserData(username);
    }

    private void loadUserData(String username) {
        SwingUtilities.invokeLater(() -> {
            try {
                UserDTO userDTO = new UserDTO();
                new UserDAO().getFullName(userDTO, username);
                welcomeLabel.setText("Welcome, " + 
                    (userDTO.getFullName() != null ? 
                     userDTO.getFullName() : username) + "!");
            } catch (Exception e) {
                welcomeLabel.setText("Welcome!");
                e.printStackTrace();
            }
        });
    }

    private void initComponents() {
        setBackground(new Color(245, 245, 245));
        setLayout(new GridBagLayout());
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20), 
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(40, 40, 40, 40)
            )
        ));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(PANEL_SIZE);

        welcomeLabel = new JLabel("Welcome!", SwingConstants.CENTER);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setFont(new Font("Poppins", Font.BOLD, 42));
        welcomeLabel.setForeground(new Color(40, 40, 40));

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        descriptionLabel.setForeground(new Color(90, 90, 90));
        descriptionLabel.setText("<html><center>Manage your inventory, sales, and staff<br><br>"
                + "Click <b style='color:#2962FF;'>Menu</b> to begin</center></html>");

        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(welcomeLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        contentPanel.add(descriptionLabel);
        contentPanel.add(Box.createVerticalGlue());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        add(contentPanel, gbc);
    }
}