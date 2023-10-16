package Interfaz;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
	import java.util.List;
	import Conector.Conexion;
        import java.sql.*;
	
	public class Principal {
		//Declaracion de las variables
            
// Declaración del panel para mostrar las tablas
            private JPanel tableButtonsPanel;
	    private JFrame frame;
	    private JMenuBar menuBar;
	    private JMenu menu;
	    private JPanel mainPanel;
	    private JPanel conectarPanel;
	    private final JPanel crearBdPanel;
	    private final JPanel crearTablasPanel;
	    private final JPanel inicioPanel;
	    private final JPanel leftPanel; 
	    private final JLabel label;
	    private JTextField nombreTablaTextField;
	    private JSpinner caracteresEspecialesSpinner;
            String host;
            String puerto;
            String usuario;
            String contrasena;
            String Database;
            JTextArea displayArea = new JTextArea(20, 40);
	    //Clase principal del JFrame
	    public Principal() {
//-----------------------------------------------------------------------------------------------------
	    	//Se crea la ventana principal del programa
	        frame = new JFrame("BunnyDB");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(800, 600);
	        frame.getContentPane().setBackground(new Color(0, 162, 255));  // establece el color de fondo del contenedor principal del JFrame en un tono de azul claro.
	        frame.setLocationRelativeTo(null);
                ImageIcon icon = new ImageIcon(Principal.class.getResource("/com/images/icono.jfif")); // Cambia la ruta a la ubicación de tu icono
                Image image = icon.getImage();
                frame.setIconImage(image);
//-----------------------------------------------------------------------------------------------------
	      
	        //-----------------------------------------------------------------------------------------------------	        
	        //Se crea el menu del JFrame
	        menuBar = new JMenuBar();
	        menu = new JMenu("Conexion");
	        menuBar.add(menu);
	      //-----------------------------------------------------------------------------------------------------
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        //Se crean los items del menu
	        menu.add(createMenuItem("Inicio")); // esta línea de código agrega un elemento de menú con el texto "Inicio" al menú principal en la barra de menús (menuBar) del JFrame.
	        menu.add(createMenuItem("Conectar"));
	        menu.add(createMenuItem("Crear"));
	        menu.add(createMenuItem("Crear tablas"));
	        frame.setJMenuBar(menuBar);  //se asigna la barra de menu
	   
	        // se asigna el administrador de diseños
	        mainPanel = new JPanel(new CardLayout()); //CardLayout es un tipo de administrador de diseño que permite mostrar un componente a la vez, ocupando todo el espacio del contenedor.
	        mainPanel.setBackground(Color.WHITE); //Se asigna un fondo
	      //-----------------------------------------------------------------------------------------------------	        
	        
	        //-----------------------------------------------------------------------------------------------------
	        // Panel para "Conectar a BD"
	        conectarPanel = new JPanel();
	        conectarPanel.setBackground(new Color(204, 223, 234)); //Color del panel conectar
	        GroupLayout conectarLayout = new GroupLayout(conectarPanel); //GroupLayout es un administrador de diseño, nos ayuda a ordenar vertical u horizontalmente los objetos, conectar panel tendra este diseño
	        conectarPanel.setLayout(conectarLayout); //A través de esta línea, se indica que el GroupLayout será responsable de organizar los componentes en el conectarPanel
	        conectarLayout.setAutoCreateGaps(true); //habilita la creación automática de espacios entre los componentes dentro de los grupos en el GroupLayout.
	        conectarLayout.setAutoCreateContainerGaps(true); // mas espacios entre los componentes
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	          
	        // Etiquetas y cuadros de texto para "Conectar a BD"
	        JLabel puertoLabel = new JLabel("Puerto:"); //label del puerto
	        JTextField puertoTextField = new JTextField(10); //Campo de texto 
	        JLabel direccionLabel = new JLabel("Host:");//Label para el host
	        JTextField direccionTextField = new JTextField(10);//campo de texto
	        JLabel usuarioLabel = new JLabel("Usuario:");//Label para usuario
	        JTextField usuarioTextField = new JTextField(10);//campo de Texto
	        JLabel contrasenaLabel = new JLabel("Contraseña:"); //label de la contraseña
	        JPasswordField contrasenaField = new JPasswordField(10); //area de la contraseña
	        JButton testButton = new JButton("Prueba"); //boton para prubeas
	        testButton.setBackground(new Color(114, 253, 253)); //Color del boton
	        testButton.setBorder(BorderFactory.createLineBorder(Color.WHITE)); //color de los bordes
	        JButton conectarButton = new JButton("Conectar"); //boton para conectar
	        conectarButton.setBackground(new Color(83, 161, 255)); //Color del boton?
	        conectarButton.setForeground(Color.white); //Color de letras del botol
	        conectarButton.setBorder(BorderFactory.createLineBorder(Color.white)); //bordes del boton
	      //-----------------------------------------------------------------------------------------------------	        
	        
//--------------------------------------------------------------------------------------------------------------
	        //Este bloque lo que hace es establecer la disposición de los componentes en el eje horizontal utilizando GroupLayout
	        conectarLayout.setHorizontalGroup(conectarLayout.createSequentialGroup()
	                .addGroup(conectarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(puertoLabel)
	                        .addComponent(direccionLabel)
	                        .addComponent(usuarioLabel)
	                        .addComponent(contrasenaLabel)
	                        .addComponent(testButton)
	                ) //El primer grupo (SequentialGroup) incluye los labels y el botón de prueba (puertoLabel, direccionLabel, usuarioLabel, contrasenaLabel, testButton).
	                
	                .addGroup(conectarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(puertoTextField)
	                        .addComponent(direccionTextField)
	                        .addComponent(usuarioTextField)
	                        .addComponent(contrasenaField)
	                        .addComponent(conectarButton)
	                ) //El segundo grupo (SequentialGroup) incluye los campos de texto y el botón de conectar (puertoTextField, direccionTextField, usuarioTextField, contrasenaField, conectarButton)
	        );
//---------------------------------------------------------------------------------------------------------------
	        
//---------------------------------------------------------------------------------------------------------------
	        //Este bloque establece la disposición de los componentes en el eje vertical utilizando GroupLayout
	        //agrupa dos componentes relacionados verticalmente en una línea base (baseline).
	        conectarLayout.setVerticalGroup(conectarLayout.createSequentialGroup()
	                .addGroup(conectarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(puertoLabel)
	                        .addComponent(puertoTextField)
	                ) // En este caso, los componentes se agrupan en parejas relacionadas, y luego esas parejas se agrupan en una secuencia.
	                .addGroup(conectarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(direccionLabel)
	                        .addComponent(direccionTextField)
	                )// cada etiqueta, con su cuadro de texto
	                .addGroup(conectarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(usuarioLabel)
	                        .addComponent(usuarioTextField)
	                )//En todos los casos
	                .addGroup(conectarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(contrasenaLabel)
	                        .addComponent(contrasenaField)
	                )//Como vemos aqui
	                .addGroup(conectarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(testButton)
	                        .addComponent(conectarButton)
	                )//y aqui
	        );
//-----------------------------------------------------------------------------------------------------------------------------
	        //Accion del boton conectar
	        conectarButton.addActionListener((ActionEvent e) -> {
                    setHost(direccionTextField.getText());
                    setPuerto(puertoTextField.getText());
                    setUsuario(usuarioTextField.getText());
                    setContrasena(contrasenaField.getText());
                    // Verifica que los campos no estén vacíos
                    if (host.isEmpty() || puerto.isEmpty() || usuario.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                        return;  // No intentes conectarte si faltan datos
                    } else{
                        initDatabaseConnection();
                    }
                    
                    // Intenta establecer la conexión
                    Conexion con = new Conexion();
                    con.connect(host, puerto, usuario, contrasena);
                });
                
//-----------------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------
	      //-----------------------------------------------------------------------------------------------------	        
	        // Panel para "Crear una Bd"
	        crearBdPanel = new JPanel();
	        crearBdPanel.setBackground(new Color(173, 216, 230));

	        GroupLayout crearBdLayout = new GroupLayout(crearBdPanel);
	        crearBdPanel.setLayout(crearBdLayout);
	        crearBdLayout.setAutoCreateGaps(true);
	        crearBdLayout.setAutoCreateContainerGaps(true);

	        // Etiquetas y cuadros de texto para "Crear una Bd"
	        JLabel nombreLabel = new JLabel("Nombre:");
	        JTextField nombreTextField = new JTextField(10);
	        JButton crearBdButton = new JButton("Crear");
	        crearBdButton.setBackground(new Color(0, 255, 0));
	        crearBdButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        JButton cancelarBdButton = new JButton("Cancelar");
	        cancelarBdButton.setBackground(new Color(255, 0, 0));
	        cancelarBdButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        crearBdLayout.setHorizontalGroup(crearBdLayout.createSequentialGroup()
	                .addGroup(crearBdLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(nombreLabel)
	                )
	                .addGroup(crearBdLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(nombreTextField)
	                        .addComponent(crearBdButton)
	                        .addComponent(cancelarBdButton)
	                )
	        );
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        crearBdLayout.setVerticalGroup(crearBdLayout.createSequentialGroup()
	                .addGroup(crearBdLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(nombreLabel)
	                        .addComponent(nombreTextField)
	                )
	                .addGroup(crearBdLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(crearBdButton)
	                )
	                .addGroup(crearBdLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(cancelarBdButton)
	                )
	        );
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        // Panel para "Crear tablas de bd"
	        crearTablasPanel = new JPanel();
	        crearTablasPanel.setBackground(new Color(204, 223, 234));

	        GroupLayout crearTablasLayout = new GroupLayout(crearTablasPanel);
	        crearTablasPanel.setLayout(crearTablasLayout);
	        crearTablasLayout.setAutoCreateGaps(true);
	        crearTablasLayout.setAutoCreateContainerGaps(true);
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        // ComboBox para bases de datos
	        JComboBox<String> basesDeDatosComboBox = new JComboBox<>(new String[]{"Base de Datos 1", "Base de Datos 2", "Base de Datos 3"});
	        JLabel nombreTablaLabel = new JLabel("Nombre de la tabla:");
	        JTextField nombreTablaTextField = new JTextField(10);
	        JLabel cantidadColumnasLabel = new JLabel("Cantidad de columnas:");
	        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 15, 1);
	        JSpinner cantidadColumnasSpinner = new JSpinner(spinnerModel);
	        JButton crearTablaButton = new JButton("Crear");
	        crearTablaButton.setBackground(new Color(0, 255, 0));
	        crearTablaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        JButton cancelarTablaButton = new JButton("Cancelar");
	        cancelarTablaButton.setBackground(new Color(255, 0, 0));
	        cancelarTablaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        crearTablasLayout.setHorizontalGroup(crearTablasLayout.createSequentialGroup()
	                .addGroup(crearTablasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(basesDeDatosComboBox)
	                        .addComponent(nombreTablaLabel)
	                        .addComponent(cantidadColumnasLabel)
	                )
	                .addGroup(crearTablasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(nombreTablaTextField)
	                        .addComponent(cantidadColumnasSpinner)
	                        .addComponent(crearTablaButton)
	                        .addComponent(cancelarTablaButton)
	                )
	        );
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        crearTablasLayout.setVerticalGroup(crearTablasLayout.createSequentialGroup()
	                .addGroup(crearTablasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(basesDeDatosComboBox)
	                )
	                .addGroup(crearTablasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(nombreTablaLabel)
	                        .addComponent(nombreTablaTextField)
	                )
	                .addGroup(crearTablasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(cantidadColumnasLabel)
	                        .addComponent(cantidadColumnasSpinner)
	                )
	                .addGroup(crearTablasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(crearTablaButton)
	                )
	                .addGroup(crearTablasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(cancelarTablaButton)
	                )
	        );
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        crearTablaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                showTableInfoDialog(nombreTablaTextField.getText(), (int) cantidadColumnasSpinner.getValue());
	            }
	        });
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        // Panel para "Inicio"
	        
	        inicioPanel = new JPanel();
	        inicioPanel.setBackground(new Color(255, 255, 255));
	        GroupLayout inicioLayout = new GroupLayout(inicioPanel);
	        inicioPanel.setLayout(inicioLayout);
	        inicioLayout.setAutoCreateGaps(true);
	        inicioLayout.setAutoCreateContainerGaps(true);

	        ImageIcon icono = new ImageIcon(Principal.class.getResource("/com/images/BunnyDB.png"));
	        label = new JLabel(icono);
	        label.setHorizontalAlignment(SwingConstants.RIGHT);  // Centrar horizontalmente
	        label.setVerticalAlignment(SwingConstants.CENTER);  // Centrar verticalmente
	        JLabel inicioTextLabel = new JLabel("¡Bienvenido a BunnyDB!");
	        inicioTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        inicioTextLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        inicioTextLabel.setForeground(Color.BLACK);
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        inicioLayout.setHorizontalGroup(inicioLayout.createSequentialGroup()
	                .addGroup(inicioLayout.createParallelGroup(GroupLayout.Alignment.CENTER)  // Alineación centrada
	                        .addComponent(label)
	                        .addComponent(inicioTextLabel)
	                )
	        );

	        inicioLayout.setVerticalGroup(inicioLayout.createSequentialGroup()
	                .addComponent(label)
	                .addComponent(inicioTextLabel)
	        );
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        

	        // Agregar los paneles a mainPanel con CardLayout
	        mainPanel.add(inicioPanel, "Inicio");
	        mainPanel.add(conectarPanel, "Conectar");
	        mainPanel.add(crearBdPanel, "Crear");
	        mainPanel.add(crearTablasPanel, "Crear tablas");
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        
	        leftPanel = new JPanel();
	        leftPanel.setPreferredSize(new Dimension(200, 0));
	        leftPanel.setBackground(new Color(0, 115, 181)); // 
	 
	        JLabel leftLabel = new JLabel("Aqui deben de aparecer las bd");
	        leftLabel.setForeground(Color.WHITE);
	        leftPanel.add(leftLabel);
                
                
	        
                // Utilizar un JSplitPane para dividir la ventana en dos partes
	        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, mainPanel);
	        splitPane.setDividerLocation(200); // Ancho inicial del panel izquierdo
	        splitPane.setDividerSize(5); // Tamaño del divisor
	        splitPane.setResizeWeight(0.0); // Bloquear el movimiento del divisor
                leftPanel.add(displayArea);
	        frame.add(splitPane, BorderLayout.CENTER);

	        frame.setVisible(true);
	    }
            
 private void initDatabaseConnection() {
    try {
        // Establece la conexión con el servidor MySQL
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/", usuario, contrasena);

        // Obtiene la lista de bases de datos
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet databases = metaData.getCatalogs();

        // Crea un panel para almacenar los botones de las bases de datos
        JPanel databaseButtonsPanel = new JPanel();
        databaseButtonsPanel.setLayout(new GridLayout(0, 1));

        // Muestra la lista de bases de datos
        displayArea.append("Bases de Datos:\n");
        while (databases.next()) {
            String dbName = databases.getString("TABLE_CAT");
            JButton dbButton = new JButton(dbName);
            dbButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aquí puedes agregar la lógica para mostrar más detalles o realizar acciones
                    displayArea.append("Base de datos seleccionada: " + dbName + "\n");

                    // Al hacer clic en el botón de una base de datos, muestra sus tablas
                    displayTablesOfDatabase(dbName);
                }
            });
            databaseButtonsPanel.add(dbButton);  // Agrega el botón al panel
        dbButton.addActionListener(new ActionListener() {
    @Override
    
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        setDatabase(sourceButton.getText());  // Obtiene el nombre de la base de datos del botón
        displayArea.append("Base de datos seleccionada: " + Database + "\n");

        // Al hacer clic en el botón de una base de datos, muestra sus tablas
        displayTablesOfDatabase(Database);
    }
});
        }


        // Agrega el panel con los botones de las bases de datos al displayArea
        displayArea.setLayout(new BorderLayout());
        displayArea.add(new JScrollPane(databaseButtonsPanel), BorderLayout.CENTER);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void displayTablesOfDatabase(String dbName) {
    try {
        // Establece la conexión con la base de datos seleccionada
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + dbName, usuario, contrasena);

        // Obtiene la lista de tablas para la base de datos seleccionada
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "%", null);

        // Crea un panel para almacenar los nombres de las tablas
        JPanel tablesPanel = new JPanel();
        tablesPanel.setLayout(new GridLayout(0, 1));

        // Limpia el panel antes de agregar nuevos componentes
        tablesPanel.removeAll();

        // Muestra la lista de tablas
        displayArea.append("Tablas en la base de datos " + dbName + ":\n");
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            JLabel tableLabel = new JLabel(tableName);
            tablesPanel.add(tableLabel);
        }

        // Agrega un botón para volver al listado de bases de datos
        JButton backButton = new JButton("Volver al listado de bases");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDatabaseList();
            }
        });
        tablesPanel.add(backButton);

        // Cierra la conexión
        connection.close();

        // Agrega el panel con los nombres de las tablas al displayArea
        displayArea.removeAll();  // Limpia el displayArea
        displayArea.setLayout(new BorderLayout());
        displayArea.add(new JScrollPane(tablesPanel), BorderLayout.CENTER);

        // Repinta la ventana para reflejar los cambios
        SwingUtilities.getWindowAncestor(displayArea).validate();
        SwingUtilities.getWindowAncestor(displayArea).repaint();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void displayDatabaseList() {
    try {
        // Establece la conexión con el servidor MySQL
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/", usuario, contrasena);

        // Obtiene la lista de bases de datos
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet databases = metaData.getCatalogs();

        // Crea un panel para almacenar los botones de las bases de datos
        JPanel databaseButtonsPanel = new JPanel();
        databaseButtonsPanel.setLayout(new GridLayout(0, 1));

        // Muestra la lista de bases de datos
        displayArea.removeAll();  // Limpia el displayArea
        displayArea.setLayout(new BorderLayout());
        displayArea.add(new JScrollPane(databaseButtonsPanel), BorderLayout.CENTER);

        while (databases.next()) {
            String dbName = databases.getString("TABLE_CAT");
            JButton dbButton = new JButton(dbName);
            dbButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayArea.removeAll();  // Limpia el displayArea
                    displayArea.setLayout(new BorderLayout());
                    displayArea.add(new JScrollPane(databaseButtonsPanel), BorderLayout.CENTER);
                    // Aquí puedes agregar la lógica para mostrar más detalles o realizar acciones
                    displayArea.append("Base de datos seleccionada: " + dbName + "\n");

                    // Al hacer clic en el botón de una base de datos, muestra sus tablas
                    displayTablesOfDatabase(dbName);
                }
            });
            databaseButtonsPanel.add(dbButton);  // Agrega el botón al panel
        }

        // Cierra la conexión
        connection.close();

        // Repinta la ventana para reflejar los cambios
        SwingUtilities.getWindowAncestor(displayArea).validate();
        SwingUtilities.getWindowAncestor(displayArea).repaint();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}



    
	  //-----------------------------------------------------------------------------------------------------	        
	    
	  //-----------------------------------------------------------------------------------------------------	        
	    private JMenuItem createMenuItem(String label) {
	        JMenuItem item = new JMenuItem(label);
	        item.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                updateMainPanel(label);
	            }
	        });
	        return item;
	    }
	  //-----------------------------------------------------------------------------------------------------	        
	  //-----------------------------------------------------------------------------------------------------	        
	    private void updateMainPanel(String selectedOption) {
	        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
	        cardLayout.show(mainPanel, selectedOption);
	    }
	  //-----------------------------------------------------------------------------------------------------	        
	    
	  //-----------------------------------------------------------------------------------------------------	        
	    
	    private void showTableInfoDialog(String tableName, int columnsCount) {
	        JFrame tableInfoFrame = new JFrame("Información de la tabla");
	        tableInfoFrame.setSize(500, 500);
	        tableInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        JPanel tableInfoPanel = new JPanel();
	        tableInfoPanel.setLayout(new BorderLayout());

	        JLabel tableNameLabel = new JLabel("Nombre de la tabla: " + tableName);
	        JLabel columnsCountLabel = new JLabel("Cantidad de columnas: " + columnsCount);

	        JPanel dataPanel = new JPanel(new GridLayout(columnsCount, 4));
	        List<JTextField> textFieldList = new ArrayList<>();
	      //-----------------------------------------------------------------------------------------------------	        
	        for (int i = 0; i < columnsCount; i++) {
	            JLabel columnNameLabel = new JLabel("Columna " + (i + 1) + ":");
	            JTextField textField = new JTextField(10);
	            JComboBox<String> dataTypeComboBox = new JComboBox<>(new String[]{"string", "int", "float", "boolean", "date", "time", "varchar"});
	            JCheckBox pkCheckBox = new JCheckBox("PK");
	            JCheckBox fkCheckBox = new JCheckBox("FK");
	            JCheckBox ukCheckBox = new JCheckBox("UK");

	            dataPanel.add(columnNameLabel);
	            dataPanel.add(textField);
	            dataPanel.add(dataTypeComboBox);
	            dataPanel.add(pkCheckBox);
	            dataPanel.add(fkCheckBox);
	            dataPanel.add(ukCheckBox);

	            textFieldList.add(textField);
	        }
	      //-----------------------------------------------------------------------------------------------------	        
	        
	      //-----------------------------------------------------------------------------------------------------	        
	        JPanel infoDisplayPanel = new JPanel();
	        infoDisplayPanel.setLayout(new BorderLayout());
	        infoDisplayPanel.add(tableNameLabel, BorderLayout.NORTH);
	        infoDisplayPanel.add(columnsCountLabel, BorderLayout.CENTER);
	        infoDisplayPanel.add(dataPanel, BorderLayout.SOUTH);

	        JScrollPane scrollPane = new JScrollPane(infoDisplayPanel);
	        tableInfoPanel.add(scrollPane, BorderLayout.CENTER);

	        JButton closeButton = new JButton("Cerrar");
	        closeButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                tableInfoFrame.dispose();
	            }
	        });
	        tableInfoPanel.add(closeButton, BorderLayout.SOUTH);

	        tableInfoFrame.add(tableInfoPanel);
	        tableInfoFrame.setVisible(true);
	    }
            
            private void mostrarInfoBaseDatos(String nombreBD) {
    // Aquí puedes agregar la lógica para mostrar información sobre la base de datos
    JOptionPane.showMessageDialog(null, "Información de la base de datos: " + nombreBD);
}

private void mostrarInfoTabla(String nombreTabla) {
    // Aquí puedes agregar la lógica para mostrar información sobre la tabla
    JOptionPane.showMessageDialog(null, "Información de la tabla: " + nombreTabla);
}
	  //-----------------------------------------------------------------------------------------------------	 

    public void setHost(String host) {
        this.host = host;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getPuerto() {
        return puerto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getHost() {
        return host;
    }

    public void setDatabase(String Database) {
        this.Database = Database;
    }

    public String getDatabase() {
        return Database;
    }

	  //-----------------------------------------------------------------------------------------------------	        
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new Principal();
	            }
	        });
	    }}
	//------------------------------