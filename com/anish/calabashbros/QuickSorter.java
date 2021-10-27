package com.anish.calabashbros;

public class QuickSorter <T extends Comparable<T>> implements Sorter<T> {

    private T[] a;

    @Override
    public void load(T[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        T temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        Quicksort(0,a.length-1);
    }
    private void Quicksort(int l,int r)
    {
        if(l>=r)
            return;
        int p=partition(l, r);
        Quicksort(l, p-1);
        Quicksort(p+1, r);
    }
    private int partition(int l,int r)
    {
        T pivot=a[l];
        int pre=l;
        int lat=r;
        while(true)
        {
            while(a[lat].compareTo(pivot)>0)
            {
                lat--;
            }
            while(a[pre].compareTo(pivot)<0)
            {
                pre++;
            }
            if(pre<lat)
                swap(pre,lat);
            else
            {
                return lat;
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
