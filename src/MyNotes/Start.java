package MyNotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Start extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu mPliki, mPomoc;
    JMenuItem iNowy, iOtworz, iZapisz, iZapiszJako, iExit, iAutor;

    JTextArea notatnik;

    File plik;

    Start() {
        super("Notes");
        menuBar = new JMenuBar();

        mPliki = new JMenu("Pliki");
        mPomoc = new JMenu("Pomoc");

        iNowy = new JMenuItem("Nowy");
        iNowy.addActionListener(this);
        iOtworz = new JMenuItem("Otwórz");
        iOtworz.addActionListener(this);
        iZapisz = new JMenuItem("Zapisz");
        iZapisz.addActionListener(this);
        iZapiszJako = new JMenuItem("Zapisz Jako");
        iZapiszJako.addActionListener(this);
        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);

        iAutor = new JMenuItem("Autor Kodu w Jave");
        iAutor.addActionListener(this);

        mPliki.add(iNowy);
        mPliki.add(iOtworz);
        mPliki.add(iZapisz);
        mPliki.add(iZapiszJako);
        mPliki.addSeparator();
        mPliki.add(iExit);

        mPomoc.add(iAutor);

        menuBar.add(mPliki);
        menuBar.add(mPomoc);

        notatnik = new JTextArea();
        notatnik.setFont(new Font("System", Font.PLAIN, 15));
        JScrollPane scrol = new JScrollPane(notatnik);
        add(scrol);

        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Start();
    }

    private void otworz() {
        notatnik.setText("");
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            plik = fc.getSelectedFile();
            try {
                Scanner scanner = new Scanner(plik);
                while (scanner.hasNext()) notatnik.append(scanner.nextLine() + "\n");
                scanner.close();
                this.setTitle(fc.getName(plik));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void zapisz()
    {
        try {
            PrintWriter pw = new PrintWriter(plik);
            Scanner scanner = new Scanner(notatnik.getText());
            while (scanner.hasNext()) pw.println(scanner.nextLine());
            scanner.close();pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void zapiszJako()
    {
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(plik);
        if (fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            plik = fc.getSelectedFile();
            zapisz();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object cel = e.getSource();

        if (cel == iExit) System.exit(0);else
            if (cel == iAutor) JOptionPane.showMessageDialog(this, "Yaroslav Didenko", "Autor", JOptionPane.INFORMATION_MESSAGE);else
                if (cel == iOtworz) otworz();else
                    if (cel == iNowy) {notatnik.setText("");this.setTitle("Notatnik");plik=null;}else
                        if (cel==iZapiszJako) zapiszJako(); else
                            if (cel==iZapisz) {if (plik==null) zapiszJako(); else zapisz();}
    }
}

