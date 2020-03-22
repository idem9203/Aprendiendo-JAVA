import javax.swing.*; //el * le indica que importara todos los elementos
import java.awt.*;
import java.awt.event.*; //Libreria para eventos se encarga de ejecutar programas al ver un evento

public class Formulario extends JFrame implements ActionListener, ItemListener { //queda pendiente a cualquier evento

    private JButton boton1, boton2, boton3, boton4, boton5;
    private JLabel label1, label2, label3, label4, label5, label6;  //modificador de acceso private unicamente esta clase tendra acceso a este label
    private JTextField textfield1, textfield2, textfield3;
    private JScrollPane scrollpane1;
    private JTextArea textarea1;

    private JComboBox combo1;

    String texto = "";

    public Formulario() {   //crear Constructor debe llamarse igual que la clase
        setLayout(null);    //evita colocar donde quiera la interfaz
        boton1 = new JButton("Cerrar");
        boton1.setBounds(330, 250, 100, 30);
        Color color1 = new Color(255, 0, 0);
        boton1.setBackground(color1);
        add(boton1);
        boton1.addActionListener(this); //el boton estara a la espera para realizar una funcion

        boton2 = new JButton("1");
        boton2.setBounds(10, 250, 100, 30);
        add(boton2);
        boton2.addActionListener(this); //el boton estara a la espera para realizar una funcion

        boton3 = new JButton("2");
        boton3.setBounds(110, 250, 100, 30);
        add(boton3);
        boton3.addActionListener(this); //el boton estara a la espera para realizar una funcion

        boton4 = new JButton("Aceptar");
        boton4.setBounds(225, 250, 100, 30);
        add(boton4);
        boton4.addActionListener(this); //el boton estara a la espera para realizar una funcion

        boton5 = new JButton("Sumar");
        boton5.setBounds(10, 100, 100, 30);
        add(boton5);
        boton5.addActionListener(this); //el boton estara a la espera para realizar una funcion

        label1 = new JLabel("Valor 1:"); //crea label
        label1.setBounds(10, 20, 300, 30);  //le da forma al label
        add(label1);  //adiciona el label a la ventana

        label2 = new JLabel("Valor 2:");
        label2.setBounds(10, 50, 100, 30);
        add(label2);

        label3 = new JLabel("Usuario:");
        label3.setBounds(10, 180, 100, 30);
        add(label3);

        label4 = new JLabel("Resultado =");
        label4.setBounds(120, 100, 100, 30);
        add(label4);

        label5 = new JLabel("Esperando..."); //crea label
        label5.setBounds(10, 200, 100, 30);  //le da forma al label
        add(label5);  //adiciona el label a la ventana

        label6 = new JLabel(""); //crea label
        label6.setBounds(100, 134, 120, 30);  //le da forma al label
        add(label6);  //adiciona el label a la ventana

        textfield1 = new JTextField();
        textfield1.setBounds(70, 187, 150, 20);
        add(textfield1);

        textfield2 = new JTextField();
        textfield2.setBounds(70, 27, 150, 20);
        add(textfield2);

        textfield3 = new JTextField();
        textfield3.setBounds(70, 57, 150, 20);
        add(textfield3);

        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(225, 30, 205, 200);
        add(scrollpane1);

        combo1 = new JComboBox();
        combo1.setBounds(10, 140, 80, 20);
        for(int i = 1; i <= 20; i++) {
            combo1.addItem("COM" + String.valueOf(i)); //convierte de entero a string
        }   
        add(combo1);     
        combo1.addItemListener(this);

        setTitle("BlueView");

    }

    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == combo1){
            String seleccion = combo1.getSelectedItem().toString();
            label6.setText("Conectado a: " + seleccion);
            setTitle("BlueView - Conectado a: " + seleccion);
        }
    }

    public void actionPerformed(ActionEvent b){ //Funcion que captura el evento, es guardado en b
        if(b.getSource() == boton1){ //compara que el boton presionado haya sido boton1
            System.exit(0);
        }
        if(b.getSource() == boton2){
            label5.setText("Presionaste 1");
        }
        if(b.getSource() == boton3){
            label5.setText("Presionaste 2");
        }
        if(b.getSource() == boton4){
            texto += textfield1.getText() + "\n";  //pone la siguente linea con un salto de linea
            textarea1.setText(texto);
            textfield1.setText("");         //limpia el campo de texto
            //setTitle(texto);              //luego de precionado el boton4 se cambia el titulo de app
        }
        if(b.getSource() == boton5){

            int valor1 = 0, valor2 = 0, resultado = 0;
            valor1 = Integer.parseInt(textfield2.getText()); //Parsea de un dato tipo String a un tipo Entero
            valor2 = Integer.parseInt(textfield3.getText());
            resultado = valor1 + valor2;
            label4.setText("Resultado = " + resultado);

            //textfield2.setText("");
            //textfield3.setText("");
        }
    }
    public static void main(String[] args) {
        Formulario formulario1 = new Formulario();
        formulario1.setBounds(0, 0, 450, 350);    //(posicion x, posicion y, ancho, alto)
        formulario1.setVisible(true);
        formulario1.setLocationRelativeTo(null);  //omite coordenadas y coloca en el centro de la pantalla la ventana
        formulario1.setResizable(false);  //deshabilita que el usario pueda agrandar la ventana
    }
}