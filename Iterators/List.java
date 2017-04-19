interface List<E>{
    int size();
    boolean add(E obj); // adds a obj to the end
    void add(int index, E obj);
    E get(int index);
    E set(int index, E obj);
    E remove(int index);


}
