/* Rellenar: Nombres de los integrantes del equipo:
1) Gonzalez Hernandez Juan Enrique
2) Sanchez Saldaña Jose Manuel
3) Ruiz Santos Orlando
4) Pichardo Nava Johanna Montserrat 
5) Martinez Ugalde Evelyn
6) Ortega Chavarria Angel Ivan
*/

// import org.w3c.dom.Node;

public class UV_E3_Apellidos_Nombre {
    public static void main(String[] args) {
        // Primero llenamos el árbol

        // TODO Prueba tus métodos en una función main con el conjunto de datos y
        // los siguientes valores: 42 y 33, tu programa debe reportar en consola
        // si existe o no el número y que tipo de búsqueda se utilizo.
        // Salida: "42 se encuentra en el árbol, se uso DFS iterativo"

        BinaryTree root = new BinaryTree();
        root.insert(12);
        root.insert(30);
        root.insert(45);
        root.insert(41);
        root.insert(34);
        root.insert(60);
        root.insert(23);
        root.insert(42);


        System.out.println(" \n\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n \n");
        
        // Prueba de los métodos de búsqueda BFS iterativo(pepe)
        int[] testValues2 = {42, 33};
        for (int value : testValues2) {
            if (searchBFSIterative(root.root, value)) {
                System.out.println(value + " se encuentra en el arbol y se usa BFS de fotma iterativa   \n");
            } else {
                System.out.println(value + " no se encuentra en el arbol y  se usa BFS de forma iterativa ");
            }
        }

        System.out.println(" \n\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n \n");


        // Probar el metodo searchDFSRecursive (EVELYN)
        int[] searchEve = {42, 33};
        for (int value : searchEve) {
            if (searchBFSRecursive(root.root, value)) {
                System.out.println("------------------------------------------------------------");
                System.out.println(value + " se encuentra en el árbol y se usó DFS recursivo");
                System.out.println("------------------------------------------------------------");
            } else {
                System.out.println("------------------------------------------------------------");
                System.out.println(value + " no se encuentra en el árbol y se usó DFS recursivo");
                System.out.println("------------------------------------------------------------");
            }
        }



        // Probar el método de searchBFSRecursive (ORLANDO)
        int[] testValues = { 42, 33 };
        for (int value : testValues) {
            if (searchBFSRecursive(root.root, value)) {
                System.out.println("-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O");
                System.out.println(value + " se esta en el árbol y se uso BFS recursivo");
                System.out.println("-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O");
            } else {
                System.out.println(value + " no se encuentra en el árbol y se uso BFS recursivo");
                System.out.println("-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O-O");
            }
        }




    }

    // Kikin
    // Para este método usa una Stack personalizada
    public boolean searchDFSIterative(int data) {
        // TODO
        throw new UnsupportedOperationException("Aun no se implemnta este método, borra est throw cuando lo completes");
    }

    // Pepe
    // Para este método usa una Queue personalizada
    public static boolean searchBFSIterative(BinaryTree.Node root, int data) {
        if (root == null) {
            return false; 
        }
        Queue<BinaryTree.Node> queue = new Queue<>();
        queue.offer(root); 
        while (!queue.isEmpty()) {
            BinaryTree.Node current = queue.poll();

            if (current.data == data) {
                return true; 
            }
            
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false; 
    }

    /* Iván
    public boolean searchDFS(int data) {
        return searchDFSRecursive(data);
    } */

    // Evelyn
    public static boolean searchDFSRecursive(BinaryTree.Node root, int data) {
        if (root == null) return false;
    
        Queue<BinaryTree.Node> queue = new Queue<>();
        queue.offer(root);
    
        while (!queue.isEmpty()) {
            BinaryTree.Node current = queue.poll();
    
            if (current.data == data) {
                return true;
            }
    
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false;
    }


    /*
     * Montse
     * public boolean searchBFS(int data) {
     * return searchBFSRecursive(data);
     * }
     */

    // Orlando
    public static boolean searchBFSRecursive(BinaryTree.Node root, int data) {
        if (root == null)
            return false;

        Queue<BinaryTree.Node> queue = new Queue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTree.Node current = queue.poll();
            if (current.data == data) {
                return true;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false;
    }

}
