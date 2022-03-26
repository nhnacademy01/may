package day8.oop1;

import java.util.Objects;

public class MyArrayList {
    private Object[] elements;  //default: null
    private int size;   //default: 0

    public MyArrayList() {
        this.elements = new Object[128];
    }

    public boolean add(Object o) {
        this.elements[this.size++] = o; //elements배열의 0번째에 o를 넣어주기
        return true;
    }

    public Object get(int index) {
        checkIndex(index);
        return this.elements[index];
    }

    void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("MyArrayList에는 " + index + " 에 위치하는 요소가 없어요");
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    //        public void clear() {     // 장점 : 메모리를 기존에 것에 할당
//            for (int i = 0; i < elements.length; i++) {
//                elements[i] = null;
//            }
//        }
    public void clear() {       // 간단하게 구현, 새로운 메모리에 할당
        this.elements = new Object[128];
        this.size = 0;
    }

    //index에 위치하는 요소를 삭제하고 반환, 만약 index가 존재하지 않으면 indexOutOfBoundsException 예외 던진다.
    public Object remove(int index) {
        checkIndex(index);
        Object result = elements[index];
        final int newSize = this.size - 1;
        if (newSize > index)
            System.arraycopy(elements, index + 1, elements, index, newSize - index);
        this.elements[newSize] = null;
        this.size = newSize;

        return result;
    }
}
