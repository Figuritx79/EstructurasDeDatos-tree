public class Queue<T> {

    private Node<T> front;  // Primer elemento (cabeza de la cola)
    private Node<T> rear;   // Último elemento (final de la cola)
    private int size;       // Tamaño de la cola

    // Constructor: Inicializa una cola vacía
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Clase interna Node para representar los nodos de la cola
    private static class Node<T> {
        T data;          // Dato almacenado en el nodo
        Node<T> next;    // Referencia al siguiente nodo

        // Constructor: Inicializa un nodo con el dato proporcionado
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Añade un elemento al final de la cola
    public boolean offer(T element) {
        Node<T> newNode = new Node<>(element); // Crea un nuevo nodo
        if (rear != null) {
            rear.next = newNode;  // El último nodo apunta al nuevo nodo
        }
        rear = newNode;           // El nuevo nodo es ahora el último
        if (front == null) {      // Si la cola estaba vacía
            front = rear;         // El nuevo nodo también es el primero
        }
        size++;                   // Incrementa el tamaño de la cola
        return true;
    }

    // Añade un elemento al final de la cola, lanza una excepción si falla
    public void add(T element) {
        if (!offer(element)) {
            throw new IllegalStateException("No se pudo añadir el elemento");
        }
    }

    // Obtiene el primer elemento sin eliminarlo, o null si está vacía
    public T peek() {
        return (front != null) ? front.data : null;
    }

    // Obtiene el primer elemento sin eliminarlo, lanza excepción si está vacía
    public T element() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return front.data;
    }

    // Elimina y devuelve el primer elemento de la cola, o null si está vacía
    public T poll() {
        if (isEmpty()) {
            return null; // Retorna null si la cola está vacía
        }
        T data = front.data; // Almacena el dato del primer nodo
        front = front.next;  // Avanza el puntero del primer nodo
        if (front == null) { // Si la cola queda vacía
            rear = null;     // También reinicia el puntero del último nodo
        }
        size--;              // Decrementa el tamaño de la cola
        return data;         // Retorna el dato eliminado
    }

    // Elimina y devuelve el primer elemento de la cola, lanza excepción si está vacía
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return poll(); // Usa el método poll para eliminar el primer elemento
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Obtiene el tamaño de la cola
    public int size() {
        return size;
    }

    // Vacía la cola
    public void clear() {
        front = null;  // Reinicia el puntero del primer nodo
        rear = null;   // Reinicia el puntero del último nodo
        size = 0;      // Reinicia el tamaño a 0
    }

    // Método toString para representar la cola
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front; // Apunta al primer nodo
        while (current != null) { // Recorre la cola hasta el final
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", "); // Agrega coma entre elementos
            }
            current = current.next; // Avanza al siguiente nodo
        }
        sb.append("]");
        return sb.toString(); // Retorna la representación como cadena
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(); // Crea una cola de enteros

        queue.offer(10);   // Añade 10
        queue.add(20);     // Añade 20
        queue.add(30);     // Añade 30

        System.out.println("Contenido de la cola: " + queue);

        System.out.println("Primer elemento (peek): " + queue.peek());
        System.out.println("Primer elemento (poll): " + queue.poll());
        System.out.println("Contenido de la cola después de poll: " + queue);

        queue.add(40); // Añade 40
        System.out.println("Primer elemento (remove): " + queue.remove());
        System.out.println("Contenido de la cola después de remove: " + queue);

        System.out.println("¿La cola está vacía?: " + queue.isEmpty());
        System.out.println("Tamaño de la cola: " + queue.size());

        queue.clear(); // Vacía la cola
        System.out.println("Contenido de la cola después de clear: " + queue);
    }
}
