package com.anish.calabashbros;

import java.awt.Color;
import java.util.Random;
public class Calabash extends Creature implements Comparable<Calabash> {

    private int rank;
    public static Calabash [] [] calabashes;

    public static void Createcalabashes (World world)
    {
        int R=0,G=0,B=0;
        Random rdi=new Random();
        Random rdj=new Random();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(calabashes[i][j]==null)
                {
                    calabashes[i][j]=new Calabash(new Color(R, G, B), world);
                }
                G+=30;
            }
            R+=30;
        }

        for(int i=0;i<8;i++)
        {
            int k=rdi.nextInt(8);
            for(int j=0;j<8;j++)
            {
                int p=rdj.nextInt(8);
                Calabash tmp=calabashes[i][j];
                calabashes[i][j]=calabashes[k][p];
                calabashes[k][p]=tmp;
            }
        }
    }

    public Calabash(Color color, World world) {
        super(color, (char) 2, world);
        this.rank = color.getRGB() & 0xffffff;
    }

    public int getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rank);
    }

    @Override
    public int compareTo(Calabash o) {
        return Integer.valueOf(this.rank).compareTo(Integer.valueOf(o.rank));
    }

    public void swap(Calabash another) {
        int x = this.getX();
        int y = this.getY();
        this.moveTo(another.getX(), another.getY());
        another.moveTo(x, y);
    }

}
