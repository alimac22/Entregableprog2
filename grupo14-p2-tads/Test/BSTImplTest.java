import uy.edu.um.prog2.adt.arbol.BinarySearchingTreeImpl;
import uy.edu.um.prog2.adt.arbol.MyBinarySearchingTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BSTImplTest {
    MyBinarySearchingTree<Integer,String> bst = new BinarySearchingTreeImpl<>();

    @Test
    void findTest(){
        //Insertamos nodos en el árbol binario de búsqueda
        bst.insert(6,"A"); //Insertar nodo raíz
        bst.insert(8,"B"); //Insertar nodo a la derecha de el nodo raíz
        bst.insert(2,"C"); //Insertar nodo a la izquierda de el nodo raíz

        //Realizar pruebas y afirmaciones
        assert bst.find(6).equals("A");
        assertNotEquals("B", bst.find(6));
        assert bst.find(2).equals("C");
    }

    @Test
    void deleteTest(){
        //Insertamos nodos en el árbol binario de búsqueda
        bst.insert(6,"A"); //Insertar nodo raíz
        bst.insert(8,"B"); //Insertar nodo a la derecha de el nodo raíz
        bst.insert(2,"C"); //Insertar nodo a la izquierda de el nodo raíz
        bst.insert(1,"D"); //Insertar nodo a la izquierda de 2
        bst.insert(4,"E"); //Insertar nodo a la derecha de 2
        bst.insert(3,"F"); //Insertar nodo a la izquierda de 4

        //Se elimina el nodo 4, quedando el nodo 3 como hijo izquierdo del nodo 2
        bst.delete(4);

        //Realizar pruebas y afirmaciones
        assert bst.find(4)==null;


    }

}
