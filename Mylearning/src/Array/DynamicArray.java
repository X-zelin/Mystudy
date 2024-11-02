package Array;
import java.util.function.Consumer;

import java.util.Iterator;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    private int[] array = {};
    public void addLast(int value){
        CheckAndGrow();
        array[size] = value;
        size++;
    }
    public void add(int index,int element){
        CheckAndGrow();
        if(index>=0&&index<size){
            System.arraycopy(array,index,array,index+1,size-index);
        }
        array[index] = element;
        size++;
    }
    public void CheckAndGrow(){
        if(size == 0){
            array = new int[capacity];
        } else if(size == capacity){
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }

    }
    public int getSize(){
            return size;
    }
    public int[] getArray(){
        return array;
    }
    public void foreach(Consumer<Integer> consumer){
        for(int i = 0;i<size;i++){
            consumer.accept(array[i]);
        }
    }


    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            int i = 0;
            public boolean hasNext(){
                return i<size;
            }
            public Integer next(){
                return array[i++];
            }
        };

    }
}
