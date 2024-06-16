package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for the instructions submenu view.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class InstructionsView extends JFrame {

    /**
     * The main panel containing the UI components.
     */
    private JPanel panel;

    /**
     * Button to go back to the previous menu.
     */
    private JButton backButton;

    /**
     * Constructs a new InstructionsView. Initializes the UI components and sets
     * up the window properties.
     */
    public InstructionsView() {
        setTitle("Instructions");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        initUI();
        setVisible(true);
    }

    /**
     * Initializes the UI components of the view.
     */
    private void initUI() {
        //----------------"Titulos"-------------------------//
        JLabel label = new JLabel("IF3001 TP01 GR02");
        label.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
        label.setBounds(32, 40, 600, 39);
        getContentPane().add(label);

        // ShortestPathFinder
        JLabel label1 = new JLabel("‘Game Instructions’");
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(32, 80, 600, 39);
        getContentPane().add(label1);

        //----------------"Instrucciones del Juego"-------------------------//
        String instructions
                = "1. Entrar al Laberinto:\n"
                + "   - Descripción: Esta opción te permite cargar nuevos laberintos o actualizar los existentes.\n"
                + "   - Cómo usar:\n"
                + "       1. Selecciona el botón 'Upload Maze'.\n"
                + "       2. Usa el explorador de archivos para seleccionar un archivo JSON con la estructura correcta de un laberinto.\n"
                + "       3. Si el archivo se carga correctamente, recibirás una confirmación. De lo contrario, verifica el formato del archivo y vuelve a intentarlo.\n\n"
                + "2. Iniciar Nuevo Juego:\n"
                + "   - Descripción: Esta opción te permite comenzar un nuevo juego seleccionando un laberinto, un jugador y un algoritmo de búsqueda.\n"
                + "   - Cómo usar:\n"
                + "       1. Selecciona el botón 'Start New Game'.\n"
                + "       2. Sigue los pasos para seleccionar un laberinto, un jugador y un algoritmo:\n"
                + "           - Select Maze: Elige uno de los laberintos cargados.\n"
                + "           - Select Player: Selecciona uno de los jugadores registrados.\n"
                + "           - Select Algorithm: Selecciona el algoritmo que deseas utilizar para resolver el laberinto.\n"
                + "       3. El juego comenzará automáticamente y el algoritmo seleccionado encontrará el camino más corto en el laberinto.\n\n"
                + "3. Simular Búsqueda de Caminos:\n"
                + "   - Descripción: Esta opción ejecuta los algoritmos de búsqueda de caminos en el laberinto seleccionado.\n"
                + "   - Cómo usar:\n"
                + "       1. Selecciona el botón 'Simulate Pathfinding'.\n"
                + "       2. El algoritmo encontrará el camino más corto y mostrará gráficamente la solución en la pantalla.\n"
                + "       3. La representación gráfica muestra el punto de inicio en azul, el punto final en rojo y el camino con una transición de colores de azul a rojo según la distancia recorrida.\n\n"
                + "4. Ver Instrucciones del Juego:\n"
                + "   - Descripción: Muestra las instrucciones del juego (este manual).\n"
                + "   - Cómo usar:\n"
                + "       1. Selecciona el botón 'Game Instructions'.\n"
                + "       2. Lee atentamente todas las instrucciones para entender cómo jugar y utilizar todas las funciones del juego.\n\n"
                + "5. Salón de la Fama:\n"
                + "   - Descripción: Muestra los récords del salón de la fama, ordenados por la cantidad de pasos dados en la solución del laberinto.\n"
                + "   - Cómo usar:\n"
                + "       1. Selecciona el botón 'Hall of Fame'.\n"
                + "       2. Verás una lista de récords con el nombre del jugador, el nombre del laberinto, el algoritmo utilizado y la cantidad de pasos dados.\n"
                + "       3. Los récords están ordenados de menor a mayor cantidad de pasos, mostrando los jugadores más eficientes en la parte superior.\n\n"
                + "6. Salir de la Aplicación:\n"
                + "   - Descripción: Cierra el juego y sale de la aplicación.\n"
                + "   - Cómo usar:\n"
                + "       1. Selecciona el botón 'Exit'.\n"
                + "       2. Confirma que deseas salir si se te pide una confirmación.\n\n"
                + "Consejos Adicionales:\n"
                + "- Formato del Archivo JSON: Asegúrate de que tus archivos JSON estén correctamente formateados. Aquí tienes un ejemplo:\n"
                + "  {\n"
                + "    \"code\": \"maze1\",\n"
                + "    \"name\": \"Simple Maze\",\n"
                + "    \"difficulty\": \"Easy\",\n"
                + "    \"grid\": [\n"
                + "      [\"S\", \" \", \"X\", \" \", \"E\"],\n"
                + "      [\"X\", \" \", \"X\", \" \", \"X\"],\n"
                + "      [\" \", \" \", \" \", \" \", \" \"],\n"
                + "      [\"X\", \"X\", \"X\", \" \", \"X\"],\n"
                + "      [\" \", \" \", \" \", \" \", \" \"]\n"
                + "    ]\n"
                + "  }\n"
                + "- Evitar Caracteres Especiales: No utilices caracteres especiales en los nombres de jugadores para evitar problemas de validación.\n"
                + "- Optimización del Camino: Prueba diferentes algoritmos y laberintos para ver cuál es más eficiente en encontrar el camino más corto.\n\n"
                + "¡Disfruta del juego y desafía tus habilidades de resolución de laberintos con Shortest Path Finder!";

        JTextArea instructionsText = new JTextArea(instructions);
        instructionsText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        instructionsText.setEditable(false);
        instructionsText.setBackground(new Color(236, 236, 236));

        JScrollPane scrollPane = new JScrollPane(instructionsText);
        scrollPane.setBounds(32, 140, 400, 200);
        getContentPane().add(scrollPane);

        //----------------"Autores"-------------------------//
        JLabel FAURIZIO = new JLabel("GONZALEZ ALFARO FAURIZIO");
        FAURIZIO.setFont(new Font("Tahoma", Font.BOLD, 10));
        FAURIZIO.setBounds(32, 480, 600, 39);
        getContentPane().add(FAURIZIO);

        JLabel REBECA = new JLabel("RODRIGUEZ GUTIERREZ REBECA");
        REBECA.setFont(new Font("Tahoma", Font.BOLD, 10));
        REBECA.setBounds(32, 500, 600, 39);
        getContentPane().add(REBECA);

        JLabel ANDREY = new JLabel("RODRIGUEZ RODRIGUEZ ANDREY ELADIO");
        ANDREY.setFont(new Font("Tahoma", Font.BOLD, 10));
        ANDREY.setBounds(32, 520, 600, 39);
        getContentPane().add(ANDREY);

        //----------------"Back"-------------------------//
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 350, 180, 39);
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

        backButton.setFocusable(false);

        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "C:\\Users\\fauri\\OneDrive - Universidad de Costa Rica\\Documentos\\GitHub\\ShortestPathFinder\\src\\main\\java\\com\\shortestpathfinder\\resources\\file.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
    }

    /**
     * Gets the back button.
     *
     * @return the back button.
     */
    public JButton getBackButton() {
        return backButton;
    }
}
