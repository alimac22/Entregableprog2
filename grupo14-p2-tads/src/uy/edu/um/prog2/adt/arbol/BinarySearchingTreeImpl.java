package uy.edu.um.prog2.adt.arbol;

public class BinarySearchingTreeImpl <K extends Comparable<K>, T> implements MyBinarySearchingTree<K,T>{

    private NodeBST<K,T> root;
    private int size;

    public BinarySearchingTreeImpl(){
        this.root=null;
        this.size=0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public T find(K key) {
        NodeBST<K,T> node=findRec(root,key);
        return (node != null)?node.data:null;
    }

    @Override
    public void insert(K key, T data) {
        root=insertRec(root,key,data);
        size++;
    }

    @Override
    public void delete(K key) {
        root=deleteRec(root,key);

    }

    private NodeBST<K,T> findRec(NodeBST<K,T> node, K key){
        if (node==null || key.compareTo(node.key)==0){
            return node;
        }
        int comp = key.compareTo(node.key);
        if (comp<0){
            return findRec(node.leftChild, key);
        }else{
            return findRec(node.rightChild, key);
        }
    }
    private NodeBST<K,T> insertRec(NodeBST<K,T> node, K key, T data){
        if (node==null){
            return new NodeBST<>(key,data);
        }
        int comp=key.compareTo(node.key);
        if (comp<0){
            node.leftChild=insertRec(node.leftChild,key,data);
        }else if (comp>0){
            node.rightChild=insertRec(node.rightChild,key,data);
        }else{
            node.data=data;
        }
        return node;
    }

    private NodeBST<K,T> deleteRec(NodeBST<K,T> node,K key){ //algoritmo reclusivo para eliminar un nodo
        if (node==null){ //Verifica si el nodo no es nulo
            return null;
        }
        int comp=key.compareTo(node.key);//busca el nodo correspondiente comparandolo con la key
        if (comp<0){
            node.leftChild=deleteRec(node.leftChild,key);
        }else if (comp>0){
            node.rightChild=deleteRec(node.rightChild,key);
        }else{ //Se verifica que el nodo tiene hijos
            if (node.leftChild==null){ //si solo tiene hijos del lado derecho...
                return node.rightChild;
            }else if (node.rightChild==null){ //si solo tiene hijos del lado izquierdo...
                return node.leftChild;
            }
            //Si tiene los dos hijos, se busca el menor nodo del subarbol derecho para que sea el sucesor del nodo actual
            NodeBST<K,T> minRightSubTree=minNodeBST(node.rightChild);
            //Traspaso de datos
            node.key= minRightSubTree.key;
            node.data= minRightSubTree.data;
            //se elimina el nodo minimo
            node.rightChild=deleteRec(node.rightChild, minRightSubTree.key);
        }
        return node;

    }
    private NodeBST<K,T> minNodeBST(NodeBST<K,T> node){ //Busca el nodo más a la derecha del árbol
        while (node.leftChild!=null){
            node=node.leftChild;
        }
        return node;
    }
}
