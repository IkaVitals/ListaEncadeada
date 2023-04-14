public class ListaEncadeada<T> {

    private No<T> referenciaEntrada;

    public ListaEncadeada(){
        this.referenciaEntrada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No(conteudo);
        if(this.isEmpty()){
            referenciaEntrada=novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;

        for(int i = 0; i<this.size()-1;i++){
            noAuxiliar =noAuxiliar.getProximoNo();
        }
        noAuxiliar.setConteudo((T) novoNo);
    }
//método add (adicionar), ele vai receber um conteudo e cria um novo nó na lista


    public T get(int index){
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
// metodo interno na classe que recebe um indice
        validaIndice(index);
// foi chamado o metodo que foi criado para validar o indice, este também recebe index
        No<T> noAuxiliar = referenciaEntrada;
        No <T> noRetorno = null;

        for(int i = 0; i <= index;i++){
            noRetorno = noAuxiliar;
            noAuxiliar =noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public T remove(int index){

        validaIndice(index);
        No<T> noPivor = getNo(index);
        // recebe o valor do No Pivô
        if(index == 0){// caso No Pivô seja igual a zero executa a baixo
            referenciaEntrada = noPivor.getProximoNo();
            // caso entre pro no zero, a referenciaEntrada sempre aponta pro inicio da lista e nesse caso eu digo para apontar para o segundo
            return  noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index-1);
        // crio uma variavel guardando o nó anterior do nó Pivô, que recebe a posição dita -1
        noAnterior.setProximoNo(noPivor.getProximoNo());
        // Aqui eu digo que o Proximo nó é o que vem depois do nó Pivô
        return noPivor.getConteudo();
    }

    public int size(){
        int tamanhoLista=0;
        No<T> referenciaAux=referenciaEntrada;
        while(true){
            if(referenciaAux != null){
                tamanhoLista++;
                if(referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo();
                }else {
                    break;
                }
            }else{
                break;
            }
        }
        return tamanhoLista;
    } //contém o tamanho da lisa

    private  void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size() -1;
            throw new IndexOutOfBoundsException("Não existe conteudo no Indice " + index + " desta lista. Esta lista so vai até o indice "+ ultimoIndice + '.');
        }
    } // validação para saber se o indice é maior que o tamanho da lista
    public  boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    public No<T> getReferenciaEntrada(){
        return referenciaEntrada;
    }

    public void setReferenciaEntrada(No<T> referenciaEntrada){
        this.referenciaEntrada = referenciaEntrada;
    }

    @Override
    public String toString(){

        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;

        for(int i = 0; i < size(); i++){
            // enquanto ir for menor que lista, incrementa
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            // serve para imprimir o conteudo dentro de cada nó
            noAuxiliar = noAuxiliar.getProximoNo();
            // A cada ciclo o noAuxiliar é o nó a frente dele
        }

        strRetorno += "null";
// quando for o ultimo nó ele vai apontar pra null (nulo)
        return strRetorno;
    }


}
