package ListaImoveis;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListaLigadaDuplamente<T> implements List<T>, Serializable, Iterator {

    private No<T> inicio;
    private No<T> fim;
    private int indice;
    private int size;

    public ListaLigadaDuplamente() {
        this.inicio = null;
        this.fim = null;
        this.indice = 0;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.getInicio() == null;
    }

    public T getLast() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            return (T) getFim().getInfo();
        }
    }

    @Override
    public boolean contains(Object o) {

        No<T> p = new No(null);

        if (o == null) {

            throw new NullPointerException("Objeto é nulo, não é possivél verificar na lista.");
        } else {
            No aux = this.inicio;
            while ((aux != null) || (aux.getProximo() != this.inicio)) {
                if (aux.getInfo() == o) {
                    return true;
                }
                aux = aux.getProximo();
            }
            return false;
        }
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        No aux;
        if (!this.isEmpty()) {
            aux = new No(getIndice(), e, getInicio(), getFim());
            this.getFim().setProximo(aux);
            this.setFim(aux);
            this.getInicio().setAnterior(getFim());
        } else {
            this.setInicio(new No(getIndice(), e, getInicio(), getInicio()));
            this.getInicio().setAnterior(getInicio());
            this.getInicio().setProximo(getInicio());
            this.setFim(getInicio());
        }

        this.setIndice(this.getIndice() + 1);
        this.setSize(this.getSize() + 1);
        return true;
    }

    @Override

    public boolean remove(Object o) {
        No<T> aux;
        if (o == null) {
            throw new NullPointerException("Objetos nulos");
        }

        if (!isEmpty()) {
            if (this.inicio.getInfo().equals((T) o)) {
                if (!this.inicio.getProximo().equals(this.inicio)) {
                    this.inicio.getAnterior().setProximo(this.inicio.getProximo());
                    this.inicio.getProximo().setAnterior(this.inicio.getAnterior());
                    this.inicio = this.inicio.getProximo();
                    this.size--;
                    return true;
                } else {
                    this.inicio = null;
                    this.size--;
                    return true;
                }
            }
            aux = this.inicio.getProximo();
            while (!aux.equals(this.inicio)) {
                if (aux.getInfo().equals((T) o)) {
                    aux.getAnterior().setProximo(aux.getProximo());
                    aux.getProximo().setAnterior(aux.getAnterior());
                    this.size--;
                    return true;
                }
                aux = aux.getProximo();
            }
        }

        return false;

    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection clctn) {
        ListaLigadaDuplamente<T> auxList = (ListaLigadaDuplamente) clctn;
        for (int x = 0; x < clctn.size(); x++) {
            this.add(auxList.get(x));
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override

    public T get(int index) {
        No aux = this.inicio;
        if (index < size && index > -1 && size != 0) {
            for (int i = 0; i < index; i++) {
                aux = aux.getProximo();
            }
            return (T) aux.getInfo();
        } else {
            throw new IndexOutOfBoundsException("Indice inválido!");
        }
    }

    /**
     * @return the inicio
     */
    public No getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public No getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(No fim) {
        this.fim = fim;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public T set(int i, T e) {

        if (e == null) {

            throw new NullPointerException("Objeto é nulo, não pode ser salvo na lista.");
        } else if (i < 0 || i >= size()) {

            throw new IndexOutOfBoundsException("Valor fora do intervalo válido.");

        } else {
            No<T> aux = this.getInicio();
            T obj;

            for (int j = 0; j < i; j++) {
                aux = aux.getAnterior();

            }
            obj = aux.getInfo();
            aux.setInfo(e);
            return obj;
        }
    }

     /**
    * Metodo que funciona se ja existe algum objeto na lista de imoveis
    * 
    * @param index
    * @param element 
    */
    @Override
    public void add(int index, T element) {
        int numElements = 0;
		if (index < 0 || index > numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		if (index == 0) {
			add(element);
			return;
		}
                No<T> aux = new No(indice, element, this.fim.getProximo(), this.fim);
                this.fim.setProximo(aux);
                this.fim = aux;
                this.inicio.setAnterior(fim);
		numElements++;

	
    }
    
    @Override
    public T remove(int i) {
        T aux1;
        No aux = null;
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            aux = (No) get(i);
            /*aux = this.inicio;
            while (aux != this.fim) {
                i =  aux.getImovel();
                if (i.getCodigo() == im.getCodigo()) {
                    break;
                }
                aux = aux.getProximo();
            }
            i = (Imovel) aux.getImovel();
            if (i.getCodigo() == im.getCodigo()) {*/
            No anterior = aux.getAnterior();
            No proximo = aux.getProximo();
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
            this.size--;
            this.decrementarLista(proximo);
            return (T) aux;
        }

    }

    @Override

    public int indexOf(Object o) {

        if (o == null) {

            throw new NullPointerException("Objeto nulo");

        } else if (isEmpty()) {

            throw new NullPointerException("Lista está vazia");
        } else {

            int cont = 0;

            if (inicio.getInfo().equals(o)) {

                return cont;

            }

            if (!(inicio.getAnterior().getInfo().equals(inicio))) {
                No aux = inicio.getProximo();

                cont++;

                while (!aux.equals(inicio)) {

                    if (aux.getInfo().equals(o)) {

                        return cont;
                    }
                    aux = aux.getProximo();

                    cont++;

                }

            }

        }

        return -1;

    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que decrementa a Lista
     *
     * @param n
     */
    private void decrementarLista(No n) {
        if (this.size == 1) {
            this.fim = inicio;
        }
        this.indice--;
        No aux = n;
        while (aux != this.fim) {
            aux.decrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();
    }

    /**
     * Método que incrementa a Lista
     *
     * @param n
     */
    private void incrementarLista(No n) {
        this.indice++;
        No aux = n;
        while (aux != this.fim) {
            aux.IncrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();

    }

    @Override

    public Iterator iterator() {

        indice = 0;

        return this;

    }

    @Override

    public boolean hasNext() {

        return indice < size;

    }

    @Override

    public T next() {

        T a = get(indice++);

        return a;

    }

}
