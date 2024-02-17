import java.util.*;
import java.awt.*;
import java.awt.event.*;



class ticgame implements ActionListener

{
    
    Frame frame =new Frame();
    //for handling the game efficiently.
    static int x;
    
    //9 buttons for giving the box to user for playing game.
    Button b1=new Button();
    Button b2=new Button();
    Button b3=new Button();
    Button b4=new Button();
    Button b5=new Button();
    Button b6=new Button();
    Button b7=new Button();
    Button b8=new Button();
    Button b9=new Button();
   
    //for giving the button to the user to select them.
    Button s3=new Button("O");
    Button s4=new Button("X");
    Button s5=new Button("O");
    Button s6=new Button("X");
     
    //for giving the again button for refressing the programm.
    Button clear=new Button("AGAIN");

    //for giving the name of the 2 player here.
    TextField t1=new TextField();
    Label l1=new Label("NAME:1st PLAYER");
    TextField t2=new TextField();
    Label l2=new Label("NAME:2rd PLAYER");
    
    //giving this for making the wrong choice and winner banner.
    Dialog d=new Dialog(frame);
   // Dialog f=new Dialog(frame);
    
    //for giving the button for closing the little window.
    Button h=new Button("ok");
    Label hd=new Label("!! wrong choice !!");
    
    //giving the labels foer chooice for the users.
    Label s=new Label("!! YOUR DICE !!");
    Label s1=new Label("1st PLAYER");
    Label s2=new Label("2rd PLAYER");
    Label tic=new Label("TIC-TOE-GAME");
  
    
    //for checking who is winnwer
    int ch=0;

    //to give the labble for the inside of pop up menu
    // Label lc1,lc2,lc3,lc4;

      ticgame()
      {   
          x=1;

          //adding the layout and color of the given programm.
          frame.setSize(900,900);
          frame.setVisible(true);
          frame.setLayout(null);
          frame.setBackground(Color.BLACK);
          frame.setForeground(Color.WHITE);
          t1.setBackground(Color.BLACK);
          t1.setForeground(Color.YELLOW);

          t2.setBackground(Color.BLACK);
          t2.setForeground(Color.YELLOW);
          
          //set the 9 buttons for playying the game.
          b1.setBounds(100,100,150,100);
          b2.setBounds(250,100,150,100);
          b3.setBounds(400,100,150,100);
          b4.setBounds(100,200,150,100);
          b5.setBounds(250,200,150,100);
          b6.setBounds(400,200,150,100);
          b7.setBounds(100,300,150,100);
          b8.setBounds(250,300,150,100);
          b9.setBounds(400,300,150,100);

          //now adding the particular button here in franme.

          b1.addActionListener(this);
          b2.addActionListener(this);
          b3.addActionListener(this);
          b4.addActionListener(this);
          b5.addActionListener(this);
          b6.addActionListener(this);
          b7.addActionListener(this);
          b8.addActionListener(this);
          b9.addActionListener(this);

          frame.add(b1);
          frame.add(b2);
          frame.add(b3);
          frame.add(b4);
          frame.add(b5);
          frame.add(b6);
          frame.add(b7);
          frame.add(b8);
          frame.add(b9);
        
          //for making the label and textfield for the users.
          l1.setBounds(600,100,100,50);
          t1.setBounds(710,100,70,50);
          l2.setBounds(600,150,100,50);
          t2.setBounds(710,150,70,50);

          //now adding that particular button in the frame.
          frame.add(l1);
          frame.add(t1);
          frame.add(l2);
          frame.add(t2);
         
          //giving the chooces to the particular users.
         s3.setBounds(685,220,40,40);
         s4.setBounds(750,220,40,40);
         s5.setBounds(685,260,40,40);
         s6.setBounds(750,260,40,40);

          frame.add(s3);
          frame.add(s4);
          frame.add(s5);
          frame.add(s6);

         s3.addActionListener(this);
         s4.addActionListener(this);
         s5.addActionListener(this);
         s6.addActionListener(this);

         //for clear section
         clear.setBounds(750,400,80,40);
         clear.addActionListener(this);
         frame.add(clear);
         clear.setForeground(Color.YELLOW);

        
         //for making the lables for dics and selecting buttons.
           s.setBounds(600,200,100,40);
           s1.setBounds(600,220,70,50);
           s2.setBounds(600,260,70,50);
           frame.add(s);
           frame.add(s1);
           frame.add(s2); 

           String upp1;

           frame.add(tic);
           tic.setBounds(100,450,700,400);
           tic.setFont(new Font("SansSerif",150,100));
           tic.setForeground(Color.YELLOW);
           
           
           //this is for the pop up menu ok button for closing it.
           h.addActionListener(this);
    
         //this is for directly close the particular window here.
          frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }        
         });    
   
        }

        public void actionPerformed(ActionEvent e)
        {

         if(e.getSource()==h)
         {
            d.dispose(); 
           // f.dispose();    
         } 

         if(e.getSource()==clear)
         {
            clear();
         }

         else if(e.getSource()==s3)
         {
            x=1;
            frame.remove(s4);
            frame.remove(s5);

            ch=1;
         }

         else if(e.getSource()==s4)
         {
            x=2;
            frame.remove(s3);
            frame.remove(s6);
            
            ch=2;
         }
         
         else if(e.getSource()==b1)
        {
            String s;
            s=b1.getLabel();

            if(s=="")
            {

            if(x%2==1)
            {
                b1.setLabel("O");
                x++;
                b1.setBackground(Color.YELLOW);
                b1.setForeground(Color.BLACK);
                this.check();
            }

            else
            {
                b1.setLabel("X");
                x++;
                b1.setBackground(Color.RED);
                b1.setForeground(Color.BLACK);
                this.check();
            }

            }

            else
            {
                wrongselect();
            }
        }

        else if(e.getSource()==b2)
        {
            String s;
            s=b2.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b2.setLabel("O");
                x++;
                b2.setBackground(Color.YELLOW);
                b2.setForeground(Color.BLACK);
                this.check();
            }

            else
            {
                b2.setLabel("X");
                x++;
                b2.setBackground(Color.RED);
                b2.setForeground(Color.BLACK);
                this.check();
            }
            }

            else
            {
               wrongselect();                  
            }
        }

        else if(e.getSource()==b3)
        {
            String s;
            s=b3.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b3.setLabel("O");
                x++;
                b3.setBackground(Color.YELLOW);
                b3.setForeground(Color.BLACK);
                this.check();

            }

            else
            {
                b3.setLabel("X");
                x++;
                b3.setBackground(Color.RED);
                b3.setForeground(Color.BLACK);
                this.check();
            }
            }

            else
            {
               wrongselect();     
            }
        }

        else if(e.getSource()==b4)
        {   
            String s;
            s=b4.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b4.setLabel("O");
                x++;
                b4.setBackground(Color.YELLOW);
                b4.setForeground(Color.BLACK);
                this.check();
            }

            else
            {
                b4.setLabel("X");
                x++;
                b4.setBackground(Color.RED);
                b4.setForeground(Color.BLACK);
                this.check();
            }
            }

            else
            {
               wrongselect();
            }
        }

        else if(e.getSource()==b5)
        { 
            String s;
            s=b5.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b5.setLabel("O");
                x++;
                b5.setBackground(Color.YELLOW);
                b5.setForeground(Color.BLACK);
                this.check();
            }
            else
            {
                b5.setLabel("X");
                x++;
                b5.setBackground(Color.RED);
                b5.setForeground(Color.BLACK);
                this.check();
            }
            }

            else
            {
              wrongselect();     
            }
        }


        else if(e.getSource()==b6)
        {   
            String s;
            s=b6.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b6.setLabel("O");
                x++;
                b6.setBackground(Color.YELLOW);
                b6.setForeground(Color.BLACK);
                this.check();
            }

            else
            {
                b6.setLabel("X");
                x++;
                b6.setBackground(Color.RED);
                b6.setForeground(Color.BLACK);
                this.check();
            }
            }

            else
            {
               wrongselect();     
            }
        }

        else if(e.getSource()==b7)
        {
            String s;
            s=b7.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b7.setLabel("O");
                x++;
                b7.setBackground(Color.YELLOW);
                b7.setForeground(Color.BLACK);
                this.check();
            }

            else
            {
                b7.setLabel("X");
                x++;
                b7.setBackground(Color.RED);
                b7.setForeground(Color.BLACK);
                this.check();
            }
            }

            else
            {
                wrongselect();         
            }
        }
        
        else if(e.getSource()==b8)
        {
            String s;
            s=b8.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b8.setLabel("O");
                x++;
                b8.setBackground(Color.YELLOW);
                b8.setForeground(Color.BLACK);
                this.check();
            }

            else
            {
                b8.setLabel("X");
                x++;
                b8.setBackground(Color.RED);
                b8.setForeground(Color.BLACK);
                this.check();
            }
            }

            else
            {
               wrongselect();
            }
        }

        else if(e.getSource()==b9)
        {
            String s;
            s=b9.getLabel();

            if(s=="")
            {
            if(x%2==1)
            {
                b9.setLabel("O");
                x++;
                b9.setBackground(Color.YELLOW);
                b9.setForeground(Color.BLACK);
                this.check();
            }

            else
            {
                b9.setLabel("X");
                x++;
                b9.setBackground(Color.RED);
                b9.setForeground(Color.BLACK);
                this.check();
            }

            }

            else
            {
               wrongselect();
            }
        }

       }

       public void wrongselect()
       {
        //this block is creating for the output of wrong choice.
        d.setSize(300,300);
        d.setVisible(true);  
        d.setBounds(450,450,200,100);
        d.setLayout(new GridLayout(1,2));
        
        d.setBackground(Color.white);
        d.setForeground(Color.black);
        
        d.add(hd);                     
        d.add(h);

       }
        
       public void clear()
       {
          //for clearing the al buttos for again implementing it.
            b1.setLabel("");
            b2.setLabel("");
            b3.setLabel("");
            b4.setLabel("");
            b5.setLabel("");
            b6.setLabel("");
            b7.setLabel("");
            b8.setLabel("");
            b9.setLabel("");
           
            b1.setBackground(Color.BLACK);
            b2.setBackground(Color.BLACK);
            b3.setBackground(Color.BLACK);
            b4.setBackground(Color.BLACK);
            b5.setBackground(Color.BLACK);
            b6.setBackground(Color.BLACK);
            b7.setBackground(Color.BLACK);
            b8.setBackground(Color.BLACK);
            b9.setBackground(Color.BLACK);

            s3.setBackground(Color.BLACK);
            s4.setBackground(Color.BLACK);
            s5.setBackground(Color.BLACK);
            s6.setBackground(Color.BLACK);



            //here i am giving the default value for next game.
            x=0;

            //lc.setText("");

            String h=null;
            t1.setText(h);
            t2.setText(h);

        //for give the buttons again for selsecting them
         frame.add(s3);
         frame.add(s4);
         frame.add(s5);
         frame.add(s6);

         //for clearing the inside lable of winner
        //  frame.remove(lc1);
        //  frame.remove(lc2);
        //  frame.remove(lc3);
        //  frame.remove(lc4);
         
       }

     

    //the winner function.
       public void winner(String st)
       {
        
//         Dialog f=new Dialog(frame);
    
//         f.setSize(300,300);
//         f.setVisible(true);  
//         f.setBounds(450,450,300,100);
//         f.setLayout(new GridLayout(1,2));

//         f.setBackground(Color.CYAN);
//         f.setForeground(Color.blanck);
        
//         String upp=t1.getText();
//          upp1=upp.toUpperCase();

//         String ups=t2.getText();
//         String ups1=ups.toUpperCase();

//         if(ch==1)
//         {
         

//             if(st=="O")
//             {
//             // f.add(new Label("WiNNER"+"---->"+upp1));                     
//             // f.add(h);

// //            this.repaint();

//             }

//             else
//             {
//                 f.add(new Label("WINNER"+"--->"+ups1));                     
//                 f.add(h);
//             }

//         }
//         if(ch==2)
//         {
//             if(st=="X")
//             {
        
//             // f.add(new Label("WINNER--->"+upp1));                     
//             // f.add(h); 
//             }
            
//             else
//            {
//             f.add(new Label("WINNER"+"--->"+ups1));                     
//             f.add(h);
//            }
        
//          }
     }
       public void check()
       {
            String n1=b1.getLabel();
            String n2=b2.getLabel();
            String n3=b3.getLabel();
            String n4=b4.getLabel();
            String n5=b5.getLabel();
            String n6=b6.getLabel();
            String n7=b7.getLabel();
            String n8=b8.getLabel();
            String n9=b9.getLabel();

            
            if( ((n1.equals(n2)) && (n1.equals(n3)) && n1=="O")  || ((n1.equals(n2)) && (n1.equals(n3)) && n1=="X"))
            {
                winner(n1);
            }    
            
            if( ((n1.equals(n4)) && (n1.equals(n7)) && n1=="O") || ((n1.equals(n4)) && (n1.equals(n7)) && n1=="X"))
            {
                winner(n1);
            }    

            if( ((n1.equals(n5)) && (n1.equals(n9)) && n1=="O") || ((n1.equals(n5)) && (n1.equals(n9)) && n1=="X"))
            {
                winner(n1);
            }
            
            if( ((n2.equals(n5)) && (n2.equals(n8)) && n2=="O") || ((n2.equals(n5)) && (n2.equals(n8)) && n2=="X"))
            {
                winner(n2);
            }   
            
            if( ((n3.equals(n6)) && (n3.equals(n9)) && n3=="O") || ((n3.equals(n6)) && (n3.equals(n9)) && n3=="X"))
            {
                winner(n3);
            }    

            if( ((n3.equals(n5)) && (n3.equals(n7)) && n3=="O") || ((n3.equals(n5)) && (n3.equals(n7)) && n3=="X"))
            {
                winner(n3);
            }   
            
            if( ((n4.equals(n5)) && (n4.equals(n6)) && n4=="O") || ((n4.equals(n5)) && (n4.equals(n6)) && n4=="X"))
            {
                winner(n4);
            }    

            if( ((n7.equals(n8)) && (n7.equals(n9)) && n7=="O") || ((n7.equals(n8)) && (n7.equals(n9)) && n7=="X"))
            {
                 winner(n7);
            }   
       }

      public static void main(String args[])
      {
          new ticgame();
      }
}
