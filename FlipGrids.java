import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class FlipGrids extends JFrame
{
  private JFrame f;
  private int count, winner;
  private JPanel panel;
  private boolean[] info;
  private String[] top3Name;
  private int[] top3Steps;
  private JLabel l;
  private JComboBox<String> comboBox;
  private JButton[] buttons;

  public FlipGrids()
  {
    f = new JFrame();
    count = 0;
    winner = 0;
    panel = new JPanel();
    l = new JLabel("                                                              ----------------Try to make all block in black!----------------                                               Steps: "+count);
    comboBox = new JComboBox<String>();
    buttons = new JButton[9];
    info = new boolean[9];
    top3Name = new String[3];
    top3Steps = new int[3];

    for(int i=0;i<3;i++)
    {
      top3Name[i] = "Nobody";
      top3Steps[i] = 0;
    }

    for(int i = 0; i<9;i++)
      info[i] = 1 == (int)(Math.random()*2);

    for(int i=0;i<9;i++)
      if(info[i])
        buttons[i] = new JButton(new ImageIcon("0.png"));
      else
        buttons[i] = new JButton(new ImageIcon("1.png"));

    comboBox.addItem("Score board");
    for(int i=0;i<3;i++)
      comboBox.addItem((i+1)+". "+top3Name[i]+"-------"+top3Steps[i]);

    for(int i=0;i<9;i++)
      panel.add(buttons[i]);


    panel.setSize(700,700);
    f.setSize(700,850);
    f.add(comboBox, BorderLayout.PAGE_START);
    f.add(l,BorderLayout.CENTER);
    f.add(panel, BorderLayout.PAGE_END);
    f.setVisible(true);
    panel.setLayout(new GridLayout(3,3));
    f.setTitle("Flip Grids --- Flip all Grids to Black!");

    addListener();
    JOptionPane.showMessageDialog(f,"Every click will filp both center and surrounding!\n"+
                                    "             Flip all Grids to Black!","Tip ^_^",JOptionPane.WARNING_MESSAGE);
  }

  public void addListener()
  {
    buttons[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[0] = ! info[0];
        info[1] = ! info[1];
        info[3] = ! info[3];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));

        check();
      }
    });

    buttons[1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[0] = ! info[0];
        info[1] = ! info[1];
        info[2] = ! info[2];
        info[4] = ! info[4];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });

    buttons[2].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[1] = ! info[1];
        info[2] = ! info[2];
        info[5] = ! info[5];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });

    buttons[3].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[3] = ! info[3];
        info[0] = ! info[0];
        info[4] = ! info[4];
        info[6] = ! info[6];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });

    buttons[4].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[3] = ! info[3];
        info[1] = ! info[1];
        info[4] = ! info[4];
        info[5] = ! info[5];
        info[7] = ! info[7];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });

    buttons[5].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[5] = ! info[5];
        info[2] = ! info[2];
        info[4] = ! info[4];
        info[8] = ! info[8];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });

    buttons[6].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[3] = ! info[3];
        info[6] = ! info[6];
        info[7] = ! info[7];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });

    buttons[7].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[4] = ! info[4];
        info[6] = ! info[6];
        info[7] = ! info[7];
        info[8] = ! info[8];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });

    buttons[8].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event)
      {
        info[7] = ! info[7];
        info[8] = ! info[8];
        info[5] = ! info[5];
        for(int i=0;i<9;i++)
          if(info[i])
            buttons[i].setIcon(new ImageIcon("0.png"));
            else
            buttons[i].setIcon(new ImageIcon("1.png"));
        check();
      }
    });
  }

  public void check()
  {
    count++;
    l.setText("                                                              ----------------Try to make all block in black!----------------                                               Steps: "+count);
    if(checkInfo())
    {
      JOptionPane.showMessageDialog(f,"Congratulation, you finish it by "+count+" steps! ^_^");
      String name=JOptionPane.showInputDialog(f,"Enter Name");
      addWinner(name,count);

      comboBox.removeAllItems();
      comboBox.addItem("Score board");
      for(int i=0;i<3;i++)
        comboBox.addItem((i+1)+". "+top3Name[i]+"-------"+top3Steps[i]);

      reset();
    }
  }

  public boolean checkInfo()
  {
    for(boolean e: info)
      if(e)
        return false;
    return true;
  }

  public void addWinner(String name, int count)
  {
    String tName;
    int tStep;

    for(int i=0;i<3;i++)
      if(top3Steps[i] > count || top3Steps[i] == 0)
      {
        tName = top3Name[i];
        tStep = top3Steps[i];
        top3Name[i] = name;
        top3Steps[i] = count;
        name = tName;
        count = tStep;
      }
  }

  public void reset()
  {
    count = 0;
    info = new boolean[9];

    for(int i = 0; i<9;i++)
      info[i] = 1 == (int)(Math.random()*2);

    for(int i=0;i<9;i++)
      if(info[i])
        buttons[i].setIcon(new ImageIcon("0.png"));
      else
        buttons[i].setIcon(new ImageIcon("1.png"));

  }
}
