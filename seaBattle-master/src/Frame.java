import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Leonid on 15.01.2016.
 */
public class Frame extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuGame;
    private JMenu menuGameStart;
    private JMenu menuHelp;
    private JMenuItem itemStartAuto;
    private JMenuItem itemStartRast;
    private JMenuItem itemExit;
    private JMenuItem itemAuto;
    private JMenuItem itemHelp;
    private JMenuItem itemAutor;
    Frame() {
        super("Морской бой");
        Panel pole=new Panel();
        menuBar=new JMenuBar();
        menuGame = new JMenu("Игра");
        menuHelp = new JMenu("Помощь");
        menuGameStart = new JMenu("Новая игра");
        itemStartAuto =new JMenuItem("Авторасстановка");
        itemStartAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pole.start();
            }
        });
        itemStartRast = new JMenuItem("Расставить корабли");
        itemStartRast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pole.startRasstanovka();
            }
        });
        itemAuto=new JMenuItem("Автоигра");
        itemAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pole.startAutoGame();
            }
        });
        itemExit=new JMenuItem("Выход");
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pole.exit();
            }
        });
        itemHelp=new JMenuItem("Правила");
        itemHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("JOptionPane showMessageDialog");
                JOptionPane.showMessageDialog(frame,"<html>Игра происходит на поле 10х10 клеточек каждого игрока," +
                                "\nна котором размещается флот кораблей.\n" +
                                "Флот состоит из\n" +
                                "   1 корабль - ряд из 4 клеток \"четырёхпалубные\"\n" +
                                "   2 корабля - ряд из 3 клеток \"трёхпалубные\"\n" +
                                "   3 корабля - ряд из 2 клеток \"двухпалубные\"\n" +
                                "   4 корабля - ряд из 1 клеточки \"однопалубые\".\n" +
                                "При размещении корабли не могут касаться друг друга углами .\n" +
                                "Палубы кораблей надо строить «в линейку», а не изгибами.\n" +
                                "Главное: нельзя строить палубы одного корабля по диагонали.\n" +
                                "Игрок, выполняющий ход, совершает выстрел.\n"+
                                "Если выстрел пришёлся в клетку, не занятую ни одним кораблём противника, \n" +
                                "то право хода переходит к сопернику.\n" +
                                "Если выстрел пришёлся в клетку, где находится многопалубный корабль (размером больше чем 1 клетка),\n" +
                                "Стрелявший игрок получает право на ещё один выстрел.\n" ,
                        "Правила", JOptionPane.INFORMATION_MESSAGE);
            }

        });
        itemAutor=new JMenuItem("Автор");
        itemAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("JOptionPane showMessageDialog");
                JOptionPane.showMessageDialog(frame,
                        "Автор: Малкиев Л.В \nГруппа: ИНФ-14\nУральский государственный горный университет\n" +
                                "Екатеринбург 2016",
                        "Автор", JOptionPane.INFORMATION_MESSAGE);


            }
        });
        menuGameStart.add(itemStartAuto);
        menuGameStart.add(itemStartRast);
        menuGame.add(menuGameStart);
        menuGame.add(itemAuto);
        menuGame.add(itemExit);
        menuHelp.add(itemHelp);
        menuHelp.add(itemAutor);
        menuBar.add(menuGame);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);
        Container container=getContentPane();
        container.add(pole);
        setSize(pole.getSize());
        setResizable(false);
        //setLayout(null); //возможность произвольной расстановки
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            setIconImage(ImageIO.read(getClass().getResource("image/icon.jpeg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);


    }

}

