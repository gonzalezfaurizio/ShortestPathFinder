package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import com.shortestpathfinder.model.Maze;

public class MazePreviewFrame extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton backButton;
    private JList<Maze> mazeList;
    private Maze selectedMaze;

    public MazePreviewFrame(List<Maze> mazes, ActionListener selectionListener) {
        setTitle("Select Maze");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

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
        scrollPane.setBounds(0, 0, 400, 400); // Ajustar tamaño y posición según el diseño
        getContentPane().add(scrollPane);

        // Back button
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
        backButton.addActionListener(e -> dispose());
        backButton.setFocusable(false);

        // Panel with image
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Image path
        String imagePath = "C:\\Users\\fauri\\OneDrive - Universidad de Costa Rica\\Documentos\\A. Universidad De Costa Rica\\A. Informática\\B. Algoritmos y Estructuras de Datos\\E. Proyecto Programado\\ShortestPathFinder\\src\\main\\java\\com\\shortestpathfinder\\resources\\maze.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);

        JButton selectButton = new JButton("Select");
        selectButton.setBackground(new Color(231, 231, 231));
        selectButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectButton.setBounds(240, 500, 180, 39);
        getContentPane().add(selectButton);
        selectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                selectButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectButton.setBackground(new Color(231, 231, 231));
            }
        });
        selectButton.addActionListener(e -> {
            selectedMaze = mazeList.getSelectedValue();
            selectionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            dispose();
        });
        selectButton.setFocusable(false);

        setVisible(true);
    }

    public Maze getSelectedMaze() {
        return selectedMaze;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
