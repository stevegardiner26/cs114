package lab3a;

class AListGrow<E> extends AList<E> {

    public AListGrow(int length){
        super(length);
    }

    public void append(E it) {
        if(this.listSize == this.maxSize) {
            this.growAList();
        }
        super.append(it);
    }

    public void insert(E it) {
        if(this.listSize == this.maxSize) {
            this.growAList();
        }
        super.insert(it);
    }

    public void growAList() {
        this.maxSize = this.maxSize * 2;
        System.out.println("AListGrow Expand the max size to " + this.maxSize);
        E[] tempArray = (E[])new Object[this.maxSize];
        for(int i = 0; i < listSize; i++) {
            tempArray[i] = listArray[i];
        }
        listArray = tempArray;
        //foArray = ;
        //listArray = new AList((maxSize * 2));
    }
}
