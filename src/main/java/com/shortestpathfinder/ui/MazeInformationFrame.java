package com.shortestpathfinder.ui;

import com.shortestpathfinder.model.Maze;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * Frame class for displaying maze information. Extends JFrame and implements
 * ActionListener to handle button events.
 *
 * @version 1.0
 * @since 2024-06-25
 *
 * Displays a list of mazes and provides a back button to return to the previous
 * menu.
 * 
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MazeInformationFrame extends JFrame implements ActionListener {

    /**
     * The main panel containing the UI components.
     */
    private JPanel panel;

    /**
     * Button to go back to the previous menu.
     */
    private JButton backButton;

    /**
     * List component to display available mazes.
     */
    private JList<Maze> mazeList;

    /**
     * Constructs a new MazeInformationFrame. Initializes the frame with a list
     * of mazes and sets up the UI components.
     *
     * @param mazes the list of Maze objects to be displayed.
     */
    public MazeInformationFrame(List<Maze> mazes) {
        setTitle("Maze Information");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        initUI(mazes);
        setVisible(true);
    }

    /**
     * Initializes the UI components of the frame.
     *
     * @param mazes the list of Maze objects to be displayed.
     */
    private void initUI(List<Maze> mazes) {
        // Maze list setup
        mazeList = new JList<>(new DefaultListModel<>());
        mazes.forEach(maze -> ((DefaultListModel<Maze>) mazeList.getModel()).addElement(maze));
        mazeList.setCellRenderer(new ListCellRenderer<>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Maze> list, Maze value, int index, boolean isSelected, boolean cellHasFocus) {
                MazePreviewPanel panel = new MazePreviewPanel(value);
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel.setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
                return panel;
            }
        });

        JScrollPane scrollPane = new JScrollPane(mazeList);
        scrollPane.setBounds(0, 0, 400, 400);
        getContentPane().add(scrollPane);

        // Back button setup
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 500, 180, 39);
        getContentPane().add(backButton);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBackground(new Color(231, 231, 231));
            }
        });
        backButton.addActionListener(this);
        backButton.setFocusable(false);

        // Panel with image setup
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Image label setup
        String imagePath = "resources/info.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
    }

    /**
     * Handles action events triggered by the view. Disposes the frame if the
     * back button is pressed.
     *
     * @param e the ActionEvent triggered by a user action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
