import java.util.Iterator;
public class DynamicArray<T> implements Iterable<T> {

    private T arr[];
    private int len = 0;
    private int capacity = 0;

    public DynamicArray(){
        this(10);
    }
    public DynamicArray(int capacity){
        if(capacity<0) throw IllegalArgumentException ("Illegal capacity:"+capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){
        return len;
    }

    public Boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        return arr[index];
    }
    public void set(T elem,int index){
        arr[index] = elem;
    }
    public void clear(){
        for(int i = 0;i<len;i++)
        arr[i] = null;
        len = 0;
    }
    public void add(T elem){
        if(len+1>capacity)
        {
            if(capacity == 0)
            capacity = 1;
            else
            capacity *= 2;
            T[] newArr = (T[]) new Object[capacity];
            for(int i=0;i<len;i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
            arr[len++] = elem;
        }
        else
        arr[len++] = elem;
    }
    public T removeAt(int rmIndex)
    {
        if( rmIndex<0 || rmIndex >= len) throw new IndexOutOfBoundsException();
        T data = arr[rmIndex];
        T[] newArr = (T[]) new Object[len-1];
        for(int i=0,j=0; i< len;i++,j++){
            if(i != rmIndex)
            newArr[j] = arr[i];
            else
            j--;
        }
        capacity = --len;
        arr = newArr;
        return data;
    }

    public int index(Object obj){
        if( obj == null){
            for(int i=0;i<len ;i++)
            if(arr[i] == null) return i;
        }
        else{
            for(int i =0 ;i<len;i++){
                if(arr[i].equals(obj)) return i;
            }
        }
        return -1;
    }

    public Boolean remove(Object obj){
        int index = index(obj);
        if(index == -1) return false;
        else removeAt(index);
        return true;
    }

    public Boolean contains(Object obj){
        return index(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
        
            int index = 0;
            @Override
            public boolean hasNext(){
                return index<len;
            }

            @Override
            public T next(){
                return arr[index++];
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString(){
        if(len == 0) return "[]";
        else{
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i=0;i<len-1;i++) sb.append(arr[i] + ", ");
            return sb.append(arr[len-1] + "]").toString();
        }
    }

}