package aula05ex05;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class JanelaCheckBox2 extends JFrame {

    private final JTextField texto = new JTextField(10);
    private final JLabel numero = new JLabel("Número");
    private final JButton excluir = new JButton("Excluir");
    private final DefaultListModel modelo = new DefaultListModel();
    private final JList lstNumeros = new JList(modelo);

    public JanelaCheckBox2() throws HeadlessException {
        super("Lista");
        setLayout(new BorderLayout(5, 5));
        JPanel pnlEntrada = new JPanel();
        pnlEntrada.setLayout(new BorderLayout(5, 5));

        pnlEntrada.add(numero, BorderLayout.WEST);
        pnlEntrada.add(texto, BorderLayout.CENTER);
        add(excluir, BorderLayout.SOUTH);
        add(pnlEntrada, BorderLayout.NORTH);
        add(new JScrollPane(lstNumeros), BorderLayout.CENTER);

        // modelo = (DefaultListModel) lstNumeros.getModel();
        for (int i = 0; i < 30; i++) {
            modelo.addElement(10 * i);
        }

        texto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.addElement(Integer.parseInt(texto.getText()));
                texto.setText("");

            }
        });

        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 
                List selecionados = lstNumeros.getSelectedValuesList();
            
            for (Object o : selecionados) {
                modelo.removeElement(o);
                
                }
            }
        });

    }

}
