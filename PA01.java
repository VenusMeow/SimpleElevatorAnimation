
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  When run as a program, this class opens a window on the screen that
 *  shows a large number of colored disks.  The positions of the disks
 *  are selected at random, and the color is randomly selected from
 *  red, green, or blue.  A black outline is drawn around each disk.
 *  The picture changes every three seconds.
 */
public class PA01 extends JPanel implements ActionListener {

    /**
     * Draws 500 disks with random colors and locations.
     * Each disk has a radius of 50 pixels.  This subroutine is
     * called every three seconds, giving a new set of disks.
     */
    public void drawFrame(Graphics g, int frameNumber, int width, int height) {

        //printing the title
        Font h = new Font("Helvetica", Font.PLAIN, 18);
        g.setFont(h);
        g.drawString("Elevator Simulation",180,25);

        //drawing the building

        //third floor and elevator door
        g.setColor(Color.BLACK);
        g.drawRect(50,50,400,150);
        g.drawRect(300,100,100,100);
        g.fillRect(300,100,100,100);
        g.setColor(Color.ORANGE);
        g.fillOval(345,70,10,10);
        //second floor and elevator door
        g.setColor(Color.BLACK);
        g.drawRect(50,200,400,150);
        g.drawRect(300,250,100,100);
        g.fillRect(300,250,100,100);
        g.setColor(Color.ORANGE);
        g.fillOval(345,220,10,10);
        //first floor and elevator door
        g.setColor(Color.BLACK);
        g.drawRect(50,350,400,150);
        g.drawRect(300,400,100,100);
        g.fillRect(300,400,100,100);
        g.setColor(Color.ORANGE);
        g.fillOval(345,370,10,10);

        if (frameNumber%1500>=0 && frameNumber%1500<100){
          g.setColor(Color.GREEN);
          g.fillOval(345,370,10,10);
          openDoor(g,frameNumber%1500,300,400);
          drawPerson(g,230,430);
          drawPerson(g,210,430);
          drawPerson(g,190,280);
        } else if (frameNumber%1500>=100 && frameNumber%1500<300){
          g.setColor(Color.GREEN);
          g.fillOval(345,370,10,10);
          openedDoor(g,300,400);
          enterPerson(g,frameNumber%1500-100,230,430);
          enterPerson(g,frameNumber%1500-100,210,430);
          drawPerson(g,190,280);
        } else if (frameNumber%1500>=300 && frameNumber%1500<400){
          closeDoor(g,frameNumber%1500-300,300,400);
          drawPerson(g,350,430);
          drawPerson(g,330,430);
          drawPerson(g,190,280);
        } else if (frameNumber%1500>=400 && frameNumber%1500<550){
          drawPerson(g,190,280);
        } else if (frameNumber%1500>=550 && frameNumber%1500<650){
          g.setColor(Color.GREEN);
          g.fillOval(345,220,10,10);
          openDoor(g,frameNumber%1500-550,300,250);
          drawPerson(g,350,280);
          drawPerson(g,330,280);
          drawPerson(g,190,280);
        } else if (frameNumber%1500>=650 && frameNumber%1500<850){
          g.setColor(Color.GREEN);
          g.fillOval(345,220,10,10);
          openedDoor(g,300,250);
          drawPerson(g,350,280);
          drawPerson(g,330,280);
          enterPerson(g,frameNumber%1500-650,190,280);
        } else if (frameNumber%1500>=850 && frameNumber%1500<950){
          closeDoor(g,frameNumber%1500-850,300,250);
          drawPerson(g,350,280);
          drawPerson(g,330,280);
          drawPerson(g,310,280);
        } else if (frameNumber%1500>=1100 && frameNumber%1500<1200){
          g.setColor(Color.GREEN);
          g.fillOval(345,70,10,10);
          openDoor(g,frameNumber%1500-1100,300,100);
          drawPerson(g,350,130);
          drawPerson(g,330,130);
          drawPerson(g,310,130);
        } else if (frameNumber%1500>=1200 && frameNumber%1500<1400){
          g.setColor(Color.GREEN);
          g.fillOval(345,70,10,10);
          openedDoor(g,300,100);
          exitPerson(g,frameNumber%1500-1200,350,130);
          exitPerson(g,frameNumber%1500-1200,330,130);
          exitPerson(g,frameNumber%1500-1200,310,130);
        } else if (frameNumber%1500>=1400 && frameNumber%1500<1500){
          closeDoor(g,frameNumber%1500-1400,300,100);
          drawPerson(g,230,130);
          drawPerson(g,210,130);
          drawPerson(g,190,130);
          g.setColor(Color.RED);
          Font hb = new Font("Helvetica", Font.BOLD, 18);
          g.setFont(hb);
          g.drawString("Yay!",150,130);
        }



    }

    public void drawPerson(Graphics g, int coordx, int coordy){
        //one person
        int x = coordx;
        int y = coordy;
        g.setColor(Color.BLACK);
        //face
        g.drawOval(x,y,20,20);
        //eyes
        g.fillOval(x+6,y+8,3,3);
        g.fillOval(x+14,y+8,3,3);
        //body
        g.drawLine(x+10,y+20,x+10,y+50);
        //arms
        g.drawLine(x+10,y+20,x+00,y+40);
        g.drawLine(x+10,y+20,x+20,y+40);
        //legs
        g.drawLine(x+10,y+50,x+00,y+70);
        g.drawLine(x+10,y+50,x+20,y+70);
    }

    public void enterPerson(Graphics g, int fp, int coordx, int coordy){
        //one person
        int f = (int)((fp%200)*0.6);
        int x = coordx+ f;
        int y = coordy;
        g.setColor(Color.BLACK);
        //face
        g.drawOval(x,y,20,20);
        //eyes
        g.fillOval(x+6,y+8,3,3);
        g.fillOval(x+14,y+8,3,3);
        //body
        g.drawLine(x+10,y+20,x+10,y+50);
        //arms
        g.drawLine(x+10,y+20,x+00,y+40);
        g.drawLine(x+10,y+20,x+20,y+40);
        //legs
        g.drawLine(x+10,y+50,x+00,y+70);
        g.drawLine(x+10,y+50,x+20,y+70);
    }

    public void exitPerson(Graphics g, int fp, int coordx, int coordy){
        //one person
        int f = (int)((fp%200)*0.6);
        int x = coordx - f;
        int y = coordy;
        g.setColor(Color.BLACK);
        //face
        g.drawOval(x,y,20,20);
        //eyes
        g.fillOval(x+6,y+8,3,3);
        g.fillOval(x+14,y+8,3,3);
        //body
        g.drawLine(x+10,y+20,x+10,y+50);
        //arms
        g.drawLine(x+10,y+20,x+00,y+40);
        g.drawLine(x+10,y+20,x+20,y+40);
        //legs
        g.drawLine(x+10,y+50,x+00,y+70);
        g.drawLine(x+10,y+50,x+20,y+70);
    }

    public void closeDoor(Graphics g, int fc, int coordx, int coordy){
        int x = coordx;
        int y = coordy;

        g.setColor(Color.WHITE);
        g.fillRect(x,y,100-fc%100,100);

    }

    public void openDoor(Graphics g, int fo, int coordx, int coordy){
        int x = coordx;
        int y = coordy;

        g.setColor(Color.WHITE);
        g.fillRect(x,y,fo%100,100);

    }

    public void openedDoor(Graphics g, int coordx, int coordy){
        int x = coordx;
        int y = coordy;

        g.setColor(Color.WHITE);
        g.fillRect(x,y,100,100);

    }

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public static void main(String[] args) {

        /* NOTE:  The string in the following statement goes in the title bar
         * of the window.
         */
        JFrame window = new JFrame("PA01: Animation");

        /*
         * NOTE: If you change the name of this class, you must change
         * the name of the class in the next line to match!
         */
        PA01 drawingArea = new PA01();

        drawingArea.setBackground(Color.WHITE);
        window.setContentPane(drawingArea);

        /* NOTE:  In the next line, the numbers 500 and 500 give the
         * initial width and height of the drawing array.  You can change
         * these numbers to get a different size.
         */
        drawingArea.setPreferredSize(new Dimension(500,500));

        window.pack();
        window.setLocation(100,50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*
         * Note:  In the following line, you can change false to
         * true.  This will prevent the user from resizing the window,
         * so you can be sure that the size of the drawing area will
         * not change.  It can be easier to draw the frames if you know
         * the size.
         */
        window.setResizable(false);

        /* NOTE:  In the next line, the number 3000 gives the time between
         * calls to drawFrame().  The time is given in milliseconds, where
         * one second equals 1000 milliseconds.  You can change the number
         * to control the animation speed.
         */
        Timer frameTimer = new Timer(20,drawingArea);

        window.setVisible(true);
        frameTimer.start();

    } // end main

    private int frameNum;

    public void actionPerformed(ActionEvent evt) {
        frameNum++;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFrame(g, frameNum, getWidth(), getHeight());
    }

}
