/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Vigenere {
    char [][] Matriz;

    public Vigenere() {
        Matriz = new char [256][256];
        int i, j,k;
        for(i=0;i<256;i++){
            k=0;
            for(j=0; j<256;j++){
                if(i+j<256){
                    Matriz[i][j]=(char) (j+i);
                }else{
                    Matriz[i][j]=(char) k;
                    k++;
                }
            }
        }
    }
    
    public String cifrar(String textoLlano, String key){
        System.out.println("Entra al metdodo");
        char [] clave = key.toCharArray();
        char [] texto = textoLlano.toCharArray();
        String textoCifrado = "";
        
        int fila=0, columna; //Fila es el index de los caracteres de la clave y columa del texto llano
        
        for(columna=0; columna<texto.length; columna++){ //Se accede a cada elemento del texto llano
            System.out.println("Caracter del texto : " +columna);
            if(fila<clave.length){//se verifica si excede los numeros de la clave
                textoCifrado =textoCifrado+(char)(this.Matriz[(int)(clave[fila])][(int)(texto[columna])]);
                fila++;
            } else{//si se excede se inicia con el primer caratcere de la clave
                fila=0;
                textoCifrado =textoCifrado+(char)(this.Matriz[(int)(clave[fila])][(int)(texto[columna])]);
                fila++;
            }
        }
        System.out.println("Texto Cifrado : " +textoCifrado);
        return textoCifrado;
    }
    
    public String descifrar(String textoCifrado, String key){
        char [] clave = key.toCharArray();
        char [] texto = textoCifrado.toCharArray();
        String descifrado="";
        int fila, columna, caracterClave=0;
        fila=(int)clave[caracterClave];
        for(int i=0; i<texto.length; i++){//Con este for se ira accediendo a cada carater del texto cifrado
            for(columna=0; columna<256; columna++){//se recorre todos los elmentos de la fila
                if(texto[i] == (char)( this.Matriz[fila][columna] )){//se busca el carater 
                    descifrado=descifrado+(char)columna; //se concatena columna que es el numero ASCCI del cracter de la primera fila
                    break;//si lo encuentra se rompe el ciclo 
                }
            }
            caracterClave++;//se incrementa el contador para acceder al siguiente caracter de la clave
            if(caracterClave==clave.length){
                caracterClave=0;
            }    
            fila=(int)clave[caracterClave];
        }
        return descifrado;
    }
    
    

}
